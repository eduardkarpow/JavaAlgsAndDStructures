package HW18;

import org.w3c.dom.events.EventException;

import java.util.Scanner;

public class ThrowsDemo {
    public static void main(String[] args) {

    }
    public void getKey() {
        Scanner myScanner = new Scanner( System.in
        );
        String key = myScanner.next();
        printDetails( key );
    }
    public void printDetails(String key) {
        try { String message = getDetails(key);
            System.out.println( message );
        }catch ( RuntimeException e){
            System.out.println(e);
        }
    }
    private String getDetails(String key) {
        if(key == "") {
            throw new RuntimeException( "Key set to empty string" );
        }
        return "data for " + key;
    }
}

