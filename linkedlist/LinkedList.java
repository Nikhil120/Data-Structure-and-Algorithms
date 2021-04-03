package linkedlist;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	Node head;
	
	public Node insertUtil(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}
		
		node.next = insertUtil(node.next, data);
		
		return node;
	}
	
	public void insert(int data) {
		head = insertUtil(head, data);
	}
	
	public Node reverseUtil(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		
		Node rest = reverseUtil(node.next);
		node.next.next = node;
		node.next = null;
		
		return rest;
	}
	
	public void reverse() {
		head = reverseUtil(head);
	}
	
	public void display() {
		Node node = head;
		System.out.println("");
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
	}
	
	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(0);
		linkedList.insert(8);
		linkedList.insert(2);
		linkedList.insert(9);
		linkedList.insert(2);
		linkedList.insert(9);
		
		linkedList.display();
		
		linkedList.reverse();
		
		linkedList.display();
	}
}
