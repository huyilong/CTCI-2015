import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Problem1 {
	public static void main(String[] args){
		String test = new String("aabbcbbdeea");
		Problem1 solver = new Problem1();
		String result = solver.helper(test);
		System.out.println(result);
	}

	private String helper(String input){
		//create an arraylist for the entries
		List<Entry> arr = new ArrayList<>();
		StringBuilder result = new StringBuilder();
		//create a hashmap for counting the frequency for each character in the string
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<input.length(); i++){
			if(!map.containsKey(input.charAt(i))){
				//new entry
				map.put(input.charAt(i), 1);
			}else{
				//update the frequency by increasing 1 for old entry
				map.put(input.charAt(i), map.get(input.charAt(i))+1);
			}
		}
		//add the entries into the arraylist
		for(char c : map.keySet()){
			Entry sub = new Entry(c, map.get(c));
			arr.add(sub);
		}
		//sort the entries based on the new comparing rule
		Collections.sort(arr);
		//build the result string
		for(Entry e : arr){
			result.append(e.getValue()).append("(").append(e.getFrequency()).append(") ");
		}
		//delete the trailing space and return the result 
		return result.deleteCharAt(result.length()-1).toString();
	}
}
