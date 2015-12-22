/*
There are a row of n houses, each house can be painted with one of the three colors: 
red, blue or green. The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on… 

Find the minimum cost to paint all houses.

Note: All costs are positive integers.

*/


/*
Dynamic Programming
subproblem: paint a single house, #subproblem = #house
guess: use one of 3 colors #choice = 3

relation: to paint house[i]
use different color from house[i-1]
use valid with minimum cost

dp[i][color] = cost[i][color] + min(dp[i-1][color1], dp[i-1][color2])
//there are three colors in total

topological order: row by row and left to right
solution: min(dp[end][color] for each color)
*/

public class Solution {
    public int minCost(int[][] costs) {
        if(costs==null || costs.length==0 || costs[0].length==0) {
            return 0;
        }
        int row = costs.length;
        int col = costs[0].length;
        int[][] dp = new int[row][col];

        //initialization
        for(int i=0; i<col; i++) {
            dp[0][i] = costs[0][i];
        }

        //the rows are different houses
        //the three colomn are three different colors
        //paint each house
        for(int i=1; i<row; i++) {
        	//dp[i][color] = cost[i][color] + min(dp[i-1][color1], dp[i-1][color2])
            //use different color with minium cost
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        //find the minimum of the three numbers
        //we are using nested min to find the min of three numbers
        return Math.min(Math.min(dp[row-1][0], dp[row-1][1]), dp[row-1][2]);
    }
}