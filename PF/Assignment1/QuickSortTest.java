package assignment_3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QuickSortTest {

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
		QuickSort obj=new QuickSort();
		int[] array=new int[]{2,5,8,9,10,77,55,11};
		int[] sortedArray=obj.quickSortArray(array,array.length-1, 0);
		int expected[]=new int[]{2,5,8,9,10,11,55,77};
		assertArrayEquals(expected,sortedArray);
	}

}
