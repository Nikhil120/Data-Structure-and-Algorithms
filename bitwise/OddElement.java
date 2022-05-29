package bitwise;

public class OddElement {
	public void printOdd(int[] arr) {
		int xor1 = 0;
		
		for (int i=0; i<arr.length; i++) {
			xor1 = xor1 ^ arr[i];
		}
		
		int xor2 = (~xor1) + 1;
		
		int setbits = xor1 & xor2;
		
		int x = 0;
		int y = 0;
		
		for (int i=0; i<arr.length; i++) {
			if ((arr[i] & setbits) == 0) {
				x = x ^ arr[i];
			}
			else {
				y = y ^ arr[i];
			}
		}
		
		System.out.println(x + ", " + y);
	}
	
	public static void main(String[] args) {
		OddElement oddElement = new OddElement();
		int[] arr = {1,3,5,6,8,0,2,1,5,3,6,8,5};
		oddElement.printOdd(arr);
	}
}
