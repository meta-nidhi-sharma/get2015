package assignment_3;

import static org.junit.Assert.*;

import org.junit.Test;


public class RecursionAssignment_1Test {

		@Test
		public void test() {
			RecursionAssignment_1 obj=new RecursionAssignment_1();
			int gcd=obj.gcd(2,1);
			assertEquals("Pass",1,gcd);
			
			int gcd1=obj.gcd(12,18);
			assertEquals("Pass",6,gcd1);
			
			int gcd2=obj.gcd(100,3);
			assertEquals("Pass",1,gcd2);
		}

		@Test
		public void test1() {
			RecursionAssignment_1 obj=new RecursionAssignment_1();
			int remainder=obj.rem(2, 1);
		    assertEquals("Pass",0,remainder);
		    
		    int remainder1=obj.rem(2, 0);
		    assertEquals("Pass",2,remainder1);
		    
		    int remainder2=obj.rem(100, 3);
		    assertEquals("Pass",1,remainder2);
		}

		@Test
		public void test2() {
			RecursionAssignment_1 obj1=new RecursionAssignment_1();
			int greatestDigit=obj1.largestDigit(2);
		    assertEquals("Pass",2,greatestDigit);
		    
		    RecursionAssignment_1 obj2=new RecursionAssignment_1();
		    int greatestDigit1=obj2.largestDigit(1257369);
		    assertEquals("Pass",9,greatestDigit1);
		    
		    RecursionAssignment_1 obj3=new RecursionAssignment_1();
		    int greatestDigit2=obj3.largestDigit(144);
		    assertEquals("Pass",4,greatestDigit2);
		}

	

}
