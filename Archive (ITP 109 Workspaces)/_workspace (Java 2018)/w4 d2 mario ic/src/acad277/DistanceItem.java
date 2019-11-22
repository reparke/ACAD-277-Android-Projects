package acad277;

/*
    range : int
    frequency : double
    accuracy : double
    duration : int

    capacity : int
 */

//to establish inheritance,
public class DistanceItem extends Item{
    private int capacity;

    public DistanceItem(String itemName, String itemColor, int itemDamage, int itemCapacity) {
        //WHENEVER THERE IS A CHILD CLASS, THE FIRST THING THE CONSTRUCTOR MUST DO
        //IS CALL THE PARENT CONSTRUCTOR
        super(itemName, itemColor, itemDamage);
        capacity = itemCapacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //override the use method
    //to override (or block) a method from the parent class
    //simply create a method with the SAME NAME AND PARAMETERS
    public void use() {
        if (capacity > 0) {
            capacity--;
            System.out.println("Using " + getName() + " (capacity = " + capacity + ")");
        }
        else {
            System.out.println(getName() + " is empty!");
        }
    }


}






