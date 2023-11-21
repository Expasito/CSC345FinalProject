package Tests;

import java.util.LinkedList;

import Models.Node;
import Models.Splay;
import Models.BST;
import Models.SearchTree;

public class PrintTree {
	
	public static void main(String[] args) {
		SearchTree st1 = new Splay();
		SearchTree st2 = new BST();
	}
	

	// Implementation code is below here
	
	private static int maxDist = 0;
	
	/**
	 * getHeight gets the height of a tree based on a current node
	 * @param n The node to start at
	 * @return The height of the tree
	 */
	private static int getHeight(Node n) {
		
		// reset the maxDistance and call the recursive helper 
		maxDist = 0;
		getHeight(n,0);
		return maxDist;

	}
	
	/**
	 * getHeight is a helper method to find the height based on a node 
	 * @param n The node we are at
	 * @param dist The current distance
	 */
	private static void getHeight(Node n, int dist) {
		
		// if null, then we found the end so update the max distance
		if(n == null) {
			if(dist > maxDist) {
				maxDist = dist;
			}
		}else {
			// recursive call on each child 
			getHeight(n.left,dist+1);
			getHeight(n.right, dist+1);
		}
	}
	
	/**
	 * Temp is used to hold information about each node.
	 * Height is the height of the node in the tree
	 * index is which index the node should be added at in the string array
	 * dx is the displacement of the node from its parent in the string array
	 * 
	 * This class is used heavily to keep the formatting consistent when printing
	 * the tree out
	 */
	static class Temp {
		int height;
		int index;
		int dx;
		Node n;
		
		/**
		 * Basic constructor for the class
		 * @param height The height of the node in the tree
		 * @param index The index of the node in the string []
		 * @param n The node itself
		 * @param dx The displacement for the child nodes from the parent
		 */
		public Temp(int height, int index, Node n, int dx) {
			this.height = height;
			this.index = index;
			this.n = n;
			this.dx = dx;
		}
		
	}
	
	private static void print(Splay s) {
		
		// get the root of the tree and the height
		Node n = s.root;
		int height = getHeight(n);
		
		// create a string[] based on the height and the total number of nodes in the tree
		String[][] grid = new String[height][(int) (Math.pow(2, height)-1)];
		
		// fill the array with empty spaces
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				grid[i][j] = " ";
			}
		}
		
		// This linkedlist is soley used for keeping track of what nodes we still need to process
		LinkedList<Temp> list = new LinkedList<>();
		
		// add the root.
		// The important info is that its at level 0, its index is halfway in the array, and the dx is half the distance from the center
		// (this is where the child nodes should appear in the array)
		list.addLast(new Temp(0,grid[0].length/2, n, (grid[0].length+1)/2));	
		
		// keep going until we are out of nodes
		while(list.isEmpty() == false) {
			// remove the first node and make sure its not a null child
			Temp t = list.removeFirst();
			if(t.n == null) {
				continue;
			}
			
			// Detailed prints so we can get parent and child references and the current value
			String par = t.n.parent==null? "null" : String.valueOf(t.n.parent.value);
			String left = t.n.left == null? "null" : String.valueOf(t.n.left.value);
			String right = t.n.right == null ? "null" : String.valueOf(t.n.right.value);
			String str = "V: " + t.n.value + ", " + "P: " + par + " L: " + left + " R: " + right + "   ";
			
			// add the node to the grid in the right spot
			grid[t.height][t.index] = String.valueOf(str);
			
			
			// now add the sub nodes to the list
			// dx is half the old displacement
			int dx = t.dx/2;
			list.addLast(new Temp(t.height+1, t.index-dx,t.n.left,dx));
			list.addLast(new Temp(t.height+1, t.index+dx,t.n.right,dx));
			
			
			
		}


		// This is just nice printing formatting
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

}
