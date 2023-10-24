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
	public boolean addNode(int value) {
		// TODO Auto-generated method stub
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
