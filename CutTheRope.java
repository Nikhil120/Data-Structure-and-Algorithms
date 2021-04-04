
public class CutTheRope {
	
	
	public static int cut(int n, int a, int b, int c) {
		if (n == 0) {
			return 0;
		}
		if (n < 0) {
			return -1;
		}
		
		int max1 = cut(n-a, a, b, c);
		int max2 = cut(n-b, a, b, c);
		int max3 = cut(n-c, a, b, c);
		int max = Math.max(Math.max(max1, max2), max3);
		
		if (max == -1) {
			return -1;
		}
		
		return max + 1;
	}
	
	public static void main(String args[]) {
		System.out.println(cut(23, 11, 9, 12));
	}
}
