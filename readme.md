# Splay(Node n)
- This method is the main mechanism to modify the tree to *be* a splaytree.
- given a node, the method determines the orientation of the node. After determining the orientation the node then switches the node with its parents and then updates the parents and children. The node recurses through, swapping the given node with its parents until the node is in the root position.
-This method rotates the tree every search so that the most recently searched Node is the root.

# searchNode(int value)
- This method searches the root, then the right or left child depending on weather it is greater or lesser than the value of the current root against value.
- The method then iterates through the left or right child until the node is ether found or returns nothing.
- The final step is to call the splay method with the node that was found.
  
# addNode(Node root, Node node)
- The addNode method adds a node by comparing the root to the value of the node and puts it to the left or right of the current root, then recurses back into the addNode method

# getAcessCount()
- returns the access count

# clearAcessCount()
- sets the access count to 0
  
# getHeight(Node n)
- returns the height of the node n

# BasicTests()
- this class performs tests on the splay and BST trees to showcase that they work, and that the access count is perfoming better on splay when applicable

