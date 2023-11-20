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

}
