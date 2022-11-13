package LinkedListWork1;

import java.util.Scanner;

public class LinkedListTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ls = new LinkedList(sc);
        System.out.println("--------------------Список комманд---------------------");
        System.out.println("add - добавить элемент, требует последующего ввода номера элемента");
        System.out.println("delete - удалить элемент, требует последующего ввода номера элемента");
        System.out.println("show - распечатать список");
        System.out.println("print - распечатать элемент, требует последующего ввода номера элемента");
        System.out.println("end - закончить сессию");
        System.out.println("--------------------Список комманд---------------------");
        while(true){
            String command = sc.nextLine();
            if(command.equalsIgnoreCase("end")){
                break;
            }
            else if(command.equalsIgnoreCase("add")){
                ls.insertElement(Integer.parseInt(sc.nextLine())-1);
            }
            else if(command.equalsIgnoreCase("delete")){
                int id = sc.nextInt();
                ls.deleteObject(id-1);
            }
            else if(command.equalsIgnoreCase("show")) {
                ls.printList();
            } else if (command.equalsIgnoreCase("print")) {
                ls.printElement(Integer.parseInt(sc.nextLine())-1);
            }
        }


    }
}

class LinkedList{
    private NodeStudent head = null;
    private Scanner scanner;
    private int size = 0;

    public LinkedList(Scanner scanner) {
        this.scanner = scanner;
    }
    public void appendElement(NodeStudent ns){
        searchElement(size).insertElement(ns);
    }
    public void unshiftElement(NodeStudent ns){
        ns.setNext(this.head);
        this.head = ns;
    }
    public void insertElement(int id){
        NodeStudent ns = new NodeStudent(this.scanner);
        if(isEmpty()) {
            this.head = ns;
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
        searchElement(size-1).setNext(null);
    }
    public void shiftElement(){
        this.head = this.head.getNext();
    }
    public void deleteObject(int id){
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
        searchElement(id+1).printElement();
    }
    public void printList(){
        NodeStudent container = this.head;
        for(int i = 0; i < size; i++){
            container.printElement();
            container = container.getNext();
        }
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public void clearList(){
        this.head = null;
    }

}
class NodeStudent{
    private String name;
    private int age;
    private NodeStudent next;
    public NodeStudent(Scanner sc) {
        System.out.print("print name: ");
        this.name = sc.nextLine();
        System.out.print("print age: ");
        this.age = Integer.parseInt(sc.nextLine());
    }
    public void printElement(){
        System.out.println("name is: " + this.name + " age is: " + this.age+" -> " + this.next);
    }
    public void insertElement(NodeStudent ns){
        if(this.next == null) {
            this.next = ns;
        } else {
            ns.next = this.next;
            this.next = ns;
        }
    }

    public NodeStudent getNext() {
        return next;
    }

    public void setNext(NodeStudent next) {
        this.next = next;
    }
}
