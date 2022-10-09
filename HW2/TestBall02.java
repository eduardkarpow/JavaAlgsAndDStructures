package HW2;

public class TestBall02 {
    public static void main(String[] args) {
        Ball ball = new Ball(1.2, 3.1);
        System.out.println(ball);
        ball.move(1.0, -2.1);
        System.out.println(ball);
    }
}
class Ball {
    private double x= 0.0, y=0.0;

    public Ball(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Ball(){
        this.x = 0.0;
        this.y = 0.0;
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
    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }
    public void move(double xDisp, double yDisp){
        this.x += xDisp;
        this.y += yDisp;
    }
    public String toString(){
        return "current position (" + this.x + ", " + this.y + ")";
    }
}