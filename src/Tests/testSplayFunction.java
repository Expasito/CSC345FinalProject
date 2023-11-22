/**
* this test case tests the splay function which where the rotation happens
* for this we print the in order traversal of the tree, we splay and then print it again, 
* they should be the same as in order gives you an the values ordered
* we do this in different sized trees to cover all edge cases
*/
package Tests;

import Models.*;
import java.util.Random;

/**
 * testSplayFunction is used to test the splay feature for our Splay tree
 * It verifies that splaying does not mess up the order of the tree and
 * to prove that splaying works well
 */
public class testSplayFunction {

	public static void main(String[] args) {

		// get random numbers
		Random gen = new Random(System.currentTimeMillis());
		gen.setSeed(0);

		// initialize the tree
		Splay s = new Splay();

		for (int j = 1; j < 15; j++) {
			int v = 0;
			Node spl = null;
			// add a bunch of nodes
			for (int i = 0; i < j; i++) {
				v = gen.nextInt(i + 100);
				spl = new Node(v);
				s.addNode(spl);
			}
			log(s);		// print in order traversal before splaying
			s.splay(spl); // splay the last node
			log(s);		// print in order traversal after splaying
			System.out.println("\n\n\n");
		}

	}

	/**
	* prints the access count and the in order traversal of the tree that is passed in
 	* @param t	is a splay tree reference
  	* @return void
	*/ 
	public static void log(Splay t) {
		System.out.println("Access Count: " + t.getAcessCount());
		log(t.root);
		System.out.println("");
	}

	/**
	* helper function to print the in order traversal
	* @param root	is the root of the tree
	* @return void
 	*/
	private static void log(Node root) {
		if (root == null) {
			// do nothing
		} else {
			if (root.left != null) {
				log(root.left);
			}
			System.out.print(root.value + ", ");
			if (root.right != null) {
				log(root.right);
			}
		}
	}
}
