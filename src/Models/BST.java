package Models;

public class BST implements SearchTree {

	Node root;

	public BST() {
		root = null;
	}

	@Override
	public void addNode(Node node) {
		root = addNode(this.root, node);
	}

	private Node addNode(Node parent, Node node) {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clearAcessCount() {
		// TODO Auto-generated method stub
		return 0;

	}

}
