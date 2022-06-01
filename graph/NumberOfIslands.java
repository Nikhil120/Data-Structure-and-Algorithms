package graph;

public class NumberOfIslands {
	
	private boolean isSafe(int[][] mat, int i, int j) {
		if (i>=0 && j>=0 && i<mat.length && j<mat[0].length && mat[i][j]==1) {
			return true;
		}
		
		
		return false;
	}
	
	public void DFS(int[][] mat, int i, int j, boolean[][] visited) {
		if (visited[i][j]) {
			return;
		}
		
		visited[i][j] = true;
		
		int[] x = {0, 0, -1, -1, -1, 1, 1, 1};
		int[] y = {-1, 1, -1, 0, 1, -1, 0, 1};
		
		for (int k=0; k<8; k++) {
			if (isSafe(mat, i + x[k], j + y[k])) {
				DFS(mat, i+x[k], j+y[k], visited);
			}
		}
		
		
	}
	
	public int countIslands(int mat[][]) {
		int m = mat.length;
		int n = mat[0].length;
		
		boolean[][] visited = new boolean[m][n];
		int count = 0;
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (mat[i][j] == 1 && !visited[i][j]) {
					DFS(mat, i, j, visited);
					++count;
				}
			}
		}
		
		return count;
	}
	
	public void DFS1(int[][] mat, int i, int j, int m, int n) {
		if (isSafe(mat, i, j)) {
			mat[i][j] = 0;
			
			DFS1(mat, i-1, j+1, m, n);
			DFS1(mat, i-1, j, m, n);
			DFS1(mat, i-1, j-1, m, n);
			DFS1(mat, i, j-1, m, n);
			DFS1(mat, i, j+1, m, n);
			DFS1(mat, i+1, j+1, m, n);
			DFS1(mat, i+1, j, m, n);
			DFS1(mat, i+1, j-1, m, n);
		}
	}
	
	public int countIslands1(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		
		int count = 0;
		
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (mat[i][j] == 1) {
					mat[i][j] = 0;
					++count;
					
					DFS1(mat, i-1, j+1, m, n);
					DFS1(mat, i-1, j, m, n);
					DFS1(mat, i-1, j-1, m, n);
					DFS1(mat, i, j-1, m, n);
					DFS1(mat, i, j+1, m, n);
					DFS1(mat, i+1, j+1, m, n);
					DFS1(mat, i+1, j, m, n);
					DFS1(mat, i+1, j-1, m, n);
					
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		NumberOfIslands numberOfIslands = new NumberOfIslands();
		int[][] mat = { { 1, 1, 0, 0, 0 },
		                { 0, 1, 0, 0, 1 },
		                { 1, 0, 0, 1, 1 },
		                { 0, 0, 0, 0, 0 },
		                { 1, 0, 1, 0, 1 } };
		
		System.out.println(numberOfIslands.countIslands(mat));
		System.out.println(numberOfIslands.countIslands1(mat));
	}

}
