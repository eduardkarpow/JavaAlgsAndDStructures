package HW25;

import java.util.Scanner;

public class PricesSplittingTester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] prices = line.split(", ");
        for(String price : prices){
            System.out.println(price);
        }
    }
}
