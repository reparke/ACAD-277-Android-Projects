
public class Knife extends Weapon implements Throwable{
	//	private boolean throwable;
	public static final double PROBABLITIY_RETRIEVING_THROWN_KNIFE = 0.75;

	int durability;

	public Knife(String name, int attackValue, int durability) {
		super(name, attackValue);
		this.durability = durability;
	}

	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	public void use() {
		System.out.println("Using " + getName());
	}

	@Override
	public void throwObject() {
		System.out.println("Throwing " + getName());

	}

	@Override
	public boolean retrieveObject() {
		if (Math.random() >= PROBABLITIY_RETRIEVING_THROWN_KNIFE) {
			System.out.println("Retrieving " + getName());
			return true;
		}
		else {
			System.out.println("Can not retrieving " + getName());
			return false;
		}

	}
}

//	public void throwKnife() {
//		if (isThrowable() == true) {
//			System.out.println("Throwing " + getName());
//		}
//		else {
//			System.out.println("Knife can't be thrown");
//		}
//}

//
//public class Knife extends Weapon {
//	private boolean throwable;
//
//	public Knife(String inputName, int inputDamage, boolean throwable) {
//		super(inputName, inputDamage);
//		this.throwable = throwable;
//	}
//
//	public boolean isThrowable() {
//		return throwable;
//	}
//
//	//	public void setThrowable(boolean throwable) {
//	//		this.throwable = throwable;
//	//	}
//
//	public void use() {
//		System.out.println("Using " + getName());
//	}
//	public void throwKnife() {
//		if (isThrowable() == true) {
//			System.out.println("Throwing " + getName());
//		}
//		else {
//			System.out.println("Knife can't be thrown");
//		}
//	}
//
//}
