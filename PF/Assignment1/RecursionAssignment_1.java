package assignment_3;
/**
author: Nidhi Sharma
Description: This program contains three function:
     1st Function: To find Greatest Common Divisor of two numbers using recursion call
     2nd Function: To find Remainder using recursion call
     3rd Function: To find largest digit in a number
     
Input:  1st Function: Two numbers to find GCD(For Example: 120,100)
        2nd Function:Dividend and Divisor(For Example: 100,3)
        3rd Function: enter a number(For Example: 2894)

Output: 1st Function: Greatest Common Divisor of two numbers(Output: 20)
        2nd Function: Remainder(Output: 1)
        3rd Function: largest digit in the number(Output: 9)
         
*/
public class RecursionAssignment_1 {
	int largest=0;
	
	public static void main(String args[])
	  {
		
		java.util.Scanner sc=new java.util.Scanner(System.in);
		
		System.out.println("To find gcd enter two numbers");
		int number1=sc.nextInt();                                 // 1st Number
		int number2=sc.nextInt();                                // 2nd Number
		RecursionAssignment_1 obj=new RecursionAssignment_1();
		int gcd=obj.gcd(number1, number2);                         //gcd i.e. Greatest Common Divisor
		System.out.println(gcd);
		
		//calling function to find Greatest Common Divisor
		
		System.out.println("To find remainder enter dividend and divisor");
		int Dividend=sc.nextInt();                              
		int Divisor=sc.nextInt();
		int remainder=obj.rem(Dividend, Divisor);
		System.out.println(remainder);
		
		//calling function to find remainder
		
		System.out.println("Enter Number");
		int number=sc.nextInt(); 
		int greatestDigit=obj.largestDigit(number);
		System.out.println(greatestDigit);
		
		//calling function to find largest digit in a number
		
		sc.close();
	  }
	
	
	/*
	 GCD: This function is to find greatest common divisor of two numbers using recursion call
	 */
	
	 int gcd(int x, int y)
	 {
		 if(x>y)
		 {
			 if(x%y!=0)
			     return gcd(y,x%y);
			 else
				 return y;
		 }
		 else
		 {
			if(y%x!=0)
				return gcd(y%x,x);
			else
			    return x;
		 }
	 }
	 
	 /*
	 Remainder: This function is to find remainder using recursion call
	  */
	 
	 int rem(int x, int y)
	 {
		 if(x>y && x-y>=y && y>0 && x>=0)
			 return rem(x-y,y);
		 else if(x-y>=0)
			 return x-y;
		 else
			 return x;
			 
	 }
	 
	 /*
	  Largest Digit: This function is to find largest digit in a number using recursion call
	  */

	 
	int largestDigit(int x)
	{
		if(x!=0)
		{
		   if(x%10>=largest)
		     {
			      largest=x%10;
		          return largestDigit(x/10);
		     }
		   else 
		          return largestDigit(x/10);
	    }
		else
			return largest;
	}	
	
}
