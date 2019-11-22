
public class Program {
	public static void main(String[] args) {
		Filledchocolate fc1 = new Filledchocolate("Reese's", 25.0, "Peanut butter");
		fc1.writeOutput();
		fc1.reset("Caramello", 15.0, "Caramel");
		System.out.println("fc1 is: ");
		fc1.writeOutput();
		
		Filledchocolate fc2 = new Filledchocolate("Reese's", 25.0, "Peanut butter");
		System.out.println("\nfc2 is:");
		fc2.writeOutput();
		if (fc1.equals(fc2))
			System.out.println("Same chocolate");
		else
			System.out.println("Different chocolate");
		
		// hasSameName inherited from Chocolate which is inherited from Candy
		if (fc1.hasSameName(fc2))
			System.out.println("Same names");
		else
			System.out.println("Different names");

		Filledchocolate fc3 = new Filledchocolate("Reese's", 25.0, "Peanut butter");
		System.out.println("\nfc3 is:");
		fc3.writeOutput();
		if (fc3.equals(fc2))
			System.out.println("Same chocolate");
		else
			System.out.println("Different chocolate");
	}

}
