package Models;



public class Splay implements SearchTree {
	
	
	Node root;
	
	public Splay() {
		root = null;
	}

	@Override
	public boolean addNode(Node node) {
		root = addNode(root, node);
		return true;
	}
	
	private Node addNode(Node root, Node node) {
		if(root == null) {
			root = node;
			return root;
		}else {
			if(root.value > node.value) {
				root.left = addNode(root.left,node);
			}
			else if(root.value < node.value) {
				root.right = addNode(root.right, node);
			} else {
				// Nothing, duplicate value
			}
			return root;
			
		}
	}

	@Override
	public boolean searchNode(int value) {
		Node base = root;
		while(base != null) {
			if(base.value > value) {
				base = base.left;
			}
			if(base.value < value) {
				base = base.right;
			}
			if(base.value == value) {
				return true;
			}
		}
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
	
	public static void log(Node root) {
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
		Splay s = new Splay();
		s.addNode(new Node(1));
		s.addNode(new Node(2));
		s.addNode(new Node(3));
		s.addNode(new Node(0));
		s.addNode(new Node(-2));
		
		log(s.root);
		System.out.println("");
		
		System.out.println(s.searchNode(3));
//		System.out.println(s.root);
	}

}
