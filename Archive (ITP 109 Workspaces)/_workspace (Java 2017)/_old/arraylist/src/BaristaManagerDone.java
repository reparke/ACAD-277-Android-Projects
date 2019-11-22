// For Docs and Utils





import java.util.ArrayList;
import java.util.Scanner;

public class BaristaManagerDone {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Hello! How many baristas would you like to create? (integer greater than 1)");
		int numBaristas = 2;
		try {
			numBaristas = input.nextInt();
			if(numBaristas < 2){
				numBaristas = 2;
				throw new Exception(); // Do this to get the Invalid entry print
			}
		} catch (Exception e) {
			System.out.println("Invalid entry, setting number of baristas to 2\n");
		}
		input.nextLine(); // clear buffer
		
		//Barista[] baristas = new Barista[numBaristas];
		ArrayList<Barista> baristas2 = new ArrayList<Barista>();

		System.out.println("Enter names");
		for(int i = 0; i < numBaristas; ++i){
			System.out.print(i + ": ");
			//baristas[i] = new Barista(input.nextLine());
			baristas2.add(new Barista(input.nextLine()));
		}
		
		int choice = 0;
		while(choice != -1){
			printMenu();
			choice = input.nextInt();
			input.nextLine();
			
			switch (choice) {
				case 1:
					printBaristas(baristas2);
					break;
				case 2:
					addBarista(baristas2);
					break;
				case 3:
					removeBarista(baristas2);
					break;
				case -1:
					System.out.println("Goodbye.");
					break;
				default:
					System.out.println("Please select a valid option.");
			}
		}
		
	}
	
	private static void printMenu() {
		System.out.println("\nPlease enter one of the following choices:");
		System.out.println("  1 --> Print baristas");
		System.out.println("  2 --> Add a barista");
		System.out.println("  3 --> Remove a barista");
		System.out.println(" -1 --> Quit");
	}
	
	private static void printBaristas(ArrayList<Barista> baristas) {
		for(int i = 0; i < baristas.size(); i++){
			System.out.println(i + ": " + baristas.get(i).getName());
		}
	}

	private static void addBarista(ArrayList<Barista> baristas) {
		System.out.println("Enter the name of the new barista");
		Barista newBarista = new Barista(input.nextLine());
		
		//System.out.println("Don't know what to do next");
		baristas.add(newBarista);
	}
	
	private static void removeBarista(ArrayList<Barista> baristas) {
		System.out.println("Enter the index of the barista to remove");
		int index = -3;
		try {
			index = input.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		input.nextLine(); // clear buffer
		
		if(index < 0 || index > baristas.size() - 1){
			System.out.println("Error: index doesn't exist");
		}
		else {
			//System.out.println("Don't know what to do next");
			baristas.remove(index);
		}
	}
	
}
