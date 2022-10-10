package HW8;

public class App04 {
    public static void main(String[] args) {
        System.out.println(searchNumbers(0,0,2,11));
    }
    public static int searchNumbers(int len, int sum, int k,int s){
        if (len == k) {
            if (sum == s) {
                return 1;
            } else {
                return 0;
            }
        }
        int c = (len == 0 ? 1 : 0);
        int res = 0;
        // Шаг рекурсии / рекурсивное условие
        for (int i = c; i < 10; i++) {
            res += searchNumbers(len + 1, sum + i, k, s);
        }
        return res;
    }
}
