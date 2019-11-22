import java.util.Scanner;

public class Week1 {

	public static final int VOTING_AGE = 18;
	
	public static void main(String[] args) {
		String name = "";
		int age = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your first name? ");
		name = input.next();
		System.out.println("How old are you? ");
		age = input.nextInt();
		
		if (age >= VOTING_AGE) {
			System.out.println("You can vote");
		}
		else {
			System.out.println("You can not vote");
		}
		
		
	}

}
