public class Problem2 {
	public static void main(String[] args){
		double test1 = 0.78;
		double test2 = 0.41;
		//available three types of changes
		int[] coins = {25, 10, 1};	
		Problem2 solver = new Problem2();
		//before pass into the solver convert the test case into cents
		int result1 = solver.helper(test1*100, coins);
		System.out.println(result1);
		int result2 = solver.helper(test2*100, coins);
		System.out.println(result2);
	}
	
	private int helper(double target, int[] coins){
		//base case of recursion
		if(target == 0){
			return 0;
		}
		//initialize the result
		int result = Integer.MAX_VALUE;		
		for(int i=0; i<coins.length; i++){
			//one feasible condition
			if(coins[i] <= target){
				//recursion
				int temp = helper(target - coins[i], coins);
				if(temp + 1 < result && temp != Integer.MAX_VALUE){
					//update the minimum number of coins we need 
					result = temp +1;
				}
			}
		}
		return result;
	}
}