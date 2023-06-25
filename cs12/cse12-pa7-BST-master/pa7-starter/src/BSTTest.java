
/**
 * File header
 * Author: Pierre Ellie
 * This is the BSTTest.java file, This file is used for testing the BST.java file
 * This allows for the user to be able to know that the methods made in BST.java work properly.
 * */
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

	/* TODO: Add your own tests */
	private DefaultMap<Integer, String> BST;

	@Before
	public void InitializeBST() {
		BST = new BST<>();
	}

	// @Test
	public void testPut() {

		assertEquals(true, BST.put(8, "A"));
	}

	// @Test
	public void testPut_Failure() {
		BST.put(3, "A");

		assertEquals(false, BST.put(3, "B"));
	}

	@Test
	public void testReplaceNull() {
		BST.put(3, "A");
		BST.replace(3, null);
		assertEquals(null, BST.get(3));
	}

	@Test
	public void testReplace() {
		BST.put(3, "A");
		BST.replace(3, "B");
		assertEquals("B", BST.get(3));
	}

	@Test
	public void testReplaceKeyNotFound() {
		BST.put(3, "A");
		BST.replace(4, "B");
		assertEquals("A", BST.get(3));
	}

	@Test
	public void testKeys() {
		BST.put(5, "A");

		List<Integer> expected = new ArrayList<Integer>();
		expected.add(5);

		assertEquals(expected, BST.keys());
	}

	@Test
	public void testAddRemove() {
		BST.put(5, "A");
		BST.put(6, "A");
		BST.remove(5);

		assertEquals("A", BST.get(6));
	}

	@Test
	public void testAddRemoveLarger() {
		BST.put(50, "50");
		BST.put(30, "30");
		BST.put(20, "20");
		BST.put(40, "40");
		BST.put(70, "70");
		BST.put(60, "60");
		BST.put(80, "80");
		System.out.print(BST.keys());
		BST.remove(20);
		System.out.print(BST.keys());
		assertEquals("40", BST.get(40));
	}

}