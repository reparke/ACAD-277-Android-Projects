package acad277;

import java.util.Scanner;
public class Main {



    public static void main(String[] args) {
        String itemName = "";
        double itemCost = 0.0;
        double tax = 0.0;
        double discount = 0.0;
        String countyName = "";
        Scanner input = new Scanner(System.in);
        String choice = "";
        while (!choice.equalsIgnoreCase("n")) {
            System.out.print("Enter item name: ");
            itemName = input.next();
            System.out.print("Enter item price: ");
            itemCost = input.nextDouble();
            System.out.print("Enter county: ");
            countyName = input.next();

            System.out.println("Do you want to add another item: (y/n)? ");
            choice = input.next();

        }
        tax = getSalesTax(itemCost, countyName);
        displayPurchase(itemName, itemCost, tax);

    }
    static double getSalesTax(double itemCost, String countyName) {
        if( countyName.equalsIgnoreCase("orange") ) {
            return itemCost * 0.08;
        }
        else if (countyName.equalsIgnoreCase("los angeles")) {
            return itemCost * 0.09;
        }
        else {
            return itemCost * 0.07;
        }

    }
    static void displayPurchase(String itemName, double itemCost, double taxAmount) {
        double totalCost = itemCost + itemCost*taxAmount;

        System.out.format("Item: " + itemName + "\n");
        System.out.format("price: $%.2f\n", itemCost);
        System.out.format("tax: $%.2f\n", taxAmount);
        System.out.format("----------\n");
        System.out.format("total: $%.2f\n", totalCost);

    }
}


