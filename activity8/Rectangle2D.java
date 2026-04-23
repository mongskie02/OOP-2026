package activity8;

public class Rectangle2D {

    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle2D() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.height = 1;
    }

    public Rectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return Math.abs(x - this.x) <= width / 2 &&
               Math.abs(y - this.y) <= height / 2;
    }

    public boolean contains(Rectangle2D r) {
        return Math.abs(r.x - this.x) + r.width / 2 <= this.width / 2 &&
               Math.abs(r.y - this.y) + r.height / 2 <= this.height / 2;
    }

    public boolean overlaps(Rectangle2D r) {
        return Math.abs(this.x - r.x) < (this.width + r.width) / 2 &&
               Math.abs(this.y - r.y) < (this.height + r.height) / 2;
    }
}