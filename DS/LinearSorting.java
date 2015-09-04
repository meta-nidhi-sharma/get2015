package SortingSystem;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author Nidhi Sharma
 * Date: 4 September,2015
 * Description : In Linear Sorting system will use Counting Sort or Radix Sort techniques (When large inputs(more than 2 digit) use Radix Sort else Counting Sort)
 */
public class LinearSorting
{
	/************************************************
	 * Peforming Counting Sorting for array having
	 * maximum elements of <=2 digits using counting
	 * sorting agorithm
	 ***********************************************/
	public int[] countingSort(int[] array, int max)
	{
		int k=0;				//To hold arrayIndex while sorting
		int[] countingArray = new int[max+1];		//array to count values number of occurence
		for(int i=0; i<array.length; i++)
		{
			countingArray[array[i]]++;
		}
		for(int i=0; i<countingArray.length; i++)
		{
			for(int j=0; j<countingArray[i];j++)
			{
				array[k] = i;
				k++;
			}
		}
		return array;				//returning sorted array
	}
	/************************************************
	 * Peforming Radix Sorting for array having
	 * maximum elements of >2 digits using Radix
	 * sorting agorithm
	 ***********************************************/
	public int[] radixSort(int[] array, int max)
	{
		@SuppressWarnings("unchecked")
		Queue<Integer>[] queueArray = new Queue[10]; 			//creating array of queues
		//Initializing queues
		for (int intialize = 0; intialize < 10; intialize++)
			queueArray[intialize] = new LinkedList<Integer>();

		int[] tempArray = new int[array.length];		//Temporary array 
		int remainder = 0;								//holding remainder
		int loopCounter = 0;							//loopCounter counting looping  
		while(loopCounter <  numberOfDigits(max))
		{
			//Assigning values in temporary array of actual array
			for(int i=0; i<array.length; i++)
				tempArray[i] = array[i];
			
			for(int i = 0; i<tempArray.length; i++)
			{
				int num = (int) (tempArray[i]/(Math.pow(10, loopCounter)));
				remainder = num % 10;
				queueArray[remainder].add(tempArray[i]);				//adding elements in queue
			}
			int k=0;						//To hold arrayIndex while sorting
			for(int j=0; j < queueArray.length ;j++)
			{
				while(!queueArray[j].isEmpty())
				{
					array[k] = queueArray[j].poll();				//Retrieves and removes the head of this queue
					k++;
				}
			}
			loopCounter++;
		}
		return array;				//returning sorted array
	}
	/******************************************
	 * Peforming bubble Sorting for array of
	 * size <=10 using bubble sort agorithm
	 *****************************************/
	public int numberOfDigits(int num)
	{
		int digits = 0;			//To hold number of digits in maximum number
		while(num!=0)
		{
			num/=10;
			digits++;
		}
		return digits;				//returning number of digits in maximum number
	}
}
