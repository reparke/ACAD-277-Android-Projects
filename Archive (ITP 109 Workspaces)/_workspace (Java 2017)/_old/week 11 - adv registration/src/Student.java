
public class Student {

	private String name;
	private int idNum;
	private int numberOfClasses;
	//* UPDATE * add support for classes
	
	public Student(String name, int idNumber){
		this.name = name;
		idNum = idNumber;
		numberOfClasses = 0; // no classes to start with
		//* UPDATE * add support for classes
		
		
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		this.name = newName;
	}
	public int getIdNum() {
		return idNum;
	}
	public int getNumberOfClasses() {
		return numberOfClasses;
	}
	
	//* UPDATE* static method getMaxClasses() 
	//returns the constant MAX_CLASSES
	
	
	//* UPDATE* method getClasses
	//returns the array of classes
	
	
	//* UPDATE* method getClassesString
	//input: none
	//output: String 
	//description: returns String with the names of all classes (in string array)

	
	public void displayInformation(){
		System.out.println("Student: " + name
							+ "\t IdNum: " + idNum
							+ "\nenrolled in " + numberOfClasses);
		//* UPDATE* to show classees
	}
	
	
}
