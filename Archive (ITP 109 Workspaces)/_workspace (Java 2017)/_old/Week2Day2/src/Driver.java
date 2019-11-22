
public class Driver {
	public static void main (String args[]) {
		//roll the die 500 times
		//store the number visible time in an array
		//calculate the average
		//display to user
		
		Die d1 = new Die(); //die
		int[] dieValues = new int[500];
		double average = 0.0;
		int sum = 0;
		
		for (int i = 0; i < dieValues.length; i++) {
			//roll
			d1.roll();
			//get num Visible
			//store position in array
			dieValues[i] = d1.getNumVisible();
		}
		
		sum = 0;
		for (int i = 0; i < dieValues.length; i++) {
			sum = sum + dieValues[i];
		}
		average = (double) sum / dieValues.length;
		
		System.out.println("Average is " + average);		//scope - where can you access variable - where exist
															//scope is typically controlled by {} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
		
	}
}