package HW4_1;

public class PersonTester03 {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 =new Person("Jack", 21);
        person1.talk();
        person2.move();
    }
}
class Person{
    private String fullName;
    private int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Person() {
    }
    public void talk(){
        System.out.println(this.fullName + " говорит!");
    }
    public void move(){
        System.out.println(this.fullName + " идет!");
    }
}
