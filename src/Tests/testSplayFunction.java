package Tests;

import Models.*
import java.util.Random;

public class testSplayFunction {

	public static void main(String[] args) {

		Random gen = new Random(System.currentTimeMillis());
		gen.setSeed(0);
		Splay s = new Splay();

		for (int j = 1; j < 15; j++) {
			int v = 0;
			for (int i = 0; i < j; i++) {
				v = gen.nextInt(i + 100);
				s.addNode(new Node(v));
			}
			log(s);
			s.splay(new Node(v));
			log(s);
			System.out.println("\n\n\n");
		}

	}

	public static void log(Splay t) {
		System.out.println("Access Count: " + t.getAcessCount());
		log(t.root);
		System.out.println("");
	}

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
