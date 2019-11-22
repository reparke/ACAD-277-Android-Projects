import java.util.Scanner;
public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Barista joe = new Barista();
		joe.setName("Joe");
		joe.displayGreeting();
		
		Order order1 = new Order();
		
		order1.setName("Colombian");
		order1.setPounds(2);
		order1.setCostPerPound(8.99);
		
			
		Order order2 = new Order();
		
		System.out.println("Enter coffee name (one word please): ");
		String tempName = input.next();
		System.out.println("Enter # of pounds: ");
		int tempPounds = input.nextInt();
		
		order2.setName(tempName);
		order2.setPounds(tempPounds);
		order2.setCostPerPound(7.99);

		joe.finalizeOrder(order2);
		
	}

}





