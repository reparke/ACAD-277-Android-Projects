package acad277;

/*
    mobility : boolean
    duration : int
    points : int
    size : int

    color : String
    name : String
    damage : int
 */

public class Item {
    private String name;
    private String color;
    private int damage;

    //constructor
    public Item(String itemName, String itemColor, int itemDamage) {
        name = itemName;
        color = itemColor;
        damage = itemDamage;
    }

    public String getName() { return name; }
    public void setName(String itemName) {name = itemName;}

    public String getColor() { return name; }
    public void setColor(String itemColor) {name = itemColor;}

    public String getDamage() { return name; }
    public void setDamage(String itemDamage) {name = itemDamage;}

    //this should never get called
    public void use() {
        System.out.println("Using generic weapon");
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", damage=" + damage +
                '}';
    }
}










