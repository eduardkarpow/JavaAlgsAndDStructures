package LinkedListWork1;

import java.util.Scanner;

public class CircleLinkedListTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircleLinkedList ls = new CircleLinkedList(sc);
        System.out.println("--------------------Список комманд---------------------");
        System.out.println("add - добавить элемент, требует последующего ввода номера элемента");
        System.out.println("delete - удалить элемент, требует последующего ввода номера элемента");
        System.out.println("show - распечатать список");
        System.out.println("print - распечатать элемент, требует последующего ввода номера элемента");
        System.out.println("end - закончить сессию");
        System.out.println("--------------------Список комманд---------------------");
        while(true){
            try {
                String command = sc.nextLine();
                if(command.equalsIgnoreCase("end")){
                    break;
                }
                else if(command.equalsIgnoreCase("add")){
                    ls.insertElement(Integer.parseInt(sc.nextLine()));
                }
                else if(command.equalsIgnoreCase("delete")){
                    int id = sc.nextInt();
                    ls.deleteObject(id);
                }
                else if(command.equalsIgnoreCase("show")) {
                    ls.printList();
                } else if (command.equalsIgnoreCase("print")) {
                    ls.printElement(Integer.parseInt(sc.nextLine()));
                }
            } catch (IndexOutOfBoundsError e){
                System.out.println(e.getMessage());
            }

        }
    }
}
class CircleLinkedList{
    private NodeStudent head = null;
    private Scanner scanner;
    private int size = 0;

    public CircleLinkedList(Scanner scanner) {
        this.scanner = scanner;
    }
    public void appendElement(NodeStudent ns){
        NodeStudent container = searchElement(size);
        container.insertElement(ns);
        container.getNext().setNext(this.head);
    }
    public void unshiftElement(NodeStudent ns){
        ns.setNext(this.head);
        this.head = ns;
        searchElement(size+1).setNext(this.head);
    }
    public void insertElement(int id){
        if(id < 0 || id > size){
            throw new IndexOutOfBoundsError();
        }
        NodeStudent ns = new NodeStudent(this.scanner);
        if(isEmpty()) {
            this.head = ns;
            this.head.setNext(this.head);
        }
        else if(id == size){
            appendElement(ns);
        }
        else if(id == 0){
            unshiftElement(ns);
        }
        else{
            NodeStudent currentNode = searchElement(id);
            currentNode.insertElement(ns);
        }
        this.size++;
    }
    public NodeStudent searchElement(int id){
        int i = 0;
        NodeStudent container=this.head;
        while(i < id-1){
            i++;
            container = container.getNext();
        }
        return container;
    }
    public void popElement(){
        searchElement(size-1).setNext(this.head);
    }
    public void shiftElement(){
        this.head = this.head.getNext();
        searchElement(size-1).setNext(this.head);
    }
    public void deleteObject(int id){
        if(id < 0 || id > size){
            throw new IndexOutOfBoundsError();
        }
        if(id == 0){
            shiftElement();
        }
        else if(id == size-1){
            popElement();
        }
        else{
            NodeStudent container = searchElement(id);
            container.setNext(container.getNext().getNext());
        }
        this.size--;

    }
    public void printElement(int id){
        if(id < 0 || id >= size){
            throw new IndexOutOfBoundsError();
        }
        searchElement(id).printElement();
    }
    public void printList(){
        NodeStudent container = this.head;
        for(int i = 0; i < size; i++){
            container.printElement();
            container = container.getNext();
        }
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public void clearList(){
        this.head = null;
    }

}
