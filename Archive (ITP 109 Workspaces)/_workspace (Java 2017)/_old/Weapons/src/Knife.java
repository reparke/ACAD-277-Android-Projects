/*
 * weapon has name, damage
 * sharpness
 * material
 * handling / weight
 * length
 * handedness
 */
public class Knife extends Weapon implements Throwable {
	private int sharpness;


	public Knife(String name, int damage, int sharpness) {
		super(name, damage);
		this.sharpness = sharpness;
	}

	public int getSharpness() {
		return sharpness;
	}

	public void setSharpness(int sharpness) {
		this.sharpness = sharpness;
	}
	
	public void use() {
		if (sharpness > 0 ) {
			System.out.println("Using " + getName() + " with sharpness of " + sharpness);
			sharpness--;
		}
		else {
			System.out.println("Knife is too dull to use");
		}
	}

	@Override
	public void throwObject() {
		System.out.println("Throwing " + getName());
	}

	@Override
	public boolean retrieveObject() {
		System.out.println("Retrieving " + getName());
		return true;
	}
	

}




















