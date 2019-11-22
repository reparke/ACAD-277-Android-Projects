
public class Program {
	public static void main(String[] args) {
		Chocolate c = new Chocolate();
		c.setName("Godiva");
		c.setPercentCocoa(75.0);
		c.writeOutput();
		
		c.reset("Kit Kat", 20);
		c.writeOutput();
	}

}
