package acad277;

public class Weapon {
	private String name;
	private int damage;

	public Weapon(String inputName, int inputDamage) {
		name = inputName;
		damage = inputDamage;
	}

	public String toString() {
		return "Name: " + name + "\tDamage: " + damage;
	}
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
	public void use() {
		System.out.println("Using generic weapon");
	}
}
