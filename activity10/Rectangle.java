package activity10;

public class Rectangle extends GeometricObject {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
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

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle width: " + width + ", height: " + height +
               ", color: " + getColor() + ", filled: " + isFilled();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Rectangle) {
            Rectangle r = (Rectangle) o;
            return this.width == r.width && this.height == r.height;
        }
        return false;
    }
}