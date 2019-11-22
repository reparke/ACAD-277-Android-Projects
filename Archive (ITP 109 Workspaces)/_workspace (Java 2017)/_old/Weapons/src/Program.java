import java.util.HashMap;

/*
 * asdfasdf
 */
public class Program {

	public static void main(String[] args) {
		
		Knife messer = new Knife("butter", 2, 10);
		Bazooka b = new Bazooka("The Amri", 100, 100);
		
		HashMap<String, Weapon> weaponHashMap = new HashMap<String, Weapon>();
		
		weaponHashMap.put(k.getName(), messer);
		weaponHashMap.put(b.getName(), b);
		
		//-------
		
		Weapon w = weaponHashMap.get("butter");
		w.use();
		
		System.out.println("There are " + weaponHashMap.size() + " weapons stored");
		
		weaponHashMap.remove("The Amri");
		System.out.println("There are " + weaponHashMap.size() + " weapons stored");
		
		if (weaponHashMap.containsKey("Grenade")) {
			System.out.println("You have a grenade");
		}
		else {
			System.out.println("You do not have a grenade");
		}
		
		
		
		
		
		

	}

}


//Weapon[] armory = new Weapon[2];
//armory[0] = k;
//armory[1] = b;
//
//for (int i = 0; i < armory.length; i++) { 
//	armory[i].use();
//}
//
//Player p1 = new Player("Private Parke", b, k);
//p1.usePrimaryWeapon();
//p1.useSecondaryWeapon();
