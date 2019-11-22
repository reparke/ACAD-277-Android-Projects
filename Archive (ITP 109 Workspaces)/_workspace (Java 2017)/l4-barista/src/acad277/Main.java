package acad277;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the barista's name: ");
        Barista barista = new Barista(input.next());
        System.out.println("\n~~ Welcome to the Coffee Shop! ~~\n");

        boolean shouldContinue = true;

        while (shouldContinue == true) {
            while (barista.isAcceptingOrders()) {
                barista.takeOrder();
            }
            barista.makeDrinks();

            System.out.println("Would you like to continue? (y/n) ");
            String response = input.next();
            while (!response.equalsIgnoreCase("y")
                    && !response.equalsIgnoreCase("n")) {
                System.out.println("Invalid input, please try again!");
                System.out.println("Would you like to continue? (y/n) ");
                response = input.next();
            }
            shouldContinue = response.equalsIgnoreCase("y");

        }
        System.out.println("Goodbye, please come again!");

    }
}
