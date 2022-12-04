package HW19;

import java.util.Hashtable;
import java.util.Scanner;

public class INNTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UI ui = new UI(sc);
        ui.controllIn();
    }
}
abstract class BLL {
    private static Hashtable<String, Integer> dataBase = new Hashtable<String, Integer>();
    public static void addElement(String FIO, int INN){
        dataBase.put(FIO, INN);
    }
    public static String checkElement(String FIO, int INN){
        int targetINN = dataBase.get(FIO);
        if(targetINN != INN){
            throw new FIOOrINNIsNotValidException();
        }
        return "Успех";
    }

}
class UI {
    private Scanner scanner;
    public UI(Scanner sc){
        this.scanner = sc;
    }
    public void controllIn(){
        while (true){
            String command = this.scanner.nextLine();
            if(command.equalsIgnoreCase("register")){
                System.out.println("введите ФИО: ");
                String FIO = this.scanner.nextLine();
                System.out.println("введите ИНН: ");
                int INN = Integer.parseInt(this.scanner.nextLine());
                BLL.addElement(FIO, INN);
            } else if (command.equalsIgnoreCase("login")) {
                try {
                    System.out.println("введите ФИО: ");
                    String FIO = this.scanner.nextLine();
                    System.out.println("введите ИНН: ");
                    int INN = Integer.parseInt(this.scanner.nextLine());
                    System.out.println(BLL.checkElement(FIO, INN));
                } catch (FIOOrINNIsNotValidException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else if (command.equalsIgnoreCase("end")) {
                break;
            }
        }
    }
}
class FIOOrINNIsNotValidException extends RuntimeException{
    public FIOOrINNIsNotValidException(){
        super("Введенные данные некоректны");
    }
}