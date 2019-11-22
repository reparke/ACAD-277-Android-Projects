import java.util.Scanner;

/*
 * For Lecture 2/19/14
 */
public class EarlyClassLabExample {

	public static void main(String[] args) {

		int menu = 0;
		boolean quit = false;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Welcome to Lab 5");

		while (quit != true) {
			printMenu();
			int choice = keyboard.nextInt();
			int num = 0;

			switch (choice) {
			case 1:
				System.out.println("Find the Largest Number");
				int largest = findLargestNumber();
				break;
			case 2:
				System.out.println("Factorial");
				int factorial = calculateFactorial();
				// print
				break;
			case 3:
				doTemperatureConversion();
				break;
			case 4:
				System.out.println("Bar chart");
				makeBarChart(5);
				break;
			case 5:
				int sum = sumNumbers();
				System.out.println("The sum of the numbers is:" + sum);
				break;
			case -1:
				quit = true;
				break;
			default:
				System.out.println("Not a valid choice");
				break;
			}

		}

		System.out.println("Goodbye.");

	}

	public static void printMenu() {
		System.out.println("Please enter one of the following choices:");
		System.out.println("  1 --> Largest Number\n  " + "2 --> Factorial\n  "
				+ "3 --> Temperature Conversion\n " + "4 --> Draw Bar Chart\n "
				+ "5 --> Sum Numbers\n" +
				// "5 --> Calculate Fibonacci\n" +
				"-1 --> Quit");
	}

	public static void makeBarChart(int numberOfLines) {
		String chart = "";
		for (int x = 0; x < numberOfLines; x++) {
			int number = EarlyClassExample.getNumberBetween(1, 30);
			chart += makeStarLine(number);
		}
		System.out.println(chart);
	}

	public static String makeStarLine(int number) {
		String s = (number + " ");
		for (int i = 0; i < number; i++) {
			s += "*";
		}
		s += "\n";
		return s;
	}

	private static void doTemperatureConversion() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Temperature Conversion");
		System.out
				.println("Enter a temperature in degrees (for example 29.6):");
		double temp = keyboard.nextDouble();
		System.out
				.println("Enter 'F' (or 'f') for Fahrenheit or 'C' (or 'c') for Celsius: ");
		String type = keyboard.next();
		double convertedTemp = 0;
		if (type.equalsIgnoreCase("f")) {
			convertedTemp = (5 * (temp - 32)) / 9.0;
			System.out.println(temp + " degrees F = " + convertedTemp
					+ " degrees Celsius");
		} else if (type.equalsIgnoreCase("c")) {
			convertedTemp = ((9 * temp) / 5.0) + 32;
			System.out.println(temp + " degrees C = " + convertedTemp
					+ " degrees Fahrenheit");

		} else {
			System.out.println("ERROR: " + type
					+ " is an unknown input. Only 'F' or 'c' are allowed");
		}

	}

	private static int calculateFactorial() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int findLargestNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int sumNumbers() {
		System.out.println("Enter numbers to sum, -1 to quit");
		int sum = 0;
		Scanner keyboard = new Scanner(System.in);
		int num = keyboard.nextInt();
		while (num != -1) {
			sum += num;
			System.out.println("Enter next number to sum, -1 to quit");
			num = keyboard.nextInt();
		}
		return sum;

	}

}
