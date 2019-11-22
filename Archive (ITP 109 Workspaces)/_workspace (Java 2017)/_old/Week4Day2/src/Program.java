import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] numbers;
		int size = 0;
		
		System.out.println("How many ints do you want? ");
		size = input.nextInt();
		
		numbers = new int[size];
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("Enter an integer: ");
			
			numbers[i] = input.nextInt() * 3;
			
//			int userInput = input.nextInt();
//			userInput = userInput*3;
//			numbers[i] = userInput;
//			
		}
		System.out.println("The numbers tripled are: ");
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//		String[] months = {"Jan", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
//		int[] days = {31,31,30,31,30,31,31,30,31,30,31}; 
//
//		for (int i = 0; i < months.length; i++){
//			System.out.println(months[i] + " has " + days[i] + " days");
//		}
		
		
		
		
		
		
		
		
	}

}
