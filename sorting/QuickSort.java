package sorting;

public class QuickSort {
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int pos = low - 1;
		
		for (int i=low; i<=high; i++) {
			if (arr[i] < pivot) {
				++pos;
				swap(arr, i, pos);
			}
		}
		swap(arr, pos+1, high);
		return pos+1;
	}
	
	public void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = partition(arr, low, high);
			
			sort(arr, low, pivot-1);
			sort(arr, pivot+1, high);
		}
	}
	
	public void printArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {4,6,9,3,8,2,5,0,1,7};
		
		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr, 0, arr.length-1);
		quickSort.printArray(arr);
	}
}
