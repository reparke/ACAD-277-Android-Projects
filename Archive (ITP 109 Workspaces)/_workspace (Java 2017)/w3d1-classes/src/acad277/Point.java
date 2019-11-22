package acad277;

public class Point {
    //instance variables
    //the data that is UNIQUE to every object
    //OOP rule is that data is (mostly) private
    private double coordX;
    private double coordY;

    // default (no-arg) constructor
    public Point() {
        coordX = 0;
        coordY = 0;
    }

    //second constructor (overloaded)
    public Point(double x, double y) {
        coordX = x;
        coordY = y;
    }

    //getters
    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    //setters
    public boolean setCoordX(double x) {
        //in our game, the valid X positions are 0, 10
        if (x >= 0 && x <= 10) {
            coordX = x;
            return  true;
        }
        else {
            System.out.println("Invalid move");
            return false;
        }
    }
    public boolean setCoordY(double y) {
        //in our game, the valid X positions are 0, 10
        if (y >= 0 && y <= 10) {
            coordY = y;
            return  true;
        }
        else {
            System.out.println("Invalid move");
            return false;
        }
    }
    //build method that calculates distance from this point to any X,Y point
    // Math.sqrt(( x1-x2)*( x1-x2) - (y1-y2)*(y1-y2)))

    public double findDistance(double x, double y) {
        double distance = 0;
        distance = Math.sqrt((coordX - x)*(coordX - x) + (coordY - y)*(coordY- y));
        return distance;
    }

    public double findDistance (Point otherPoint) {
        double distance = 0;
        distance = Math.sqrt(
                (coordX - otherPoint.getCoordX())*(coordX - otherPoint.getCoordX())
                        + (coordY - otherPoint.getCoordY())*(coordY- otherPoint.getCoordY()));
        return distance;
    }




}





