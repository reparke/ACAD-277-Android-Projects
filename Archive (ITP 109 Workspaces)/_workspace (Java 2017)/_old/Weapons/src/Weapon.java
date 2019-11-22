
public class Weapon {	//parent class
	/*
	 * damage
	 * durability
	 * weight
	 * cost
	 * range
	 * accuracy
	 * stopping power
	 * handed
	 * name
	 */
	
	private String name;
	private int damage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public Weapon(String name, int damage) {
		super();
		this.name = name;
		this.damage = damage;
	}
	
	public void use() {
		System.out.println("Using generic weapon -- you shouldn't see this");
	}
	
	public String toString() {
		String msg = "Name: " + name + ", Damage: " + damage;
		
		return msg;
		
	}
	
	
	

}














