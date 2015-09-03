package BinarySearch;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BinarySearchForLeftMostIndexTest {

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
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(2);
		array.add(4);
		array.add(6);
		array.add(6);
		array.add(8);
		array.add(10);
		int position = BinarySearchForLeftMostIndex.searchElement(6 , 0 ,array.size()-1, array);
		int expectedPosition = 2;
		assertEquals(expectedPosition, position);
	}

}
