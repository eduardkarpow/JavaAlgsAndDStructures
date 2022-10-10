package HW6;

public class NameableTester {
    public static void main(String[] args) {
        Car car = new Car();
        car.getName();
        Plane plane = new Plane();
        plane.getName();
    }
}
interface Nameable {
    void getName();
}

class Car implements Nameable {
    public Car() {
    }
    public void getName() {
        String name = this.toString().split("@")[0];
        System.out.println(name);
    }
}
class Plane implements Nameable {
    public Plane() {
    }
    public void getName() {
        String name = this.toString().split("@")[0];
        System.out.println(name);
    }
}