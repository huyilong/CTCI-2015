public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int found_so_far){
        if(found_so_far == word.length()){
            return true;
        }
        
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1){
            return false;
        }
        if(board[i][j] != word.charAt(found_so_far)){
             return false;
         }
        
        
        // if(board[i][j] == word.charAt(found_so_far)){
        //     return true;
        // }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean res = dfs(board, word, i+1, j, found_so_far+1) || dfs(board, word, i-1, j, found_so_far+1) || dfs(board, word, i, j+1, found_so_far+1) ||dfs(board, word, i, j-1, found_so_far+1);
        board[i][j] = temp;
        
        return res;
        
    }
        
        
}
        
        
        
        
 private static boolean bfs(int[][] maze, int startx, int starty) {
            // TODO Auto-generated method stub
            if(maze == null)
                  return false;
            if(maze.length == 0 || maze[0].length == 0)
                  return false;
            LinkedList<Node>queue = new LinkedList<Node>();
            int[][] Direction = {{-1,0}, {0, -1}, {1, 0}, {0, 1}}; //方向：左上右下     
            Noden1 = new Node(0, 0, maze[0][0]);
            queue.offer(n1);
      
            int M = maze.length;
            int N = maze[0].length;
            
            while (!queue.isEmpty()) {
                  Nodenode = queue.poll();
                  if (node.val == 9) {
                        return true;
                  }
                  for(int i = 0; i < 4; i++){
                        int x = node.x + Direction[i][0];
                        int y = node.y + Direction[i][1];
                        //bfs
                        if(x >= 0 && x < M && y >= 0 && y < N && maze[x][y] > 0){
                              NodenewNode = new Node(x, y, maze[x][y]);
                              queue.offer(newNode);
                              maze[x][y] = -1;
                        }
                  }
            }
            return false;
      }
              
        
        
        
        
        
        
        
        