package HW2;

import java.util.ArrayList;

public class ShopTester04 {
    public static void main(String[] args) {
        Shop.addElement(new Notebook(1,500, "Some notebook", 3.5));
        Shop.addElement(new PersonalComputer(2,300, "Some PC", 4.2));
        Shop.addElement(new TabletComputer(3,250, "Some tablet", 11.2));
        System.out.println(Shop.searchComputerForCustomer(1));
    }
}
abstract class Shop {
    private static ArrayList<Computer> shop = new ArrayList<Computer>();
    public static void addElement(Computer computer){
        Shop.shop.add(computer);
    }
    public static Computer searchComputerForCustomer(int id){
        for(int i = 0; i < Shop.shop.size(); i++){
            if(Shop.shop.get(i).getId() == id){
                return Shop.shop.get(i);
            }
        }
        return null;
    }
    public static int searchComputerForDeleting(int id){
        for(int i = 0; i < Shop.shop.size(); i++){
            if(Shop.shop.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public static void deleteComputer(int id){
        int i = Shop.searchComputerForDeleting(id);
        if(i != -1) {
            Shop.shop.remove(i);
        }
    }
}


interface Computer {
    public int getId();
    public int getPrice();
    public String getTitle();
    public String toString();
}
class Notebook implements Computer{
    private int id, price;
    private String title;
    private double chargeTime;

    public Notebook(int id, int price, String title, double chargeTime) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.chargeTime = chargeTime;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(double chargeTime) {
        this.chargeTime = chargeTime;
    }
    public String toString(){
        return "HW2.Notebook data title: " + this.title + ", price: " + this.price + ", chargeTime: " + this.chargeTime;
    }
}
class PersonalComputer implements Computer{
    private int id, price;
    private String title;
    private double countingPower;

    public PersonalComputer(int id, int price, String title, double countingPower) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.countingPower = countingPower;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCountingPower() {
        return countingPower;
    }

    public void setcountingPower(double countingPower) {
        this.countingPower = countingPower;
    }
    public String toString(){
        return "Personal HW2.Computer data title: " + this.title + ", price: " + this.price + ", Counting power: " + this.countingPower;
    }
}
class TabletComputer implements Computer{
    private int id, price;
    private String title;
    private double displaySize;

    public TabletComputer(int id, int price, String title, double displaySize) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.displaySize = displaySize;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getdisplaySize() {
        return displaySize;
    }

    public void setdisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }
    public String toString(){
        return "HW2.Notebook data title: " + this.title + ", price: " + this.price + ", display size: " + this.displaySize;
    }
}
