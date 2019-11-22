	/*
	 * ammo
	 * 	 * scope (boolean)
	 * range
	 * burstFiring
	 * recoilAmount
	 * handleSize
	 * nozzleLength

	 * 
	 */
public class Rifle extends Weapon { //rifle IS A weapon
	private int numBullets;
	private boolean scope;
	
	public Rifle(String name, int damage, int numBullets, boolean scope) {
		//first thing is you MUST call parent constructor
		super(name, damage);
		
		this.numBullets = numBullets;
		this.scope = scope;
//		System.out.println("Inside rifle constructor");
		
	}

	public int getNumBullets() {
		return numBullets;
	}

	public void setNumBullets(int numBullets) {
		this.numBullets = numBullets;
	}
	
	public void offsetNumBullets(int number) {
		numBullets += number;
	}

	public boolean isScope() {
		return scope;
	}

	public void setScope(boolean scope) {
		this.scope = scope;
	}
	
	public String toString() {
		String msg = super.toString();
		msg += ", numBullets = " + numBullets + 
				", scope = " + scope;
		return msg;
	}
	
	public void use() {
		if (numBullets >= 3) {
			numBullets -= 3;
			System.out.println("Firing " + getName() );
		}
		else {
			System.out.println("Empty!");
		}
	}
	


}




















