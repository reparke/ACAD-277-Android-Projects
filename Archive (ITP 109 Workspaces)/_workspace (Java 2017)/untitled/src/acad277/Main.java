package acad277;

import java.util.Random;
import java.util.Scanner;

public class Main {

    //define constant globally
    public static final int choiceRock = 0;
    public static final int choicePaper = 1;
    public static final int choiceScissors= 2;

    public static final int playerWins = 1;
    public static final int playerTies = 0;
    public static final int playerLoses = -1;

    public static void main(String[] args) {

    }

    // method: displayMenu
    // input: none
    // output: none
    // description: prints rules to users
    public static void displayMenu() {
        System.out.println("Here are the rules!");
    }

    public static int getPlayerChoice() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choice (0 for rock, 1 for paper, 2 for scissors): ");
        return input.nextInt();
    }

    public static int getComputerChoice() {
        Random random = new Random();
        return random.nextInt(3);
    }

    public static int playRound(int playerChoice, int computerChoice) {
        /*
            if choices are the same,
                return tie
             else if all combinations of winning
                return win
              else
                return lose
         */
        if (playerChoice == computerChoice) {
            return playerTies;
        }
        else if ( (playerChoice == choiceRock && computerChoice == choiceScissors)
            || (playerChoice == choicePaper && computerChoice == choiceRock)
            || (playerChoice == choiceScissors && computerChoice == choicePaper) ) {
            return playerWins;
        }
        else {
            return playerLoses;
        }
    }

    public static boolean continueGame() {
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to continue (y/n)? ");
        String answer = input.next();

        if(answer.equalsIgnoreCase("y")) {
            return true;
        }
        else if (answer.equalsIgnoreCase("n")) {
            return false;
        }
        else {
            System.out.println("Error in input");
            return false;
        }
    }


}














