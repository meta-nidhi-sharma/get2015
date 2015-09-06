package TreeSort;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeSortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		BinaryTreeNode root = null;
		BinaryTreeNode actualNode = TreeSort.insert(root, 6);
		BinaryTreeNode expectedNode = new BinaryTreeNode(6);
		assertEquals(expectedNode.nodeValue, actualNode.nodeValue);
	}

	@Test
	public void test2() {
		BinaryTreeNode root = null;
		BinaryTreeNode node = TreeSort.insert(root, 6);
		BinaryTreeNode actualNode = TreeSort.insert(node, 9);
		BinaryTreeNode expectedNode = new BinaryTreeNode(node.nodeValue);
		assertEquals(expectedNode.nodeValue, actualNode.nodeValue);
	}
	
	@Test
	public void test3() {
		BinaryTreeNode root = null;
		root = TreeSort.insert(root, 6);
		root = TreeSort.insert(root, 9);
		root = TreeSort.insert(root, 5);
		root = TreeSort.insert(root, 3);
		root = TreeSort.insert(root, 8);
		root = TreeSort.insert(root, 5);
		root = TreeSort.insert(root, 10);
		root = TreeSort.insert(root, 0);
		root = TreeSort.insert(root, 9);
		String actual = TreeSort.treeSorting(root);
		String expected = " 0 3 5 5 6 8 9 9 10";
		assertEquals(expected, actual);
	}

}
