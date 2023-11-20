package Tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import Models.SearchTree;
import Models.Splay;

class BasicTests {
	private static Random gen = new Random(System.currentTimeMillis());
    private static ArrayList<Integer> exp = new ArrayList<Integer>();
	@Test
	void test() {
		SearchTree st = new BST();
		SearchTree spl = new Splay();
		SearchTree st2 = new BST();
		SearchTree spl2 = new Splay();
		SearchTree st3 = new BST();
		SearchTree spl3 = new Splay();
		SearchTree spl4 = new Splay();
		SearchTree st4, new BST();
		test1(st);
		test2(st2, spl2);
		test3(st3, spl3);
		test4(st4, spl4);
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
			System.out.println("node"+n2+"access count "+st.getAcessCount());
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
			System.out.println("add node "+"splay"+spl.getAcessCount()+"bst "+st.getAcessCount());
		}
		}
		for(int j =0;j<500;j++) {
			int n3 = gen.nextInt(500);
			if(j%50==0) {
				int nCon = 35;
				st.searchNode(nCon);
				spl.searchNode(nCon);
				System.out.println("control node "+nCon+"get access count of control for bst "+st.getAcessCount()
				+"splay access count "+spl.getAcessCount());
				
			}else {
			st.searchNode(n3);
			spl.searchNode(n3);
			}
			System.out.println("node "+n3+"access count "+ st.getAcessCount());
			System.out.println("for splay: node "+n3+"access count "+spl.getAcessCount());
			
		}
	}
	void test3(SearchTree st, SearchTree spl) {
		int[] controlTest = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2,1,0};
		for(int i = 0; i<controlTest.length;i++){
			Node ins = new Node(controlTest[i]);
			st.addNode(ins);
			spl.addNode(ins);
		}
		for(int j =0;j<10;j++){
			st.searchNode(0);
			spl.searchNode(0);
			System.out.println("access count for bst: "+st.getAcessCount());
			System.out.println("access count for splay: "+spl.getAcessCount());

		}
	}
	void test4(SearchTree st, SearchTree spl){
		int[] testarr = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,
		12,11,10,9,8,7,6,5,4,3,2,1};
		for(int i = 0; i<testarr.length;i++){
			Node ins = new Node(testarr[i]);
			st.addNode(ins);
			spl.addNode(ins);
		}
		for(int j =0; j<100;j++){
			int ran = gen.nextInt(13);
			st.searchNode(ran);
			spl.searchNode(ran);
			System.out.println("access count for bst: "+st.getAcessCount());
			System.out.println("access count for splay: "+spl.getAcessCount());
		}
	}
}