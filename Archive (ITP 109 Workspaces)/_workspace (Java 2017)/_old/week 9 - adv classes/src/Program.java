public class Program {
	public static void main(String[] args) {
		Vehicle carlaCar = new Vehicle(18, "Truckz", 16.5);
		Vehicle johnCar = new Vehicle(4, "5WFC333", 10);

		carlaCar.reportVehicle();
		johnCar.reportVehicle();
		System.out.println("Num Cars: " + Vehicle.getNumCars());
		
	}
}
