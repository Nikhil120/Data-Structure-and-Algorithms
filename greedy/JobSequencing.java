package greedy;

import java.util.ArrayList;
import java.util.Collections;

class Job implements Comparable<Job> {
	char id;
	int deadline;
	Integer  profit;
	
	public Job(char id, int deadline, int profit) {
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	@Override
	public int compareTo(Job o) {
		return o.profit.compareTo(profit);
	}
}

public class JobSequencing {
	public static void printJobScheduling(ArrayList<Job> arr, int t) {
		Collections.sort(arr);
		int n = arr.size();
		boolean[] slot = new boolean[t];
		char[] jobs = new char[t];
		
		for (int i=0; i<n; i++) {
			for(int j=Math.min(t-1, arr.get(i).deadline-1); j>=0; j--) {
				if (slot[j] == false) {
					slot[j] = true;
					jobs[j] = arr.get(i).id;
					break;
				}
			}
		}
		
		for (char job : jobs) {
			System.out.print(job + " ");
		}
	}

	public static void main(String[] args) {
		ArrayList<Job> arr = new ArrayList<Job>(); 
		  
        arr.add(new Job('a', 2, 100)); 
        arr.add(new Job('b', 1, 19)); 
        arr.add(new Job('c', 2, 27)); 
        arr.add(new Job('d', 1, 25)); 
        arr.add(new Job('e', 3, 15)); 
        
        // Function call 
        System.out.println("Following is maximum "
                           + "profit sequence of jobs"); 
  
        // Calling function 
        printJobScheduling(arr, 3); 
	}
}
