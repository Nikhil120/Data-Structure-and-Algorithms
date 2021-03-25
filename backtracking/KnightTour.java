package backtracking;

public class KnightTour {
	
	public static void printSolution(int[][] sol, int n) {
		for (int i=0; i<n; i++) {
			System.out.println("");
			for (int j=0; j<n; j++) {
				System.out.print(sol[i][j] + "  ");
			}
		}
	}
	
	public static boolean isSafe(int x, int y, int n, int[][] sol) {
		return x>=0 && x<n && y>=0 && y<n && sol[x][y]==-1;
	}

	public static boolean solveUtil(int x, int y, int n, int move, int[][] sol, int[] moveX, int[] moveY) {
		
		if (move == n*n) {
			sol[x][y] = move;
			return true;
		}
		
		int nextX = 0;
		int nextY = 0;
		
		for (int i=0; i<n; i++) {
			nextX = x + moveX[i];
			nextY = y + moveY[i];
			
			if (isSafe(nextX, nextY, n, sol)) {
				sol[nextX][nextY] = move;
				if (solveUtil(nextX, nextY, n, move+1, sol, moveX, moveY)) {
					return true;
				}
				else {
					sol[nextX][nextY] = -1;
				}
			}
		}
		
		
		return false;
	}
	
	public static void solve() {
		int n = 8;
		int[][] sol = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				sol[i][j] = -1;
			}
		}
		
		int[] moveX = {1, 2, 2, 1, -1, -2, -2, -1};
		int[] moveY = {-2, -1, 1, 2, 2, 1, -1 ,-2};
		
		sol[0][0] = 0;
		
		if (!solveUtil(0, 0, n, 1, sol, moveX, moveY)) {
            System.out.println("Solution does not exist");
		}
		printSolution(sol, n);
	}
	
	public static void main(String[] args) {
		solve();
	}
}
