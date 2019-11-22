import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Die d1 = new Die();
		System.out.println("Die 1 with default constructor: " + d1.getNumSides());
		
		Die d2 = new Die(12);
		System.out.println("Die 2 with overload constructor: " + d2.getNumSides());
		
		//count dice rolls until sum is a user specified value
		int desiredSum = 0;
		int numRolls = 0;
		
		System.out.println("Enter a desired sum: ");
		desiredSum = input.nextInt();
		
		do {
			numRolls++;
			d1.roll();
			d2.roll();
		} while ((d1.getNum() + d2.getNum()) != desiredSum);
		
		System.out.println("It took " + numRolls + " to get sum of "
				+ desiredSum);
	}
}
