package backtracking;

public class RatInAMaze {
	
	public static void printSolution(int[][] sol, int n) {
		for (int i=0; i<n; i++) {
			System.out.println("");
			for (int j=0; j<n; j++) {
				System.out.print(sol[i][j] + "  ");
			}
		}
	}
	
	public static boolean isSafe(int[][] maze, int x, int y, int n) {
		return x>=0 && x<n && y>=0 && y<n && maze[x][y]==1;
	}
	
	public static boolean solveMazeUtil(int[][] maze, int x, int y, int n, int[][] sol) {
		
		if (x == n-1 && y == n-1 && maze[x][y] == 1) {
			sol[x][y] = 1;
			return true;
		}
		
		if (isSafe(maze, x, y, n)) {
			if (sol[x][y] == 1) {
				return false;
			}
			sol[x][y] = 1;
			
			if (solveMazeUtil(maze, x+1, y, n, sol)) {
				return true;
			}
			if (solveMazeUtil(maze, x, y+1, n, sol)) {
				return true;
			}
			if (solveMazeUtil(maze, x-1, y, n, sol)) {
				return true;
			}
			if (solveMazeUtil(maze, x, y-1, n, sol)) {
				return true;
			}
			
			sol[x][y] = 0;
			return false;
		}
		
		return false;
	}
	
	public static void solveMaze(int[][] maze, int n) {
		int[][] sol = new int[n][n];
		
		if (solveMazeUtil(maze, 0, 0, n, sol) == false) {
			System.out.println("Solution not exists");
		}
		
		printSolution(sol, n);
	}
	
	public static void main(String args[])
    {
        int maze[][] = { { 1, 0, 0, 0 },
                         { 1, 1, 0, 1 },
                         { 0, 1, 0, 0 },
                         { 1, 1, 1, 1 } };
 
        int n = maze.length;
        solveMaze(maze, n);
    }
}
