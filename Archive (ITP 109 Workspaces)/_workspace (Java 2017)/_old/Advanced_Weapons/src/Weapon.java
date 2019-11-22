
public class Weapon {
	private String name;
	private int attackValue;
	
	public Weapon(String name, int attackValue) {
		this.name = name;
		this.attackValue = attackValue;
//		System.out.println("Inside weapon constructor");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttackValue() {
		return attackValue;
	}
	public void setAttackValue(int attackValue) {
		this.attackValue = attackValue;
	}
	
	public String toString() {
		String msg = "Name = " + name + 
					 ", Attack = " + attackValue;
		
		return msg;
	}
	
	public void use() {
		System.out.println("Using a weapon");
	}
	
	
	
}








