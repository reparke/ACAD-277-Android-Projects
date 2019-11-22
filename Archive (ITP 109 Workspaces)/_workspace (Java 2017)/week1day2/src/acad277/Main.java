package acad277;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = 0;

        System.out.println("Enter a positive number: ");
        num = input.nextInt();

        //print out all even numbers
        while (num >= 0) {
            if (num % 2 == 0) { //if num is even
                System.out.println(num);
            }
            num = num - 1;
        }

        //use a for loop to sum all the numbers from user num to 0
        System.out.println("Enter a positive number: ");
        num = input.nextInt();
        int sum = 0;
        double average = 0;


        for (int i = num; i > 0; i--) {
            sum = sum + i;
            System.out.println(sum);
        }
        average = (double)sum/num;
        System.out.println("The average of the numbers summed is: " + average);










    }
}





//        String word = "Cat";
//
//        switch(word.toLowerCase()){
//            case "cat":
//                System.out.println("Cats are cute!");
//                break;
//            case "dog":
//                System.out.println("Dogs are great!");
//                break;
//            default:
//                System.out.println("I'm sure your pet is great too!");
//        }
//    }

