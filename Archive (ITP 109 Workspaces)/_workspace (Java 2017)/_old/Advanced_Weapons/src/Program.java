
public class Program {

	public static void main(String[] args) {
		
		
		Weapon[] armory = new Weapon[3];
		
		armory[0] = new Rifle("AK47", 30, 50, false);
		armory[1] = new Rifle("SCAR", 50, 20, false);
		armory[2] = new SniperRifle("Sniper", 80, 8);
		
		for (int i = 0; i < armory.length; i++) {
			armory[i].use();
		}
				
		//----------------
		
		Knife knife = new Knife("butter knife", 5, 5);
		Rifle ak47 = new Rifle("AK47", 30, 50, false);
		SniperRifle sniper = new SniperRifle("Sniper", 80, 8);
		
		PlayerWithTwoWeapons p = new PlayerWithTwoWeapons("Sally", ak47, knife);
		p.usePrimaryWeapon();
		
		p.setPrimaryWeapon(sniper);
		p.usePrimaryWeapon();
		
		
	}
}
	
	
	//version of code with static methods
	
	/*public class Program {

		public static void main(String[] args) {
			
			
			Weapon[] armory = new Weapon[3];
			
			armory[0] = new Rifle("AK47", 30, 50, false);
			armory[1] = new Rifle("SCAR", 50, 20, false);
			armory[2] = new SniperRifle("Sniper", 80, 8);
			
			for (int i = 0; i < armory.length; i++) {
				armory[i].use();
			}

			testWeapon(armory[2]);
			
			SniperRifle s = new SniperRifle("long rifle", 30, 5);
			testWeapon(s);
			
			testWeapon(armory[1]);
			
		
			
			Player p = new Player("Sally", s);
			
			
			
		}		
	
	public static void testWeapon(Weapon w) {
		System.out.println("Testing your weapon...");
		
		
		if (w instanceof SniperRifle) {
			SniperRifle s = (SniperRifle) w;
			s.use();
			s.setZoomLevel(4);
		}
		else if (w instanceof Rifle) {
			Rifle r = (Rifle) w;
			r.offsetNumBullets(4);
			r.use();
		}
		
		
		
	}
	
	
	
	*/
	
	
	
	