

public class Cat extends Animal {

	public Cat() {
		super("Cat", "Meow");
	}
	
	public Cat(String name, String theSound) {
		super(name, theSound);
	}
	
	public void makeSound() {
		super.makeSound();
		System.out.print(". I Like tuna.");
	}

}
