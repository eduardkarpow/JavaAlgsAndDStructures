package HW2;

import java.util.ArrayList;

public class DogsNursery05 {
    private static ArrayList<Dog> dogNursery = new ArrayList<Dog>();
    public static void main(String[] args) {
        dogNursery.add(new Dog("Rex", 1));
        dogNursery.add(new Dog("Dawg", 3));
        for(int i = 0; i < dogNursery.size(); i++){
            System.out.println(dogNursery.get(i));
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }
    public int toHumanAge(){
        return this.age*7;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return "data of Current HW2.Dog name: " + this.name + ", age: " + this.age + ", age in Human: " + toHumanAge();
    }
}