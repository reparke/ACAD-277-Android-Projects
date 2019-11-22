
public class Player {
	private String name;
	private Weapon primaryWeapon;
	private Throwable secondaryWeapon;
	
	public Player(String name, Weapon primaryWeapon, Throwable secondaryWeapon) {
		super();
		this.name = name;
		this.primaryWeapon = primaryWeapon;
		this.secondaryWeapon = secondaryWeapon;
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
	public void setPrimaryWeapon(Weapon primaryWeapon) {
		this.primaryWeapon = primaryWeapon;
	}

	public void usePrimaryWeapon() {
		primaryWeapon.use();
	}
	
	public void useSecondaryWeapon() {
		secondaryWeapon.throwObject();
	}
	

}









