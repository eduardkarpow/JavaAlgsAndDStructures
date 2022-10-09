package HomeWork1;

import java.util.Scanner;

public class HomeWork1 {
    public static void main(String args[]){
        //Third();
        //Forth();
        Fifth(args);
        //Sixth();


    }
    private static void Third(){
        int[] nums = new int[10];
        int Sum = 0;
        for(int i = 0; i < nums.length; i++){
            nums[i] = i+5;
            Sum+=nums[i];
        }
        System.out.println(Sum);
        System.out.println((float)Sum/(float)nums.length);
    }
    private static void Forth(){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        int i = 0;
        while(i<10){
            nums[i] = sc.nextInt();
            i++;
        }
        int max = nums[0];
        int min = nums[0];
        i=0;
        while(i<nums.length){
            if(nums[i]>max){
                max = nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
            i++;
        }
        System.out.println(max);
        System.out.println(min);
    }
    private static void Fifth(String[] args){
        for(String arg : args){
            System.out.println(arg);
        }
    }
    private static void Sixth(){
        for(int i =1; i<11;i++){
            if(i == 1){
                System.out.print("1, ");
            } else{
                System.out.print("1/"+i+", ");
            }
        }
    }
    private static int Factorial(int n){
        if(n == 1){
            return 1;
        }
        return n*Factorial(n-1);
    }
}
