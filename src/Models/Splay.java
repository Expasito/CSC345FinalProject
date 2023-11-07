package Models;



public class Splay implements SearchTree {
	
	private int accessCount = 0;
	
	Node root;
	
	public Splay() {
		root = null;
	}

	@Override
	public void addNode(Node node) {
		root = addNode(root, node);
	}
	
	private Node addNode(Node root, Node node) {
		accessCount++;
		if(root == null) {
			root = node;
			return root;
		}else {
			if(root.value > node.value) {
				root.left = addNode(root.left,node);
				root.left.parent = root;
			}
			else if(root.value < node.value) {
				root.right = addNode(root.right, node);
				root.right.parent = root;
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
			accessCount++;
			if(base.value > value) {
				base = base.left;
			}
			else if(base.value < value) {
				base = base.right;
			}
			else if(base.value == value) {
				// add 1 to the number of times the node has been searched for
				base.visited++;
				splay();
				return true;
			}
		}
		return false;
	}
	
	private void splay() {
		
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
		Splay s = new Splay();
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
