package acad277;

public class Main {

    public static void main(String[] args) {
        Point p1 = new Point();
        // what is the value of p1's xcoord?

        Point p2 = new Point(5, -3);

        System.out.println("The coords of p1 are (" + p1.getXCoord()
                + ", " + p2.getYCoord() + ")" );

        p2.setxCoord(-10);
        p2.setYCoord(30);

        System.out.println(p1);
        System.out.println(p2);


    }
}




