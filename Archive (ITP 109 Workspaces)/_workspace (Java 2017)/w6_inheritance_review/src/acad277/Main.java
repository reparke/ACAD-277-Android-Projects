package acad277;

import org.w3c.dom.css.Rect;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Rectangle court = new Rectangle("basketball court", 94, 50);
        Circle c = new Circle("dartboard", 1);

        System.out.println("The area of the " + court.getName() + " is " + court.getArea() );
	    System.out.println(court);

	    Shape[] things = new Shape[4];
	    things[0] = court;
	    things[1] = c;
	    things[2] = new Circle("helipad", 50);
	    things[3] = new Rectangle("tissue", 0.5, 1);

	    for (int i = 0; i < things.length; i++) {
	        System.out.println("The perimeter of " + things[i].getName() + " is " + things[i].getPerimeter());

        }
        //we MUST already know that index 3 IS a rectangle

        double height = ((Rectangle) things[3]).getHeight();
	    System.out.println(height);


    }
}
