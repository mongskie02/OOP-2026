package activity10;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<GeometricObject> shapes = new ArrayList<>();

        shapes.add(new Circle(5));
        shapes.add(new Circle(5, "red", true));
        shapes.add(new Rectangle(4, 6));
        shapes.add(new Rectangle(4, 6, "blue", false));

        for (GeometricObject g : shapes) {
            System.out.println(g.toString());
            System.out.println("Area: " + g.getArea());
            System.out.println("Perimeter: " + g.getPerimeter());
            System.out.println();
        }

        Circle c1 = new Circle(5);
        Circle c2 = new Circle(5);

        Rectangle r1 = new Rectangle(4, 6);
        Rectangle r2 = new Rectangle(4, 6);

        System.out.println("Circle equal: " + c1.equals(c2));
        System.out.println("Rectangle equal: " + r1.equals(r2));
    }
}
