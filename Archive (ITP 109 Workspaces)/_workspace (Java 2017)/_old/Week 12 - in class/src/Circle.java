
public class Circle extends Shape{

	private double r;
	
	public Circle (String inputName, double inputR) {
		super(inputName);
		r = inputR;
	}
	
	public void display() {
		System.out.println("Circle");
		System.out.println("\traidus: " + r);
	}
}

