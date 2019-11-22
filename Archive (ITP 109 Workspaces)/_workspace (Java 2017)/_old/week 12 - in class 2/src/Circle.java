
public class Circle extends Shape implements Measurable {

	private double r;
	
	public Circle (String inputName, double inputR) {
		super(inputName);
		r = inputR;
	}
	@Override
	public void display() {
		System.out.println("Circle");
		System.out.println("\traidus: " + r);
	}
	@Override
	public double getArea() {
		return Math.PI * r * r;
	}
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * r;
	}
}

