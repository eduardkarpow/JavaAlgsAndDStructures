package HW4_1;

public class FurnitureTester09 {
    public static void main(String[] args) {
        Sellable[] furniture = {new Chair(200, "casual chair"), new Bath(700, "vertical bath")};
        FurnitureShop fShop = new FurnitureShop(furniture);
        fShop.searchFurniture("casual chair");
    }
}

interface Sellable {
    void sell();
    String getName();
}

abstract class Furniture {
    protected double price;
    protected String name;

    public void sell(){
        System.out.println("Спасибо за покупку: "+this.name + " по цене: " + this.price);
    }
    public String getName(){
        return this.name;
    }
}
class Chair extends Furniture implements Sellable{
    public Chair(double price, String name) {
        this.price = price;
        this.name = name;
    }
}
class Bath extends Furniture implements Sellable{
    public Bath(double price, String name) {
        this.price = price;
        this.name = name;
    }
}

class FurnitureShop{
    private final Sellable[] furniture;
    public FurnitureShop(Sellable[] furniture){
        this.furniture = furniture;
    }
    public void searchFurniture(String name){
        for(Sellable furn : this.furniture){
            if(furn.getName().equalsIgnoreCase(name)){
                furn.sell();
            }
        }
    }
}