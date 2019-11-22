
public class PlayerWithTwoWeapons {
	private String name;
	private Weapon primaryWeapon;
	private Throwable secondaryWeapon;
	
	public PlayerWithTwoWeapons(String inputName, Weapon inputPrimary, Throwable inputSecondary) {
		name = inputName;
		primaryWeapon = inputPrimary;
		secondaryWeapon = inputSecondary;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weapon getPrimaryWeapon() {
		return primaryWeapon;
	}

	public void setPrimaryWeapon(Weapon w) {
		this.primaryWeapon = w;
	}

	public Throwable getSecondaryWeapon() {
		return secondaryWeapon;
	}

	public void setSecondaryWeapon(Throwable t) {
		this.secondaryWeapon = t;
	}

	public void usePrimaryWeapon() {
		primaryWeapon.use();
	}
	
	public void throwSecondaryWeapon() {
		secondaryWeapon.throwObject();
	}
	
	public boolean retrieveSecondaryWeapon() {
		return secondaryWeapon.retrieveObject();
	}
	

}
