package assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class removeDuplicateTestCase {

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
		removeDuplicateArr obj=new removeDuplicateArr();
		int a[]=new int[]{1,3,4,3,5,7};
		int[] arr;
		int b[]=new int[]{1,3,4,5,7};
		arr=obj.removeDuplicate(a);
		assertArrayEquals(b,arr);
	}

}
