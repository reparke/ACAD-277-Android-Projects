import java.util.Scanner;
public class Foo {

	public static void main(String[] args) {

		int a = 1, b = 2, c = 6, resultInt = 0;
		double x = 2.0, y = 5.0, z = 4.0, resultDouble = 0.0;
		boolean resultBoolean = true;

		resultInt = a - b + c / b % b;
		// 1 - 2 + 5 / 2 % 2

		System.out.println(resultInt);
		System.out.println(c / b % b);

		resultDouble = y +  y / x;
		System.out.println(resultDouble);


		resultBoolean = (3*b == c);
		System.out.println(resultBoolean);

		resultBoolean = ((z-x) == x);
		System.out.println(resultBoolean);

		resultBoolean = (a > 1 && b == 2);
		System.out.println(resultBoolean);

		resultBoolean = (c != 5 || b == 2);
		System.out.println(resultBoolean);


		//===========
		//		Scanner input = new Scanner(System.in);
		//		System.out.println("What kind of pet do you have? ");
		//		String pet = input.next();
		//		switch (pet){
		//		case "dog":
		//			System.out.println("Bark bark!");
		//			break;
		//		case "cat":
		//			System.out.println("Meow!");
		//			break;
		//		default:
		//			System.out.println("Insert some other sound");
		//			break;
		//		}

		//		//===========
		//		Scanner input = new Scanner(System.in);
		//		String pet = "";
		//		
		//		System.out.println("What kind of pet do you have (type exit to stop)? ");
		//		pet = input.next();
		//		while(!pet.equalsIgnoreCase("exit")) {
		//			switch (pet){
		//			case "dog":
		//				System.out.println("Bark bark!");
		//				break;
		//			case "cat":
		//				System.out.println("Meow!");
		//				break;
		//			default:
		//				System.out.println("Insert some other sound");
		//				break;
		//			}
		//			System.out.println("What kind of pet do you have (type exit to stop)? ");
		//			 pet = input.next();
		//		}

		//		//===========
		//		Scanner input = new Scanner(System.in);
		//		String pet = "";
		//
		//		do {
		//			System.out.println("What kind of pet do you have (type exit to stop)? ");
		//			pet = input.next();
		//			switch (pet){
		//			case "dog":
		//				System.out.println("Bark bark!");
		//				break;
		//			case "cat":
		//				System.out.println("Meow!");
		//				break;
		//			case "exit":
		//				System.out.println("Goodbye!");
		//				break;
		//			default:
		//				System.out.println("Insert some other sound");
		//				break;
		//			}
		//
		//		} while(!pet.equalsIgnoreCase("exit"));
		//

		//===========
//		Scanner input = new Scanner(System.in);
//		int userNum = 0;
//
//		System.out.println("Enter an integer: ");
//		userNum = input.nextInt();
//
//		if (userNum > 0) {
//			for (int i = userNum; i > 0; i--){
//				System.out.println(i);
//			}
//
//		}
//		else if (userNum < 0){
//			for (int i = userNum; i < 0; i++){
//				System.out.println(i);
//			}
//
//		}
//		else {
//			System.out.println("Nothing to countdown!");
//		}







	}
}