package HW2;

public class CircleTester03 {
    public static void main(String[] args) {
        Circle crcl = new Circle(1.0, 2.3, 1.0, 45);
        System.out.println(crcl);
    }
}
class Circle{
    private Point center;
    private double radius, angle;
    public Circle(double xCenter, double yCenter, double radius, double angle){
        this.center = new Point(xCenter,yCenter);
        this.radius = radius;
        this.angle = angle;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    private Point calculatePointPosition() {
        double x = this.center.getX()+this.radius*Math.cos(Math.toRadians(this.angle));
        double y = this.center.getY()+this.radius*Math.sin(Math.toRadians(this.angle));
        return new Point(x,y);
    }
    public String toString(){
        Point pnt = calculatePointPosition();
        return "position of given point is: (" + pnt.getX() + ", " + pnt.getY() + ")";
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