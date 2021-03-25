package backtracking;

public class MColoring {
	
	public static boolean isSafe(int[][] graph, int v, int x, int c, int[] color) {
		
		for (int i=0; i<v; i++) {
			if (graph[x][i] == 1 && color[i] == c) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean solveUtil(int[][] graph, int v, int m, int x, int[] color) {
		if (x == v) {
			return true;
		}
		
		for (int i=1; i<=m; i++) {
			if (isSafe(graph, v, x, i, color)) {
				color[x] = i;
				if (solveUtil(graph, v, m, x+1, color)) {
					return true;
				}
				color[x] = 0;
			}
		}
		
		return false;
	}
	
	public static void solve(int[][] graph, int v, int m) {
		int color[] = new int[v];
		
		if (!solveUtil(graph, v, m, 0, color)) {
			System.out.println("Not Possible");
		}
		
		for (int i=0; i<v; i++) {
			System.out.println(color[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int m = 3; 
		int v = 4;
		int graph[][] = {
	            { 0, 1, 1, 1 },
	            { 1, 0, 1, 0 },
	            { 1, 1, 0, 1 },
	            { 1, 0, 1, 0 },
	            };
		
		solve(graph, v, m);
	}
}
