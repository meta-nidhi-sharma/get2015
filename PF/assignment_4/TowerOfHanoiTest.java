package assignment_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TowerOfHanoiTest {

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
		TowerOfHanoi obj=new TowerOfHanoi();
		List<String> Result=new ArrayList<String>();
		Result=obj.towerOfHanoi("A","B","C",1);
		String[] Result_Array = Result.toArray(new String[Result.size()]);
		String[] expected={"Move Disk 1 from A to B"};
		assertArrayEquals(expected,Result_Array);
	}
	
	@Test
	public void test1() {
		TowerOfHanoi obj1=new TowerOfHanoi();
		List<String> Result1=new ArrayList<String>();
		Result1=obj1.towerOfHanoi("A","B","C",2);
		String[] Result_Array1 = Result1.toArray(new String[Result1.size()]);
		String[] expected1={"Move Disk 1 from A to C","Move Disk 2 from A to B","Move Disk 1 from C to B"};
		assertArrayEquals(expected1,Result_Array1);
	}
	
	@Test
	public void test2() {
		TowerOfHanoi obj=new TowerOfHanoi();
		List<String> Result=new ArrayList<String>();
		Result=obj.towerOfHanoi("A","B","C",3);
		String[] Result_Array = Result.toArray(new String[Result.size()]);
		String[] expected={"Move Disk 1 from A to B","Move Disk 2 from A to C","Move Disk 1 from B to C","Move Disk 3 from A to B","Move Disk 1 from C to A","Move Disk 2 from C to B","Move Disk 1 from A to B"};
		assertArrayEquals(expected,Result_Array);
	}

	


	
}
