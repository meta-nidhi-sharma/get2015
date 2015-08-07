package assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class jobSchedulingTestCase {

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
		jobScheduling obj=new jobScheduling();
int output[][]=obj.FCFS(new int[]{1,5,9,25},new int[]{12,7,2,5});
		
		int expected[][]={{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		jobSchedulingTestCase jst=new jobSchedulingTestCase();

		assertEquals("",1,jst.isArrayEqual(expected, output));
	}
	
	public int isArrayEqual(int expected[][], int actual[][])
	{
		int result=1;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(expected[i][j]!=actual[i][j])
				{
					result=0;
				}
			}
		}
		return result;
	}

}
