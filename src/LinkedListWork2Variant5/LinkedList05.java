package LinkedListWork2Variant5;

import java.util.Scanner;

public class LinkedList05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите начальные элементы не более 5");
        String[] baseNums;
        try{
            baseNums = sc.nextLine().split(" ");
            if(baseNums.length>5){
                throw new TooMuchElementsError();
            }
        } catch (TooMuchElementsError e){
            System.out.println(e.getMessage());
            baseNums = sc.nextLine().split(" ");
        }

        int[] baseIntNums = new int[baseNums.length];
        for(int i = 0; i < baseNums.length; i++){
            baseIntNums[i] = Integer.parseInt(baseNums[i]);
        }
        ArrayLinkedList ls = new ArrayLinkedList(sc, baseIntNums);
        System.out.println("--------------------Список комманд---------------------");
        System.out.println("add - добавить элемент, требует последующего ввода числа");
        System.out.println("show - распечатать список");
        System.out.println("end - закончить сессию");
        System.out.println("--------------------Список комманд---------------------");
        while(true){
            String command = sc.nextLine();
            if(command.equalsIgnoreCase("end")){
                break;
            } else if(command.equalsIgnoreCase("add")){
                ls.addElement(Integer.parseInt(sc.nextLine()));
            } else if (command.equalsIgnoreCase("show")) {
                ls.printArray();
            }
        }


    }
}
class ArrayLinkedList{
    private Node head=null;
    private Scanner scanner;
    public ArrayLinkedList(Scanner sc, int[] args){
        this.scanner = sc;
        this.head = new Node(args);
    }
    public void addElement(int element){
        Node container = this.head;
        do {
            if(container.searchEntryFlag(element) != 5){
                break;

            }
            container = container.getNext();
        }
        while(container != null);
        while(container != null){
            if(container.getSizeOfFilledCells() != 5){
                element = container.insertElement(element);
                break;
            } else{
                element = container.insertElement(element);
                if(element == -1){
                    break;
                }
                container = container.getNext();
            }
        }
        if(element != -1){
            addNode(element);
        }
    }
    public void addNode(int element){
        Node container = this.head;
        while(container.getNext() != null){
            container = container.getNext();
        }
        int[] el = {element};
        container.setNext(new Node(el));
    }
    public void printArray(){
        Node container = this.head;
        do {
            container.printNode();
            container = container.getNext();
        }
        while(container != null);
    }
}
class Node {
    private Node next = null;
    private int[] content= new int[5];
    private int sizeOfFilledCells = 0;

    public Node(int args[]) {
        for(int i = 0; i < args.length; i++){
            this.content[i] = args[i];

        }
        this.sizeOfFilledCells = args.length;
        sortArray();
    }
    public void sortArray(){
        for(int i = 0; i<sizeOfFilledCells-1; i++){
            for(int j = 0; j<sizeOfFilledCells-i-1; j++){
                if(this.content[j] > this.content[j+1]){
                    int container = this.content[j];
                    this.content[j] = this.content[j+1];
                    this.content[j+1]=container;
                }
            }
        }
    }
    public int searchEntryFlag(int element){
        for (int i = 0; i < sizeOfFilledCells; i++){
            if(this.content[i] > element){
                return i;
            }
        }
        return sizeOfFilledCells;
    }
    public int insertElement(int element){

        int flag = searchEntryFlag(element);
        for(int i = flag; i<sizeOfFilledCells; i++){
            int container = this.content[i];
            this.content[i] = element;
            element = container;
        }
        if(sizeOfFilledCells == 5){
            return element;
        }
        this.content[sizeOfFilledCells] = element;
        this.sizeOfFilledCells++;
        return -1;
    }
    public void printNode(){
        for(int i = 0; i < sizeOfFilledCells; i++){
            System.out.print(this.content[i] + ", ");

        }
        System.out.println(" -> ");
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getSizeOfFilledCells() {
        return sizeOfFilledCells;
    }
}
class TooMuchElementsError extends RuntimeException{
    TooMuchElementsError(){
        super("Error: too much elements was sended");
    }
}