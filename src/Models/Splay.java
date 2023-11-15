package Models;

import java.util.LinkedList;

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
	
	private static Node leftRotate(Node n) {
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		
		Node par = n.parent;
		n.parent = x;
		x.parent = par;
		return x;
	}
	
	private static Node rightRotate(Node n) {
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		
		Node par = n.parent;
		n.parent = x;
		x.parent = par;
		return x;
	}
	
//	// Right rotation
//	private static Node zig(Node n) {
//		Node x = n.left;
//		n.left=x.right;
//	}

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
	
	
	private static void print(Node root, int height) {
		
		int maxHeight = height;
		LinkedList<Node> l = new LinkedList<>();
		l.add(root);
		int counter = 0;
		int curHeight = 0;
		String spacing = "";
		for(int i = 0;i<1;i++) {
			spacing += "     ";
		}
		// now add whitespace according to the height
		System.out.print(spacing);
		height--;
		int middle = 0;
		while(height != 0) {
			Node n = l.removeFirst();
			
			
//			if(counter == Math.pow(2, curHeight-1)) {
//				System.out.print(spacing);
//				middle++;
//			}
//			if(counter == Math.pow(2, curHeight-2)) {
//				System.out.print(spacing);
//				middle++;
//			}
//			if(counter == Math.pow(2, curHeight-3)) {
//				System.out.print(spacing);
//				middle++;
//			}
			
//			for(int i = 2;i<height;i+=2) {
//				if(middle % i == 0) {
//					System.out.print("     ");
//				}
//			}
			
//			if(middle %2 == 0) {
//				System.out.print(spacing);
//
//			}
//			if(middle % 4 == 0) {
//				System.out.print(spacing);
//			}

			middle++;
			
			counter++;
			if(n == null) {
				System.out.print("_");
				l.addLast(null);
				l.addLast(null);
			}else {
				System.out.print("" + n.value+ "");

				// add children
				l.addLast(n.left);
				l.addLast(n.right);
			}
			
			System.out.print(spacing);
			
			
			// end of nodes so go down a level
			if(Math.pow(2, curHeight) == counter) {
				curHeight++;
				System.out.println("");
				counter = 0;
				middle=0;
//				spacing = spacing.substring(0,spacing.length()/2);
				
				// now add whitespace according to the height
				System.out.print(spacing);
//				System.out.print(" ");
				height--;
			}
			
		}
		
		System.out.println("\n");
	}
	
	private static void print2(Node n) {
		String[][] grid = new String[3][7];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
//				grid[i][j] = String.valueOf(i) + " " + String.valueOf(j);
				grid[i][j] = "";
			}
		}
		
		LinkedList<Node> l = new LinkedList<>();
		l.addLast(n);
		
		int curLevel = 0;
		
		grid[0][grid[0].length/2] = "HH";
		grid[1][grid[0].length/2 -2] = "AA";
		grid[1][grid[0].length/2 + 2] = "BB";
		
		
		
		// print the grid
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				System.out.print(grid[i][j] + ", ");
			}
			System.out.println("");
		}
		
		
	}
	
	private static double lb2(int x) {
		return (int) (Math.log(x) / Math.log(2));
	}
	
	public static void main(String[] args) {
		Splay s = new Splay();
		
		s.addNode(new Node(6));
		s.addNode(new Node(7));
		s.addNode(new Node(4));
		s.addNode(new Node(3));
		s.addNode(new Node(5));
//		s.addNode(new Node(4));
//		s.addNode(new Node(2));
//		s.addNode(new Node(1));
//		s.addNode(new Node(3));
//		s.addNode(new Node(8));
//		s.addNode(new Node(7));
//		s.addNode(new Node(9));
//		s.addNode(new Node(0));
////		s.addNode(new Node(10));
//		s.addNode(new Node(6));
//		s.addNode(2);
		
//		s.addNode(new Node(1));
//		s.addNode(new Node(2));
//		s.addNode(new Node(3));
//		s.addNode(new Node(0));
//		s.addNode(new Node(-2));
		
//		s.log();
//		System.out.println("");
		
//		print(s.root, 5);
		
		s.root.left = rightRotate(s.root.left);
		
		s.root = rightRotate(s.root);
		
//		print(s.root,5);
		
		print2(s.root);
		
//		System.out.println(s.searchNode(3));
	}

}
