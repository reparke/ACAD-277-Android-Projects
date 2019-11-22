public class Vehicle {
	private int numberOfWheels;
	private String licensePlate;
	public double fuelCapacity;		//Generally, all instance variables should be private

	public void setNumberOfWheels(int input) {
		numberOfWheels = input;
	}
		public int getNumberOfWheels() {
		return numberOfWheels;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String lp) {
		licensePlate = lp;
	}

	public void reportVehicle() {
		System.out.println("Suspect is driving a " + numberOfWheels
				+ " vehicle with plate: " + licensePlate);
	}
}
