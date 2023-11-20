package Models;

/**
 * Node is a basic class for all SearchTree classes.
 * It has a parent, left and right pointer along with the value.
 */
public class Node {
	
	// References for each part of the node
	public Node left;
	public Node right;
	public Node parent;
	
	// the value of the node
	public int value;
	
	/**
	 * Basic constructor for a node with no references assigned.
	 * @param value The value of the node
	 */
	public Node(int value) {
		left = null;
		right = null;
		parent = null;
		this.value = value;
	}
	
	/**
	 * Basic toString method for the class
	 * @return The string representation of the class
	 */
	@Override
	public String toString() {
		return "Node: (" + String.valueOf(value) + ")";
	}

}
