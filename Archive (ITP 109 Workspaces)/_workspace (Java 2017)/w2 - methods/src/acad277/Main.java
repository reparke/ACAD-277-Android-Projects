package acad277;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String itemName = "";
        double itemCost = 0.0;
        double tax = 0.0;
        String countyName = "";

        Scanner input = new Scanner(System.in);

        System.out.print("Enter item name: ");
        itemName = input.next();
        System.out.print("Enter item price: ");
        itemCost = input.nextDouble();
        System.out.print("Enter county: ");
        countyName = input.next();

        tax = getSalesTax(countyName);
        displayPurchase(itemName, itemCost, tax);
    }

    public static double getSalesTax(String county){
        if(county.equalsIgnoreCase("LA"))  {
            return 9;
        }
        else if (county.equalsIgnoreCase("Orange")){
            return 8;
        }
        else {
            return 7;
        }
    }

    public static void displayPurchase(String itemName, double itemCost, double tax) {
        double finalCost = itemCost + itemCost * tax / 100;

        System.out.println("item: " + itemName);
        System.out.println("price: " + itemCost);
        System.out.println("tax: " + tax + "%");
        System.out.println("----------");

        System.out.println("total: $" + finalCost);





    }







}
