package greedy;

import java.util.ArrayList;
import java.util.Collections;

class Item implements Comparable<Item> {
	int weight;
	int value;
	Double fractionValue;
	
	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
		this.fractionValue = (double) value/weight;
	}

	@Override
	public int compareTo(Item o) {
		return o.fractionValue.compareTo(fractionValue);
	}
}

public class FractionalKnapsack {

	public static double findMaxValue(int[] weight, int[] value, int capacity) {
		int n = weight.length;
		double totalValue = 0d;
		ArrayList<Item> items = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			Item item = new Item(weight[i], value[i]);
			items.add(item);
		}
		
		Collections.sort(items);

		for (Item item : items) {
			int curr_wt = item.weight;
			int curr_val = item.value;
			
			if(capacity - curr_wt >= 0) {
				capacity = capacity - curr_wt;
				totalValue = totalValue + curr_val;
			}
			else {
				totalValue = totalValue + capacity * item.fractionValue;
				capacity = 0;
				break;
			}
		}
		
		return totalValue;
	}
	
	public static void main(String[] args) {
		int[] weight = { 10, 40, 20, 30 };
		int[] value = { 60, 40, 100, 120 };
		int capacity = 50;
		
		double maxValue = findMaxValue(weight, value, capacity);
		System.out.println("Maximum Value: " + maxValue);
	}
}
