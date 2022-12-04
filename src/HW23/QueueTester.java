package HW23;

import java.util.AbstractQueue;
class Car{
    private int speed;
    private String mark;

    public Car(int speed, String mark) {
        this.speed = speed;
        this.mark = mark;
    }
    public String toString(){
        return "speed: "+ this.speed + " mark: " + this.mark;
    }
}
public class QueueTester {
    public static void main(String[] args) {
        ArrayQueueModule queue = new ArrayQueueModule();
        queue.insertQueue(new Car(120,"BMW"));
        queue.insertQueue(new Car(240, "Tesla"));
        queue.displayItems();
    }
}
class ArrayQueueModule extends ArrayQueueADT<Car>{
    public ArrayQueueModule() {
        super(Car.class,10);
    }
}
abstract class ArrayQueueADT<T>{
    protected int front,rear;
    protected int SIZE;
    protected T items[];
    protected ArrayQueueADT(Class<T> dataType, int SIZE){
        front = -1;
        rear = -1;
        this.SIZE = SIZE;
        this.items=(T[]) java.lang.reflect.Array.newInstance(dataType, this.SIZE);
    }
    public boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        return false;
    }
    public boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }
    public void insertQueue(T element) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = (T)element;
            System.out.println("Insert " + element);
        }
    }
    public T deleteQueue() {
        T element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        else {
            element = items[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            }
            else {
                front++;
            }
            System.out.println( element + " Deleted");
            return (element);
        }
    }
    public void displayItems() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        }
        else {
            System.out.println("\nFront index-> " +
                    front);
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print(items[i] + " ");
            System.out.println("\nRear index-> " +
                    rear);
        }
    }

}