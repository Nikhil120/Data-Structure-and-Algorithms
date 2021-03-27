package tree;

public class BinarySearchTree {
	Node root;
	
	private Node insertUtil(Node root, int x) {
		if (root == null) {
			root = new Node(x);
			return root;
		}
		
		if (x < root.x) {
			root.left = insertUtil(root.left, x);
		}
		else if (x > root.x) {
			root.right = insertUtil(root.right, x);
		}
		
		return root;
	}
	
	public void insert(int x) {
		root = insertUtil(root, x);
	}
	
	private void inOrderUtil(Node root) {
		if (root == null) {
			return;
		}
		
		inOrderUtil(root.left);
		System.out.print(root.x + " ");
		inOrderUtil(root.right);
	}
	
	public void inOrder() {
		System.out.println("\nInOrder");
		inOrderUtil(root);
	}
	
	private void preOrderUtil(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.x + " ");
		preOrderUtil(root.left);
		preOrderUtil(root.right);
	}
	
	public void preOrder() {
		System.out.println("\nPreOrder");
		preOrderUtil(root);
	}
	
	private void postOrderUtil(Node root) {
		if (root == null) {
			return;
		}

		postOrderUtil(root.left);
		postOrderUtil(root.right);
		System.out.print(root.x + " ");
	}
	
	public void postOrder() {
		System.out.println("\nPostOrder");
		postOrderUtil(root);
	}
	
	private boolean searchUtil(Node root, int x) {
		if (root == null) {
			return false;
		}
		
		if (root.x == x) {
			return true;
		}
		
		if (x < root.x) {
			return searchUtil(root.left, x);
		}
		else {
			return searchUtil(root.right, x);
		}
	}
	
	public boolean search(int x) {
		System.out.println("\nSearching: " + x);
		return searchUtil(root, x);
	}
	
	private int heightUtil(Node root) {
		if (root == null) {
			return 0;
		}
		
		int lh = heightUtil(root.left);
		int rh = heightUtil(root.right);
		
		return Math.max(lh, rh) + 1;
	}
	
	public int height() {
		System.out.println("\nHeight");
		return heightUtil(root);
	}
	
	private int minValue(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		
		return root.x;
	}
	
	private Node deleteUtil(Node root, int x) {
		if (root == null) {
			return root;
		}
		
		if (x < root.x) {
			root.left = deleteUtil(root.left, x);
		}
		else if (x > root.x) {
			root.right = deleteUtil(root.right, x);
		}
		else {
			if (root.left == null) {
				return root.right;
			}
			else if (root.right == null) {
				return root.right;
			}
			
			root.x = minValue(root.right);
			root.right = deleteUtil(root.right, root.x);
		}
		
		return root;
	}
	
	public void delete(int x) {
		deleteUtil(root, x);
	}
	
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(5);
		binarySearchTree.insert(2);
		binarySearchTree.insert(6);
		binarySearchTree.insert(1);
		binarySearchTree.insert(8);
		binarySearchTree.insert(0);
		binarySearchTree.insert(6);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		binarySearchTree.insert(11);
		binarySearchTree.insert(9);
		binarySearchTree.insert(3);
		binarySearchTree.insert(12);
		binarySearchTree.insert(10);
		
		binarySearchTree.inOrder();
		binarySearchTree.preOrder();
		binarySearchTree.postOrder();
		
		boolean b1 = binarySearchTree.search(6);
		System.out.println(b1);
		boolean b2 = binarySearchTree.search(3);
		System.out.println(b2);
		
		int height = binarySearchTree.height();
		System.out.println(height);
		
		binarySearchTree.delete(5);

		binarySearchTree.inOrder();
		binarySearchTree.preOrder();
		binarySearchTree.postOrder();
		
	}
}

