import java.util.Scanner;

public class Program {
	public static void main (String args[]){
		int x = 4;
		int[] b = {1, 3, 5};

		System.out.println("X before method: " + x);
		System.out.println("X after method: " + x);
		System.out.println("b before method: ");
		printArray(b);		
		System.out.println("b after method: " + b);
		printArray(b);

	}
	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i]);
		}
	}
	public static void changeNum(int num) {
		num = num + 100;
		System.out.println("\tvalue in method: " + num);
	}
	public static void changeArray(int [] arr) {
		for (int i = 0; i < arr.length; i++){
			
			
		}
		System.out.println("\tvalue in method: " + num);
	}
}
