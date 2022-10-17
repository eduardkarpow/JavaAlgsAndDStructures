package HW4;

public class AtelierTester {
    public static void main(String[] args) {
        Cloth[] cloths = new Cloth[4];
        cloths[0] = new Tshirt(Sizes.M, 43.5, "Red");
        cloths[1] = new Pants(Sizes.L, 62.5, "Blue");
        cloths[2] = new Skirt(Sizes.XS, 50.5, "Black");
        cloths[3] = new Tie(Sizes.S, 10.0, "Green");
        Atelier.dressWoman(cloths);
        Atelier.dressMan(cloths);
    }
}
abstract class Atelier {
    public static void dressWoman(Cloth[] cloths){
        for(int i =0; i < cloths.length; i++){
            Class[] interfaces = cloths[i].getClass().getInterfaces();
            for(Class c : interfaces){
                if("HW4.WomenClothing".equals(c.getSimpleName())){
                    WomenClothing container =(WomenClothing)cloths[i];
                    System.out.println(container.dressWoman());
                }

            }
        }
    }
    public static void dressMan(Cloth[] cloths){
        for(int i =0; i < cloths.length; i++){
            Class[] interfaces = cloths[i].getClass().getInterfaces();
            for(Class c : interfaces){
                if("HW4.MenClothing".equals(c.getSimpleName())){
                    MenClothing container =(MenClothing)cloths[i];
                    System.out.println(container.dressMan());
                }
            }
        }
    }
}
enum Sizes {
    XXS(32){
        @Override
        public String getDescription(){
            return "детский размер";
        }
    },XS(34),S(36),M(38),L(40);
    private int euroSize;
    Sizes(int euroSize){
        this.euroSize = euroSize;
    }
    public String getDescription(){
        return "Взрослый размер";
    }
}
interface MenClothing {
    String dressMan();
}
interface WomenClothing {
    String dressWoman();
}
abstract class Cloth{
    protected Sizes size;
    protected double price;
    protected String color;
}
class Tshirt extends Cloth implements MenClothing,WomenClothing{
    public Tshirt(Sizes size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String dressMan(){
        return "dressing man with HW4.Tshirt size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
    public String dressWoman(){
        return "dressing woman with HW4.Tshirt size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
}
class Pants extends Cloth implements MenClothing,WomenClothing{
    public Pants(Sizes size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String dressMan(){
        return "dressing man with HW4.Pants size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
    public String dressWoman(){
        return "dressing woman with HW4.Pants size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
}
class Skirt extends Cloth implements WomenClothing{
    public Skirt(Sizes size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
    public String dressWoman(){
        return "dressing woman with skirt size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
}
class Tie extends Cloth implements MenClothing{
    public Tie(Sizes size, double price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String dressMan(){
        return "dressing man with tie size: "+this.size.toString()+" color: " + this.color + " price: " + this.price;
    }
}
