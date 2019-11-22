import java.util.Scanner;


public class Week2InClass {

	static int numFilledSeats = 0;
	static Scanner in =  new Scanner(System.in);

	public static void main(String[] stuff){
		int numSeats = Integer.parseInt(stuff[0]);
		String[] allSeats = new String[numSeats];


		int choice = 0;

		System.out.println("Welcome to Ticket Sales!");
		while(choice != -1){
			System.out.println("Enter 1) to see filled seats, 2) to purchase, -1) exit");
			choice = in.nextInt();
			switch(choice) {
			case 1:
				printSeats(allSeats);
				break;
			case 2:
				buyTicket(allSeats);
				break;
			}

		}



	}

	public static void printSeats(String[] allSeats) {
		if (numFilledSeats == 0) {
			System.out.println("\tNo seats have been sold yet");
		}
		else {
			for(int i = 0; i < numFilledSeats; i++) {
				System.out.println(i + " : " + allSeats[i]);
			}
		}

	}
	public static void buyTicket(String[] allSeats) {
		if (numFilledSeats < allSeats.length) {
			System.out.println("Enter your name: ");
			allSeats[numFilledSeats] = in.next();
			numFilledSeats++;
		}				
		else {
			System.out.println("Sold out!");
		}
	}

}








