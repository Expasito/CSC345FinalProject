package Models;



public class Splay implements SearchTree {
	
	class Node {
		Node left;
		Node right;
		Node parent;
		int value;
		
		public Node(int value) {
			left = null;
			right = null;
			parent = null;
			this.value = value;
			
		}
	}
	
	Node root;
	
	public Splay() {
		root = null;
	}

	@Override
	public boolean addNode(int value) {
		Node node = new Node(value);
		if(root == null) {
			root = node;
		}else {
			// Something here
		}
		return false;
	}

	@Override
	public boolean searchNode(int value) {
		// TODO Auto-generated method stub
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
