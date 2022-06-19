package recursion;

public class PermuteString {
	
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
			swap(ch, i, l);
			permute(ch, l+1, r);
			swap(ch, i, l);
		}
	}

	public static void main(String[] args) {
		PermuteString permuteString = new PermuteString();
		
		char[] ch = {'A', 'B', 'C'};
		
		permuteString.permute(ch, 0, ch.length-1);
	}
}
