/*
 * Keiko Kang
 * keikokan@usc.edu
 * ITP 109 Spring 2015
 * Description: this program stores and displays the stats of an athlete. 
 */

import java.util.Scanner;
import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		AthleteCalculator calc = new AthleteCalculator();

		int numAthletes = 0;
		String nameChoice = "";
		int yardsChoice = 0;
		int choice = 0;
		int maxIndex = -1;
		int minIndex = -1;

		System.out
				.println("How many athletes would you like to collect data for?");
		numAthletes = input.nextInt();
		input.nextLine();

		Athlete[] athletes = new Athlete[numAthletes];

		for (int i = 0; i < athletes.length; i++) {

			System.out.println("Please enter the name of player " + (i + 1));
			nameChoice = input.nextLine();

			System.out.println("Please enter the number of yards for "
					+ nameChoice);

			yardsChoice = input.nextInt();
			input.nextLine();

			athletes[i] = new Athlete(nameChoice, yardsChoice);
		}

		// Menu

		do {

			System.out
					.println(" 1) Print out total yards \n 2) Print out average yards "
							+ "\n 3) Add yards to a specific athlete \n 4) Print out athlete with the most yards"
							+ "\n 5) Print out athlete with the least yards \n 6) Print out info for all athletes"
							+ "\n -1) Quit");

			choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("The total number of yards ran is "
						+ calc.getTotalYards(athletes));
				break;
			case 2:
				System.out.println("The average number of yards ran is "
						+ calc.getAverageYards(athletes));
				break;
			case 3:
				calc.addYardsToAthlete(athletes);
				System.out.println("Added successfully");
				break;
			case 4:
				maxIndex = calc.getMaxIndex(athletes);
				System.out.println("The player who ran the most yards is "
						+ athletes[maxIndex].getName() + ". They ran "
						+ athletes[maxIndex].getYardsRan() + " yards.");
				break;
			case 5:
				minIndex = calc.getMinIndex(athletes);
				System.out.println("The player who ran the most yards is "
						+ athletes[minIndex].getName() + ". They ran "
						+ athletes[minIndex].getYardsRan() + " yards.");
				break;
			case 6:
				calc.printAthletes(athletes);
				break;
			}

		} while (choice != -1);
		System.out.println("Quitting...");
	}

}
