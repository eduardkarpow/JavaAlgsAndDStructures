package HW2;

public class SwitchDirection08 {
    public static void main(String[] args) {
        String[] arr = {"asd", "ads", "dsd"};
        arr = switchDirection(arr);
        for(String el : arr){
            System.out.print(el + " ");
        }
    }
    public static String[] switchDirection(String[] arr){
        for(int i = 0; i < arr.length/2; i++){
            String container;
            container = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = container;
        }
        return arr;
    }
}
