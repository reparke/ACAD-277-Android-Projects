
public class Canary extends Animal implements Flying {

	public Canary() {
		super("Canary", "Tweet");
	}
	
	public Canary(String name, String theSound) {
		super(name, theSound);
	}

	public void BeginFlying() {
		System.out.println(getName() + " begins flying");
	}

	public void EndFlying() {
		System.out.println(getName() + " ends flying");
	}
	
}
