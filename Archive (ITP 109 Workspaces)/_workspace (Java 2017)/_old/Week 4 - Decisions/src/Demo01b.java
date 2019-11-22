import java.util.Scanner;

/*
 * Nathan Greenfield
 * ngreenfi@usc.edu
 * ITP 109, Spring 2013
 * This program demonstrates a problem with plurals
 */

public class Demo01b {
	public static void main(String[] args) {
		int duckNumber = 0;
		String duckAdjective;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number greater than 0: ");
		duckNumber = keyboard.nextInt();
		String ignored = keyboard.nextLine();
		
		if (duckNumber > 0)
		{
			System.out.println("\"" + duckNumber + "\" is a good number!");			
		}
		else
		{
			System.out.println("Hey shmoehawk -- I said GREATER THAN 0!");
			System.out.println("I'm gonna use 1 because you can't follow directions.");
		}
	}

}
