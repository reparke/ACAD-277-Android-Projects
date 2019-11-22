/*
 * Nathan Greenfield
 * ngreenfi@usc.edu
 * ITP 109, Spring 2013
 * This program demonstrates checking the user input
 */

import java.util.Scanner;

public class DuckDemo02 {
	public static void main(String[] args) {
		int duckNumber = 0;
		String ignored = "";
		boolean isOne;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number greater than 0: ");
		duckNumber = keyboard.nextInt();
		ignored = keyboard.nextLine();
		
		isOne = (duckNumber == 1);
		
		if (isOne)
		{
			System.out.println("There can be only 1");
		}
		else
		{
			System.out.println("\"" + duckNumber + "\" is a good number!");			
		}
	}

}
