package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinHeap {
	private final int maxSize;
	private int size;
	private int[] arr;
	
	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		arr = new int[maxSize];
	}
	
	private int leftChild(int pos) {
		return (2 * pos + 1);
	}
	
	private int rightChild(int pos) {
		return (2 * pos + 2);
	}
	
	private int parent(int pos) {
		return ((pos-1)/2);
	}
	
	public void heapify(int pos) {
		
		int min = pos;
		
		if (leftChild(pos) < size && arr[leftChild(pos)] < arr[min]) {
			min = leftChild(pos);
		}
		
		if (rightChild(pos) < size && arr[rightChild(pos)] < arr[min]) {
			min = rightChild(pos);
		}
		
		if (min != pos) {
			swap(pos, min);
			heapify(min);
		}
	}
	
	private void swap(int pos1, int pos2) {
		int temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	
	public void insert(int x) {
		if (size == maxSize) {
			System.out.println("Overflow");
			return;
		}
		
		arr[size++] = x;
		int currPos = size-1;
		
		while (parent(currPos) >= 0 && arr[currPos] < arr[parent(currPos)]) {
			swap(currPos, parent(currPos));
			currPos = parent(currPos);
		}
	}
	
	public int getMin() {
		if (size == 0) {
			System.out.println("Underflow");
			return Integer.MAX_VALUE;
		}
		
		int popped = arr[0];
		arr[0] = arr[--size];
		heapify(0);
		return popped;
	}
	
	public void delete(int x) {
		if (size == 0) {
			System.out.println("Underflow");
			return;
		}
		
		
	}

	public void display() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		
		while (!queue.isEmpty()) {
			int pos = queue.poll();
			int leftChildPos = leftChild(pos);
			int rightChildPos = rightChild(pos);
			
			if (leftChildPos < this.size) {
				queue.add(leftChildPos);
			}
			
			if (rightChildPos < this.size) {
				queue.add(rightChildPos);
			}
			System.out.print(arr[pos] + ", ");
		}
	}
	
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(9);
		
		minHeap.insert(4);
		minHeap.insert(7);
		minHeap.insert(9);
		minHeap.insert(1);
		minHeap.insert(0);
		minHeap.insert(3);
		minHeap.insert(2);
		minHeap.insert(8);
		minHeap.insert(6);
		
		minHeap.display();
		
		int min = minHeap.getMin();
		System.out.println("\nMin : " + min);
		
		minHeap.display();
	}
}
