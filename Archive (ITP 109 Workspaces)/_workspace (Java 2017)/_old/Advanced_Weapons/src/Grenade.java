
public class Grenade extends Weapon implements Throwable{

	private int blastRadius;
	
	public Grenade(String name, int attackValue, int blastRadius) {
		super(name, attackValue);
		this.blastRadius = blastRadius;
	}
	
	public int getBlastRadius() {
		return blastRadius;
	}


	public void setBlastRadius(int blastRadius) {
		this.blastRadius = blastRadius;
	}


	@Override
	public void throwObject() {
		System.out.println("Lobbing " + getName());
		
	}

	@Override
	public boolean retrieveObject() {
		System.out.println("Can not retrieve " + getName());
		return false;
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
