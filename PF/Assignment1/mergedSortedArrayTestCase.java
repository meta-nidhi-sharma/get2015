package assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class mergedSortedArrayTestCase {

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
		mergedSortedArr obj=new mergedSortedArr();
		int a[]=new int[]{1,3,5,7};
		int b[]=new int[]{2,4,6,8};
		int c[]=new int[a.length+b.length];
		int arrayE[]=new int[]{1,2,3,4,5,6,7,8};
		c=obj.join(a,a.length,b,b.length,c);
		assertArrayEquals(arrayE,c);
		
	}

}
