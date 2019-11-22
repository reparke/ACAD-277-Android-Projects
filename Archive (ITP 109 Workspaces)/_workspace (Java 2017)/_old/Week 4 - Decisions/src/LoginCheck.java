import java.util.Scanner;

public class LoginCheck {
	public static void main(String[] args) {
		final String correctUserName = "ttrojan";
		final String correctPassword = "traveler";
		String userName, password;

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter your name: ");
		userName = keyboard.nextLine();
		System.out.print("Please enter your password: ");
		userName = keyboard.nextLine();
		
		System.out.println("Welcome, " + userName);
		
		
}
