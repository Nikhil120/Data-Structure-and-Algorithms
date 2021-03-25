package backtracking;

public class NQueens {
	
	public static void printBoard(int[][] sol, int n) {
		for (int i=0; i<n; i++) {
			System.out.println("");
			for (int j=0; j<n; j++) {
				System.out.print(sol[i][j] + "  ");
			}
		}
	}

	public static boolean isSafe(int[][] board, int x, int y, int n) {
		// Check for queen in the left columns
		for (int i=0; i<y; i++) {
			if (board[x][i] == 1) {
				return false;
			}
		}
		
		// Check for queen in left top diagonal
		for (int i=x, j=y; i>=0 && j>=0; --i, --j) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		
		// Check for queen in left bottom diagonal
		for (int i=x, j=y; i<n && j>=0; ++i, --j) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean solveUtil(int[][] board, int c, int n) {
		
		if (c >= n) {
			return true;
		}
		
		for (int i=0; i<n; i++) {
			if (isSafe(board, i, c, n)) {
				board[i][c] = 1;
				
				if(solveUtil(board, c+1, n)) {
					return true;
				}
				board[i][c] = 0;
			}
		}
		
		
		return false;
	}
	
	public static void solve(int n) {
		int[][] board = new int[n][n];
		
		if (!solveUtil(board, 0, n)) {
			System.out.println("Solution not exists");
		}
		
		printBoard(board, n);
	}
	
	public static void main(String[] args) {
		solve(8);
	}
}
