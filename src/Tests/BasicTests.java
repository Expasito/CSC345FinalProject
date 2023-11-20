package Tests;

import Models.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasicTests {
	private static Random gen = new Random(System.currentTimeMillis());
    private static ArrayList<Integer> exp = new ArrayList<Integer>();
	@Test
	void test() {
		SearchTree st = new BST();
		SearchTree spl = new Splay();
		//test1(st);
		test2(st, spl);
//		fail("Not yet implemented");

	}
	
	@Test
	void random_nonrandom() {
		SearchTree bst = new BST();
		SearchTree splay = new Splay();
		System.out.println("\n\nTesting BST");
		test3(bst, 100, 5, 100);
		System.out.println("\n\nTesting Splay");
		test3(splay, 100, 5, 100);
	}
	
	void test1(SearchTree st) {
		int count = 0;
		while (count< 100) {
			int num = gen.nextInt(100);
			exp.add(num);
			count++;
		}
		for(int i =0; i<100;i++) {
			Node inst = new Node(exp.get(i));
			st.addNode(inst);
		}
		for(int i =0;i<100;i++) {
			int n2 = gen.nextInt(100);
			st.searchNode(n2);
			System.out.println("node "+n2+" access count "+st.getAcessCount());
		}
		assertEquals(st.searchNode(2), true);
	}
	void test2(SearchTree st, SearchTree spl) {
		int conNumb =0;
		int count =0;
		while (count<500) {
			int num = gen.nextInt(500);
			exp.add(num);
			count++;
		}
		for(int i =0;i<500;i++) {
			Node inst = new Node(exp.get(i));
			if(i==0) {
				Node con = new Node(35);
				spl.addNode(con);
				st.addNode(con);
				
			}else {
			spl.addNode(inst);
			st.addNode(inst);
			System.out.println("add node "+"splay "+spl.getAcessCount()+" bst "+st.getAcessCount());
		}
		}
		for(int j =0;j<500;j++) {
			int n3 = gen.nextInt(500);
			if(j%50==0) {
				int nCon = 35;
				st.searchNode(nCon);
				spl.searchNode(nCon);
				System.out.println("     control node "+nCon+" get access count of control for bst "+st.getAcessCount()
				+" splay access count "+spl.getAcessCount());
				
			}else {
			st.searchNode(n3);
			spl.searchNode(n3);
			}
			System.out.println("for bst: node "+n3+" access count "+ st.getAcessCount());
			System.out.println("for splay: node "+n3+" access count "+spl.getAcessCount());
			
		}
	}
	
	/*
	 * 
	 * int elements The number of items to add
	 * int subElements The number of sub elements to add
	 * int searches The number of searches to perform
	 * 
	 * This test focuses on random data with a small set of values to search for
	 * 'element' number of  nodes will be inserted into the tree and 'subElements' number of nodes will be chosen to be the set to search for. 
	 * The subElements will be added linearly throughout adding the nodes to the tree
	 * After inserting all of the nodes, 1 of the N number of nodes will be searched for. This will be repeated 'searches' times
	 * 
	 * 
	 */
	void test3(SearchTree st, int elements, int subElements, int searches) {
		st.clearAcessCount();
		
		int[] subSet = new int[subElements];
		int counter = 0;
		
		int mod = elements/ subElements;
		
		// create random with seed of 1 to keep it consistent.
		Random rand = new Random();
		for(int i = 0; i< elements;i++) {
			int add = rand.nextInt();
			st.addNode(new Node(add));
			if(i % mod == 0 && counter < subElements) {
				subSet[counter] = add;
				counter++;
			}
		}
		
		System.out.println("Cost to add elements :: Access Count: " + st.getAcessCount());
		
		System.out.println("SubSet values:");
		for(int i = 0;i<subElements;i++) {
			System.out.print(subSet[i] + ", ");
		}
		System.out.println("");
		
		st.clearAcessCount();
		
		System.out.println("Searching...");
		
		for(int i =0;i<searches;i++) {
			int index = rand.nextInt(0,subElements);
			int key = subSet[index];
			st.searchNode(key);
		}
		
		System.out.println("Cost to search elements :: Access Count: " + st.getAcessCount());
		
		
	}

}
