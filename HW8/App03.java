package HW8;

public class App03 {
    public static void main(String[] args) {
        fromAToB(7,6);
    }
    private static void fromAToB(int A, int B){
        if(A<B){
            System.out.print(A+ " ");
            fromAToB(A+1, B);
        } else if (A>B) {
            System.out.print(A+" ");
            fromAToB(A-1,B);
        } else {
            System.out.println(A);
        }
    }
}
