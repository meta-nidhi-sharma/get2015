package SortingSystem;

import java.util.Scanner;
/**
 * @author Nidhi Sharma
 * Date: 4 September,2015
 * Description : Main Function for whole sorting process according to user's choice and input elements
 */
public class MainSorting 
{
	//Main
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);		//Scanner Class
		System.out.println("Hello Dear :");
		do
		{
			//Operations 
			System.out.println("Enter your choice of sorting");
			System.out.println("1. Comparison Sorting");
			System.out.println("2. Linear Sorting");
			System.out.println("3. Exit");
			
			int choice = sc.nextInt();		//holding user's choice of operation
			switch(choice)
			{
			//For Comparison Sorting
			case 1:
				comparisonSortingProcess();
				break;
			//For Linear Sorting	
			case 2:
				linearSortingProcess();
				break;
			// To Exit
			case 3:
				sc.close();
				System.exit(0);
				break;
			//Default Case
			default:
				System.out.println("Invalid Input");
				break;
			}
		}while(true);
	}
	/***************************************************************************
	 * Process for Comparison Sorting:Taking number of elements in array and
	 * performing bubble sort for less than or equal to 10 elements and Quick
	 * sorting for more than 10 elements
	 ***************************************************************************/
	public static void comparisonSortingProcess()
	{
		int[] sortedArray;									//holding sorted array
		ComparisonSorting cs = new ComparisonSorting();		//creating object
		final int SIZE_LIMIT_FOR_COMPARISON_SORTING = 10;		//finalizing limit
		int[] inputArray = getInputFromUserForArray();			//taking input array from fumction "getInputFromUserForArray()"
		
		//Performing sorting and calling display function to display sorted array
		if(inputArray.length <= SIZE_LIMIT_FOR_COMPARISON_SORTING)
		{
			sortedArray = cs.bubbleSort(inputArray);
			System.out.println("System has used 'BUBBLE' sorting technique and sorted list as below :");
			displaySortedArray(sortedArray);
		}
		else
		{
			 sortedArray = cs.quickSort(0, inputArray.length-1 , inputArray);
			 System.out.println("System has used 'QUICK' sorting technique and sorted list as below :");
			displaySortedArray(sortedArray);
		}
	}
	/***************************************************************************
	 * Process for Linear Sorting:Taking number of elements in array and
	 * performing Counting Sort for array of elements having values of at most 
	 * two(2) digits and Radix Sort for remaining
	 ***************************************************************************/
	public static void linearSortingProcess()
	{
		int[] sortedArray;			//holding sorted array
		LinearSorting ls = new LinearSorting();
		final int DATA_VALUE_LIMIT = 99;
		int[] array = getInputFromUserForArray();
		int maxElement = maximumElement(array);
		
		//Performing sorting and calling display function to display sorted array
		if(maxElement <= DATA_VALUE_LIMIT)
		{
			sortedArray = ls.countingSort(array, maxElement);
			System.out.println("System has used 'COUNTING' sorting technique and sorted list as below :");
			displaySortedArray(sortedArray);
		}
		else
		{
			sortedArray = ls.radixSort(array, maxElement);
			System.out.println("System has used 'RADIX' sorting technique and sorted list as below :");
			displaySortedArray(sortedArray);
		}
	}
	/***************************************************************************
	 * Taking Input from user for array to sort like:
	 * Number of elements in array as "numberOfElements" an array elements
	 ***************************************************************************/
	public static int[] getInputFromUserForArray()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);			//Scanner Class
		System.out.println("Enter number of elements in array");
		int numberOfElements = sc.nextInt();			//holding number of elements in array
		int[] array = new int[numberOfElements];		//Declaring array
		
		//Adding elements in array
		System.out.println("Enter elements");
		for(int count=0; count<numberOfElements; count++)
			array[count] = sc.nextInt();
		
		return array;			//returning array
	}
	/******************************************************
	 * To find maximum element in array for linear sorting
	 * taking array as input
	 ******************************************************/
	public static int maximumElement(int[] array)
	{
		int max=0;				//to hold maximun element
		//storing maximum in max
		for(int count =0 ; count<array.length; count++)
		{
			if(array[count] > max)
				max = array[count];
		}
		return max;			//returning maximum element
	}
	/**************************
	 * Displaying sorted array 
	 *************************/
	public static void displaySortedArray(int[] sortedArray)
	{
		for(int count=0 ; count < sortedArray.length; count++)
			System.out.println(sortedArray[count]);
	}
}
