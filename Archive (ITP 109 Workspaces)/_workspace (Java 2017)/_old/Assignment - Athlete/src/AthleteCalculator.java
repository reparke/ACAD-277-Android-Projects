import java.util.Scanner;

public class AthleteCalculator {

	// Methods:

	/*
	 * Description: gets the total number of yards ran by all of the athletes
	 * Input: Athlete [] athletes 
	 * Output: int total number of yards 
	 * Side Effect: none
	 */
	public int getTotalYards(Athlete[] athletes) {
		int sum = 0;
		for (int i = 0; i < athletes.length; i++) {
			athletes[i].getYardsRan();
			sum += athletes[i].getYardsRan();
		}
		return sum;
	}

	/*
	 * Description: averages the total number of yards ran by all of the
	 * athletes 
	 * Input: Athlete [] athletes 
	 * Output: double average number of yards 
	 * Side Effect: none
	 */
	public double getAverageYards(Athlete[] athletes) {
		int total = getTotalYards(athletes);
		return (double) total / athletes.length;
	}

	/*
	 * Description: adds yards to a specific athlete 
	 * Input: Athlete [] athletes
	 * Output: none 
	 * Side Effect: none
	 */

	public void addYardsToAthlete(Athlete[] athletes) {
		Scanner input = new Scanner(System.in);
		int index = -1;
		int pickYards = 0;
		for (int i = 0; i < athletes.length; i++) {
			System.out.println((i + 1) + ":	" + athletes[i].getName());
		}
		System.out
				.println("Pick the number of the athlete you wish to add yards to.");
		index = input.nextInt();
		System.out.println("How many yards do you want to add?");
		pickYards = input.nextInt();
		athletes[(index - 1)].addYards(pickYards);
	}

	/*
	 * Description: gets the index of the athlete with the largest number of
	 * yards 
	 * Input:Athlete [] athletes 
	 * Output: int index of the athletes array
	 * Side Effect: none
	 */

	public int getMaxIndex(Athlete[] athletes) {
		int maxYards = 0;
		int index = -1;
		for (int i = 0; i < athletes.length; i++) {
			if (athletes[i].getYardsRan() > maxYards) {
				maxYards = athletes[i].getYardsRan();
				index = i;
			}
		}
		return index;
	}

	/*
	 * Description: gets the index of the athlete with the smallest number of
	 * yards 
	 * Input: Athlete [] athletes 
	 * Output: int index of the athletes array
	 * Side Effect: none
	 */

	public int getMinIndex(Athlete[] athletes) {
		int minYards = 1000000000;
		int index = -1;
		for (int i = 0; i < athletes.length; i++) {
			if (athletes[i].getYardsRan() < minYards) {
				minYards = athletes[i].getYardsRan();
				index = i;
			}
		}
		return index;
	}

	/*
	 * Description: prints out the name and yard for each athlete 
	 * Input: Athlete [] athletes 
	 * Output: void 
	 * Side Effect: none
	 */

	public void printAthletes(Athlete[] athletes) {
		for (int i = 0; i < athletes.length; i++) {
			athletes[i].display();
		}
	}

}
