// For Docs and Utils





public class Superhero {

	private String name;
	private int healthPoints;
	private int attackValue;
	private static final int MAX_HEALTHPOINTS = 50;
	private static final int MAX_ATTACKVALUE = 20;
	
	public Superhero(String userName){
		name = userName;
		healthPoints = MAX_HEALTHPOINTS;
		attackValue = (int)(Math.random() * MAX_ATTACKVALUE) + 1;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	
	public int getAttackValue() {
		return attackValue;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setHealthPoints(int newHealthPoints) {
		healthPoints = newHealthPoints;
	}
	
	public void setAttackValue(int newAttackValue) {
		attackValue = newAttackValue;
	}

	public void displayHero() {
		System.out.println("Name: " + getName());
		System.out.println("Health Points: " + getHealthPoints());
		System.out.println("Attack Value: " + getAttackValue());
	}

	public boolean isInjured() {
		if (healthPoints <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void loseHealthPoints(int attackValue) {
		healthPoints = healthPoints - attackValue;
	}

}
