package acad277.intent_mvc.model;

import java.io.Serializable;

/**
 * Created by R on 3/8/2018.
 */

public class Order implements Serializable {
    //create instance variables
    private String drink;   //coffee or tea or future drink plans
    private boolean wantsIced;
    private boolean wantsCream;

    public Order() {

    }

    public Order(String drink, boolean wantsIced, boolean wantsCream) {
        this.drink = drink;
        this.wantsIced = wantsIced;
        this.wantsCream = wantsCream;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public boolean isWantsIced() {
        return wantsIced;
    }

    public void setWantsIced(boolean wantsIced) {
        this.wantsIced = wantsIced;
    }

    public boolean isWantsCream() {
        return wantsCream;
    }

    public void setWantsCream(boolean wantsCream) {
        this.wantsCream = wantsCream;
    }

    @Override
    public String toString() {
        return "Order{" +
                "drink='" + drink + '\'' +
                ", wantsIced=" + wantsIced +
                ", wantsCream=" + wantsCream +
                '}';
    }
}





