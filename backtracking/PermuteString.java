package backtracking;

public class PermuteString {
	
	private boolean issafe(char[] ch, int i, int l, int r) {
		// check if previous char is A and current char is B
		if (l != 0 && ch[l-1] == 'A' && ch[i] == 'B') {
			return false;
		}
		// check if last two char is BA and after swap it AB
		if (r == (l+1) && ch[i] == 'A' && ch[l] == 'B') {
			return false;
		}
		// check if last two char is AB and swap does not effect as i=l, 
		// so after swap, string is still AB
		if (r == (l+1) && l == i && ch[l] == 'A' && ch[r] == 'B') {
			return false;
		}
		
		return true;
	}
	
	public void swap(char[] ch, int i, int j) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
	
	public void display(char[] ch) {
		for (int i=0; i<ch.length; i++) {
			System.out.print(ch[i]);
		}
		System.out.println("");
	}
	
	public void permute(char[] ch, int l, int r) {
		if (l == r) {
			display(ch);
			return;
		}
		
		for (int i=l; i<=r; i++) {
			if (issafe(ch, i, l, r)) {
				swap(ch, i, l);
				permute(ch, l+1, r);
				swap(ch, i, l);
			}
		}
	}
	
	public static void main(String[] args) {
		PermuteString permuteString = new PermuteString();
		
		char[] ch = {'A', 'B', 'C', 'D'};
		
		permuteString.permute(ch, 0, ch.length-1);
	}
}
