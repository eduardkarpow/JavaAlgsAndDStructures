package HW3;

import java.util.Random;

public class randomNumbers01 {

    public static void main(String[] args) {
        Random rnd = new Random();
        int n = 10;
        double[] numbers = new double[n];
        for(int i = 0; i < n; i++){
            if(i < n/2){
                numbers[i] = rnd.nextDouble()*10;
            } else{
                numbers[i] = Math.random()*10-5;
            }
        }
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n - i-1; j ++){
                if(numbers[j] > numbers[j+1]){
                    double container = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = container;
                }
            }
        }
        for(int i = 0; i < 10; i++){
            System.out.println(numbers[i]);
        }
    }
}
