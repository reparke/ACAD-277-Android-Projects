
public class ChocolateDemo {
	public static void main(String[] args) {
		Chocolate c = new Chocolate();
		c.setName("Godiva");
		c.setPercentCocoa(75.0);
		c.writeOutput();
		
		Chocolate c2 = new Chocolate("Godiva", 75.0);
		
		System.out.println(c2.equals(c));
	}

}
