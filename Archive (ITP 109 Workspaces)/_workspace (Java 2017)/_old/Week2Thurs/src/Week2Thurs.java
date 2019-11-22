/*
 * Rob 
 * etc.
 */

import java.util.Scanner;
/*
 * Input: First Name, Last Name, Mom’s Maiden Name, City of Birth
Calculate the Star Wars Name:
For the new first name:
1.  Take the first 3 letters of 1st name & add
2.  the first 2 letters of last name
For the new last name:
3.  Then take the first 2 letters of Mom's maiden name & add
4.  the first 3 letters of the city person was born. 
Example: Tommy Trojan, Deer, Peoria would give: Tomtr Depeo

 */
public class Week2Thurs {

	public static void main(String[] args) {
		//create variables
		Scanner input = new Scanner(System.in);
//		String firstName = "", lastName = "", maidenName = "", city = "";
//		
//		String swFirstName = "", swLastName = "";
//		
//		//get user input
//		System.out.println("What is your first name? ");
//		firstName = input.nextLine();
//		System.out.println("What is your last name? ");
//		lastName = input.nextLine();
//		System.out.println("What is your mother's maiden name? ");
//		maidenName = input.nextLine();
//		System.out.println("In what city were you born? ");
//		city = input.nextLine();
//
//		swFirstName = firstName.substring(0, 3) + lastName.substring(0,2).toLowerCase();
//		
//		//output
//		System.out.println(swFirstName + " " + swLastName);
//		
//		
//		Take the 1st letter of the word and move it to the end of the word
//		If the word is 4 letters or more, add a random vowel to the end of the word (for now just always use "e")
//		If the word is 3 letters or fewer, append “en” to the end of the word
//		Change all k’s to c’s
		
		String word = "flag";
		String translated = word.substring(1, word.length()) + word.substring(0,1);
		System.out.println(word);
		System.out.println(translated);
		System.out.println(word.substring(0,1));
		System.out.println(word.substring(1, word.length()));
		System.exit(1);
		
	}

}







