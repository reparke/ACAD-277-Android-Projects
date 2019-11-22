import java.util.ArrayList;
import java.util.Scanner;

public class Driver{
	public static String choices[] = {
										"Find an average and largest",
										"Find the winner of the vote",
										"Survey says...",
										"What does the _____ say?",
										"Keep stock of inventory",
										"Quit"
										};
	public static int MINIMUM_NUMBER_FOR_PRODUCE = 10;
	
	public static void main(String args[]){
		Scanner userInput = new Scanner(System.in);
		
		//0 is a valid selection in our loop
		//we do this so that even if the user enters something bad, we can still loop
		int selection = 0;
		
		do{
			System.out.println("Please choose an option:");
			
			//note that we don't have to use i here, we can name it whatever we want!
			//also, the ++ can work on any variable!
			//all it does is say "add one to yourself and remember the new value"
			for (int index = 0; index < choices.length; index++){
				//here, we say we want the value of the choices array
				//at the location equal to index
				//why do you think we did it this way?
				System.out.println( index + ") " + choices[index] );
			}
			
			selection = userInput.nextInt();
			
			switch(selection){
				case 0:
				
					//we can give an array values immediately in code
					double arrayOfDoubles[] = { 1.29, 10.4, 15.9, 60, 4.13, 72.999999, 33 };
					
					
					//our math is right by sign
					double largest = arrayOfDoubles[0];
					double average = 0;
					
					//why do we want to loop only when index < arrayOfDoubles.length?
					//this is because our length is the literal number of elements (7)
					//meanwhile, ALL arrays start at position 0
					//when we count from 0: 0, 1, 2, 3, 4, 5, 6 <- 6 is our 7th position
					//so we never want to be equal to length when looping
					for (int index = 0; index < arrayOfDoubles.length; index++){
						//largest
						if (arrayOfDoubles[index] > largest) {
							largest = arrayOfDoubles[index];
						}
						
						//average
						average = average + arrayOfDoubles[index];
					}
					
					
					
					//TODO: uncomment this
					average = average / arrayOfDoubles.length; /*fill this part*/;
					
					System.out.println("The average value in the array is: " + average);
					System.out.println("The largest value in the array is: " + largest);
				break;
				
				case 1:
					//we can have an array with no values, just empty spots
					boolean votesArray[] = new boolean[5];
					
					System.out.println("We are now accepting 5 votes.");
					System.out.println("Please enter 1 to vote for pizza or 2 for ice cream.");
					
					for (int index = 0; index < votesArray.length; index++){
						System.out.println("Enter vote: ");
						boolean voteValue = false;
						
						int voteSelection = userInput.nextInt();
						
						if (voteSelection == 1){
							voteValue = false;
						}else if (voteSelection == 2){
							voteValue = true;
						}else{
							//evil people try to break our program
							//we must punish them
							System.out.println("So you want to play? Too bad. You get pizza.");
							//we don't have to set voteValue to false here
							//because we said by default, it would be false
							//and nothing has changed it if we come into here
						}
						
						//here, we show you how to set the value at a specific position in the
						//array
						votesArray[index] = voteValue;
					}
					
					//TODO:
					//determine the winner of the votes
					//hint: count the number of trues or the number of falses in the array
					int numTrue = 0;
					
					//TODO:
					//when you have a winner, uncomment the lines below and fill it in
					//if ( /*fill this in*/){
					//	System.out.println("We have a winner! We celebrate with ice cream!");
					//}else{
					//	System.out.println("We have a winner! We celebrate with pizza!");
					//}
				break;
				
				case 2:
					//we will always have some non-finishing input before this
					//so lets clear it out before asking for more
					userInput.nextLine();
					
					//creating an ArrayList of any object looks like this
					//for future ArrayLists, just replace String with
					//whatever object you want
					ArrayList<String> surveyResponses = new ArrayList<String>();
					
					
					//note that we use size() for ArrayLists and length for arrays!
					for (int index = 0; index < 5; index++){
						System.out.println("What do you think about chocolate?");
						//we don't need to know how big the ArrayList is
						//or where to put things
						//we can just say "hey Java, add it to the list"
						String comment = userInput.nextLine();
						surveyResponses.add(comment);
					}
					
					//TODO: now print back out what people have said about chocolate
					for (int index = 0; index < surveyResponses.size(); index++){
						//TODO:
						//fill this part in, just output everything from your ArrayList
						//one String at a time
						//hint: this is one or two lines of code
						//HINT: use the get method that is inside surveyResponses
						System.out.println(surveyResponses.get(index));
						
					}
					
					//foreach version
					for (String s: surveyResponses) {
						System.out.println(s);
					}
					
					
					

					
				break;
				
				case 3:
					//BE SURE TO FINISH THE ANIMAL CLASS BEFORE TESTING THIS OPTION
					
					//TODO:
					//create an array of 5 animals
					
					Animal[] arrayAnimals = new Animal[5];
					
					
					//TODO:
					//After making an array of objects, we need to actually create each one!
					//fill in this for loop by creating a NEW Animal in each index of the array
					for (int index = 0; index < arrayAnimals.length; ++index){
						arrayAnimals[index] = new Animal();
					}
					
					
					
					//TODO:
					//Ask the user to input the names and calls of each one
					//only use the userInput variable two times
					//hint: use a loop
					for (int i = 0; i < arrayAnimals.length; i++) {
						System.out.println("Enter animal name: ");
						String userName = userInput.nextLine();
						
						arrayAnimals[i].setName(userName);
						
						System.out.println("Enter animal call: ");
						String userCall = userInput.nextLine();
						
						arrayAnimals[i].setName(userCall);
						
						
					}
					
					
					
					//TODO:
					//Randomly describe 2 of your Animals to the user.
					//hint: don't use a loop
					
				break;
				
				case 4:
					//BE SURE TO FINISH THE FOODITEM CLASS BEFORE TESTING THIS OPTION
					
					//TODO:
					//create an ArrayList of FoodItems
					//name it listFoodItems
					
					
					//notice how this print doesn't have "ln" at the end?
					//this means we do not go to the next line, we stay where we end
					System.out.print("Please enter the number of food items you have: ");
					int numberOfFoodItemsAtRestaurant = userInput.nextInt();
					
					//TODO:
					//uncomment the loop and fill in all the empty parts
					for (int index = 0; index < numberOfFoodItemsAtRestaurant; index++){
//						//notice we added 1 to index. This is to make it easier
//						//for the user to understand
//						System.out.print("What is item " + (index + 1) + " called: ");
//						userInput.nextLine(); //we know we got an int earlier so we need to clear out userInput
//						String foodItemName = userInput.nextLine();
//						
//						System.out.print("How many of it do you have: ");
//						int foodItemAmount = userInput.nextInt();
//						
//						//create a new FoodItem using foodItemName and foodItemAmount and add it to the ArrayList
//						/*TODO*/
//						
					}
					
					
					int numInsufficient = 0;
					//TODO:
					//now loop through all your FoodItems
					//tell the user if they have enough and if not, tell them how much they are missing
					//Also, whenever the user does not have enough of a FoodItem, increase numInsufficient
					
					
					if (numInsufficient == 0){
						System.out.println("We can open up shop and make ALL the moneys!");
					}else{
						System.out.println("Oh no, better stock up before our customers riot!");
					}
					
					break;
				
				case 5:
					selection = -1;
					break;
				
				default:
					System.out.println("You didn't pick one of the choices!");
					//length - 1 below because we want to show all our valid options.
					//the length is the number of elements but we are offset by 1
					//because our arrays start at 0
					System.out.println("Try again. Pick only 0 - " + (choices.length - 1));
					selection = 0;
				break;
			}
		}while(selection >= 0);
		
		userInput.close();
	}
}