package HW3;

import java.util.ArrayList;
import java.util.Scanner;

public class App05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = reading(sc);
        long[] numbers = new long[n];
        ArrayList<Long> oddNumbers = new ArrayList<Long>();
        for(int i = 0; i < n; i++){
            numbers[i] = Math.round(Math.random()*n+1);
            System.out.print(numbers[i] + ", ");
            if(numbers[i]%2 == 0){
                oddNumbers.add(numbers[i]);
            }
        }
        System.out.println(" ");
        for(int i =0; i < oddNumbers.size(); i++){
            System.out.print(oddNumbers.get(i)+" ");
        }
    }
    public static int reading(Scanner sc){
        try {
            System.out.println("type the number");
            return sc.nextInt();
        } catch (Error e){
            return reading(sc);
        }
    }
}
