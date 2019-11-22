import java.util.ArrayList;
import java.util.HashMap;


public class Program {

	public static void main(String[] args) {
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("job", "doctor");
		hm.put("name", "juan");
		String s = hm.get("pet");
		
		System.out.println(hm.get("job"));
		System.out.println(hm.get("pet"));
		
		hm.remove("foo");
		System.out.println(hm);
		if (hm.containsValue("juan"))
			System.out.println("True");
		
//		//List<Integer> numList = new ArrayList<Integer>();
//		//this is a common syntax
//		ArrayList<Integer> numList = new ArrayList<Integer>();
//		numList.add(10); numList.add(4); numList.add(5)	;
//		
//		// imagine we will list with 5 numbers
//		int sum = 0;
//		for (int i=0; i < numList.size(); i++) {
//			sum += numList.get(i);
//		}
//		System.out.println("Sum is " + sum);
//
//		sum = 0;
//		for (int num:numList) {
//			sum += num;
//		}
//		System.out.println("Sum is " + sum);
	}
}