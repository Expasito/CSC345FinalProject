package Models;

public interface SearchTree {
	
	/**
	 * addNode adds a node to the tree, unless its already in there.
	 * @param value The integer value to add to the tree
	 * @return If the value was already in the tree
	 */
	public boolean addNode(Node node);

	/**
	 * searchNode searches for a value in the tree.
	 * @param value The value to search for
	 * @return If the value was found in the tree
	 */
	public boolean searchNode(int value);
	
	
	// Stuff for measuring access count
	public int getAcessCount();
	public int clearAcessCount();
}
