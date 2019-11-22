
public class Filledchocolate extends Chocolate {
	private String filling;
	
	public Filledchocolate() {
		super();
		filling = "None";
	}
	
	public Filledchocolate(String initialName, double initialPercentCocoa, 
			String initialFilling) {
		super(initialName, initialPercentCocoa);
		setFilling(initialFilling);
	}

	public void reset(String newName, double newPercentCocoa, 
			String newFilling) {
		reset(newName, newPercentCocoa); // Chocolate's reset
		setFilling(newFilling);
	}
	
	public String getFilling() {
		return filling;
	}
	
	public void setFilling(String newFilling) {
		if (newFilling.equalsIgnoreCase("chocolate")) {
			System.out.println("That would make it a \"SOLID\" chocolate bar!");
			System.exit(0);
		}
		else {
			filling = newFilling;
		}		
	}
	
	public void writeOutput() {
		super.writeOutput();
		System.out.println("Filling: " + filling);
	}
	
	public boolean equals(Filledchocolate otherFilledchocolate) {
		return equals((Chocolate)otherFilledchocolate) &&
				(this.filling.equalsIgnoreCase(otherFilledchocolate.filling));
	}
}
