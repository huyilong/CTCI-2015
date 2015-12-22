//BFS的queue或者是DFS的stack都是需要空间的。。worst case是O(mn)吧
public class Maze {

  public static int[][] arr = new int[][] {
            {0,0,0,0,0,0,0,0,0},
            {5,5,5,0,0,0,0,0,0},
            {0,0,0,5,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,9},
    };

  private static class Point {
        int x;
        int y;
        Point parent;

        public Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }

        public Point getParent() {
            return this.parent;
        }

        public String toString() {
            return "x = " + x + " y = " + y;
        }
  }

  public static Queue<Point> q = new LinkedList<Point>();

    public static Point getPathBFS(int x, int y) {

        q.add(new Point(x,y, null));

        while(!q.isEmpty()) {
            Point p = q.remove();

            if (arr[p.x][p.y] == 9) {
                System.out.println("Exit is reached!");
                return p;
            }

            if(isFree(p.x+1,p.y)) {
                arr[p.x][p.y] = -1;
                Point nextP = new Point(p.x+1,p.y, p);
                q.add(nextP);
            }

            if(isFree(p.x-1,p.y)) {
                arr[p.x][p.y] = -1;
                Point nextP = new Point(p.x+1,p.y, p);
                q.add(nextP);
            }

            if(isFree(p.x,p.y+1)) {
                arr[p.x][p.y] = -1;
                Point nextP = new Point(p.x,p.y+1, p);
                q.add(nextP);
            }

             if(isFree(p.x,p.y-1)) {
                arr[p.x][p.y] = -1;
                Point nextP = new Point(p.x,p.y-1, p);
                q.add(nextP);
            }

        }
        return null;
    }


    public static boolean isFree(int x, int y) {
        if((x >= 0 && x < arr.length) && (y >= 0 && y < arr[x].length) && (arr[x][y] == 0 || arr[x][y] == 9)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Point p = getPathBFS(0,0);

         for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        while(p.getParent() != null) {
            System.out.println(p);
            p = p.getParent();
        }

    }

}