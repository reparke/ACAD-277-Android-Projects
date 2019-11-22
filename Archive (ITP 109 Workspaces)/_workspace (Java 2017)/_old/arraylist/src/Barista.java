// For Docs and Utils





public class Barista {

	private String name;
	private int yearsExperience;

	
	public Barista(String userName){
		name = userName;
		yearsExperience = 0;
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public int getYearsExperience() {
		return yearsExperience;
	}
	
	public void setYearsExperience(int newYearsExperience) {
		yearsExperience = newYearsExperience;
	}
	
	public void displayBarista() {
		System.out.println("Name: " + getName());
		System.out.println("Years Experience: " + getYearsExperience());
	}

}
