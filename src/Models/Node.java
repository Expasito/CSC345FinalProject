package Models;

public class Node {
	
	public Node left;
	public Node right;
	public Node parent;
	public int value;
	public int visited;
	
	public Node(int value) {
		left = null;
		right = null;
		parent = null;
		this.value = value;
		visited = 1;
	}
	
	public String toString() {
		return "Node: (" + String.valueOf(value) + ")";
	}

}
