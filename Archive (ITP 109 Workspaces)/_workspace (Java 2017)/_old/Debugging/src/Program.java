//






public class Program {

	public static void main(String[] args) {		
		Superhero player1 = new Superhero("Prof Parke"); 
		Superhero player2 = new Superhero("TA Mike");

		
		Superhero [] players = new Superhero[2];
		players[0] = player1;
		players[1] = player2;
		players[players.length].displayHero();
	}

}
