package Models;



public class Splay implements SearchTree {
	
	
	Node root;
	
	public Splay() {
		root = null;
	}

	@Override
	public boolean addNode(Node node) {
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
