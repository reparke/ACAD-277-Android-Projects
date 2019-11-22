
public class Athlete {

	private String name;
	private int yardsRan;
	
	//Default constructor 
	public Athlete (){
		name = "";
		yardsRan = -1; 
	}
	
	//Overloaded Constructor: Name
	public Athlete (String athleteName){
		name = athleteName; 	
	}
	
	//Overload Constructor: Name + Yards
	public Athlete (String athleteName, int numYardsRan){
		name = athleteName; 
		yardsRan= numYardsRan; 
	}

	//Getters and Setters
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public int getYardsRan() {return yardsRan;}
	public void setYardsRan(int yardsRan) {this.yardsRan = yardsRan;}
	
	//Add Yards Method
	public void addYards(int addYards){
		yardsRan = yardsRan + addYards; 
	}
	
	//Display Method
	public void display (){
		System.out.println( name + " has run " + yardsRan + " yards.");
	}
}
