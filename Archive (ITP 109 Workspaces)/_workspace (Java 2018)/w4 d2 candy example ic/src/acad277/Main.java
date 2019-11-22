package acad277;

public class Main {
	public static void main(String[] args) {

		Candy candy1 = new Candy("sour patch kids");
		candy1.writeOutput();

		Chocolate chocolate1 = new Chocolate("kit kat", .70);

		System.out.println(chocolate1);



//		chocolate1.writeOutput();
//		System.out.println(chocolate1.getName());

//
//		Chocolate c = new Chocolate();
//		c.setName("Godiva");
//		c.setPercentCocoa(75.0);
//		c.writeOutput();
	}

}
