package tree;

public class MaxHeap {
	private int size;
	private final int maxSize;
	private int[] heap;
	
	public MaxHeap(int maxSize) {
		this.size = 0;
		this.maxSize = maxSize;
		this.heap = new int[maxSize];
	}
	
	private int parent(int pos) {
		return (pos - 1) / 2;
	}
	
	private int leftChild(int pos) {
		return (2 * pos) + 1;
	}
	
	private int rightChild(int pos) {
		return (2 * pos) + 2;
	}
	
	private void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	public void insert(int x) {
		if (size >= maxSize) {
			System.out.println("Overflow");
			return;
		}
		
		heap[size] = x;
		int current = size;
		++size;
		while (parent(current) >=0 && heap[current] > heap[parent(current)] ) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	private void heapify(int pos) {
		int max = pos;
		
		if (heap[leftChild(pos)] > heap[max]) {
			max = leftChild(pos);
		}
		if (heap[rightChild(pos)] > heap[max]) {
			max = rightChild(pos);
		}
		
		if (max != pos) {
			swap(max, pos);
			heapify(max);
		}
	}
	
	public int getMax() {
		if (size <= 0) {
			System.out.println("Underflow");
		}
		
		int popped = heap[0];
		heap[0] = heap[--size];
		heapify(0);
		return popped;
	}
	
	public void display() {
		for (int i=0; i<size; i++) {
			System.out.print(heap[i] + "  ");
		}
	}
	
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap(9);
		
		maxHeap.insert(5);
		maxHeap.insert(8);
		maxHeap.insert(1);
		maxHeap.insert(9);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(6);
		maxHeap.insert(2);
		maxHeap.insert(17);
		maxHeap.insert(9);
		maxHeap.insert(5);
		maxHeap.insert(3);
		
		maxHeap.display();
		
		System.out.println("\n" + maxHeap.getMax());

		maxHeap.display();
		
	}
}
