package Models;

public class BST implements SearchTree {
	Node root;

	public BST() {
		root = null;
	}

	public boolean addNode(Node n) {
		root = addNodeRecursive(root, n.value);
		return true;
	}

	private Node addNodeRecursive(Node current, int value) {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clearAcessCount() {
		// TODO Auto-generated method stub
		return 0;

	}

}
