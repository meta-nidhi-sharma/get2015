package assignment_3;

/**
author: Nidhi Sharma
Description: This program contains two function:
     1st Function: To linear search a given number in an array using recursion call
     2nd Function: To binary search a given number in an array using recursion call
     
Input:  1st Function: Number of elements in array and Array Elements
        2nd Function: Number of elements in array and sorted array elements

Output: 1st Function: '1' if number is found else '0'
        2nd Function:  '1' if number is found else '0'
         
*/

public class RecursionAssignment_2 {
	public static void main(String args[])
	  {
		
		java.util.Scanner sc=new java.util.Scanner(System.in);
		int i=0;
		RecursionAssignment_2 obj=new RecursionAssignment_2();
		
		//Linear Search
		
		System.out.println("enter number of elements in array for linear search");
		int numberOfElememnts_Linear=sc.nextInt();
		if(numberOfElememnts_Linear>0)
		{
		int arrayForLinearSearch[]=new int[numberOfElememnts_Linear];
		System.out.println("enter array elements");
		for(int j=0;j<numberOfElememnts_Linear;j++)
		arrayForLinearSearch[j]=sc.nextInt();
		System.out.println("enter number to search");
		int numberToSearch_Linear=sc.nextInt();
		
		int linearSearchResult=obj.linearSearchUsingRecursion(arrayForLinearSearch, numberToSearch_Linear, i);
		if(linearSearchResult==1)
		System.out.println("number is found");
		else
			System.out.println("number not found");
		}
		else 
			System.out.println("Enter a valid size for array");
		
		//Binary Search
		
		System.out.println("enter number of elements in array for binary search");
		int numberOfElements_Binary=sc.nextInt();
		if(numberOfElememnts_Linear>0)
		{
		int arrayForBinarySearch[]=new int[numberOfElements_Binary];
		System.out.println("enter sorted elements in array for binary search");
		for(i=0;i<numberOfElements_Binary;i++)
		arrayForBinarySearch[i]=sc.nextInt();
		System.out.println("enter number to search");
		int numberToSearch_Binary=sc.nextInt();
		int min=0;
		int max=arrayForBinarySearch.length-1;
		int binarySearchResult=obj.binarySearchUsingRecursion(arrayForBinarySearch, numberToSearch_Binary, min, max);
		if(binarySearchResult==1)
			System.out.println("number is found");
			else
			System.out.println("number not found");
		}
		else 
			System.out.println("Enter a valid size for array");
		
		sc.close();
	  }
	
	/*
	 Linear Search: This function is to search a number in an array using linear search algorithm
	                It is returning 1 if number is found, else returning 0;
	 */
	
	int linearSearchUsingRecursion(int array[], int number, int i)
	{
		if(number==array[i])
		return 1;
		else if(++i<array.length)
			return linearSearchUsingRecursion(array, number, i);
		else
			return 0;
	}
	
	/*
	Binary Search:  This function is to search a number in an array using binary search algorithm
	                It is returning 1 if number is found, else returning 0;
	 */
	
	int binarySearchUsingRecursion(int array[],int number, int min, int max)
	{	
		if(min<=max)
		{
		    int middle=(max+min)/2;
		    if(number==array[middle])
		         return 1;
		    else if(number>array[middle])
		      {
			     min=middle+1;
		         return binarySearchUsingRecursion(array, number, min, max);
		      }
		    else if(number<array[middle])
		      {
			     max=middle-1;
			     return binarySearchUsingRecursion(array, number, min, max);
		      }
		}
			return 0;
	}

}
