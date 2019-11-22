

public class Bat extends Animal implements Flying {
	
	public Bat() {
		super("Bat", "Echolocation");
	}
	
	public Bat(String name, String theSound) {
		super(name, theSound);
	}

	public void BeginFlying() {
		System.out.println(getName() + " begins flying");
	}

	public void EndFlying() {
		System.out.println(getName() + " ends flying");
	}
	
}
