///*
// * create a superhero class
// */
public class Barista {

	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void displayGreeting(){ 
		System.out.println("Hi, I'm " + name + ".  I'll ring up your order");
	}
	
	public void finalizeOrder(Order order1) {
		double total = order1.calcCost();
		order1.printOrder();
		System.out.println("Your total will be $" + total + ". Thanks for shopping!");
		
	}
}




