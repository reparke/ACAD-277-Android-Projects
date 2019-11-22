package acad277;

import java.util.Random;

public class Die {
    private int numSides;
    private int result;

    Die(int sides) {
        numSides = sides;
        result = 0;
    }
    Die() {
        numSides = 6;
        result = 0;
    }
    public int roll() {
        Random random = new Random();
        result = random.nextInt(numSides)+1;
        return result;
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
