
public class Rifle extends Weapon{
	private int numBullets;


	public Rifle(String inputName, int inputDamage, int numBullets) {
		super(inputName, inputDamage);
		this.numBullets = numBullets;
	}

	public int getNumBullets() {
		return numBullets;
	}

	public void setNumBullets(int numBullets) {
		this.numBullets = numBullets;
	}

	public String toString() {
		String msg = super.toString();
		msg += "\nNumBullets: " + numBullets;
		return msg;
	}

	public void use() {
		if(numBullets >= 3) {
			numBullets -= 3;
			System.out.println("\tFiring {"+getName()+"} (bullets: {"+numBullets+"})");
		}
		else{
			System.out.println("Empty!");
		}
	}
}

