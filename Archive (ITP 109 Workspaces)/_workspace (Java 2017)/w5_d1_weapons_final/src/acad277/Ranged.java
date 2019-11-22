package acad277;

public class Ranged extends Weapon{
	private int capacity;


	public Ranged(String inputName, int inputDamage, int capacity) {
		super(inputName, inputDamage);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String toString() {
		String msg = super.toString();
		msg += "\nCapacity: " + capacity;
		return msg;
	}

	public boolean reduceCapacity(int num) {
		if (this.capacity - num >= 0) {
			this.capacity -= num;
			return true;
		}
		return false;
	}

	public void use() {
		boolean result = reduceCapacity(1);
		if (result == true) {
			System.out.println("\tFiring {"+getName()+"} (capacity: {"+ capacity +"})");
		}
		else{
			System.out.println("Out of capacity!");
		}
	}
}

