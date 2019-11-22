
public class Rectangle extends Shape implements Measurable {
	private double w;
	private double l;
	
	public Rectangle(String inputName, double inputW, double inputL) {
		super(inputName);
		w = inputW;
		l = inputL;
	}
	@Override
	public void display() {
		System.out.println("Rectangle");
		System.out.println("\twidth: " + w + ", height: " + l);
	}
	@Override
	public double getArea() {
		return w * l;
	}
	@Override
	public double getPerimeter() {
		return 2 * w + 2 * l;
	}
}
