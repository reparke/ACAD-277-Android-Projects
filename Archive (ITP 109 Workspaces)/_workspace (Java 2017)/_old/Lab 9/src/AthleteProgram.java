import java.util.Scanner;

/* Bryan Mercado
bmercado@usc.edu
ITP 109, Fall 2014
This is a program that allows a user to enter any number of athletes and compare their yards gained
import java.util.Scanner;
*/

public class AthleteProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int athletes = 0;
		int choice = 0;
		System.out.println ("How many many athletes will be competing?");
		athletes = input.nextInt();
		int [] athlete = new int [athletes];
		String [] newAthlete = new String [athletes];
		double [] yards = new double [athletes];
		for (int index = 0; athletes > index; index=index+1) {
			String name = "";
			System.out.println ("Please enter athlete name:");
			name = input.nextLine();
			newAthlete [index] = input.nextLine();


			System.out.println ("Enter athlete yards:");
			yards [index] = input.nextDouble ();
		}
		//allows the user to choose what they want to view from the inputed data
		while(choice != -1){
			displayMenu();
			choice = input.nextInt();

			switch (choice){
			case 1://call method get total yards
				System.out.println("The total yards ran is" + getTotal(yards));

				break;
			case 2: //call method get average 
				System.out.println("The average yards ran is " + getAverage(yards, athlete));
				break;
			case 3: //call method get most yards
				int maxIndex= getMaxIndex(yards);

				System.out.println("The athlete with the most yards is " + newAthlete[getMaxIndex(yards)] + " with " + yards[getMaxIndex(yards)] + " yards");
				break;
			case 4: //call method get least yards
				int minIndex= getMinIndex(yards);
				System.out.println("The athlete with the least yards is" + newAthlete[getMinIndex(yards)] + " with " +yards[getMinIndex(yards)] + " yards");
				break;
			case 5: // call method get athlete performance 
				System.out.println("Athlete performance: " );
				printInfo(newAthlete, yards);
				break;
			}
		}
		System.out.println("Goodbye");
	}
	//Method for menu
	static void displayMenu(){
		Scanner input = new Scanner(System.in); 
		System.out.println("1 -> Print out the total yards");
		System.out.println("2 -> Print out the average yards");
		System.out.println("3 -> Print out the athlete with the most yards ");
		System.out.println("4 -> Print out the athlete with the least yards ");
		System.out.println("5 -> Print out the info for all the athletes ");
		System.out.println("-1 --> Quit");
	}
	//calculates the total yards gained
	static double getTotal(double[] yards){
		double sum = 0;
		for(int x = 0; yards.length > x; x++)
			sum = sum + yards [x];
		return sum;
	}
	//calculates the average yards gained among the athletes
	static double getAverage(double[] yards, int[] athlete){ 
		double sum = 0;
		double average;
		for(int x = 0; yards.length > x; x++)
			sum = sum + yards[x];
		average = sum/ athlete.length;
		return average;
	}
	//gets the max index
	public static int getMaxIndex(double[] yards) { //not sure how to do it w/out athlete
		double longestRun = yards[0];
		int bestAthlete = 0;
		for(int x=1; yards.length > x; x++)
		{
			if(yards[x] > longestRun)
			{

				bestAthlete = x;
			}

		}

		return bestAthlete;

	}
	//gets the minimum index
	public static int getMinIndex(double[] yards) { //not sure how to do it w/out athlete
		double shortestRun = yards[0];
		int worstAthlete = 0;
		for(int x=1; yards.length > x; x++)
		{
			if(yards[x] < shortestRun)
			{

				worstAthlete = x;
			}

		}

		return worstAthlete;
	}
	static void printInfo(String[] athleteName, double[] yards){ 
		for( int x =0; athleteName.length > x; x++){
			System.out.println(athleteName[x] + " " + yards[x]);
		}

	}

}