package HW6;

public class movableTester {
    public static void main(String[] args) {

    }
}
interface Movable{
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}
class MovablePoint implements Movable{
    private int x, y, xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return "coordinates: x = "+ this.x + " y = " + this.y;
    }

    @Override
    public void moveUp() {
        this.y += this.ySpeed;
    }

    @Override
    public void moveDown() {
        this.y -= this.ySpeed;
    }

    @Override
    public void moveLeft() {
        this.x+=this.xSpeed;
    }

    @Override
    public void moveRight() {
        this.x -= this.xSpeed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}
class MovableCircle implements Movable{
    private int r;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int r) {
        this.center = new MovablePoint(x,y,xSpeed,ySpeed);
        this.r = r;
    }

    @Override
    public String toString() {
        return "coordinates: x = "+ this.center.getX() + " y = " + this.center.getY();
    }

    @Override
    public void moveUp() {
        this.center.setySpeed(this.center.getY()+this.center.getySpeed());
    }

    @Override
    public void moveDown() {
        this.center.setySpeed(this.center.getY()-this.center.getySpeed());
    }

    @Override
    public void moveLeft() {
        this.center.setxSpeed(this.center.getX()+this.center.getxSpeed());
    }

    @Override
    public void moveRight() {
        this.center.setxSpeed(this.center.getX()-this.center.getxSpeed());
    }
}
class MovableRectangle implements Movable{
    private MovablePoint topLeft, bottomRight;

    public MovableRectangle(int x1, int x2, int y1, int y2, int xSpeed, int ySpeed) {
        this.topLeft = new MovablePoint(x1,y1,xSpeed,ySpeed);
        this.bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public String toString() {
        return "coordinates of rectangle: top left point: x = " + this.topLeft.getX() + " y = "+
                this.topLeft.getY() + " bottom right point: x = " + this.bottomRight.getX() +
                " y = " + this.bottomRight.getY();
    }
    @Override
    public void moveUp() {
        this.topLeft.setySpeed(this.topLeft.getY()+this.topLeft.getySpeed());
        this.bottomRight.setySpeed(this.bottomRight.getY()+this.bottomRight.getySpeed());
    }

    @Override
    public void moveDown() {
        this.topLeft.setySpeed(this.topLeft.getY()-this.topLeft.getySpeed());
        this.bottomRight.setySpeed(this.bottomRight.getY()-this.bottomRight.getySpeed());
    }

    @Override
    public void moveLeft() {
        this.topLeft.setxSpeed(this.topLeft.getX()+this.topLeft.getxSpeed());
        this.bottomRight.setxSpeed(this.bottomRight.getX()+this.bottomRight.getxSpeed());
    }

    @Override
    public void moveRight() {
        this.topLeft.setxSpeed(this.topLeft.getX()-this.topLeft.getxSpeed());
        this.bottomRight.setxSpeed(this.bottomRight.getX()-this.bottomRight.getxSpeed());
    }
}