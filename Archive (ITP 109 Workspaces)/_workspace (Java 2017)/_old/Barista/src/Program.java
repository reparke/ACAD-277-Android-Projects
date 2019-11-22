

public class Program {
	
	public static void main(String[] args) {
		//initialize variables
		Barista cashier = new Barista("Rob");
		DrinkOrder order1;
		DrinkOrder order2;
		
		//take and prepare first order
		cashier.displayGreeting();
		order1 = cashier.takeCustomerOrder();
		
		//this code tells java to pause for 2 seconds
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cashier.finalizeCustomerOrder(order1);
		
		//take and prepare second order
		cashier.displayGreeting();
		order2 = cashier.takeCustomerOrder();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cashier.finalizeCustomerOrder(order2);



	
	}


}