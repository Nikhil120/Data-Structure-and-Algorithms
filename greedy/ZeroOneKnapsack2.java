package greedy;

public class ZeroOneKnapsack2 {
	
	public static int max(int a, int b) {
		return (a>b) ? a : b;
	}

	public static int findMaxValue(int[] weight, int[] value, int capacity, int n) {
		int k[][] = new int[n+1][capacity+1];
		
		for (int i=0; i<=n; i++) {
			for (int c=0; c<=capacity; c++) {
				if (i==0 || c==0) {
					k[i][c] = 0;
				}
				else if (c >= weight[i-1]) {
					k[i][c] = max(value[i-1] + k[i-1][c-weight[i-1]], k[i-1][c]);
				}
				else {
					k[i][c] = k[i-1][c];
				}
				
			}
		}
		
		return k[n][capacity];
	}
	
	
	public static void main(String[] args) {
		int[] weight = { 10, 20, 30 };
		int[] value = { 60, 100, 120 };
		int capacity = 50;
		int n = weight.length;
		
		double maxValue = findMaxValue(weight, value, capacity, n);
		System.out.println("Maximum Value: " + maxValue);
	}
}
