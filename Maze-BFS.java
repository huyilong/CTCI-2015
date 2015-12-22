class Point {
	int row;
	int col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Maze {
	public static int solution(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		if (matrix[0][0] == 9) {
			return 1;
		}
		if (matrix[0][0] == 0) {
			return 0;
		}
		final int[] dx = { -1, 0, 0, 1 };
		final int[] dy = { 0, 1, -1, 0 };
		int m = matrix.length;
		int n = matrix[0].length;
		Queue q = new LinkedList();
		matrix[0][0] = -1;
		q.add(new Point(0, 0));
		while (!q.isEmpty()) {
			Point curPoint = q.poll();
			for (int i = 0; i < 4; i++) {
				int nextRow = curPoint.row + dx[i];
				int nextCol = curPoint.col + dy[i];
				if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
					if (matrix[nextRow][nextCol] == 9) {
						return 1;
					} else if (matrix[nextRow][nextCol] == 1) {
						q.add(new Point(nextRow, nextCol));
						matrix[nextRow][nextCol] = -1;
					}
				}
			}
		}
		return 0;
	}
}