// For Docs and Utils





import java.util.Scanner;

public class SuperheroManager {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Hello! How many heroes would you like to create? (integer greater than 1)");
		int numHeroes = 2;
		try {
			numHeroes = input.nextInt();
			if(numHeroes < 2){
				numHeroes = 2;
				throw new Exception(); // Do this to get the Invalid entry print
			}
		} catch (Exception e) {
			System.out.println("Invalid entry, setting number of heroes to 2\n");
		}
		input.nextLine(); // clear buffer
		
		Superhero[] heroes = new Superhero[numHeroes];
		
		System.out.println("Enter names");
		for(int i = 0; i < numHeroes; ++i){
			System.out.print(i + ": ");
			heroes[i] = new Superhero(input.nextLine());
		}
		
		int choice = 0;
		while(choice != -1){
			printMenu();
			choice = input.nextInt();
			input.nextLine();
			
			switch (choice) {
				case 1:
					printHeroes(heroes);
					break;
				case 2:
					addHero(heroes);
					break;
				case 3:
					removeHero(heroes);
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
		System.out.println("  1 --> Print heroes");
		System.out.println("  2 --> Add a hero");
		System.out.println("  3 --> Remove a hero");
		System.out.println(" -1 --> Quit");
	}
	
	private static void printHeroes(Superhero[] heroes) {
		for(int i = 0; i < heroes.length; i++){
			System.out.println(i + ": " + heroes[i].getName());
		}
	}

	private static void addHero(Superhero[] heroes) {
		System.out.println("Enter the name of the new hero");
		Superhero newHero = new Superhero(input.nextLine());
		
		System.out.println("Don't know what to do next");
	}
	
	private static void removeHero(Superhero[] heroes) {
		System.out.println("Enter the index of the hero to remove");
		int index = -3;
		try {
			index = input.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid entry");
		}
		input.nextLine(); // clear buffer
		
		if(index < 0 || index > heroes.length - 1){
			System.out.println("Error: index doesn't exist");
		}
		else {
			System.out.println("Don't know what to do next");
		}
	}
	
}
