import java.util.Scanner;

public class week6 {

	public static void main(String[] args) {
		// declare variables
		Scanner input = new Scanner(System.in);
		int num = 0;
		int square = 0;
		String name = "";

		// get user input
		System.out.println("Enter a number to sum: ");
		num = input.nextInt();
		System.out.println("Enter your name: ");
		name = input.next();

		// call displaySum (which will print to console)
		displaySum(num, name);

		square = calcSquare(num);
		System.out.println("The square of " + num + " is " + square);
	}

	/*
	 * calcSquare Method 
	 * precondition (input): (int) x 
	 * postcondition (output): (int) x * x 
	 * description: calculates the square of a number
	 */
	public static int calcSquare(int x) {
		int temp = x * x;
		return temp;
	}

	/*
	 * displaySum Method 
	 * precondition (input): 
	 * 		(int) numberToSum: a number greater than 0 
	 * 		(String) userName 
	 * postcondition (output): none 
	 * side effects: displays the summation from zero to numberToSum along with the
	 * 		userName
	 */
	public static void displaySum(int numberToSum, String userName) {
		int sum = 0;
		for (int i = 0; i <= numberToSum; i++) {
			sum += i;
		}
		System.out.println("Hello, " + userName);
		System.out.println("The summation of " + numberToSum + " is " + sum);
	}

	/*
	 * printDay Method 
	 * precondition (input): none 
	 * postcondition (output): none
	 * description: prints a message to the console
	 */
	public static void printDay() {
		System.out.println("Today is Tuesday!");
	}

}
