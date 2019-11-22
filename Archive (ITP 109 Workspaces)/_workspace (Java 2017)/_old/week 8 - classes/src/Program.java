public class Program {
	public static void main(String[] args) {
		Vehicle carlaCar = new Vehicle();
		Vehicle johnCar = new Vehicle();

		carlaCar.fuelCapacity = 16.5;
		carlaCar.setNumberOfWheels(18);
		carlaCar.setLicensePlate("Truckz");
		carlaCar.reportVehicle();

		johnCar.setNumberOfWheels(4);
		johnCar.setLicensePlate("5WFC333");
		johnCar.reportVehicle();
	}
}
