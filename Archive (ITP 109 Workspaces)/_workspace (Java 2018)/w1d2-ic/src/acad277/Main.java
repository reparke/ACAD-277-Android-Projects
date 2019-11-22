package acad277;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //declare variables
//        int age;
//        String lastName, firstName;
//
//        //get input
//        Scanner input = new Scanner (System.in);
//        System.out.println("What is your first name? ");
//        firstName = input.next();
//        System.out.println("What is your last name? ");
//        lastName = input.next();
//        System.out.println("What is your age? ");
//        age = input.nextInt();
//
//        //display result
//        //Hello Abe Lincoln, you are 58, and next year you will be 59
//
//        System.out.println("Hello " + firstName + " " +lastName + ", you are " + age + ", and next year you will be " + (age + 1));
//
//
        //display the numbers from X to 100 OR see an inspiring quote
        Scanner input = new Scanner(System.in);
        int choice;
        String wantsContinue = "yes";
        while(wantsContinue.equals("yes")) {
            System.out.println("Enter (1) to count numbers or (2) for a quote: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:     //choice is 1 so we count numbers
                    System.out.println("Enter a number to count to 100: ");
                    int num = input.nextInt();
                    for (int i = num; i <= 100; i++) {
                        System.out.println(i);
                    }
                    break;
                case 2:     //choice is 2 so show a quote
                    System.out.println("If you believe in yourself, anything is possible!");
                    break;
                default:    //else
                    System.out.println("It appears there has been a mistake");
            }
            System.out.println("Do you want to continue (yes/no)?");
            wantsContinue = input.next();
        }










    }
}




