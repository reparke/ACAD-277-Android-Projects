package acad277;

import java.util.ArrayList;

public class Barista {
    public static final int MAX_ORDERS = 3;

    private String name;
    private ArrayList<Coffee> orders;   //arraylist is JUST like an array, except it can grow and shrink

    public Barista(String baristaName) {
        name = baristaName;

        //init arraylist
        orders = new ArrayList<Coffee>();
    }

    public void makeDrinks(){
        //do some stuff
        orders.clear();
    }
}






