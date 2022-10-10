package HW2;

import java.util.Scanner;
public class HowMany10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int counter = 0;
        for(String s: str.split("[^a-zA-z]+")){
            counter++;
        }
        System.out.println(counter);
    }
}
