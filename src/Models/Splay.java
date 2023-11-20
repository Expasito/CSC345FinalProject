package Models;

import java.util.LinkedList;
import java.util.Random;

/**
 * Splay is a splay tree with appropriate methods. 
 * A splay tree is a version of a Binary Search Tree where recently searched nodes
 * are closer to the root of the tree.
 */
public class Splay implements SearchTree {
	
	private int accessCount = 0;
	
	Node root;
	
	public Splay() {
		root = null;
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
	 * searchNode 
	 */
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
				
				// now splay to move it to the top
				splay(base);
				return true;
			}
		}
		return false;
	}
	
	private void splay(Node n) {
		
		Node par = n.parent;
		
		// incase of the root being the searched value
		if(par == null) {
			return;
		}
		
		// right rotate parent
		if(par.left == n) {
			
			accessCount++;
			
			
			// swap n's right child
			n.parent.left = n.right;
			if(n.right != null) {
				n.right.parent = n.parent;
			}
			
			// swap parents
			Node par_ = par.parent;
			par.parent = n;
			n.parent = par_;
			
			// swap nodes
			Node r = n.right;
			n.right = par;
			par.left = r;
			
			// now update parent's children
			if(par_== null) {
				root = n;
				return;
			}
			if(par_.left == par) {
				par_.left = n;
			}else if(par_.right == par) {
				par_.right = n;
			}
			
			
			splay(n);
			
		}
		// left rotate parent
		else if(par.right == n) {
			
			accessCount++;
			
			// swap n's left child
			n.parent.right = n.left;
			if(n.left != null) {
				n.left.parent = n.parent;
			}
			
			// swap parents
			Node par_ = par.parent;
			par.parent = n;
			n.parent = par_;
			
			// swap nodes
			Node l = n.left;
			n.left = par;
			par.right = l;
			
			// now update parent's children
			if(par_==null) {
				root = n;
				return;
			}
			if(par_.left == par) {
				par_.left = n;
			}else if(par_.right == par) {
				par_.right = n;
			}
			
			
			splay(n);
			
			
			
			
		}

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
		System.out.println("");
	}
	
	private static void log(Node root) {
		if(root == null) {
			// do nothing
		}else {
			if(root.left != null) {
				log(root.left);
			}
			String par = root.parent==null? "null" : String.valueOf(root.parent.value);
			String left = root.left == null? "null" : String.valueOf(root.left.value);
			String right = root.right == null ? "null" : String.valueOf(root.right.value);
			System.out.print("V: " + root.value + ", " + "P: " + par + " L: " + left + " R: " + right + "   ");
			if(root.right != null) {
				log(root.right);
			}
		}
	}
	
	
	private int maxDist = 0;
	
	// returns the height of the tree from n
	private int getHeight(Node n) {
		maxDist = 0;
		getHeight(n,0);
		return maxDist;

	}
	
	private void getHeight(Node n, int dist) {
		if(n == null) {
			if(dist > maxDist) {
				maxDist = dist;
			}
		}else {
			getHeight(n.left,dist+1);
			getHeight(n.right, dist+1);
		}
	}
	
	static class Temp {
		int height;
		int index;
		int dx;
		Node n;
		
		public Temp(int height, int index, Node n, int dx) {
			this.height = height;
			this.index = index;
			this.n = n;
			this.dx = dx;
		}
		
		public String toString() {
			return "Temp(Height: " + height + " Index: " + index + " DX: " + dx + " Node: " + n + ")";
		}
		
	}
	
	private static void print(Splay s) {
		Node n = s.root;
		int height = s.getHeight(n);
		String[][] grid = new String[height][(int) (Math.pow(2, height)-1)];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				grid[i][j] = " ";
			}
		}
		
		LinkedList<Node> l = new LinkedList<>();
		l.addLast(n);
		
		LinkedList<Temp> list = new LinkedList<>();
		list.addLast(new Temp(0,grid[0].length/2, n, (grid[0].length+1)/2));	
		
		while(list.isEmpty() == false) {
			Temp t = list.removeFirst();
			if(t.n == null) {
				continue;
			}
			
			String par = t.n.parent==null? "null" : String.valueOf(t.n.parent.value);
			String left = t.n.left == null? "null" : String.valueOf(t.n.left.value);
			String right = t.n.right == null ? "null" : String.valueOf(t.n.right.value);
			String str = "V: " + t.n.value + ", " + "P: " + par + " L: " + left + " R: " + right + "   ";
			
//			System.out.println(t);
			grid[t.height][t.index] = String.valueOf(str);
			
			
			// now add the subnodes
			int dx = t.dx/2;
			list.addLast(new Temp(t.height+1, t.index-dx,t.n.left,dx));
			list.addLast(new Temp(t.height+1, t.index+dx,t.n.right,dx));
			
			
			
		}


		
		for(int i = 0; i<grid[0].length;i++) {
			System.out.print("==");
		}
		
		System.out.println("");
		
		// print the grid
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("");
		}
		
		for(int i = 0; i<grid[0].length;i++) {
			System.out.print("==");
		}
		
		System.out.println("");
		
		
	}
	

	
	public static void main(String[] args) {
		Splay s = new Splay();
		
		s.addNode(new Node(9));
		s.addNode(new Node(8));
		s.addNode(new Node(7));
//		s.addNode(new Node(6));
//		s.addNode(new Node(5));
//		s.addNode(new Node(4));
//		s.addNode(new Node(3));
//		s.addNode(new Node(2));
//		s.addNode(new Node(1));
//		s.addNode(new Node(0));

		
		s.searchNode(7);
//		print(s);
//		System.exit(1);
		
//		s.searchNode(9);
//		s.searchNode(0);
//		s.searchNode(9);
//		s.searchNode(6);
//		s.searchNode(9);
		
		
		Random r = new Random(4);

		
		
		int range = 1000;
		
		System.out.println("Testing rn");
		
		Splay splay = new Splay();
		for(int i=0;i<10000;i++) {
			splay.addNode(new Node(r.nextInt(range)));
			
			int guess = r.nextInt(range);
			
			boolean found = splay.searchNode(guess);
			if(found == true) {
				if(splay.root.value == guess) {
					System.out.println("Passed");
				}else {
					System.out.println("Failed");
					System.out.println("Searching for: " + guess);
					print(splay);
					System.exit(1);
				}
			}
		}
//		
//		System.out.println("Done testing");
		
		
		
	}

}
