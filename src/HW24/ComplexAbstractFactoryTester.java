package HW24;

public class ComplexAbstractFactoryTester {
    public static void main(String[] args) {

    }
}
class Complex{
    private int real, imag;

    public Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }
}
interface ComplexAbstractFactory {
    public Complex createComplex();
    public Complex CreateComplex(int real, int imag);
}
class ConcreteFactory implements ComplexAbstractFactory{
    public Complex createComplex(){
        return new Complex(0,0);
    }
    public Complex CreateComplex(int real, int imag){
        return new Complex(real, imag);
    }
}