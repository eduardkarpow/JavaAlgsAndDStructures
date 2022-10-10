package HW8;

public class App02 {
    public static void main(String[] args) {
        print1ton(4,1);
    }
    public static void print1ton(int n,int i){
        System.out.print(i + " ");
        if(n != i){
            print1ton(n,i+1);
        }

    }
}
