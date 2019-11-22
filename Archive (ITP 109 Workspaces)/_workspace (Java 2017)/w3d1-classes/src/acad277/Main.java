package acad277;

public class Main {

    public static void main(String[] args) {
        //make point (3, 4.5)
	    Point p1 = new Point();
	    Point p2 = new Point(3, 4.5);
        String message = "hello";

        System.out.println("P1 is (" + p1.getCoordX()
                + "," + p1.getCoordY() + ")");

        p1.setCoordX(9.5);
        p1.setCoordY(-1.3);

        System.out.println("P1 is (" + p1.getCoordX()
                + "," + p1.getCoordY() + ")");

        p1.setCoordX(9.5);
        p1.setCoordY(3.3);

        System.out.println("P1 is (" + p1.getCoordX()
                + "," + p1.getCoordY() + ")");

        System.out.println("Distance from P1 to (0,0) is " +
                        p1.findDistance(0,0));

        System.out.println("Distance from P1 to P2 is " +
                p1.findDistance(p2));
    }
}
