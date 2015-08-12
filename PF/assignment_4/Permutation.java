package assignment_4;

/**
author: Nidhi Sharma
Description: This program contains a function to perform permutation of a string
              and print all possible combinations of that string.
     
Input:  Enter String

Output: It will give the list of strings which consists of all possible combination of Input String

For Example: I/P:Enter String ABC
O/P:
ABC
ACB
BAC
BCA
CBA
CAB

*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Permutation {
	 int l=0;                                  //A variable to globally handle the lower bound of String
	 
List<String> Result=new ArrayList<String>();            // A variable to store list of strings
	
	public static void main(String args[])
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("Enter String");
		String input_String = sc.nextLine();                        // Enter String to permute
		if(input_String.length()-1>=0)
		{
		     Permutation obj=new Permutation();
		     obj.Result=obj.generatePermutations(input_String);         //Call Function
		     Iterator<String> itr=obj.Result.iterator();                //Iteration to print all the strings in the list
		     while(itr.hasNext()){             
			      System.out.println(itr.next());  
			     } 
		}
		else
			System.out.println("String is empty" );
		sc.close();
	}

	/*
	 Permutation function to print all possible combinations of that string
	 This function is returning the list of string which consists of all possible combination of that string
	 */
	List<String> generatePermutations(String input)
	{
	char[] c = input.toCharArray();                  //converting string to character array to swap characters
		   int i;                            
		   int r=(input.length()-1);                 //To store outer bound of string
		   if (l == r)
		    Result.add(input);                      //adding strings to result(List)
		   else
		   {
		       for (i = l; i <= r; i++)
		       {
		    	   char temp;                    
				    temp = c[l];
				    c[l] = c[i];
				    c[i] = temp;
				    
				// swapping characters
				    
				    input = new String(c);
				    ++l;
		          generatePermutations(input);       //Recursive call
		          --l;
		          char temp1;
				    temp1 = c[l];
				    c[l] = c[i];
				    c[i] = temp1;
				    
				 // swapping characters
				    
				    input = new String(c);
		       }
		       input = new String(c);
		   }
		 
		return Result;
		
	}

}
