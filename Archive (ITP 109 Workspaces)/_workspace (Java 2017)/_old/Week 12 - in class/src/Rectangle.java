
public class Rectangle extends Shape {
	private double w;
	private double l;
	
	public Rectangle(String inputName, double inputW, double inputL) {
		super(inputName);
		w = inputW;
		l = inputL;
	}
	
	public void display() {
		System.out.println("Rectangle");
		System.out.println("\twidth: " + w + ", height: " + l);
	}
}
