/*
 * Nathan Greenfield
 * ngreenfi@usc.edu
 * ITP 109, Spring 2013
 * This program demonstrates a solution to 
 * the floats problem.
 */

public class DemoFloatsSolution {
	public static void main(String[] args) {
		double firstNum = 2.00;
		double secondNum = 1.10;
		double answer = 0.0;

		System.out.println("Is \"" + firstNum + 
			"\" - \"" + secondNum + "\" = 0.9?");
		answer = firstNum - secondNum;
		if ((answer > 0.89) && (answer < 0.91))
			System.out.println("\tApproximately");
		else
			System.out.println("\tNo");
	}
}
