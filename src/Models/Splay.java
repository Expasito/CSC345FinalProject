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
	public void addNode() {
		// TODO Auto-generated method stub
		
	}

}
