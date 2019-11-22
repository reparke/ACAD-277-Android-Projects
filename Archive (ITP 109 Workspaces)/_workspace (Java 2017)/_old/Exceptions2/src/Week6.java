import java.util.Scanner;

public class Week6 {
	public static void main (String args[]) {
		Scanner input = new Scanner(System.in);
		
		int x = 30;
		int result = 0;
		
		System.out.println("Enter a number: ");
		
		int y = input.nextInt();
		
		try {
			result = x/y;
			System.out.println("The result is " + result);
		}
		catch (Exception e) {
			System.out.println("Oops, you divided by zero!");
		}
		
		
		
		
	}

}
