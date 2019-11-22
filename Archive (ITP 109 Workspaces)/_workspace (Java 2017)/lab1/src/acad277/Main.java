//Rob Parke
//Lab 1
//1-11-16
//Simple mad libs program

package acad277;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //Define variables
        Scanner input = new Scanner(System.in);
        String noun1 = "";
        String verb1 = "";
        String adj1 = "";
        String noun2 = "";
        int number = 0;

        //get input from user
        System.out.println("Please enter a noun: ");
        noun1 = input.next();
        System.out.println("Please enter a verb: ");
        verb1 = input.next();
        System.out.println("Please enter an adjective: ");
        adj1 = input.next();
        System.out.println("Please enter a noun: ");
        noun2 = input.next();
        System.out.println("Please enter a number: ");
        number = input.nextInt();

        //Display story
        System.out.println("Today I adopted \'" + number + "\' \'" + noun1 + ". It has a \'" +
                adj1 + "\' \'" + noun2 +"\' and it \'" + verb1 +"\'");




    }
}
