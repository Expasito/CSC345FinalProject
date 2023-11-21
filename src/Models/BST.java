/**
 * filename: BST.java
 * 
 * implements a binary search tree with an accessCount in order to test and compare efficiency against splay trees
 * there are no duplicates and there is no deletion
 * 
 * course:	CSC 345
 * project:	Team Project
 * date:	11/20/2023
 */

package Models;

public class BST implements SearchTree {
	// root node of the tree
	Node root;

	// counts how many times the nodes of the tree have been accessed
	private int accessCount = 0;

	// constructor
	public BST() {
		root = null;
	}

	// constructor
	public BST(Node node) {
		root = node;
	}

	/**
	 * Adds node n to the tree
	 * 
	 * @param n n is the node we are adding
	 * @return void
	 */
	public void addNode(Node n) {
		root = addNodeRecursive(root, n.value);
	}

	/**
	 * Helper function for adding a node
	 * 
	 * @param current is the current node that we are on
	 * @param value   is the value of the original node we are adding
	 * @return returns current node in order to recurse
	 */
	private Node addNodeRecursive(Node current, int value) {
		accessCount++;
		if (current == null) {
			return new Node(value);
		}

		// add to the left
		if (value < current.value) {
			current.left = addNodeRecursive(current.left, value);

			// add to the right
		} else if (value > current.value) {
			current.right = addNodeRecursive(current.right, value);
		}

		return current;
	}

	/**
	 * Searches for the node that has the value value, and returns true if it is
	 * found
	 * 
	 * @param value value we are going to search for
	 * @return returns if the node was found
	 */
	public boolean searchNode(int value) {
		return searchNodeRecursive(root, value) != null;
	}

	/**
	 * Helper function in for searching a node
	 * 
	 * @param current current node we are in
	 * @param value   the value we are searching for
	 * @return current node in order to recurse
	 */
	private Node searchNodeRecursive(Node current, int value) {
		// base case
		if (current == null)
			return null;

		accessCount++;

		// node was found
		if (current.value == value) {
			return current;
		}

		// go left
		if (value < current.value) {
			return searchNodeRecursive(current.left, value);
		}

		// go right
		return searchNodeRecursive(current.right, value);
	}

	@Override
	/**
	 * returns the trees access count
	 * 
	 * @return the access count of the tree
	 */
	public int getAcessCount() {
		return accessCount;
	}

	@Override
	/**
	 * resets the access count and returns previous one
	 * 
	 * @return Previous access count
	 */
	public int clearAcessCount() {
		int temp = accessCount;
		accessCount = 0;
		return temp;
	}

}
