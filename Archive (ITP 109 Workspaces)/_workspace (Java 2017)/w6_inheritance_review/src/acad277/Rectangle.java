package acad277;

/**
 * Created by R on 2/13/2017.
 */
public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(String n, double h, double w) {
        super(n);   //call the PARENT constructor

        //initialize the new rectangle instance variables
        height = h;
        width = w;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return height * 2 + width * 2;
    }

    public String toString() {
        String msg = super.toString();
        msg += ", height = " + height + ", width = " + width;
        return msg;
    }


}





