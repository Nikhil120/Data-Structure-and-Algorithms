package greedy;

public class ZeroOneKnapsack1 {
	
	public static int max(int a, int b) {
		return (a>b) ? a : b;
	}

	public static int findMaxValue(int[] weight, int[] value, int capacity, int n) {
		if (n==0 || capacity==0) {
			return 0;
		}
		
		if (weight[n-1] > capacity) {
			return findMaxValue(weight, value, capacity, n-1);
		}
		else {
			int value1 = value[n-1] + findMaxValue(weight, value, capacity-weight[n-1], n-1);
			int value2 = findMaxValue(weight, value, capacity, n-1);
			return max(value1, value2);
		}
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
