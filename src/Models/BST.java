package Models;



public class BST implements SearchTree {
	
	class Node {
		Node left;
		Node right;
		int value;
		public Node(int value) {
			left = null;
			right = null;
			this.value = value;
		}
		
	}

	Node root;
	
	public BST() {
		root = null;
	}

	@Override
	public void addNode() {
		// TODO Auto-generated method stub
		
	}
}
