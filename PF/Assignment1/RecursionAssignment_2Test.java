package assignment_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionAssignment_2Test {

	/*@Test
	public void test() {
		RecursionAssignment_2 obj=new RecursionAssignment_2();
		int array[]=new int[]{2,5,8,9,10,77,55};
		int actualValue=obj.linearSearchUsingRecursion(array, 88 , 0 );
	    assertEquals("pass",0,actualValue);
	
	    int array1[]=new int[]{2,5,8,9,10, 77, 55, 11};
	    int actualValue1=obj.linearSearchUsingRecursion(array1, 77 , 0 );
        assertEquals("pass",1,actualValue1);
        
	}
	*/
	@Test
	public void test1() {
		RecursionAssignment_2 obj=new RecursionAssignment_2();
		int array[]=new int[]{2,5,8,9,10,55,77};
		int actualValue=obj.binarySearchUsingRecursion(array, 88 , 0 ,array.length-1);
	    assertEquals("pass",0,actualValue);
	    
	    int array1[]=new int[]{2,5,8,9,10,55,77};
		int actualValue1=obj.binarySearchUsingRecursion(array1, 77 , 0 ,array1.length-1);
	    assertEquals("pass",1,actualValue1);
	}


}
