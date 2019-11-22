/*
Sucheta Bangalore
ITP-109
10/17/2014
Lab 6 - Rock Paper Scissors 
This program will allow the user to play rock, paper, scissors with the computer.
 */

import java.util.Scanner;
public class rockPaperScissors {

	public static void main(String[] args) {
		//Declaring variables for main method
		int computerChoice = 0; //records computer random choice
		int playerChoice = 0; //records player's choice
		int winner  = 0; //records winner of the round
		int totalPlayerWins = 0; //records total number of rounds player won
		int totalComputerWins = 0; //records total number of rounds computer won
		int totalTies = 0; //records total number of draws 
		boolean continueGame = true; //records if the player wants to continue playing
		String youChoice = ""; //indicates if player choice is rock, paper or scissors
		String compChoice = ""; //indicates if computer choice is rock, paper or scissors


		while (continueGame != false) { //will only run if the player wants to keep playing
			displayMenu(); //calls method displayMenu
			computerChoice = getComputerChoice(); //stores value from method getComputerChoice
			playerChoice = getPlayerChoice(); //stores value from method getPlayerChoice
				
			//prints out player choice
				if (playerChoice == 0){ //prints out rock for player choice
					youChoice = "Rock";
					System.out.println("You chose " + youChoice + ".");
				}
				else if (playerChoice == 1) { //prints out paper for player choice
					youChoice = "Paper";
					System.out.println("You chose " + youChoice + ".");
				}
				else if (playerChoice == 2) { //prints out scissors for player choice
					youChoice = "Scissors";
					System.out.println("You chose " + youChoice + ".");
				}
				
			//prints out computer choice
				if (computerChoice == 0){ //prints out rock for computer choice
					compChoice = "Rock";
					System.out.println("The computer chose " + compChoice + ".");
				}
				else if (computerChoice == 1) { //prints out paper for computer choice
					compChoice = "Paper";
					System.out.println("The computer chose " + compChoice + ".");
				}
				else if (computerChoice == 2) { //prints out scissors for computer choice
					compChoice = "Scissors";
					System.out.println("The computer chose " + compChoice + ".");
				}
			
			
			//stores value from method playRound that uses input from methods getComputerChoice and getPlayerChoice
			winner = playRound(computerChoice, playerChoice); 
				//prints out winner and how they won.
				if (winner == 1) { //player wins
					//checks the player's choice and computer's choice and uses the game logic
					if ((youChoice.equals("Rock")) && (compChoice.equals("Scissors"))){ 
						//prints out the reason for win - Rock > scissors
						System.out.println("Rock smashes scissors. You win!");
					}
					else if ((youChoice.equals("Paper")) && (compChoice.equals("Rock"))){
						//prints out the reason for win - Paper > rock
						System.out.println("Paper covers rock. You win!" );
					}
					else if ((youChoice.equals("Scissors")) && (compChoice.equals("Paper"))){
						//prints out the reason for win - Scissors > paper
						System.out.println("Scissors cut paper. You win!" );
					}		
				}
	
				else if (winner == -1) { //computer wins
					//checks the player's choice and computer's choice and uses the game logic
					if ((compChoice.equals("Rock")) && (youChoice.equals("Scissors"))){
						//prints out the reason for win - Rock > scissors
						System.out.println("Rock smashes scissors. Computer wins!" );
					}
					else if ((compChoice.equals("Paper")) && (youChoice.equals("Rock"))){
						//prints out the reason for win - Paper > rock
						System.out.println("Paper covers rock. Computer wins!" );
					}
					else if ((compChoice.equals("Scissors")) && (youChoice.equals("Paper"))){
						//prints out the reason for win - Scissors > paper
						System.out.println("Scissors cut paper. Computer wins!" );
					}		
				}
	
				else {//it's a tie
					//prints out the reason for tie - player choice = computer choice
					System.out.println("It's a tie! You both chose " + youChoice);
				}

			if (winner == 1) {//calculates total Player wins
				totalPlayerWins = totalPlayerWins + 1;
			}
			else if (winner == -1){//calculates total computer wins
				totalComputerWins = totalComputerWins + 1;
			}
			else if (winner == 0) {//calculates total number of ties
				totalTies = totalTies + 1;
			}
			
			continueGame = continueGame(); //calls method continueGame 
		}


		//prints out when player wishes to end the game
		System.out.println("You won " + totalPlayerWins + " game(s)."); //prints number of player's wins
		System.out.println("The computer won " + totalComputerWins + " game(s)."); //prints number of computer wins
		System.out.println("You tied with the computer " + totalTies + " time(s)."); //prints number of ties
		System.out.println("Thanks for playing!"); 


	}

	public static void displayMenu() { //method displays rules of the game/logic of the game; does not return anything
		System.out.println("Welcome! Let's play rock, paper, scissors.");
		System.out.println("The rules of the game are:");
		System.out.println("   Rock smashes scissors \n   Scissors cut paper \n   Paper covers rock");
		System.out.println("   If both the choices are the same, it's a tie");
	}

	public static int getComputerChoice() {//method generates random choice for computerChoice; returns an int
		int computerChoice= ((int)(Math.random() * 3));

		return computerChoice; //returns int value to computerChoice in main method
	}

	public static int getPlayerChoice() {//method asks player to enter choice; returns an int
		Scanner input = new Scanner(System.in); //Scanner is local to the method
		System.out.println("Please choose (0) for rock, (1) for paper or (2) for scissors ");
		int playerChoice = input.nextInt(); //declaring local variable to record player choice
		while ((playerChoice < 0) || (playerChoice > 2)){ //runs only if player choice is not 0, 1, 2
			System.out.println("Invalid");
			System.out.println("Please choose (0) for rock, (1) for paper or (2) for scissors ");
			playerChoice = input.nextInt();
		}

		return playerChoice; //returns int value to playerChoice in main method
	}

	public static int playRound(int computerChoice, int playerChoice) {
		//method calculates winner of the round; two inputs from main method (which were recorded from methods getComputerChoice and getPlayerChoice) 
		int winner = 0; //declaring local variable to record winner

		if (playerChoice == computerChoice) { //tie
			winner = 0;	
		}
		else if (playerChoice == 0) {//player chooses rock
			if (computerChoice == 1) {//computer chooses paper
				winner = -1; //computer wins
			}
			else if (computerChoice == 2) {//computer chooses paper
				winner = 1; //player wins
			}
		}
		else if (playerChoice == 1) {//player chooses paper
			if (computerChoice == 0) {//computer chooses rock
				winner = 1; //player wins
			}
			else if (computerChoice == 2) {//computer chooses scissors
				winner = -1; //computer wins
			}
		}
		else if (playerChoice == 2) { //player chooses scissors
			if (computerChoice == 0) { //computer chooses rock
				winner = -1; //computer wins
			}
			else if (computerChoice == 1) { //computer chooses paper
				winner = 1; //player wins
			}
		}

		return winner;	//returns int value that indicates winner to variable winner in main method
	}

	public static boolean continueGame() { //checks if player wants to continue playing; returns boolean to main method
		Scanner input = new Scanner(System.in); //Scanner local to method
		String contGame = ""; //declaring string variable to get answer from player
		boolean continueGame = true; //declaring boolean to record true or false

		System.out.println("Do you want to continue playing? Enter (Y) for Yes or (N) for No.");
		contGame = input.nextLine(); //asks user for answer

		while ((!contGame.equalsIgnoreCase("y")) && (!contGame.equalsIgnoreCase("n"))) { //runs if player input is not y, Y or n, N
			System.out.println("Invalid");
			System.out.println("Enter (Y) for Yes or (N) for No.");
			contGame = input.nextLine();
		}
		
		if (contGame.equalsIgnoreCase("y")){ //if Yes
			continueGame = true; //player wants to continue 
		}
		else if (contGame.equalsIgnoreCase("n")){ //if no
			continueGame = false; //player does not want to continue 
		}

		return continueGame; //returns boolean to variable continueGame in the main method	
	}

}


