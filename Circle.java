public class Circle {
    double radius;
    static final double PI = 3.1416;

    public  Circle () {
        radius = 0.0;

    }

    public Circle(double radius) {
        this.radius = radius;

    }

    public double getArea() {
        return PI * radius * radius;

    }

    

    

}
