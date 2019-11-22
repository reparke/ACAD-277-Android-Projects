import java.util.Scanner;

public class EarlyClassExample {
	public static void main(String[] args) {
		int num = getNumberBetween(1, 30);
		System.out.println("number is: " + num);
		num = getNumberBetween(1, 100);
		System.out.println("number is: " + num);
		num = getNumberBetween(90, 100);
		System.out.println("number is: " + num);
	}

	public static int getNumberBetween(int min, int max) {
		System.out.println("Please enter a number, between " + min + " and "
				+ max);
		Scanner keyboard = new Scanner(System.in);
		int num = keyboard.nextInt();

		while (num < min || num > max) { // bad input
			System.out.println("Please enter a number, between " + min
					+ " and " + max);
			num = keyboard.nextInt();
		}
		return num;
	}

	public static int getMenuChoice(int min, int max, int quitOption) {
		System.out.println("Please enter a number, between " + min + " and "
				+ max);
		Scanner keyboard = new Scanner(System.in);
		int num = keyboard.nextInt();
		while (num != quitOption && (num < min || num > max)) { // bad input
			System.out.println("Please enter a number, between " + min
					+ " and " + max);
			num = keyboard.nextInt();
		}
		return num;
	}

}
