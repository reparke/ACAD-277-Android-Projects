
public class Die {
	public static int DEFAULT_NUM_SIDES = 6;
	
	private int num;
	private int numSides;

	public Die() {
		numSides = DEFAULT_NUM_SIDES;

	}
	public Die(int newNumSides) {
		//error checking
		numSides = newNumSides;

	}
	
	public int getNum() {return num;}
	public int getNumSides() {return numSides;}

//	//purposefully omit these methods
//	public void setNum(int input) { num = input;}
//	public void setNumSides(int input) { numSides = input;}
	
	public void roll() {
		num = (int) (Math.random() * numSides) + 1;
	}


}
