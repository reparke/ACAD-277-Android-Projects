

public class DrinkOrder {
	// Constants to make sizes
	public static final String SMALL = "small";
	public static final String MEDIUM = "medium";
	public static final String LARGE = "large";
	
	// Static variable - shared for all instances of DrinkOrder, keeps track of all drinks made
	// public static int numberOfDrinks = 0;
	
	private String size;
	private String temperature;
	private boolean wantsCream;
	private String drinkName;
	private String customerName;
	private double cost;

	

	public DrinkOrder(String size, String temperature, boolean wantsCream,
			String drinkName, String customerName, double cost) {
		super();
		this.size = size;
		this.temperature = temperature;
		this.wantsCream = wantsCream;
		this.drinkName = drinkName;
		this.customerName = customerName;
		this.cost = cost;
	}

	
	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	private String getTemperature(){

		return temperature;
	}
	
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}


	public boolean wantsCream() {
		return wantsCream;
	}

	public void setWantsCream(boolean wantsCream) {
		this.wantsCream = wantsCream;
	}
	
	private String getCreamString(){
		if(wantsCream()){
			return "with cream";
		}
		else return "with NO cream";
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFullDrinkString(){
		return getSize() + " " + getTemperature() + " " +  getDrinkName() + " " + getCreamString();
	}

	
}
