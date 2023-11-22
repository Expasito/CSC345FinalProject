package Models;

/**
 * SearchTree is an interface for the basic functionality for a tree structure
 * used for searching.
 */
public interface SearchTree {

	/**
	 * addNode adds a node to the tree, unless its already in there.
	 * @param value The integer value to add to the tree
	 */
	public void addNode(Node node);

	/**
	 * searchNode searches for a value in the tree.
	 * @param value The value to search for
	 * @return If the value was found in the tree
	 */
	public boolean searchNode(int value);
	
	
	/**
	 * getAcessCount returns the acessCount of the tree
	 * @return The current acessCount of the tree
	 */
	public int getAcessCount();
	
	/**
	 * clearAcessCount resets the acessCount of the tree
	 * @return The current acessCount of the tree before resetting
	 */
	public int clearAcessCount();
}
