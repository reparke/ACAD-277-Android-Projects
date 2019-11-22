import java.util.Scanner;

/*
 * Nathan Greenfield
 * ngreenfi@usc.edu
 * ITP 109, Spring 2013
 * This program demonstrates a problem with plurals
 */

public class Demo01a {
	public static void main(String[] args) {
		int duckNumber = 0;
		String duckAdjective;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		duckNumber = keyboard.nextInt();
		String ignored = keyboard.nextLine();
		System.out.print("Please enter an adjective: ");
		duckAdjective = keyboard.nextLine();
		
		System.out.println("You own \"" + duckNumber + "\" \""
				+ duckAdjective + "\" ducks");
	}

}
