package printPyramid;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DisplayFullPyramidTest {

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
	public void test() 
		{
			
			DisplayFullPyramid obj=new DisplayFullPyramid(); 
			String str=new String();
			str=obj.Spaces(3, 5);
			String expected="  ";
			assertEquals(expected,str);
			
		}
		
		@Test       //Test Case for numbers function
		public void test1() {
			 
			DisplayFullPyramid obj=new DisplayFullPyramid(); 
			String str=new String();
			str=obj.Numbers(3, 5);
			String expected="12321";
			assertEquals(expected,str);
			
		}

		@Test       //Test Case for WholePyramid function
		public void test2() {
			 
			DisplayFullPyramid obj=new DisplayFullPyramid(); 
			String str=new String();
			str=obj.WholePyramid(3);
			String expected="  1\n 121\n12321\n 121\n  1\n";
			assertEquals(expected,str);
			
		}

}
