package tree;

class TNode {
	int data;
	TNode left;
	TNode right;
	boolean isRightNode;
	
	public TNode(int x) {
		this.data = x;
		this.left = null;
		this.right = null;
		this.isRightNode= false; 
	}
}

public class ThreadedBinaryTree {
	TNode root;
	
	public TNode insertUtil(TNode parent, TNode node, int x) {
		if (node == null) {
			node = new TNode(x);
			node.right = parent;
//			if (parent != null) {
//				node.isRightNode = true;	
//			}
			node.isRightNode = true;
			return node;
		}
		
		if (x < node.data) {
			node.left = insertUtil(node, node.left, x);
		}
		else if (x > node.data) {
			if (node.isRightNode) {
				TNode ptr = node.right;
				node.right = null;
				node.isRightNode = false;
				node.right = insertUtil(parent, node.right, x);
				node.right.right = ptr;
			}
			else {
				node.right = insertUtil(parent, node.right, x);
			}
		}
			
		return node;
	}
	
	
	
//	public TNode insertUtil(TNode node, int x) {
//		if (node == null) {
//			node = new TNode(x);
//			return node;
//		}
//		
//		if (x < node.data) {
//			node.left = insertUtil(node.left, x);
//		}
//		else if (x > node.data) {
//			node.right = insertUtil(node.right, x);
//		}
//			
//		return node;
//	}
	
	public void insert(int x) {
		this.root = insertUtil(null, this.root, x);
	}
	
	public TNode leftMost(TNode node) {
		if (node == null) {
			return null;
		}
		
		while (node.left != null) {
			node = node.left;
		}
		
		return node;
	}
	
	public void inOrderUtil(TNode node) {
		TNode ptr = leftMost(node);
		
		while (ptr != null) {
			System.out.println(ptr.data);
			
			if (ptr.isRightNode) {
				ptr = ptr.right;
			}
			else {
				ptr = leftMost(ptr.right);
			}
		}
	}
	
//	public void inOrderUtil(TNode node) {
//		if (node == null) {
//			return;
//		}
//		
//		inOrderUtil(node.left);
//		System.out.println(node.data);
//		inOrderUtil(node.right);
//	}
	
	public void inOrder() {
		inOrderUtil(root);
	}
	
	public static void main(String[] args) {
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		threadedBinaryTree.insert(10);
		threadedBinaryTree.insert(5);
		threadedBinaryTree.insert(15);
		threadedBinaryTree.insert(12);
		threadedBinaryTree.insert(30);
		threadedBinaryTree.insert(3);
		threadedBinaryTree.insert(6);
		
		threadedBinaryTree.inOrder();
	}
	
}
