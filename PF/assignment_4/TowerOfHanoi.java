package assignment_4;

/**
author: Nidhi Sharma
Description: This program contains a function to handle tower of hanoi problem for n disks
     
Input:  Enter number of disk (For Example: 2)

Output:  It will give the list of strings which consist of way of movement of disk from source to destination 
         using auxiliary string
         
For Example:I/P: 2
O/P:
Move Disk 1 from A to C
Move Disk 2 from A to B
Move Disk 1 from C to B
         
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TowerOfHanoi {
	 List<String> Result=new ArrayList<>();                             // A variable to store list of strings
	
	public static void main(String args[])
	{
		java.util.Scanner sc=new java.util.Scanner(System.in);
		
		System.out.println("enter number of disk");
		int numOfDisk=sc.nextInt();                             // Enter Number of Disk
		if(numOfDisk>0)
			{
			TowerOfHanoi obj=new TowerOfHanoi();
		    obj.Result=obj.towerOfHanoi("A", "B" , "C", numOfDisk); //Call Function
		    Iterator<String> itr=obj.Result.iterator();          //Iteration to print all the strings in the list
		    while(itr.hasNext()){  
			   System.out.println(itr.next());  
			  } 
			} 
		else
			System.out.println("enter at least one disk");
		sc.close();
	}

	/*
	 Tower of Hanoi Function using recursion
	 */
	
 List<String> towerOfHanoi(String source, String destination, String temp, int numOfDisk)
	{
		if(numOfDisk==1)                           /*If number of disk is 1 in source string 
			                                      then it will send it to destination string*/
			Result.add("Move Disk "+numOfDisk+" from "+ source+" to "+destination);	  
		//adding strings to result(List)
		 else if(numOfDisk>1)
		{
			towerOfHanoi(source, temp, destination, numOfDisk-1);     //Recursive call
			Result.add("Move Disk "+numOfDisk+" from "+source+" to "+destination);	
			//adding strings to result(List)
			
			towerOfHanoi(temp, destination, source, numOfDisk-1);     ////Recursive call
		}
		
		return Result;
	}
	
	
}
