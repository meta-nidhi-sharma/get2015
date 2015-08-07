package assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class longIncreasingSequenceTestCase {

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
		longIncreasingSequence obj=new longIncreasingSequence();
		int output[];
		
		output=obj.longestSequence(new int[]{1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8});
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,8},output);
		//fail("Not yet implemented");
	}

}
