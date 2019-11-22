//

import java.util.Scanner; 

public class VendingMachine {

	public static void main(String[] args) {
		final int DOLLAR = 100;
		final int QUARTER = 25;
		final int DIME = 10;
		final int NICKEL = 5;
		final int PENNY = 1;
		
		Scanner keyboard = new Scanner(System.in); 

		System.out.println("Vending Machine");
		System.out.println("Enter the price on an item in cents (25-100)");
		int itemPrice = keyboard.nextInt();
		System.out.println("You have bought an item for "+ itemPrice +" cents and gave me a dollar.");
		
		int change = DOLLAR - itemPrice;
		System.out.println("Your change ("+ change +") is");
		
		int quarters = change / QUARTER;
		int temp = change % QUARTER; 
		int dimes = temp / DIME;
		temp = change % DIME; 
		int nickels = temp / NICKEL;
		temp = change % NICKEL; 
		int pennies = temp / PENNY;
		temp = change % PENNY;
				
		System.out.println(quarters +" Quarters");
		System.out.println(dimes +" Dimes");
		System.out.println(nickels +" Nickels");
		System.out.println(pennies +" Pennies");
		System.out.println("Thank you. Have a nice day!");
	}

}
