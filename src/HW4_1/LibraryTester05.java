package HW4_1;

public class LibraryTester05 {
    public static void main(String[] args) {
        Reader reader = new Reader("Иванов И. И.", "Инженер", "12.06.1991", "9999999999",123);
        reader.takeBook();
        reader.takeBook(3);
        String[] books = {"asd", "adhksd", "sadja"};
        reader.takeBook(books);
        Book[] books2 = {new Book("Капитанская дочка", "Пушкин"), new Book("Преступление и наказание","Достоевский")};
        reader.takeBook(books2);
    }
}
class Reader{
    private String FIO, faculty, bornDate, phoneNumber;
    private int readerCardNumber;

    public Reader(String FIO, String faculty, String bornDate, String phoneNumber, int readerCardNumber) {
        this.FIO = FIO;
        this.faculty = faculty;
        this.bornDate = bornDate;
        this.phoneNumber = phoneNumber;
        this.readerCardNumber = readerCardNumber;
    }
    public void takeBook(){
        System.out.println(this.FIO + " взял книгу");
    }
    public void returnBook(){
        System.out.println(this.FIO + " вернул книгу");
    }
    public void takeBook(int n){
        System.out.println(this.FIO + " взял " + n + " книги");
    }
    public void takeBook(String[] books){
        String str = this.FIO + " взял: ";
        for(int i = 0; i < books.length; i++){
            str+=books[i]+", ";
        }
        System.out.println(str);;
    }
    public void takeBook(Book[] books){
        String str =  this.FIO + " взял: ";
        for(int i =0; i < books.length; i++){
            str+=books[i].getAuthor()+ " " + books[i].getTitle() + ", ";
        }
        System.out.println(str);
    }
    public void returnBook(int n){
        System.out.println(this.FIO + " вернул " + n + " книги");
    }
    public void returnBook(String[] books){
        String str = this.FIO + " вернул: ";
        for(int i = 0; i < books.length; i++){
            str+=books[i]+", ";
        }
        System.out.println(str);;
    }
    public void returnBook(Book[] books){
        String str =  this.FIO + " вернул: ";
        for(int i =0; i < books.length; i++){
            str+=books[i].getAuthor()+ " " + books[i].getTitle() + ", ";
        }
        System.out.println(str);
    }

}
class Book{
    private String title, author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}