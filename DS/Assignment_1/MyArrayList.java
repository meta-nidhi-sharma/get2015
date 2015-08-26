package DSAssignment1;
/**
 * @ Nidhi
 * Date: 25 august,2015
 * Description: Arraylist to perform different functions
 */
import java.util.Scanner;

public class MyArrayList 
{
	private int myArray[];
	private int size = 0;

	public MyArrayList() 
	{
		myArray = new int[10];
	}

	// will merge two lists <q.2>
	public MyArrayList mergeLists(MyArrayList arrayList, MyArrayList arrayList1) 
	{
		for (int i = 0; i < arrayList1.size; i++) 
		{
			arrayList.addElement(arrayList1.getItem(i));
		}
		return arrayList;
	}

	// Adding an item into array list and check if list is full, then resizing
	// the arraylist
	public void addElement(int item) 
	{
		if (size < myArray.length) 
		{
			myArray[size] = item;
			size++;
		} 
		else 
		{
			int newArray[] = new int[myArray.length + 5];
			for (int i = 0; i < myArray.length; i++) 
			{
				newArray[i] = myArray[i];
			}
			newArray[size] = item;
			size++;
			myArray = newArray;
		}
	}

	// Adding an item into array list at the given particular location i
	public int[] addElementAtPosition(int index, int item) 
	{
		for (int i = size; i > index; i--)
		{
			myArray[i] = myArray[i - 1];
		}
		myArray[index] = item;
		size++;
		return myArray;
	}

	// Retrieving the first occurrence of an item
	public int retrievingPosition(int obj)
	{
		for (int i = 0; i < size; i++)
		{
			if (myArray[i] == obj) 
			{
				return i;
			}
		}
		return -1;
	}

	// Retrieving the first occurrence of an item based on its given location
	public int retrievingPositionBasedOnLocation(int obj, int position)
	{
		for (int i = position; i < size; i++)
		{
			if (myArray[i] == obj) 
			{
				return i;
			}
		}
		return -1;
	}

	// Removing an item based on particular location
	public int[] removeAtIndex(int index)
	{
		for (int i = index; i < size; i++)
		{
			myArray[i] = myArray[i + 1];
		}
		size--;
		return myArray;
	}

	// Remove given particular item from the arraylist
	public int[] removeItem(int item) 
	{
		for (int i = 0; i < size; i++) 
		{
			if (myArray[i] == item)
			{
				for (int j = i; j < size - 1; j++) 
				{
					myArray[j] = myArray[j + 1];
				}
			}
		}
		size--;
		return myArray;
	}

	// print all elements
	public void printAllElements() 
	{
		for (int i = 0; i < size; i++) 
		{
			System.out.println(myArray[i]);
		}
	}

	// Return Reverse of arraylist
	public void reverseArrayList()
	{
		int start = 0, end = size - 1;
		int temp;
		while (start <= end) 
		{
			temp = myArray[start];
			myArray[start] = myArray[end];
			myArray[end] = temp;
			start++;
			end--;
		}
	}

	// will return value at given position
	public int getItem(int index)
	{
		return myArray[index];
	}

	// Clear the list i.e. remove all the elements of the list
	public void clearList() 
	{
		size = 0;
	}

	@SuppressWarnings("resource")
	public static void main(String args[])
	{

		MyArrayList arrayList = new MyArrayList();
		int ch, item, loc;
		Scanner sc = new Scanner(System.in);
		while (true) 
		{
			System.out.print("\n 1. Adding an item "
							+ "\n 2. Adding an item into array list at the given particular location i"
							+ "\n 3. Retrieving the first occurrence of an item based on its given location"
							+ "\n 4. Retrieving the first index of particular item in the arraylist"
							+ "\n 5. Removing an item based on particular location"
							+ "\n 6. Remove given particular item from the arraylist  "
							+ "\n 7. Clear the list i.e. remove all the elements of the list"
							+ "\n 8. Reverse the arraylist"
							+ "\n 9.Display List"
							+"\n 10. Merge arraylists" + "\n 11.Exit");
			System.out.print("\n Enter Your Choice : ");
			ch = sc.nextInt();
			switch (ch) // Apply switch case and call corresponding method
						// according to the choice
			{
			//Adding an item
			case 1:
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				arrayList.addElement(item);
				break;
			//Adding an item into array list at the given particular location i
			case 2:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				arrayList.addElementAtPosition(loc, item);
				break;
			//Retrieving the first occurrence of an item based on its given location
			case 3:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				System.out.print("\n Enter Item : ");
				item = sc.nextInt();
				loc = arrayList.retrievingPositionBasedOnLocation(item, loc);
				if(loc>=0)
					System.out.print(loc);
					else
						System.out.print("Element not available in list");
				break;
			// Retrieving the first index of particular item in the arraylist
			case 4:
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				loc =arrayList.retrievingPosition(item);
				if(loc>=0)
					System.out.print(loc);
				else
					System.out.print("Element not available in list");
				break;
			// Removing an item based on particular location	
			case 5:
				System.out.print("\n Enter Location : ");
				loc = sc.nextInt();
				arrayList.removeAtIndex(loc);
				break;
			//Remove given particular item from the arraylist	
			case 6:
				System.out.print("\n Enter item : ");
				item = sc.nextInt();
				arrayList.removeItem(item);
				break;
			//Clear the list i.e. remove all the elements of the list	
			case 7:
				arrayList.clearList();
				break;
			//Reverse the arraylist	
			case 8:
				arrayList.reverseArrayList();
				break;
			//Display List
			case 9:
				arrayList.printAllElements();
				break;
			//Merge arraylists
			case 10:
				MyArrayList arrayList1 = new MyArrayList();
				arrayList1.addElement(6);
				arrayList1.addElement(7);
				arrayList1.addElement(9);
				arrayList.mergeLists(arrayList, arrayList1);
				break;
			//Exit	
			case 11:
				System.exit(0);
			}
		}
	}

}
