package acad277;

/**
 * Created by R on 2/13/2017.
 */
public class Shape {
    private String name;

    public Shape(String n) {
        name = n;
    }

    public String getName() { return name;}
    public void setName(String n) {name = n; }

    //toString NEVER prints anything
    //toString RETURNS a string
    public String toString() {
        String msg = "Shape name = " + name;

        return msg;
    }

    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }

}








