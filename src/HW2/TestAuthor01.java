package HW2;

public class TestAuthor01 {
    public static void main(String[] args) {
        Author author = new Author("Jack", "Jack01@mail.com", 'm');
        System.out.println(author);
    }
}

class Author {
    private String name, email;
    private char gender;
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }
    public String toString() {
        return "name: " + this.name + " email: " + this.email + " gender: " + this. gender;
    }
}