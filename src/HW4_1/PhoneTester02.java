package HW4_1;

public class PhoneTester02 {
    public static void main(String[] args) {

    }
}
class Phone{
    private String number,model;
    private double weight;
    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }
    public Phone(String number, String model, double weight) {
        new Phone(number, model);
        this.weight = weight;
    }



    public Phone() {

    }
    public String RecieveCall(String name){
        return "Звонит " + name;
    }
    public String getNumber(){
        return this.number;
    }

}
