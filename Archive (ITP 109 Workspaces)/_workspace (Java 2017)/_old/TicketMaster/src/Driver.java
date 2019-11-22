//
//public class Driver {
//	public static void main (String args[]) {
//		Die d1 = new Die();
//		
//		Die d2 = new Die(26, 5);
//		
//		System.out.println("Die 1 is showing " + d1.getNumVisible());
//		System.out.println("Die 2 is showing " + d2.getNumVisible());
//		
//		
//		d1.setNumVisible(2);
//		
//		System.out.println("Die 1 is showing " + d1.getNumVisible());
//		
//		for (int i = 0; i < 1000; i++ ) {
//			d2.roll();
//			System.out.println("Die 2 is showing " + d2.getNumVisible());
//		}
//		
//	}
//}
import java.util.Scanner;


public class Driver {


	

	/**
	 * 
	 * @param args -- 1st argument is the total number of seats
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many seats are there? ");
		int numSeats = in.nextInt();
		
		TicketMaster tm = new TicketMaster(numSeats);
		

		int choice = 0;
		while (choice != 3){

			tm.printOptions();
			choice = in.nextInt();
			in.nextLine(); // clear buffer
			switch(choice){
			case 1: 
				tm.sellTickets();
				break;
			case 2: 
				tm.displayTickets();
				break;
			case 3: 
				System.out.println("Goodbye");
				break;
			default: 
				System.out.println("Invalid otpion: " + choice);
			}

		}


	}

}