package Models;

/**
 * Splay is a splay tree with appropriate methods. 
 * A splay tree is a version of a Binary Search Tree where recently searched nodes
 * are closer to the root of the tree.
 */
public class Splay implements SearchTree {
	
	// keep track of the access count of the tree
	private int accessCount = 0;
	
	// The Node reference for the tree
	public Node root;
	
	/**
	 * default constructor with no root
	 */
	public Splay() {
		root = null;
	}
	
	/**
	 * construct with root value provided
	 * @param n The root of the tree
	 */
	public Splay(Node n) {
		root = n;
	}

	/**
	 * addNode adds a node to the tree 
	 * @param Node node the node object to add
	 */
	@Override
	public void addNode(Node node) {
		root = addNode(root, node);
	}
	
	/**
	 * addNode is a helper method which recursivly traverses the tree to add
	 * a node
	 * @param root The current root of the tree, which can be a subtree
	 * @param node The node to add
	 * @return The node object that has been updated
	 */
	private Node addNode(Node root, Node node) {
		
		// increment the access count
		accessCount++;
		
		// if the root is null, set the root to null and then return it for the parent to be reassigned.
		if(root == null) {
			root = node;
			return root;
		}
		else {
			// traverse left
			if(root.value > node.value) {
				root.left = addNode(root.left,node);
				root.left.parent = root;
			}
			// traverse right
			else if(root.value < node.value) {
				root.right = addNode(root.right, node);
				root.right.parent = root;
			} 
			// equal so a duplicate so we ignore
			else {
				// Nothing, duplicate value
			}
			return root;
			
		}
	}

	/**
	 * searchNode searches for a value in the tree
	 * @param int value the value to search for
	 * @return if the value was in the tree or not
	 * 
	 * searchNode will call splay() if the node is found
	 */
	@Override
	public boolean searchNode(int value) {
		Node base = root;
		while(base != null) {
			// increase accessCount for each iteration
			accessCount++;
			
			// traverse left
			if(base.value > value) {
				base = base.left;
			}
			// traverse right
			else if(base.value < value) {
				base = base.right;
			}
			// we found it so splay and return true
			else if(base.value == value) {
				
				// now splay to move it to the top
				splay(base);
				return true;
			}
		}
		
		// end of tree so not found
		return false;
	}
	
	
	/**
	 * splay moves Node 'n' up the tree to the root by using left and right rotations
	 * @param n The node to move up the tree
	 */
	private void splay(Node n) {
		
		// get the parent node
		Node par = n.parent;
		
		// incase of the root being the searched value or we are at the root
		if(par == null) {
			return;
		}
		
		// right rotate parent
		if(par.left == n) {
			// we are moving up a level so increased cost
			accessCount++;
			
			
			// swap n's right child
			n.parent.left = n.right;
			if(n.right != null) {
				n.right.parent = n.parent;
			}
			
			// swap parents of n and n's parent references
			Node par_ = par.parent;
			par.parent = n;
			n.parent = par_;
			
			// swap nodes of n and the parent
			Node r = n.right;
			n.right = par;
			par.left = r;
			
			// now update the root value if null
			if(par_== null) {
				root = n;
				return;
			}
			
			// now update the parent's children
			if(par_.left == par) {
				par_.left = n;
			}else if(par_.right == par) {
				par_.right = n;
			}
			
			// recurse on the node with its new position
			splay(n);
			
		}
		// left rotate parent
		else if(par.right == n) {
			
			// increased cost
			accessCount++;
			
			// swap n's left child
			n.parent.right = n.left;
			if(n.left != null) {
				n.left.parent = n.parent;
			}
			
			// swap n and n's parent's parent references
			Node par_ = par.parent;
			par.parent = n;
			n.parent = par_;
			
			// swap nodes of n and n's parent
			Node l = n.left;
			n.left = par;
			par.right = l;
			
			// now update the root if parent is null
			if(par_==null) {
				root = n;
				return;
			}
			
			// update the parent's children
			if(par_.left == par) {
				par_.left = n;
			}else if(par_.right == par) {
				par_.right = n;
			}
			
			// and recurse on the node with its new position
			splay(n);
			
		}

	}
	
	/**
	 * getAcessCount returns the current access count of the tree
	 * @return the current access count
	 */
	@Override
	public int getAcessCount() {
		return accessCount;
	}

	/**
	 * clearAcessCount returns the current access count and sets it to 0
	 * @return the current acess count before clearning
	 */
	@Override
	public int clearAcessCount() {
		int temp = accessCount;
		accessCount = 0;
		return temp;
	}

}
