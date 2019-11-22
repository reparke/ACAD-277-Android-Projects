import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		int age = 0;
		//var age
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your age? ");
		//console.log("What is your age?)
		
		age = input.nextInt();
		
		if (age > 18) {
			System.out.println("You can vote! ");
		}
		else {
			System.out.println("You can not vote!");
		}
		
		
	}

}
