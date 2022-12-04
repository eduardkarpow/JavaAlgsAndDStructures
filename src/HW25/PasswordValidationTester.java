package HW25;

import java.util.Scanner;

public class PasswordValidationTester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        boolean passIsValid = line.matches("\"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$\"");
        System.out.println(passIsValid);
    }
}
