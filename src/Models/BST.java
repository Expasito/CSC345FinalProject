package Models;

public class BST implements SearchTree {
	Node root;
	
	private int accessCount = 0;

	public BST() {
		root = null;
	}

	public void addNode(Node n) {
		root = addNodeRecursive(root, n.value);
	}

	private Node addNodeRecursive(Node current, int value) {
		accessCount++;
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addNodeRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addNodeRecursive(current.right, value);
		}

		return current;
	}

	public boolean searchNode(int value) {
		return searchNodeRecursive(root, value) != null;
	}

	private Node searchNodeRecursive(Node current, int value) {
		accessCount++;
		if (current == null)
			return null;

		if (current.value == value) {
			return current;
		}

		if (value < current.value) {
			return searchNodeRecursive(current.left, value);
		}

		return searchNodeRecursive(current.right, value);
	}

	@Override
	public int getAcessCount() {
		return accessCount;
	}

	@Override
	public int clearAcessCount() {
		int temp = accessCount;
		accessCount = 0;
		return temp;

	}
	
	public void log() {
		System.out.println("Access Count: " + accessCount);
		log(root);
	}
	
	private static void log(Node root) {
		if(root == null) {
			// do nothing
		}else {
			if(root.left != null) {
				log(root.left);
			}
			System.out.print(root.value + ", ");
			if(root.right != null) {
				log(root.right);
			}
		}
	}
	
	public static void main(String[] args) {
		BST s = new BST();
		s.addNode(new Node(1));
		s.addNode(new Node(2));
		s.addNode(new Node(3));
		s.addNode(new Node(0));
		s.addNode(new Node(-2));
		
		s.log();
		System.out.println("");
		
		System.out.println(s.searchNode(3));
//		System.out.println(s.root);
	}

}
