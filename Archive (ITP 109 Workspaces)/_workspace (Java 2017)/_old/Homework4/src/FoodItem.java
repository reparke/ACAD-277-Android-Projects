
public class FoodItem {
	private String mName;
	private int mAmountOwned;
	private int mAmountNeeded;
	
	public FoodItem(){
		setName("Cheese");
		setAmountOwned(10);
		setAmountNeeded();
	}
	
	public FoodItem(String newFoodName, int newAmountOwned){
		setName(newFoodName);
		setAmountOwned(newAmountOwned);
		setAmountNeeded();
	}

	public String getName() {
		return mName;
	}

	public void setName(String newFoodName) {
		mName = newFoodName;
	}

	public int getAmountOwned() {
		return mAmountOwned;
	}

	public void setAmountOwned(int newAmountOwned) {
		mAmountOwned = newAmountOwned;
	}

	//we can have methods be private
	//this just means only a FoodItem can call this
	//and it can only be called inside the FoodItem
	private int getAmountNeeded() {
		return mAmountNeeded;
	}

	private void setAmountNeeded() {
		mAmountNeeded = (int) (Math.random() * 10 + 1);
	}
	
	public boolean haveEnough(){
		boolean result = false;
		
		//TODO:
		//fill this in by comparing mAmountNeeded and mAmountOwned
		//you want true when mAmountOwned is more than or equal to mAmountNeeded
		//hint: call getAmountNeeded, you can do it here since you are inside FoodItem!
		if (mAmountOwned >= mAmountNeeded){
			result = true;
		}else{
			result = false;
		}
		
		return result;
	}
	
	public int getAmountMissing(){
		return getAmountNeeded() - getAmountOwned();
	}
	
}
