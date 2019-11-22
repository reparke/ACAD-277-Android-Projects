/*
 * Nathan Greenfield
 * ngreenfi@usc.edu
 * ITP 109, Spring 2013
 * This program demonstrates the problem with floats...
 */

public class DemoFloatsProblem {
	public static void main(String[] args) {
		double firstNum = 2.00;
		double secondNum = 1.10;
		double answer = 0.0;

		System.out.println("Is \"" + firstNum + 
			"\" - \"" + secondNum + "\" = 0.9?");
		answer = firstNum - secondNum;
		if ((answer) == 0.9)
			System.out.println("\tYes!");
		else
			System.out.println("\tNo!");
	}
}
