public class Animal{
	public static String DEFAULT_ANIMAL_NAME = "Unicorn";
	public static String DEFAULT_ANIMAL_CALL = "I AM FABULOUS!";
	private String mName;
	private String mCall;
	
	//default constructor
	public Animal(){
		setName(DEFAULT_ANIMAL_NAME);
		setCall(DEFAULT_ANIMAL_CALL);
	}
	
	public Animal(String newAnimalName, String newAnimalCall){
		setName(newAnimalName);
		setName(newAnimalCall);
	}
	
	//notice that the parameter here (newAnimalName) is the same as in our constructor
	//this is allowed because each method only sees the one closest to it
	//they are named the same because they have the same purpose, not because they have to be the same
	//we cannot guarantee that since someone else can call setName without calling the constructor
	public void setName(String newAnimalName){
		mName = newAnimalName;
	}
	
	public void setCall(String newAnimalCall){
		mCall = newAnimalCall;
	}
	
	public String getName(){
		return mName;
	}
	
	public String getCall(){
		return mCall;
	}
	
	public String describe(){
		String description = "";
		//TODO:
		//Fill this part in
		//it should return something that looks like
		//"When you startle a Unicorn in the wild, it will shout "I AM FABULOUS" before running away."
		//but instead of always saying Unicorn and "I AM FABULOUS",
		//it should say whatever the Animal has saved
		
		description = "When you startle a " + getName() + " in the wild, it will shout " + 
						getCall() + " before running away";
		
			
		
		return description;
	}
}





