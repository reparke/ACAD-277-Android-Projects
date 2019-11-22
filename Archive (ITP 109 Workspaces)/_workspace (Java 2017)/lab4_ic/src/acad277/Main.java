package acad277;

public class Main {

    public static void main(String[] args) {
        //RIGHT HERE

        System.out.println("The default number of sides for the die class is " + Die.DEFAULT_NUM_SIDES);

	    Die d1 = new Die(); //use default constructor
        Die d2 = new Die(26); //use overloaded constructor
        double total = 0;
        double total2 = 0;
        for (int i = 0; i<1000; i++) {
            total = total + d1.roll();
            total2 = total2 + d2.roll();
        }
        System.out.println("The average of 1000 rolls of d1 " + total/1000);
        System.out.println("The average of 1000 rolls of d2 " + total2/1000);

        //---------------------

        int counter = 0;
        int numInARow = 0;
        //d1 rolls
        /*
            while we don't have 5 in a row
                roll die
                if die roll is 3
                    counter increase
                    numRow increase
                else die is NOT 3
                    counter increase
                    reset numRow to 0
         */
        while (numInARow != 5) {
            if (d1.roll() == 3) {
                counter++;
                numInARow++;
            }
            else {
                counter++;
                numInARow = 0;
            }
        }
        System.out.println("The number of rolls for a die with " + d1.getNumSides() +" was " + counter);

        //reset my counters
        numInARow = 0;
        counter = 0;
        while (numInARow != 5) {
            if (d2.roll() == 3) {
                counter++;
                numInARow++;
            }
            else {
                counter++;
                numInARow = 0;
            }
        }
        System.out.println("The number of rolls for a die with " + d2.getNumSides() + " sides was " + counter);









    }
}
