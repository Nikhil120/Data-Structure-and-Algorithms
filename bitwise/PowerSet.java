package bitwise;

public class PowerSet {
	
	public void printPowerSet(String str) {
		int n = str.length();
		int count = 1 << n;
		
		for (int i=0; i<count; i++) {
			for (int j=0; j<n; j++) {
				if ((i & (1<<j)) > 0) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		PowerSet powerSet = new PowerSet();
		powerSet.printPowerSet("ABC");
	}
}
