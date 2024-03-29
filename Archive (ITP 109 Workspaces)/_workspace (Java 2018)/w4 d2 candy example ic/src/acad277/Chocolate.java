package acad277;


public class Chocolate extends Candy {
	private double percentCocoa;
	
	public Chocolate() {
		super();
		// Indicating no setting yet
		percentCocoa = 0;
	}
	
	public Chocolate(String initialName, double initialPercentCocoa) {
		super(initialName);
		percentCocoa = initialPercentCocoa;
	}
	
	public void reset(String newName, double newPercentCocoa) {
		setName(newName);
		percentCocoa = newPercentCocoa;
	}
	
	public double getPercentCocoa() {
		return percentCocoa;
	}
	
	public void setPercentCocoa(double newPercentCocoa) {
		percentCocoa = newPercentCocoa;
	}

	
	public boolean equals(Chocolate otherChocolate) {
		return this.hasSameName(otherChocolate) &&
				(this.percentCocoa == otherChocolate.percentCocoa);
	}


	public void writeOutput() {
		super.writeOutput();
		System.out.println("Cocoa: " + percentCocoa);
	}

	public String toString() {
		String msg = getName() + " (" + percentCocoa +")";
		return msg;
	}









/*	// A better equals
    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (!(otherObject instanceof Chocolate))
            return false;
        else
        {
            Chocolate otherChocolate = (Chocolate)otherObject;
            return (this.hasSameName(otherChocolate) &&
            		(this.percentCocoa == otherChocolate.percentCocoa));
        }
    }
*/
}
