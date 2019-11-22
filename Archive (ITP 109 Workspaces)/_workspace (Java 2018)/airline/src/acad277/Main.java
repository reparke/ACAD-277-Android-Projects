//package acad277;
//import java.util.Scanner;
//
//
//public class Main {
//
//    public static final int NUM_FIRST_CLASS_SEATS = 4;
//    public static final int TOTAL_SEATS = 10;
//    public static void main(String[] args) {
//        String[] seats = new String[TOTAL_SEATS];
//
//        for (int i = 0; i < TOTAL_SEATS; i++){
//            seats[i] = ""; // could set to String "Empty", or just leave blank
//        }
//
//        int filledFirstSeats = 0;
//
//        String menu = "1: Assign Seat\n2: Print Seat Map\n3: Print Boarding Pass\n-1: Quit.\n";
//        Scanner sc = new Scanner (System.in);
//
//        boolean isQuit = false;
//        do{
//            System.out.println("\n" + menu);
//            System.out.println("Enter your choice > ");
//            int userChoice = sc.nextInt();
//            switch(userChoice){
//                case 1: //assign seat
//                    System.out.println("Please enter your name:");
//                    String name = sc.next();
//                        if(filledFirstSeats < NUM_FIRST_CLASS_SEATS){ // first are available
//                            seats[filledFirstSeats] = name;
//                            filledFirstSeats++;
//                        }
//                        else{
//                            System.out.println("Sorry the entire plane is full.");
//                        }
//                    break;
//                case 2: // print seat map
//                    for(int i = 0; i < TOTAL_SEATS; i++){
//                        if(seats[i].isEmpty()){
//                            System.out.println("Seat " + (i+1) + ":  Empty");
//                        }
//                        else{
//                            System.out.println("Seat " + (i+1) + ":  " + seats[i]);
//                        }
//                    }
//                    break;
//                case 3:
//                    System.out.println("Type 1 to get Boarding Pass by seat number\nType 2 to get Boarding Pass by name.\n");
//                    int bp = sc.nextInt();
//                    int num = -1;
//                    if(bp == 1){
//                        System.out.println("Please enter seat number>");
//                        num = sc.nextInt();
//                        num--; // subtract one to get the correct index
//                        //could check for valid number
//                        if(num < 0 || num > TOTAL_SEATS){
//                            System.out.println("Invalid number, no boarding pass can be found");
//                        }
//                        if(seats[num].isEmpty()){
//                            System.out.println("No person has been assigned to that seat");
//                        }
//                    }
//                    else if (bp == 2){
//                        System.out.println("Please enter passenger name>");
//                        String pName = sc.next();
//
//                        for(int i =0 ; i < TOTAL_SEATS; i++){
//                            if(seats[i].equalsIgnoreCase(pName)){
//                                num = i;
//                            }
//                        }
//                        if(num == -1){
//                            System.out.println("No person with name: " + pName + " was found");
//                        }
//                    }
//                    else {
//                        System.out.println("Invalid option.");
//                    }
//
//                    //print pass
//                    if(num != -1){
//                        System.out.println("***************************************");
//                        System.out.println("\t" + seats[num]);
//                        System.out.println("\tSeat: " + (num+1));
//                    }
//                    else {
//                        System.out.println("Invalid information, no boarding pass can be found");
//                    }
//
//                    break;
//                case -1:
//                    isQuit = true;
//                    break;
//                default:
//                    System.out.println("NOT a valid choice");
//            }
//        }while(!isQuit);
//
//
//    }
//
//}
/*
extra credit version
*/
package acad277;
import java.util.Scanner;


public class Main {

    public static final int NUM_FIRST_CLASS_SEATS = 4;
    public static final int NUM_ECONOMY_CLASS_SEATS = 6;
    public static final int TOTAL_SEATS = 10;
    public static void main(String[] args) {
        String[] seats = new String[TOTAL_SEATS];

        for (int i = 0; i < TOTAL_SEATS; i++){
            seats[i] = ""; // could set to String "Empty", or just leave blank
        }

        int filledFirstSeats = 0;
        int filledEconomySeats = 0 + NUM_FIRST_CLASS_SEATS;

        String menu = "1: Assign Seat\n2: Print Seat Map\n3: Print Boarding Pass\n-1: Quit.\n";
        Scanner sc = new Scanner (System.in);

        boolean isQuit = false;
        do{
            System.out.println("\n" + menu);
            System.out.println("Enter your choice > ");
            int userChoice = sc.nextInt();
            switch(userChoice){
                case 1: //assign seat
                    System.out.println("Please enter your name:");
                    String name = sc.next();
                    System.out.println("Type 1 for First class or type 2 for Economy");
                    int type = sc.nextInt();
                    if(type == 1){ //they want first
                        if(filledFirstSeats < NUM_FIRST_CLASS_SEATS){ // first are available
                            seats[filledFirstSeats] = name;
                            filledFirstSeats++;
                        }
                        else{
                            System.out.println("First class is full, would you like Economy. Type 2 for Economy. Type -1 to cancel ticket purchase.");
                            type = sc.nextInt();
                        }
                    }
                    if(type == 2){ //this has to be if NOT else/if because we let them choose economy if first is full
                        if(filledEconomySeats < TOTAL_SEATS){ // economy are available
                            seats[filledEconomySeats] = name;
                            filledEconomySeats++;
                        }
                        else{
                            System.out.println("Economy class is full, would you like First Class? Type 1 for First class. Type -1 to cancel ticket purchase.");
                            type = sc.nextInt();
                            if(type == 1){ //if they are going to switcc
                                if(filledFirstSeats < NUM_FIRST_CLASS_SEATS){ // first are available
                                    seats[filledFirstSeats] = name;
                                    filledFirstSeats++;
                                }
                                else{
                                    System.out.println("Sorry the entire plane is full.");
                                    type = -1;
                                }
                            }
                        }

                    }
                    if (type == -1){
                        System.out.println("Sorry, no ticket was purchased for " + name);
                    }
                    break;
                case 2: // print seat map
                    for(int i = 0; i < TOTAL_SEATS; i++){
                        if(i < NUM_FIRST_CLASS_SEATS){
                            System.out.print("FC: ");
                        }
                        else{
                            System.out.print("Ec: ");
                        }
                        if(seats[i].isEmpty()){
                            System.out.println("Seat " + (i+1) + ":  Empty");
                        }
                        else{
                            System.out.println("Seat " + (i+1) + ":  " + seats[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Type 1 to get Boarding Pass by seat number\nType 2 to get Boarding Pass by name.\n");
                    int bp = sc.nextInt();
                    int num = -1;
                    if(bp == 1){
                        System.out.println("Please enter seat number>");
                        num = sc.nextInt();
                        num--; // subtract one to get the correct index
                        //could check for valid number
                        if(num < 0 || num > TOTAL_SEATS){
                            System.out.println("Invalid number, no boarding pass can be found");
                        }
                        if(seats[num].isEmpty()){
                            System.out.println("No person has been assigned to that seat");
                        }
                    }
                    else if (bp == 2){
                        System.out.println("Please enter passenger name>");
                        String pName = sc.next();

                        for(int i =0 ; i < TOTAL_SEATS; i++){
                            if(seats[i].equalsIgnoreCase(pName)){
                                num = i;
                            }
                        }
                        if(num == -1){
                            System.out.println("No person with name: " + pName + " was found");
                        }
                    }
                    else {
                        System.out.println("Invalid option.");
                    }

                    //print pass
                    if(num != -1){
                        System.out.println("***************************************");
                        System.out.println("\t" + seats[num]);
                        System.out.println("\tSeat: " + (num+1));
                        if(num < NUM_FIRST_CLASS_SEATS) {
                            System.out.println("\tSection: First Class ");
                        }
                        else {
                            System.out.println("\tSection: Economy  ");
                        }
                        System.out.println("***************************************");

                    }
                    else {
                        System.out.println("Invalid information, no boarding pass can be found");
                    }

                    break;
                case -1:
                    isQuit = true;
                    break;
                default:
                    System.out.println("NOT a valid choice");
            }
        }while(!isQuit);


    }

}
