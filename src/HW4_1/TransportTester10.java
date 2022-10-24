package HW4_1;

public class TransportTester10 {
    public static void main(String[] args) {
        Transport car = new Car(60.5,2500, 10);
        Transport plane = new Plane(300, 6000, 2300);
        System.out.println(car);
        System.out.println(plane);
    }
}
abstract class Transport{
    protected double velocity, price,length;

    public Transport(double velocity, double price, double length) {
        this.velocity = velocity;
        this.price = price;
        this.length = length;
    }
    protected double getPrice(){
        return this.length/this.velocity*this.price;
    }
    public String toString(){
        return "price for transportation: " + getPrice();
    }
}
class Car extends Transport{
    public Car(double velocity, double price, double length) {
        super(velocity, price, length);
    }
    @Override
    public String toString(){
        return "price for transportation by car: "+ super.getPrice();
    }
}
class Train extends Transport{
    public Train(double velocity, double price, double length) {
        super(velocity, price, length);
    }
    @Override
    public String toString(){
        return "price for transportation by train: "+ super.getPrice();
    }
}
class Plane extends Transport{
    public Plane(double velocity, double price, double length) {
        super(velocity, price, length);
    }
    @Override
    public String toString(){
        return "price for transportation by plane: "+ super.getPrice();
    }
}
class Ship extends Transport{
    public Ship(double velocity, double price, double length) {
        super(velocity, price, length);
    }
    @Override
    public String toString(){
        return "price for transportation by ship: "+ super.getPrice();
    }
}