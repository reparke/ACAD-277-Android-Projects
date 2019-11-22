package acad277;

/*
 * sharpness
 * length
 * numberEdges
 * durability
 * throwable (boolean)
 */
public class Melee extends Weapon {
	private int durability;		// number of uses
	private boolean throwable;
	
	//constructor 
	public Melee(String inputName, int inputDamage, int inputDurability, boolean inputThrowable) {
		super(inputName, inputDamage);
		this.durability = inputDurability;
		this.throwable = inputThrowable;
	}
	
	//isThrowable
	public boolean isThrowable() {
		return this.throwable;
	}
	
	public void throwItem() {
		if (this.throwable == true && this.durability > 0) {
			this.durability = 0;
			System.out.println("Throwing " + this.getName() );
		}
		else {
			System.out.println("Melee can not be thrown");
		}
	}
	
	public void use() {
		if (this.durability >= 1) {
			this.durability--;
			System.out.println("Using " + this.getName());
		}
		else {
			System.out.println("Melee is broken");
		}
	}
	
	public String toString() {
		String temp = super.toString();
		temp += "\nDurabiltity: " + this.durability + "\nThrowable: " + this.throwable;
		return temp;
	}

}





















