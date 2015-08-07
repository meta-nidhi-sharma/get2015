package assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class checkSortingTestCase {

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
		checkSorting obj=new checkSorting();
		int a[]=new int[]{6,2,3,4};
		int asize=a.length;
		assertEquals(0,obj.checkSortedArray(a,asize));
	}

}
