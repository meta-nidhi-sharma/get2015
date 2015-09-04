package SortingSystem;

import java.util.Scanner;
/**
 * @author Nidhi Sharma
 * Date: 4 September,2015
 * Description :  In Comparison Sorting system will use Bubble Sort or Quick Sort techniques (When less number of inputs (input elements <= 10) use Bubble Sort else Quicksort)
 */
public class ComparisonSorting
{
	Scanner sc;			//Scanner
	/******************************************
	 * Peforming bubble Sorting for array of
	 * size <=10 using bubble sort agorithm
	 *****************************************/
	public int[] bubbleSort(int[] array)
	{
		int indexOfUnsortedElement = array.length-1;			//to hold loop end limit
		boolean swapped;						//Indication for swapping
		do
		{
			swapped = false;
			for(int count=0; count < indexOfUnsortedElement; count++)
			{
				if(array[count] > array[count+1])
				{
					//swapping
					swap(count, count+1 , array);
					swapped = true;
				}
			}
			indexOfUnsortedElement--;
		}while(swapped);
		
		return array;			//returning sorted array
	}
	/*****************************************
	 * Peforming Quick Sorting for array of
	 * size >10 using quick sort agorithm 
	 * taking 1st element as pivot
	 ****************************************/
	public int[] quickSort(int startIndex, int endIndex, int[] array)
	{
		if(startIndex <= array.length-1 && endIndex >=0 && startIndex < endIndex)
		{
			int pivotIndex = startIndex;				//taking startIndex as pivot
			int storeIndex = pivotIndex+1;				//storing pivot index+1 to perform swapping
			for(int count = pivotIndex+1; count <= endIndex; count++)
			{
				if(array[count] < array[pivotIndex])
				{
					swap(count, storeIndex,array);			//swapping
					storeIndex++;
				}
			}
			swap(pivotIndex, storeIndex-1 , array);			//swapping pivot element to its right place
			
			quickSort(startIndex, storeIndex-2, array);		//sorting left segment of pivot
			quickSort(storeIndex, endIndex, array);			//sorting right segment of pivot
		}
		return array;					//returning sorted array
	}
	/***************************************************************************
	 * Swapping array elements of given index
	 ***************************************************************************/
	public void swap(int x, int y, int[] array)
	{
		int temp = array[x];		//holding one of the element value to perform swapping
		array[x] = array[y];
		array[y] = temp;
	}
}
