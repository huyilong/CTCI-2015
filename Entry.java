//an entry class defines a pair of character and frequency of this character
//this is for solving the Problem 1
public class Entry implements Comparable<Entry>{
	//declare the variables for entry
	private char value;
    private int frequency;
    //constructor
    public Entry(char c, int f){
    	this.value = c;
    	this.frequency = f;
    }
    //getters and setters
    public int getFrequency(){
    	return frequency;
    }
    public char getValue(){
    	return value;
    }
    public void setFrequency(int f){
    	this.frequency = f;
    }
    public void setValue(char c){
    	this.value = c;
    }
    
	@Override
	public int compareTo(Entry o) {
		int compareFrequency = o.getFrequency();
		//sort the array based on acsending order
		return this.frequency - compareFrequency;
	}
    
}
