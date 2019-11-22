
public class Candy {
	private String name;
	
	public Candy() {
		this("No name yet");
	}
	
	public Candy(String initialName) {
		name = initialName;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void writeOutput() {
		System.out.println("Name: " + name);
	}
	
	public boolean hasSameName(Candy otherCandy) {
		return this.name.equalsIgnoreCase(otherCandy.name);
	}
}
