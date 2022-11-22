package LinkedListWork1;

import java.util.Scanner;

public class DoubleLinkedListTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedList ls = new DoubleLinkedList(sc);
        System.out.println("--------------------Список комманд---------------------");
        System.out.println("add - добавить элемент, требует последующего ввода номера элемента");
        System.out.println("delete - удалить элемент, требует последующего ввода номера элемента");
        System.out.println("show - распечатать список");
        System.out.println("print - распечатать элемент, требует последующего ввода номера элемента");
        System.out.println("end - закончить сессию");
        System.out.println("--------------------Список комманд---------------------");
        while(true){
            try{
                String command = sc.nextLine();
                if(command.equalsIgnoreCase("end")){
                    break;
                }
                else if(command.equalsIgnoreCase("add")){
                    ls.insertElement(Integer.parseInt(sc.nextLine()));
                }
                else if(command.equalsIgnoreCase("delete")){
                    int id = sc.nextInt();
                    ls.deleteElement(id);
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

class DoubleLinkedList{
    private NodeStudent2 head = null;
    private NodeStudent2 tail = null;
    private Scanner scanner;
    private int size=0;
    public DoubleLinkedList(Scanner scanner) {
        this.scanner = scanner;
    }

    public void appendElement(NodeStudent2 ns){
        ns.setPrev(this.tail);
        this.tail.setNext(ns);
        this.tail = ns;
    }
    public void unshiftElement(NodeStudent2 ns){
        this.head.setPrev(ns);
        ns.setNext(this.head);
        this.head = ns;
    }
    public void insertElement(int id){
        if(id < 0 || id > size){
            throw new IndexOutOfBoundsError();
        }
        NodeStudent2 ns = new NodeStudent2(this.scanner, this.tail);
        if(isEmpty()) {
            this.head = ns;
            this.tail = ns;
        } else if (id == size) {
            appendElement(ns);
        } else if (id == 0) {
            unshiftElement(ns);
        } else{

            searchElement(id).insertElement(ns);
        }
        size++;
    }
    public NodeStudent2 searchElement(int id){
        int i = 0;
        NodeStudent2 container=this.head;
        while(i < id-1){
            i++;
            container = container.getNext();
        }
        return container;
    }
    public void popElement(){
        this.tail = this.tail.getPrev();
        this.tail.setNext(null);
    }
    public void shiftElement(){
        this.head = this.head.getNext();
        this.head.setPrev(null);
    }
    public void deleteElement(int id){
        if(id < 0 || id > size){
            throw new IndexOutOfBoundsError();
        }
        if(id == 0){
            shiftElement();
        }
        else if(id == size-1){
            popElement();
        } else{
            System.out.println(123);
            NodeStudent2 container = searchElement(id);

            container.setNext(container.getNext().getNext());
            container.getNext().setPrev(container);
        }
        size--;

    }
    public void printElement(int id){
        if(id < 0 || id >= size){
            throw new IndexOutOfBoundsError();
        }
        searchElement(id).printElement();
    }
    public void printList(){
        NodeStudent2 container = this.head;
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
class NodeStudent2{
    private String name;
    private int age;
    private NodeStudent2 next;
    private NodeStudent2 prev;
    public NodeStudent2(Scanner sc, NodeStudent2 prev) {
        System.out.print("print name: ");
        this.name = sc.nextLine();
        System.out.print("print age: ");
        this.age = Integer.parseInt(sc.nextLine());
        this.prev = prev;
    }
    public void printElement(){
        System.out.println("name is: " + this.name + " age is: " + this.age+ " "+this.prev + " <-> "+ this.next);
    }
    public void insertElement(NodeStudent2 ns){
        if(this.next == null) {
            this.next = ns;
        } else {
            ns.next = this.next;
            this.next.prev = ns;
            ns.prev = this;
            this.next = ns;

        }
    }

    public NodeStudent2 getNext() {
        return next;
    }

    public void setNext(NodeStudent2 next) {
        this.next = next;
    }
    public NodeStudent2 getPrev() {
        return prev;
    }

    public void setPrev(NodeStudent2 prev) {
        this.prev = prev;
    }
}