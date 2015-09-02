package BinarySearch;
/**
 * @author Nidhi Sharma
 * Date: 2 september,2015
 * Description: To search an element in array and return its position (leftmost position) using binary search algorithm
 */
import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchForLeftMostIndex
{
	private static int index = 0;		//holding index in arrayList
	private static ArrayList<Integer> arrayList = new ArrayList<Integer>();		//ArrayList to store sorted elements
	
	//Main 
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);		//Scanner Class
		arrayList.add(2);
		arrayList.add(4);
		arrayList.add(6);
		arrayList.add(6);
		arrayList.add(8);
		arrayList.add(10);
		do
		{
			System.out.println("1. To add new element");
			System.out.println("2. To search element");
			System.out.println("3. To Display array");
			System.out.println("4. Exit");
			int choice = sc.nextInt();		//to hold user's choice of operation
			
			switch(choice)
			{
				//Add element in arrayList
				case 1:
					addElement();
					break;
				//To search element in arrayList
				case 2:
					System.out.println("Enter element to search");
					int data = sc.nextInt();			//data to find in list
					int position = searchElement(data,0,arrayList.size()-1, arrayList);		//holding location of element in arraylist
					if(position >= 0)
						System.out.println("Position of element is "+position);
					else
						System.out.println("Element not found");
					break;
				//To display List
				case 3:
					displayList();
					break;
				//To exits
				case 4:
					System.exit(0);
					break;
				//Default case
				default:
					System.out.println("Invalid Option");
					break;
			}
		}
		while(true);
	}
	
	/*******************************
	 * To add Elements in arrayList
	 *******************************/
	private static void addElement()
	{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);		//Scanner Class
		int value=0;								//Holding value to insert in list
		System.out.println("Enter value");
		if(!arrayList.isEmpty())						//To check for list is not empty
		{
			do
			{
				System.out.println("Enter sorted value");
				value = sc.nextInt();
			}while(value < arrayList.get(index-1));
		}
		else 
			value = sc.nextInt();			//if list is empty
		arrayList.add(value);				//adding element in arrayList
		index++;	
	}
	
	private static int location =-1;				//to hold position of data in list to traverse left list
	
	/******************************
	 * To search location of element
	 * in list
	 * @param data
	 * @param start
	 * @param end
	 * @return location
	 *****************************/
	public static int searchElement(int data, int start, int end, ArrayList<Integer> array)
	{
		int mid = (start+end)/2;		//to hold middle positions
		//condition for traversing list
		if(end >=0 && start< array.size() && start <=end)
		{
			//if list is empty return -1;
			if(array.isEmpty())
			{
				System.out.println("arrayList empty..");
				return location;
			}
			//if data found search for occurancein left
			else if(data == array.get(mid))
			{
				location = mid;
				System.out.println(location);
				return searchElement(data, start, mid-1, array);
			}
			else if(data < array.get(mid))
				return searchElement(data, start, mid-1, array);
			else 
				return searchElement(data, mid+1, end, array);	
		}
		else
			return location;		//Returning index of leftmost occurance of element to be found
	}
	
	/*******************************
	 * To display sorted arrayList
	 ******************************/
	public static void displayList()
	{
		//displaying each element
		for(Integer value : arrayList)
			System.out.println(value);
	}
}
