package HW4_1;

public class ShapeTester08 {
    public static void main(String[] args) {
        Shape shape = new Rectangle(2.3,4.2);
        System.out.println(shape);
    }
}
abstract class Shape {
    protected String color;
    protected boolean filled;
    public Shape(){
        this.color = "white";
        this.filled = true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public double getArea() {
        return 0.0;
    }
    public double getPerimetr(){
        return 0.0;
    }
    public String toString(){
        return "";
    }
}
class Circle extends Shape{
    private double radius;
    public Circle(){
        super();
        this.radius = 0.0;


    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea(){
        return 3.14*this.radius*this.radius;
    }
    @Override
    public double getPerimetr(){
        return 6.28*this.radius;
    }
    @Override
    public String toString(){
        return "area of circle: " + getArea() + " perimetr of circle: "+ getPerimetr();
    }

}
class Rectangle extends Shape{
    private double width, length;

    public Rectangle(){
        super();
        this.width = 0.0;
        this.length = 0.0;
    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea(){
        return this.width*this.length;
    }
    @Override
    public double getPerimetr(){
        return 2*(this.width+this.length);
    }
    @Override
    public String toString(){
        return "area of rectangle: "+getArea() + " perimetr of rectangle: " + getPerimetr();
    }

}
class Square extends Rectangle{
    private double side;
    public Square() {
        super();
        this.side = 0.0;
    }

    public Square(double side) {
        super(side ,side);
        this.side = side;
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
        this.side = side;
    }
    public void setSide(double side){
        this.side = side;
    }
    public void setLength(double side){
        super.setLength(side);
    }
    public void setWidth(double side){
        super.setWidth(side);
    }
    @Override
    public String toString(){
        return "area of square: "+ getArea() + " perimetr of square: "+ getPerimetr();
    }

}