package Tests;

import Models.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasicTests {

	@Test
	void test() {
		SearchTree st = new BST();
		test1(st);
		fail("Not yet implemented");
	}
	
	@Test
	void test1(SearchTree st) {
		assertEquals(st.searchNode(2), true);
	}

}
