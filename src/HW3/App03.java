package HW3;

public class App03 {
    public static void main(String[] args) {
        double[] numbers = new double[4];
        for(int i =0; i < 4; i++){
            numbers[i] = Math.random()*89+10;
            System.out.println(numbers[i]);
        }
        boolean isIncreasing = true;
        for(int i = 0; i< 3; i++){
            if(numbers[i] > numbers[i+1]){
                isIncreasing = false;
            }
        }
        System.out.println(isIncreasing);
    }
}
