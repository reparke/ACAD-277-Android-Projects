package acad277;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //declare the array, but NOT initialize it
        int[] numbers;

        System.out.println("How many numbers do you want to average? ");
        int userInput = input.nextInt();

        //initialize the array
        numbers = new int[userInput];

        //ask user for numbers
        System.out.println("Enter numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        //add all the numbers
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        //show average
        System.out.println("The average is " + (double) sum/numbers.length);







    }
}






