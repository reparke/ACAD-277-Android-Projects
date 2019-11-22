
import java.util.Scanner;


public class Barista {

	private String name;
	private Scanner input = new Scanner(System.in);
	private static final double COST_SMALL = 3.99;
	private static final double COST_MEDIUM = 4.49;
	private static final double COST_LARGE = 4.99;
	

	public Barista(String name){ this.name = name;	}
	
	public String getName() { return name;	}
	public void setName(String name) {	this.name = name;	}


	private boolean askCream() {
		System.out.println("Do you want cream (Y, N)? ");
		String userResponse = input.next();
		boolean goodInput = false, wantsCream = true;

		while(!goodInput){
			//convert userResponse to wantsCream
			if( userResponse.equalsIgnoreCase("Y") ) {
				wantsCream = true; goodInput = true;
			}
			else if ( userResponse.equalsIgnoreCase("N") ) {
				wantsCream = false; goodInput = true;
			}
			else {
				System.out.println("I'm sorry. I didn't understand.");
			}
		}
		return wantsCream;
	}
	
	private String askTemperature() {
		System.out.println("Do you want hot or iced? ");
		String temperature = input.next();
		return temperature;
	}
	
	private String askCustomerName() {
		System.out.println("What is your name?");
		String customerName = input.next();
		return customerName;
	}
	private String askSize() {
		String size = ""; 
		boolean isGoodSize = false;
		while(!isGoodSize){
			System.out.println("What size coffee do you want (S,M,L)? ");
			String coffeeSize = input.next();
			if(coffeeSize.equalsIgnoreCase("S")){
				size = DrinkOrder.SMALL;
				isGoodSize = true;
			}
			else if (coffeeSize.equalsIgnoreCase("M")){
				size = DrinkOrder.MEDIUM;
				isGoodSize = true;
			}
			else if (coffeeSize.equalsIgnoreCase("L")){
				size = DrinkOrder.LARGE;
				isGoodSize = true;
			}
			else{
				System.out.println("So sorry. I didn't understand your size: " + coffeeSize);
			}
		}
		return size;
	}

	public void displayGreeting(){ 
		System.out.println("Hi, I'm " + name + ".  I'll ring up your order");
	}

	public DrinkOrder takeCustomerOrder(){

		String size = askSize();
		String temperature = askTemperature();

		System.out.println("What kind of drink do you want? ");
		String drinkName = input.next();
		boolean wantsCream = askCream();

		String customerName = askCustomerName();

		double cost;
		
		if (size.equalsIgnoreCase(DrinkOrder.SMALL)) 
			cost = COST_SMALL;
		else if (size.equalsIgnoreCase(DrinkOrder.MEDIUM))
			cost = COST_MEDIUM;
		else if (size.equalsIgnoreCase(DrinkOrder.LARGE))
			cost = COST_LARGE;
		else
			cost = 0;
		
		System.out.println("Thanks, " + customerName + ". That will be $" + cost + ".  Your drink will be up ready in a second.");
		
		DrinkOrder item1 = new DrinkOrder(size, temperature, wantsCream, drinkName, customerName, cost);
		
		
		return item1;
	}
	public void finalizeCustomerOrder(DrinkOrder order){

		System.out.println("I have a " + order.getFullDrinkString() + " for " + order.getCustomerName() + " ready!");
	}
}




