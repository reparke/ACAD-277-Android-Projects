


/* class order
 * instance variables
 * 	name is a String
 * 	pounds is an int
 * 	costPerPound is a double
 */
public class Order {
	// variables declaration
	private String name;
	private int pounds;
	private double costPerPound;
	
	// get / set methods
	public String getName(){
		return name;
	}
	public int getPounds() {
		return pounds;
	}
	public double getCostPerPound() {
		return costPerPound;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	public void setPounds(int newPounds) {
		pounds = newPounds;
	}
	public void setCostPerPound(double newCostPerPound){
		costPerPound = newCostPerPound;
	}
	
	// method section
	/* calcCost
	 * input: none
	 * output: returns pounds * costPerPound
	 */
	public double calcCost(){
		double cost = pounds * costPerPound;
		return cost;
	} 
	
	/* displayOrder
	 * input: none
	 * output: none
	 * side-effect: prints a summary of the order to the screen
	 */
	public void displayOrder(){
		System.out.println("Order: " + name + " for " + pounds +
							" lbs @ $" + costPerPound + "/lb");
	}
}













