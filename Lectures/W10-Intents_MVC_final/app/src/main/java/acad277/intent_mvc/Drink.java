package acad277.intent_mvc;

import java.io.Serializable;

/**
 * Created by R on 3/21/2017.
 */

public class Drink implements Serializable{
    private String type;


    private boolean wantsHot;
    private boolean wantsCream;

    public Drink() {
        this.type = "";
        this.wantsHot = false;
        this.wantsCream = false;
    }
    public Drink(String type, boolean wantsHot, boolean wantsCream) {
        this.type = type;
        this.wantsHot = wantsHot;
        this.wantsCream = wantsCream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWantsHot() {
        return wantsHot;
    }

    public void setWantsHot(boolean wantsHot) {
        this.wantsHot = wantsHot;
    }

    public boolean isWantsCream() {
        return wantsCream;
    }

    public void setWantsCream(boolean wantsCream) {
        this.wantsCream = wantsCream;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "type='" + type + '\'' +
                ", wantsHot=" + wantsHot +
                ", wantsCream=" + wantsCream +
                '}';
    }
}
