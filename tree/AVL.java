package tree;

public class AVL {
	Node root;
	
	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		
		return node.height;
	}
	
	private int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	private int getBalance(Node root) {
		if (root == null) {
			return 0;
		}
		
		return height(root.left) - height(root.right);
	}
	
	private Node leftRotate(Node x) {
		Node y = x.right;
		Node T3 = y.left;
		
		y.left = x;
		x.right = T3;
		
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		
		return y;
	}
	
	private Node rightRotate(Node x) {
		Node y = x.left;
		Node T3 = y.right;
		
		y.right = x;
		x.left = T3;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		
		return y;
	}
	
	public Node insertUtil(Node root, int x) {
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
		else {
			return root;
		}
		
		root.height = max(height(root.left), height(root.right)) + 1;
		int balance = getBalance(root);
		
		if (balance > 1 && x < root.left.x) {
			return rightRotate(root);
		}
		if (balance < -1 && x > root.right.x) {
			return leftRotate(root);
		}
		if (balance > 1 && x > root.left.x) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		if (balance < -1 && x < root.right.x) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		
		return root;
	}
	
	public void insert(int x) {
		this.root = insertUtil(this.root, x);
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
	
	public int getHeight() {
		return height(root);
	}
	
	private Node findMinValue(Node root) {
		Node current = root;
		
		while (current.left != null) {
			current = current.left;
		}
		return current;
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
				root = root.right;
			}
			else if (root.right == null) {
				root = root.right;
			}
			else {
				Node temp = findMinValue(root);
				root.x = temp.x;
				deleteUtil(root.right, temp.x);
			}
		}
		
		if (root == null) {
			return root;
		}
		
		root.height = max(height(root.left), height(root.right)) + 1;
		int balance = getBalance(root);
		
		if (balance > 1 && getBalance(root.left) >= 0) {
			return rightRotate(root);
		}
		if (balance < -1 && getBalance(root.right) <= 0) {
			return leftRotate(root);
		}
		if (balance > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		if (balance < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
	}
	
	public void delete(int x) {
		root = deleteUtil(root, x);
	}
	
	public int leftMost(Node node) {
		if (node == null) {
			return -1;
		}
		
		while (node.left != null) {
			node = node.left;
		}
		
		return node.x;
	}
	
	public int floorUtil(Node node, int x) {
		if (node == null) {
			return -1;
		}
		
		int result;
		
		if (x < node.x) {
			result = floorUtil(node.left, x);
		}
		else if (x > node.x) {
			result = floorUtil(node.right, x);
		}
		else {
			result = leftMost(node.right);
		}
		
		return Math.max(node.x, result);
	}
	
	public int floor(int x) {
		int result = floorUtil(this.root, x);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		AVL avl = new AVL();
		
		avl.insert(3);
		avl.insert(4);
		avl.insert(1);
		avl.insert(7);
		avl.insert(5);
		avl.insert(9);
		avl.insert(0);
		avl.insert(6);
		avl.insert(2);
		avl.insert(6);
		avl.insert(8);
		
		avl.inOrder();
		avl.preOrder();
		
		int height = avl.getHeight();
		System.out.println("\nHeight : " + height);
		
		avl.delete(4);
		avl.inOrder();
		avl.preOrder();
		
		height = avl.getHeight();
		System.out.println("\nHeight : " + height);
	}
}
