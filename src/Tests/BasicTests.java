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
		test1(st);
		test1(spl);
//		fail("Not yet implemented");
	}
	
	void test1(SearchTree st) {
		int count = 0;
		while (count < 100) {
			int num = gen.nextInt(100);
			exp.add(num);
			count++;
		}
		for(int i =0; i<100;i++) {
			Node inst = new Node(exp.get(i));
			st.addNode(inst);
		}
		for(int i =0;i>100;i++) {
			int n2 = gen.nextInt(100);
			st.searchNode(n2);
			System.out.println(st.getAcessCount());
		}
	}

}
