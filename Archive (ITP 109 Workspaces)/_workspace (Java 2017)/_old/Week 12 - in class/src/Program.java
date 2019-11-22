
public class Program {

	public static void main(String[] args) {
		Circle c = new Circle ("ball", 5);
		Rectangle r = new Rectangle ("court", 4, 10);
		
		showInfo(c);
		showInfo(r);
	}
	
	public static void showInfo(Shape s) {
		s.display();
	}

}
