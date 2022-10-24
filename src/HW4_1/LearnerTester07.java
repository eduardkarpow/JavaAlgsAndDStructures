package HW4_1;

import java.util.Scanner;

public class LearnerTester07 {
    public static void main(String[] args) {
        Learner[] learners = {new Schoolboy("Jhon"), new Student("Jack"), new Schoolboy("James")};
        Scanner sc = new Scanner(System.in);
        String className = sc.nextLine();
        getElements(learners, className);
    }
    private static void getElements(Learner[] learners, String className){
        for(Learner learner : learners){
            String clas = learner.getClass().getName();
            if(clas.equalsIgnoreCase(className)){
                System.out.println(learner);
            }
        }
    }
}
class Learner {
    protected String name;
    public Learner(String name){
        this.name = name;
    }

}
class Schoolboy extends Learner{
    public Schoolboy(String name){
        super(name);
    }

    @Override
    public String toString() {
        return "HW4_1.Schoolboy - "+ this.name;
    }
}
class Student extends Learner{
    public Student(String name){
        super(name);
    }
    @Override
    public String toString() {
        return "HW4_1.Student - "+ this.name;
    }
}