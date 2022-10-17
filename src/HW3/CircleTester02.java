package HW3;

public class CircleTester02 {

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.sortCircles();
        System.out.println(tester.searchMaxCircle());
        System.out.println(tester.searchMinCircle());
    }
}
class Tester {
    private Circle[] circles = new Circle[10];
    private int len = circles.length;
    public Tester(){
        for(int i = 0; i < this.len; i++){
            this.circles[i] = new Circle(Math.random()*10, Math.random()*15, Math.random()*8);
        }
    }
    public Circle searchMinCircle(){
        double min = 10.;
        Circle minCircle = this.circles[0];
        for(Circle c : this.circles){
            if(c.getRadius() < min){
                min = c.getRadius();
                minCircle = c;
            }
        }
        return minCircle;
    }
    public Circle searchMaxCircle(){
        double max = 0.;
        Circle maxCircle = this.circles[0];
        for(Circle c : this.circles){
            if(c.getRadius() > max){
                max = c.getRadius();
                maxCircle = c;
            }
        }
        return maxCircle;
    }
    public void sortCircles(){
        for(int i =0; i < len; i++){
            for(int j = 0; j < len-i-1; j++){
                if(this.circles[j].getRadius()>this.circles[j+1].getRadius()){
                    Circle container = this.circles[j];
                    this.circles[j] = this.circles[j+1];
                    this.circles[j+1] = container;
                }
            }
        }
        for(Circle c: this.circles){
            System.out.println(c);
        }
    }
}
class Circle{
    private Point center;
    private double radius;
    public Circle(double xCenter, double yCenter, double radius){
        this.center = new Point(xCenter,yCenter);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString(){
        return "This circle have center: x = " + this.center.getX() + " y = " + this.center.getY() +
                " and radius = " + this.radius;
    }

}
class Point {
    private double x,y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}