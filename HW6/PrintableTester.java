package HW6;

public class PrintableTester {
    public static void main(String[] args) {
        Printable[] booksAndShops = {new Book("first book"), new Shop("first shop"), new Book("Second book")};
        for(Printable el : booksAndShops){
            el.print();
        }
    }
}
interface Printable {
    void print();
}
class Book implements Printable{
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public void print(){
        System.out.println(this.title);
    }
}
class Shop implements Printable{
    private String title;

    public Shop(String title) {
        this.title = title;
    }

    public void print(){
        System.out.println(this.title);
    }
}
