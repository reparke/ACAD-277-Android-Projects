package acad277;

public class Main {

    public static void main(String[] args) {
        Item i = new Item("coin", "yellow", 0);
        i.use();

        DistanceItem flower = new DistanceItem("flower", "yellow", 10, 8);
        DistanceItem ice = new DistanceItem("ice balls", "white", 10, 9);
        CloseItem baseballBat = new CloseItem("baseball bat", "tan", 5, true);

        //polymorphism -- parent class can represent ANY child class
        Item[] yoshiBag = new Item[3];
        yoshiBag[0] = flower;
        yoshiBag[1] = ice;
        yoshiBag[2] = baseballBat;


        //GOAL: we want to call throwItem for CLOSEITEM, and call use for everything else
        for (int index = 0; index < yoshiBag.length; index++) {
            if (yoshiBag[index] instanceof CloseItem ) {
                //we have to CAST this to a closeItem
                CloseItem c = (CloseItem) yoshiBag[index];
                c.throwItem();
            }
            else {
                yoshiBag[index].use();

            }

        }











    }
}
