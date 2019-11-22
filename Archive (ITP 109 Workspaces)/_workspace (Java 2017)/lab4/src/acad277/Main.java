package acad277;

public class Main {

    public static void main(String[] args) {
        Die d1 = new Die();
        int rollValues = 0;

        for (int i = 0; i < 1000; i++) {
            rollValues += d1.roll();
        }

        System.out.println("The average value of 1000 rolls of a die with "
                + d1.getNumSides() + " sides is " + rollValues/1000.0);

        //==========================================
        Die d2 = new Die(26);
        rollValues = 0;

        for (int i = 0; i < 1000; i++) {
            rollValues += d2.roll();
        }

        System.out.println("The average value of 1000 rolls of a die with "
                + d2.getNumSides() + " sides is " + rollValues/1000.0);

        //==========================================
        int numInARow = 0;
        int numRolls = 0;

        while (numInARow != 5) {
            d1.roll();
            numRolls++;
            if (d1.getResult() == 3) {
                numInARow++;
            }
            else {
                numInARow = 0;
            }
        }
        System.out.println("It took "+ numRolls
                + " rolls to get the number 3 to appear 5 times on a die with "
                + d1.getNumSides() + " sides");

        //==========================================
        numInARow = 0;
        numRolls = 0;

        while (numInARow != 5) {
            d2.roll();
            numRolls++;
            if (d2.getResult() == 3) {
                numInARow++;
            }
            else {
                numInARow = 0;
            }
        }
        System.out.println("It took "+ numRolls
                + " rolls to get the number 3 to appear 5 times on a die with "
                + d2.getNumSides() + " sides");


    }

}
