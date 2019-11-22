/*Name: Suong Phan
 *Email address: phansuong289@yahoo.com
 * ITP 109, Spring 2015
 * This programming calculates 2 things.
 * First is to calculate the largest integer.
 * Second is to calculate the factorial of an integer.
 */

import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in );

		System.out.println("Please choose one of the following: ");

		int choice = 0;
		while (choice != -1) // choice can't be -1 {
			System.out.println("1. Largest Number \n" + "2. Factorial \n" + "-1. Quit ");
			choice = input.nextInt();

			switch (choice) {
				case -1:	//equivalent to choice equals ("-1")
				System.out.println("Good bye! ");
				break;
				case 1:		//equivalent to choice equals ("1")
					System.out.println("Input an integer greater than or equal to 0 or -1 to quit: ");
					int largestNumber = 0;
					int userInput = 0;

					while (userInput != -1) {
						userInput = input.nextInt();
						if (userInput > largestNumber) {
							largestNumber = userInput;
						}
					}
					System.out.println("The largest number is " + largestNumber);
					break;
				case 2:		//equivalent to choice equals ("2")
					System.out.println("Please enter an interger to calculate the factorial: ");
					int factorialNumber = 0;
					factorialNumber = input.nextInt();

					if (factorialNumber < 0) {
						System.out.println("Error! Can't be negative number ");

					} else if (factorialNumber == 0) {
						System.out.println("The factorial of 0 is 1 ");

					} else {
						long newFactorial = 1;
						for (int i = 1; i <= factorialNumber; i++) 
							// new factorial number will be equal new factorial times i
							{
							newFactorial = newFactorial * i;
						}
						System.out.println("The factorial of " + factorialNumber + " is " + newFactorial);

					}
					break;
				default:
					System.out.println("Invalid choice ");
					break;
			}
			input.close();
		}
		
	}

