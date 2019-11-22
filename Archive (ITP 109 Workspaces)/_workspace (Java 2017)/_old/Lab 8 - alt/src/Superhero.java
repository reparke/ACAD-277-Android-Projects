/*
 * create a superhero class
 */
public class Superhero {

	private String name;
	private int healthPoints;
	private int attackValue;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int health) {
		this.healthPoints = health;
	}
	public int getAttackValue() {
		return attackValue;
	}
	public void setAttackValue(int attack) {
		this.attackValue = attack;
	}

	public void displayHero() {
		System.out.format(
				"Name: %s\nHealth Points: %d\nAttack Value: %d\n", name, healthPoints, attackValue);
	}
	
	public boolean isInjured() {
		if (healthPoints <= 0) 
			return true;
		return false;
	}
	public void loseHealth(int attackValue) {
		healthPoints -= attackValue;
	}
}




