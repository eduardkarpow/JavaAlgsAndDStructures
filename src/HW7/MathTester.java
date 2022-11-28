package HW7;

public class MathTester {
    public static void main(String[] args) {
        MathFunc mf = new MathFunc();
        System.out.println(mf.complexAbs(2,3));
        System.out.println(mf.power(3,2));
        System.out.println(mf.getCircleLength(1));
    }
}
interface MathCalculable{
    double power(double number, double degree);
    double complexAbs(double a,double b);
    double pi = 3.14;
}

class MathFunc implements MathCalculable{
    public double power(double number, double degree){
        return Math.pow(number,degree);
    }
    public double complexAbs(double a, double b){
        return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
    public double getCircleLength(double R){
        return pi*2*R;
    }
}
