
public class Die {
	public static final int DEFAULT_NUM_SIDES = 6;
	public static final int MIN_NUM_SIDES = 4;
	public static final int MAX_NUM_SIDES = 26;
	public static final int DEFAULT_NUM_VISIBLE = 1;
	
	
	private int numVisible;
	private int numSides;
	private String name;
	
	
	public Die() {
		numSides = DEFAULT_NUM_SIDES;
		numVisible = DEFAULT_NUM_VISIBLE;
		
	}
	
	public Die (int inputNumSides,
			int inputNumVisible){
		if (inputNumSides >=  MIN_NUM_SIDES && inputNumSides <= MAX_NUM_SIDES) {
			numSides = inputNumSides;
		}
		else {
			numSides = DEFAULT_NUM_SIDES;
		}
		if (inputNumVisible >= 1 && inputNumVisible <= numSides) {
			numVisible = inputNumVisible;
		}
		else {
			numVisible = DEFAULT_NUM_VISIBLE;
		}
		
	}
	
//	//getters
//	Get methods
//	write one "get" method for every private variable
//	take no input
//	return a value
			
	public int getNumVisible() {
		return numVisible;
	}
	
	public int getNumSides() {
		return numSides;
	}
//	
//	Set methods (** we don't actually WANT to have setters for the Die class)
//	set methods have one job--take an input, and assign to the private variable
//	no output, take ONE input
	
	public void setNumVisible(int inputNumVisible) {
		if (inputNumVisible >= 1 && inputNumVisible <= numSides) {
			numVisible = inputNumVisible;
		}
		else {
			numVisible = DEFAULT_NUM_VISIBLE;
		}
	}
	
//	roll method
//	input: none
//	output: none
//	side effect: no printing
//	description: selects a random number from 1 to numSides, and assigns to numVis
	
	public void roll() {
		numVisible = (int) (Math.random() * numSides) + 1;
		
	}
	
	
	
	
	
	
	
	
		
	

}















