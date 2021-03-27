package tree;

public class Node {
	int x;
	Node left;
	Node right;
	int height;
	
	public Node(int x) {
		this.x = x;
		this.height = 1;
	}
}