package greedy;

public class ActivitySelection {
	
	public static void printMaxActivities(int[] s, int[] f, int n) {
		int i=0; 
		int j=0;
		
		System.out.print(i + " ");
		
		for (i=1; i<n; i++) {
			if (s[i] >= f[j]) {
				System.out.print(i + " ");
				j = i;
			}
		}
		
	}
	
	 public static void main(String[] args) {
	    int s[] =  {1, 3, 0, 5, 5, 8};
	    int f[] =  {2, 4, 6, 7, 9, 9};
	    int n = s.length;
	        
	    printMaxActivities(s, f, n);
	 }
}
