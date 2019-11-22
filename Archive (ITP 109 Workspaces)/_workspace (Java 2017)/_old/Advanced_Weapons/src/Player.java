
public class Player {
	private String name;
	private Weapon w;
	
	public Player(String inputName, Weapon inputW) {
		name = inputName;
		w = inputW;
	}
	
	public void useWeapon() {
		w.use();
	}

}
