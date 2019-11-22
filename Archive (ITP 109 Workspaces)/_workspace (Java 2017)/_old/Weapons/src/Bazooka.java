/*
 * num of rockets / ammo
 * distance
 * accuracy
 * color
 * splash
 * 
 */
public class Bazooka extends Weapon {
	private int ammo;

	public Bazooka(String name, int damage, int ammo) {
		super(name, damage);
		this.ammo = ammo;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	public void use() {
		if (ammo >= 25) {
			System.out.println("Firing " + getName() + "...duck!");
			ammo = ammo - 25;
		}
		else {
			System.out.println(getName() + " is out of ammo!");			
		}
		
	}

}









