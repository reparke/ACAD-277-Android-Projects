import java.util.Scanner;

/*
 * Nathan Greenfield
 * ngreenfi@usc.edu
 * ITP 109, Spring 2013
 * This program demonstrates a problem with plurals
 */

public class Demo01c {
	public static void main(String[] args) {
		String answer;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter your a number between 1 and 10");
		System.out.println("Ready? Now I'll guess it.");
		System.out.println("Is your number even (Y/N)? ");
		answer = keyboard.nextLine();
		
		if (answer.equalsIgnoreCase("Y"))
		{
			System.out.println("Is your number prime (Y/N)? ");
			answer = keyboard.nextLine();
			if (answer.equalsIgnoreCase("Y"))
				System.out.println("Your number is 2!");
			else
			{
				System.out.println("More calculation is needed");
			}
		}
		else if (answer.equalsIgnoreCase("N"))
		{
			System.out.println("Is your number prime (Y/N)? ");
			answer = keyboard.nextLine();
			if (answer.equalsIgnoreCase("Y"))
				System.out.println("More calculation is needed");
			else
			{
				System.out.println("Your number is 9!");
			}
		}
		else
		{
			System.out.println("Hey there! I only understand answers of "
					+ "\"Y\" and \"N\"!");
		}
	}

}
