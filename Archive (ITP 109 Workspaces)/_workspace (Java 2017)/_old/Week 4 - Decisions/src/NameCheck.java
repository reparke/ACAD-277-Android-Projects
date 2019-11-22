import java.util.Scanner;

/*
 * Nathan Greenfield
 * ngreenfi@usc.edu
 * ITP 109, Spring 2013
 * I'll greet myself!
 */

public class NameCheck {
	public static void main(String[] args) {
		String myName = "Nathan", upperName = "NATHAN", userName;

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter your name: ");
		userName = keyboard.nextLine();
		
		if (userName.equals(myName))
			System.out.println("Welcome back " + myName + "!");
		else if (userName.equals(upperName))
		{
			System.out.println("Welcome back " + myName + "!");
			System.out.println("Your CapsLock is on.");
		}
		else if (userName.equalsIgnoreCase(myName))
		{
			System.out.println("Welcome back " + myName + "!");
			System.out.println("Better check the shift key");
		}
		else
			System.out.println("Who are you?");
	}

}
