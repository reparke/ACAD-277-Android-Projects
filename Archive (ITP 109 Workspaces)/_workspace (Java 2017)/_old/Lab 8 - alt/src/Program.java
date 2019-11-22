public class Program {
	public static void main(String[] args) {
		Superhero player1 = new Superhero();
		Superhero player2 = new Superhero();
		int rounds = 0;
		
		player1.setName("Wolverine");
		player1.setAttackValue(50);
		player1.setHealthPoints(100);
		
		player2.setName("Magneto");
		player2.setAttackValue(30);
		player2.setHealthPoints(150);
		
		System.out.println("HEROES");
		player1.displayHero();
		player2.displayHero();
		
		System.out.println("\nFIGHT!\n");
		
		while(player1.isInjured() == false && player2.isInjured() == false){
			rounds++;
			System.out.println("====== Round " + rounds + " ======");

			// player 1 attacks player 2
			player2.loseHealth(player1.getAttackValue());
			// player 2 attacks player
			player1.loseHealth(player2.getAttackValue());
			player1.displayHero();
			player2.displayHero();
			System.out.println();
		}

		if(player1.isInjured())
			System.out.println(player2.getName() + " won!");
		else
			System.out.println(player1.getName() + " won!");
			
		


	}
	
}
