package acad277;

import java.util.Scanner;

public class Main {
    //constant
    public static final int NUM_PEOPLE_IN_277 = 8;

    public static void main(String[] args) {
//        String monthNames[] = {"January","February","March","April", "May","June","July","August", "September","October","November","December"};
//        int monthDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
//
//        for(int i = 0 ; i < monthNames.length; i++) {
//            System.out.println(monthNames[i] + " has " + monthDays[i] + " days");
//        }
//
//        String desiredMonth = "May";
//
//        for (int i = 0; i < monthNames.length; i++) {
//            if (monthNames[i].equalsIgnoreCase(desiredMonth)) {
//                System.out.println(monthNames[i] + " has " + monthDays[i] + " days");
//
//            }
//        }
//

        String[] favFoods = new String[NUM_PEOPLE_IN_277];
        Scanner input = new Scanner(System.in);
        String choice = "y";
        int numFilledEntries = 0;

        while (!choice.equalsIgnoreCase("n")) {
            System.out.println("Enter a favorite food for someone in this class: ");
            favFoods[numFilledEntries] = input.next();
            numFilledEntries++;

            if (numFilledEntries < favFoods.length) {
                System.out.println("Do you want to enter any more? (y/n)");
                choice = input.next();
            }
            else {
                choice = "n";
            }
        }
//            System.out.println("There are " + numFilledEntries + " entries in an array of size " + favFoods.length);
//
////
 }

}











