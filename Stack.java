/*
public class StackData{
	public int start;
	public int size = 0;
	public int capacity =100;
	//we must use public for each var to define their scopes
}*/
public class Stack{
	public stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	//use a single array of buffer to implement 3 stacks

	//tops is an array of 3 numbers for each top index of the stack
	int[] tops = {-1, -1, -1};//here we are initializing the array directly

	public void push(int stackNum, int value) throws Exception{
		if(tops[stackNum] >= stackSize){
			throw new FullStackException();
		}

		//update the pointer for checking capacity
		tops[stackNum]++;
		//update the value at this position
		int index = stackNum * stackSize + tops[stackNum];
		buffer[index] = value;

	}

	//for pop we just need to specify which stack to pop without value
	public void pop(int stackNum) throws Exception{
		if(isEmpty(stackNum)){
			throw new EmptyStackException;
		}
		int top_index = stackNum * stackSize + tops[stackNum];
		//update the tops index
		tops[stackNum]--;
		//before we clear the value at this position we must get the value at first
		int value = buffer[top_index];

		/////here we forget to do one thing which is clear the value in the buffer
		buffer[top_index] = 0;
		return value;
	}


	public int peek(int stackNum) throws Exception{
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		int top_index = stackNum * stackSize + tops[stackNum];
		return buffer[top_index];
	}

	public boolean isEmpty(int stackNum){
		return tops[stackNum] == -1;
	}

	//the difference between throws and throw!!!!
}