
public class Program {

	public static void main(String[] args) {
		Circle c = new Circle ("ball", 5);
		Rectangle r = new Rectangle ("court", 4, 10);
		
		showInfo(c);
		showInfo(r);
		
		showMeasurableInfo(c);
		showMeasurableInfo(r);
	}
	
	public static void showInfo(Shape s) {
		s.display();
	}
	
	public static void showMeasurableInfo(Measurable m) {
		System.out.println("Area: " + m.getArea());
		System.out.println("Perimeter: " + m.getPerimeter());
	}

}
