
public class Animal {
	
	private String name = "";
	private String sound = "";
	
	public Animal(String name, String theSound) {
		this.name = name;
		sound = theSound;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setSound(String newSound) {
		sound = newSound;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSound() {
		return sound;
	}
	
	public void eat(Animal myPrey) {
		System.out.println(this.getName() + " tries to eat " + myPrey.getName());
		
	}
	
	public void makeSound() {
		System.out.print(sound);
	}
}
