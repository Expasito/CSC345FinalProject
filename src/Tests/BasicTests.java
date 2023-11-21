package Tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.Test;

import Models.BST;
import Models.Node;
import Models.SearchTree;
import Models.Splay;

class BasicTests {
	private static Random gen = new Random(System.currentTimeMillis());
    private static ArrayList<Integer> exp = new ArrayList<Integer>();
    
	public static void main(String[] args) {
		SearchTree st = new BST();
		SearchTree spl = new Splay();
		SearchTree st2 = new BST();
		SearchTree spl2 = new Splay();
		SearchTree st3 = new BST();
		SearchTree spl3 = new Splay();
		SearchTree spl4 = new Splay();
		SearchTree st4=  new BST();
		SearchTree st5 = new BST();
		SearchTree spl5 = new Splay();
		test1(st, spl);
		test2(st2, spl2);
		test3(st3, spl3);
		test4(st4, spl4);
		test5(st5, spl5);
	}
	
	static void test1(SearchTree st, SearchTree spl) {
		System.out.println("starting test 1 ---");
		int count = 0;
		while (count< 100) {
			int num = gen.nextInt(100);
			exp.add(num);
			count++;
		}
		for(int i =0; i<100;i++) {
			Node inst = new Node(exp.get(i));
			st.addNode(inst);
			spl.addNode(inst);
		}
		for(int i =0;i<100;i++) {
			int n2 = gen.nextInt(100);
			st.searchNode(n2);
			if(i%10==0) {
			System.out.println("node"+n2+"access count "+st.getAcessCount());
		}
			System.out.println("");
			System.out.println("splay node  "+spl.getAcessCount());
		}

	}
	static void test2(SearchTree st, SearchTree spl) {
		System.out.println("test 2 start---");
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
			if(i%50==0) {
		}
			}
		}
		st.clearAcessCount();
		spl.clearAcessCount();
		for(int j =0;j<500;j++) {
			int n3 = gen.nextInt(500);
			if(j%5==0) {
				int nCon = 35;
				st.searchNode(nCon);
				spl.searchNode(nCon);
				System.out.println("control node "+nCon+"get access count of control for bst "+st.getAcessCount()
				+"splay access count "+spl.getAcessCount());
				System.out.println("");
			}else {
			st.searchNode(n3);
			spl.searchNode(n3);
			}
			if(j%50==0) {
			System.out.println("for BST: node "+n3+"access count "+ st.getAcessCount());
			System.out.println("for splay: node "+n3+"access count "+spl.getAcessCount());
			}
		}
	}
	
	static void test3(SearchTree st, SearchTree spl) {
		System.out.println("Test 3 start---");
		int[] controlTest = new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2,1,0};
		for(int i = 0; i<controlTest.length;i++){
			Node ins = new Node(controlTest[i]);
			st.addNode(ins);
			spl.addNode(ins);
		}
		st.clearAcessCount();
		spl.clearAcessCount();
		for(int j =0;j<10;j++){
			st.searchNode(0);
			spl.searchNode(0);
			System.out.println("access count for bst: "+st.getAcessCount());
			System.out.println("access count for splay: "+spl.getAcessCount());

		}
	}
	static void test4(SearchTree st, SearchTree spl){
		System.out.println("test 4 start");
		int[] testarr = new int[]{13, 12, 14, 11, 15, 9, 16, 8, 17, 7};
		for(int i = 0; i<testarr.length;i++){
			Node ins = new Node(testarr[i]);
			st.addNode(ins);
			spl.addNode(ins);
		}
		for(int j =0; j<100;j++){
			int ran = gen.nextInt(13);
			st.searchNode(ran);
			spl.searchNode(ran);
			if(j%10==0) {
			System.out.println("access count for bst: "+st.getAcessCount());
			System.out.println("access count for splay: "+spl.getAcessCount());
		}
		}
	}
	static void test5(SearchTree st, SearchTree spl) {
		System.out.println("Test 5 start---");
		int[] test5Array = new int[100];
		int[] searchArray = new int[] {30, 27, 86};
		for(int i = 0; i<test5Array.length;i++) {
			Node ins = new Node(gen.nextInt(100));
			st.addNode(ins);
			spl.addNode(ins);
		}
		st.clearAcessCount();
		spl.clearAcessCount();
		for(int j = 0; j<50;j++) {
			int nran = gen.nextInt(2);
			spl.searchNode(searchArray[nran]);
			st.searchNode(searchArray[nran]);
			if(j%5==0) {
			System.out.println("splay access counts   "+spl.getAcessCount());
			System.out.println("");
			System.out.println("bst access counts   "+st.getAcessCount());
		}}
	}
}
