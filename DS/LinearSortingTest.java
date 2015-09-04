package SortingSystem;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LinearSortingTest {

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
		LinearSorting ls = new LinearSorting();
		int[] inputArray = {3,5,2,6,4,8,12,10};
		int[] actualArray = ls.countingSort(inputArray, 12);
		int[] expextedArray = {2,3,4,5,6,8,10,12};
		assertArrayEquals(expextedArray, actualArray);
	}
	@Test
	public void test2() {
		LinearSorting ls = new LinearSorting();
		int[] inputArray = {3,5,2,6,4,8,12,345,567,23,123,89,10};
		int[] actualArray = ls.radixSort(inputArray, 567);
		int[] expextedArray = {2,3,4,5,6,8,10,12,23,89,123,345,567};
		assertArrayEquals(expextedArray, actualArray);
		
	}
	@Test
	public void test3() {
		LinearSorting ls = new LinearSorting();
		int actualValue = ls.numberOfDigits(5687);
		int expectedValue = 4;
		assertEquals(expectedValue, actualValue);
	}
	@Test
	public void test4() {
		LinearSorting ls = new LinearSorting();
		int actualValue = ls.numberOfDigits(567);
		int expectedValue = 4;
		assertEquals(expectedValue, actualValue);
	}

}
