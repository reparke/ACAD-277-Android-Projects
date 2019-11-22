package itp341.lists.model;


public class Food {
    private String name;
    private String location;
    private int quantityLeft;

    @Override
    public String toString() {
        return name + " (" + location +") x "+ quantityLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public Food(String name, String location, int quantityLeft) {

        this.name = name;
        this.location = location;
        this.quantityLeft = quantityLeft;
    }
    public Food() {

    }
}








