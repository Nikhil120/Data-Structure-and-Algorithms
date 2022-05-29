package recursion;

public class StringSubset {
	public static void printSubset(String str, String subset, int pos) {
		
		if (pos == str.length()) {
			System.out.println(subset);
			return;
		}
		
		printSubset(str, subset, pos+1);
		printSubset(str, subset + str.charAt(pos), pos+1);
	}
	
	public static void main(String args[]) {
		printSubset("ABC", "", 0);
	}
}
