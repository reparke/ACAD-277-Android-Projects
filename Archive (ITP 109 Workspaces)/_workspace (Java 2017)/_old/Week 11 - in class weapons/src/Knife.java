
public class Knife extends Weapon {
	private boolean throwable;

	public Knife(String inputName, int inputDamage, boolean throwable) {
		super(inputName, inputDamage);
		this.throwable = throwable;
	}

	public boolean isThrowable() {
		return throwable;
	}

	//	public void setThrowable(boolean throwable) {
	//		this.throwable = throwable;
	//	}

	public void use() {
		System.out.println("Using " + getName());
	}
	public void throwKnife() {
		if (isThrowable() == true) {
			System.out.println("Throwing " + getName());
		}
		else {
			System.out.println("Knife can't be thrown");
		}
	}

}
