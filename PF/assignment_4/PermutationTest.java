package assignment_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PermutationTest {

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
		Permutation obj=new Permutation();
		List<String> Result=new ArrayList<String>();
		Result=obj.generatePermutations("ABC");
		String[] Result_Array = new String[Result.size()];
		Result_Array = Result.toArray(Result_Array);
		String[] expected={"ABC","ACB","BAC","BCA","CBA","CAB"};
		assertArrayEquals(expected,Result_Array);
	}
	
	@Test
	public void test1() {
		Permutation obj1=new Permutation();
		List<String> Result1=new ArrayList<String>();
		Result1=obj1.generatePermutations("ABCD");
		String[] Result_Array1 = new String[Result1.size()];
		Result_Array1 = Result1.toArray(Result_Array1);
		String[] expected1={"ABCD","ABDC","ACBD","ACDB","ADCB","ADBC","BACD","BADC","BCAD","BCDA","BDCA","BDAC","CBAD","CBDA","CABD","CADB","CDAB","CDBA","DBCA","DBAC","DCBA","DCAB","DACB","DABC"};
		assertArrayEquals(expected1,Result_Array1);
	}

}
