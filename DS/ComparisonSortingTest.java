package SortingSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComparisonSortingTest {

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
	public void test() {
		ComparisonSorting cs = new ComparisonSorting();
		int[] inputArray = {3,5,2,6,4,8,12,10};
		int[] actualArray = cs.bubbleSort(inputArray);
		int[] expextedArray = {2,3,4,5,6,8,10,12};
		assertArrayEquals(expextedArray, actualArray);
	}

	@Test
	public void test1() {
		ComparisonSorting cs = new ComparisonSorting();
		int[] inputArray = {3,5,2,6,23,34,56,123,34,55,8,12,10};
		int[] actualArray = cs.quickSort(0, inputArray.length-1 , inputArray);
		int[] expextedArray = {2,3,5,6,8,10,12,23,34,34,55,56,123};
		assertArrayEquals(expextedArray, actualArray);
	}
}
