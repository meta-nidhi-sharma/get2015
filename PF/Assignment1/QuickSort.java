package assignment_3;

/**
author: Nidhi Sharma
Description: This program contains a function to perform sorting of an array using quick sort
     
Input:  1.Enter number of elements in array
        2.Enter array elements

Output: A sorted array

For Example: Input: Number of elements= 9
                    Array= {2,5,8,9,10,7,3,1,4}
                    
             Output: {1,2,3,4,5,7,8,9,10}       
         
*/

public class QuickSort {
	
	public static void main(String args[])
	  {
		
		java.util.Scanner sc=new java.util.Scanner(System.in);
		QuickSort obj=new QuickSort();                                                   //creating object
		System.out.println("enter number of elements in array for quick sort search");
		int numberOfElememnts=sc.nextInt();                                   //Input: Number of elements in array
		if(numberOfElememnts>1)
		{
		int array[]=new int[numberOfElememnts];
		System.out.println("enter array elements");
		for(int i=0;i<numberOfElememnts;i++)                                    //Input: Enter array elements
		array[i]=sc.nextInt();
		int min=0;
		int max=array.length-1;
	 
		int[] sortedArray=obj.quickSortArray(array,max,min);                   //calling quick sort function
		for(int i=0;i<numberOfElememnts;i++)
			System.out.println(sortedArray[i]);                 //printing sorted array
		} 
		else if(numberOfElememnts==1)
			System.out.println("Enter more than one element to sort");
		else if(numberOfElememnts<=0)
			System.out.println("There are no elements to sort");
		

	
		sc.close();
	  }
	
	/*
	 function to perform quick sorting
	 */
	
	int[] quickSortArray(int a[],int max, int min)
	{
		int p;                                       // To hold pivot and sometimes to swap values
		int left=min;                                       
		int right=max;
		int middle=(right+left)/2;
		
			while(left<right)
			{
				if((a[left]<=a[middle] && a[middle]<=a[right]) || (a[right]<=a[middle] && a[middle]<=a[left]))
				{
					if(a[left]>=a[right])
					{
						int temp=0;
						temp=a[left];
						a[left]=a[right];
						a[right]=temp;
					}
				}
				
				// To swap and put smallest no. in left, greatest no. in right when medium no. is in middle
				
				else if((a[middle]<=a[left] && a[left]<=a[right]) || (a[right]<=a[left] && a[left]<=a[middle]))
				{
					p=a[left];
					if(a[middle]>a[right])
					{
						a[left]=a[right];
						a[right]=a[middle];
						a[middle]=p;
					}
					else if(a[middle]<=a[right])
					{
						a[left]=a[middle];
						a[middle]=p;
					}
				}
				
				// To swap and put smallest no. in left, greatest no. in right when medium no. is in left
				
				else if((a[left]<=a[right]) && a[right]<=a[middle] || (a[middle]<=a[right] && a[right]<=a[left]))
				{
					p=a[right];
					if(a[middle]>a[left])
					{
						a[right]=a[middle];
						a[middle]=p;
					}
					else if(a[left]>=a[middle])
					{
						a[right]=a[left];
						a[left]=a[middle];
						a[middle]=p;
					}
				}
				
				// To swap and put smallest no. in left, greatest no. in right when medium no. is in right
				
				++left;
				--right;                                    
			}
			/* 
			 Here values of elements of left half array are less than the value of middle element of array
			 and values of elements of right half of array are larger than the value of middle element of array 
			*/
			
			if(max>left)                                   
				quickSortArray(a, max,  left); 
			 // To sort left half of array
			
			if(min<right)                                  
				quickSortArray(a, right,  min);
			 // To sort right half of array
			
			return a;
			// Returning sorted array
		}
	
}
