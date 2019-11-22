
public class Barista {
	// variable
	private String name;
	
	// get / set
	public String getName() {
		return name;
	}
	public void setName(String newName){
		name = newName;
	}
	
	//method
	public void displayGreeting(){
		System.out.println("Hello, my name is " + name +
						" and I'll be your barista");
	}
	
	public void finalizeOrder(Order newOrder){
		newOrder.displayOrder();
		System.out.println("Your order costs "+ newOrder.calcCost());
		
	}
	
	
}








