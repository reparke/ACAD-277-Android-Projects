import java.util.Scanner;


public class TicketMaster {
	
	private String[] allSeats;		//array of seats (names of people)
	private int filledSeats;		//how many seats are actually filled
	private Scanner input = new Scanner(System.in);
	
	
	public TicketMaster(int numSeats) {
		filledSeats = 0;
		allSeats = new String[numSeats];
	}


	public void displayTickets() {
		System.out.println(filledSeats + " Seats sold out of " + allSeats.length + " total seats");
		for(int i = 0; i< filledSeats; i++){
			System.out.println("\t" + i + " : " + allSeats[i]);
		}
	}


	public void printOptions() {
		System.out.println("Enter 1 to buy a ticket");
		System.out.println("Enter 2 to see all the sold tickets");
		System.out.println("Enter 3 to quit");

	}


	public void sellTickets(){
		boolean done = false;

		if(filledSeats == allSeats.length){
			System.out.println("Sold out!");
			done = true;
		}
		while (!done){
			System.out.println("Enter your name to purchase a ticket: ");
			String name = input.nextLine();
			allSeats[filledSeats] = name;
			System.out.println(name + " has been assigned seat number: " + filledSeats);
			filledSeats++;
			if(filledSeats == allSeats.length){
				System.out.println("Sold out!");
				done = true;
			}
			else {
				System.out.println("Want to buy more tickets? (Yes/No)");
				String response = input.nextLine();
				if(!isYes(response)){
					done = true;
				}
			}
		}
	}

	public boolean isYes(String response) {
		if(response.equalsIgnoreCase("yes") || response.startsWith("y") || response.startsWith("Y"))
			return true;
		else 
			return false;
	}

}
