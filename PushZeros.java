public class PushZeros{
	public static void main(String[] args){
		int[] arr = {0,1,3,0,2,4,3};
		//non-static method helper(int[]) cannot be referenced from a static context
		PushZeros obj = new PushZeros();
		//or we can make the helper function static so that we can directly call it here
		obj.helper(arr);
		for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
	}

	//java passed by value? in this way could it possibly change the arr passed in without return?
	//but here we are passing the initial address of the array into the helper funciton
	private void helper(int[] arr){
		int len = arr.length;
		int newindex = 0;
		for(int i=0; i < len; i++){
			if(arr[i]!=0){
				arr[newindex] = arr[i];
				newindex++;
			}
		}

		//after this all the non-zero values should be in the front of the arr
		//then we just need to padding the remaining positions
		for(int j=newindex; j<len; j++){
			arr[j] = 0;
		}
	}
}