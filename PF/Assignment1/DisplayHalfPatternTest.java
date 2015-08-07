package printPyramid;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DisplayHalfPyramidTest {

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

	@Test       //Test Case for Space function
	public void test() {
		
		DisplayHalfPattern obj=new DisplayHalfPattern(); 
		String str=new String();
		str=obj.Spaces(3, 5);
		String expected="  ";
		assertEquals(expected,str);
		
	}
	
	@Test       //Test Case for numbers function
	public void test1() {
		 
		DisplayHalfPattern obj=new DisplayHalfPattern(); 
		String str=new String();
		str=obj.Numbers(3, 5);
		String expected="123";
		assertEquals(expected,str);
		
	}

	@Test       //Test Case for WholePyramid function
	public void test2() {
		 
		DisplayHalfPattern obj=new DisplayHalfPattern(); 
		String str=new String();
		str=obj.WholePyramid(6);
		String expected="123456\n 12345\n  1234\n   123\n    12\n     1\n";
		assertEquals(expected,str);
		
	}
}
