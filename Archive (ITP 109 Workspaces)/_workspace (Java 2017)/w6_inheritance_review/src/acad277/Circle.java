package acad277;

/**
 * Created by R on 2/13/2017.
 */
public class Circle extends Shape {
    private double radius;

    public Circle(String n, double r) {
        super(n);
        radius = r;
    }
    //get / set
    public String toString() {
        String msg = super.toString();
        msg += ", radius = " + radius;
        return msg;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }
}
