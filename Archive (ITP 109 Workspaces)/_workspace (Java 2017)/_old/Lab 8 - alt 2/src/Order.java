
public class Order {
	private double costPerPound;
	private int pounds;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCostPerPound() {
		return costPerPound;
	}
	public void setCostPerPound(double costPerPound) {
		this.costPerPound = costPerPound;
	}
	public int getPounds() {
		return pounds;
	}
	public void setPounds(int pounds) {
		this.pounds = pounds;
	}

	public void printOrder(){
		System.out.println("Order: " + name + " for " + pounds + " lbs  @ $" + costPerPound + "/lb");
	}
	public double calcCost() {
		return costPerPound * pounds;
	}
	
	
}
