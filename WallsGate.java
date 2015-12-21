/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room. We use the value 
231 - 1 = 2147483647 to represent INF as you may assume that the distance to a 
gate is less than 2147483647. Fill each empty room with the distance to its nearest gate. 
If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid: INF -1 0 INF INF INF INF -1 INF -1 INF -1 0 -1 INF INF After running your function, 
the 2D grid should be: 3 -1 0 1 2 2 1 -1 1 -1 2 -1 0 -1 3 4

*/

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0 || rooms[0].length==0) {
            return;
        }

        int row = rooms.length;
        int col = rooms[0].length;

        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                //start from gate
                if(rooms[i][j] == 0) {
                    visit(rooms, i, j, 0, visited);
                }
            }
        }
    }


    public void visit(int[][] rooms, int i, int j, int distance, boolean[][] visited) {
        int row = rooms.length;
        int col = rooms[0].length;

        //invalid position
        if(i<0 || j<0 || i>=row || j>=col) {
            return;
        }
        //visited room
        if(visited[i][j]) {
            return;
        }
        //obstacle
        if(rooms[i][j] == -1) {
            return;
        }
        //larger distance to get here
        if(distance > rooms[i][j]) {
            return;
        }

        visited[i][j] = true;
        if(distance < rooms[i][j]) {
            rooms[i][j] = distance;
        }

        //visit neighbors
        visit(rooms, i-1, j, distance+1, visited);
        visit(rooms, i+1, j, distance+1, visited);
        visit(rooms, i, j-1, distance+1, visited);
        visit(rooms, i, j+1, distance+1, visited);


        //backtraking after each turn we need to refresh
        //the state and then for next turn it could visit here again
        visited[i][j] = false;
    }
}