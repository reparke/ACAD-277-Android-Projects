package acad277;

public class Point {
    //instance variables
    private double xCoord;
    private double yCoord;

    //default constructor aka no input
    public Point() {
        xCoord = 0;
        yCoord = 0;
    }
    //second constructor
    //"overloaded" constructor when it has input
    public Point(double x, double y) {
        xCoord = x;
        yCoord = y;
    }
    //getters
    public double getXCoord() {
        return xCoord;
    }
    public double getYCoord() {
        return yCoord;
    }
    //setters
    public void setxCoord(double x) {
        xCoord = x;
    }
    public void setYCoord(double y) {
        yCoord = y;
    }

    //toString ALWAYS...
    //returns a string, and takes no input
    //sole job to create "pleasing" text version of object
    public String toString() {
        //DOES NOT CALL PRINTLN
        String msg = "(" + xCoord + ", " + yCoord + ")";
        return msg;
     }




}






