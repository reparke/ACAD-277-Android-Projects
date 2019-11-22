package acad277;

import java.util.Random;

public class Die {

    //define constants (final means can't change)
    public static final int DEFAULT_NUM_SIDES = 6;
    public static final int MIN_NUM_SIDES = 0;
    public static final int MAX_NUM_SIDES = 26;
    public static final int DEFAULT_RESULT = 0;

    private int numSides;
    private int numResult;


    //default constructor
    public Die() {
        numSides = DEFAULT_NUM_SIDES; //default sides
        numResult = DEFAULT_RESULT;
    }

    //overloaded constructor
    //a second (or third, etc.) constructor
    //MEANS say name, but different number or type of parameters
    public Die(int sides) {
        if (sides > MIN_NUM_SIDES && sides <= MAX_NUM_SIDES) {
            numSides = sides;
        } else {
            numSides = DEFAULT_NUM_SIDES;
        }

        numResult = DEFAULT_RESULT;
    }

    //Getters
    public int getNumSides() {
        return numSides;
    }

    public int getNumResult() {
        return numResult;
    }
//
//    //setters
//    public void setNumSides(int sides) {
//        numSides = sides;
//    }
//
//    public void setNumResult(int result) {
//        numResult = result;
//    }

    public int roll() {
        Random random = new Random();

        numResult = random.nextInt(numSides) + 1;
        return numResult;
    }
}




