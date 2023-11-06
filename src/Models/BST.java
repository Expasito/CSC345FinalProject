package Models;

public class BST implements SearchTree {
	
	private int accessCount = 0;

	Node root;

	public BST() {
		root = null;
	}

	@Override
	public void addNode(Node node) {
		root = addNode(this.root, node);
	}

	private Node addNode(Node parent, Node node) {
		accessCount++;
		if (parent == null) {
			parent = node;
		}

		if (node.value < parent.value) {
			parent.left = addNode(parent.left, node);
		}

		if (node.value > parent.value) {
			parent.right = addNode(parent.right, node);
		}

		return parent;
	}

	@Override
	public boolean searchNode(int value) {
		return searchNode(this.root, value);
	}

	private boolean searchNode(Node root, int value) {
		accessCount ++;
		if (root == null)
			return false;
		if (value == root.value)
			return true;
		if (value < root.value)
			return searchNode(root.left, value);
		if (value > root.value)
			return searchNode(root.right, value);
		return false;
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
	}

}
