public class Program {
	public static void main(String[] args) {
		Order item1 = new Order();
		
		
		item1.setCostPerPound(8.99);
		item1.setPounds(2);
		item1.setName("Kona");
		
		item1.printOrder();
		
		System.out.println("Cost: " + item1.calcCost());

	}
	
}

//public class Program {
//	public static void main(String[] args) {
//		Order item1 = new Order();
//		Barista barKate = new Barista();
//		
//		barKate.setName("Kate");
//		
//		
//		item1.setCostPerPound(8.99);
//		item1.setPounds(2);
//		item1.setName("Kona");
//
//		barKate.displayGreeting();
//		barKate.finalizeOrder(item1);
//
//	}
//	
//}