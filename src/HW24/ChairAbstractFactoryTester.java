package HW24;

public class ChairAbstractFactoryTester {
    public static void main(String[] args) {
        Client client = new Client();
        ChairFactory chairFactory = new ChairFactory();
        client.setChair(chairFactory.createMagicChair());
        client.sit();
    }
}
interface AbstractChairFactory{
    public VictorianChair createVictorianChair(int age);
    public MagicChair createMagicChair();
    public FunctionalChair createFunctionalChair();
}
class ChairFactory implements AbstractChairFactory{
    public VictorianChair createVictorianChair(int age){
        return new VictorianChair(age);
    }
    public MagicChair createMagicChair(){
        return new MagicChair();
    }
    public FunctionalChair createFunctionalChair(){
        return new FunctionalChair();
    }
}
interface Chair{
    public void sitOnChair();
}
class VictorianChair implements Chair{
    private int age;
    public VictorianChair(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }

    public void sitOnChair(){
        System.out.println("it's victorian chair");
    }
}
class MagicChair implements Chair{
    public void doMagic(){
        System.out.println("Doing magic");
    }

    public void sitOnChair(){
        System.out.println("it's magic chair");
    }
}
class FunctionalChair implements Chair{
    public int sum(int a, int b){
        return a+b;
    }

    public void sitOnChair(){
        System.out.println("it's functional chair");
    }
}
class Client{
    private Chair chair;
    public void sit(){
        chair.sitOnChair();
    }
    public void setChair(Chair chair){
        this.chair = chair;
    }
}