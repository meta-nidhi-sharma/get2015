package DSAssignment1;
/**
 * @ Nidhi
 * Date: 25 august,2015
 * Description: Linkedlist to perform different functions
 */
import java.util.Scanner;

public class LinkedList
{
	public Node start;
	private static Scanner sc;
	
	// Adding an item into linked list
	void createLinkedList(int item) 
	{
		Node newNode = new Node(item, null);
		Node temp;
		if (start == null)
		{
			start = newNode;
		}
		else 
		{
			temp = start;
			while (temp.getNext() != null) 
			{
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
	}

	/***************************************
	 * Inserting item at given location
	 * @param item
	 * @param index
	 **************************************/
	public void insertAtParticularPosition(int item, int index) 
	{
		Node newNode = new Node(item, null);
		Node temp = start;
		int count;
		if (index == 0) 
		{
			newNode.setNext(start);
			start = newNode;
		}
		for (count = 0; count < index - 1; count++) 
		{
			temp = temp.getNext();
			if (temp == null)
			{
				System.out.println("Location doesn't exist");
				return;
			}
		}
		newNode.setNext(temp.getNext());
		temp.setNext(newNode);
	}

	/*************************************
	 * traversingLinkedlist
	 **************************************/
	void traversalLinkedList() 
	{
		Node temp = start;
		System.out.println("The linked list is.. ");
		while (temp != null) 
		{
			System.out.print(temp.getValue()+"\t");
			temp = temp.getNext();
		}
	}

	/*************************************
	 * traversingLinkedlist
	 **************************************/
	void retrievalAtIndex(int index)
	{
		Node temp = start;
		int count;
		for (count = 1; count <= index; count++)
		{
			temp = temp.getNext();
		}
		System.out.println("The value at index is " + temp.getValue());
	}

	/*************************************
	 * traversingLinkedlist
	 **************************************/
	public void deleteItemOnIndex(int index)
	{
		Node temp = null, current = start;
		int count;
		if (index == 0)
		{
			start = current.getNext();
		} 
		else
		{
			for (count = 1; count <= index; count++)
			{
				temp = current;
				current = current.getNext();
			}
			System.out.println("Node deleted " + current.getValue());
			temp.setNext(current.getNext());
		}
	}

	/*************************************
	 * traversingLinkedlist
	 **************************************/
	public void deleteItemOnValue(int item) 
	{
		Node current = start;
		Node temp = current;
		if (start == null)
		{
			System.out.println("Empty List");
		} 
		else 
		{
			while (current != null)
			{
				if (current.getValue() == item)
				{
					if (temp == start) {
						start = temp.getNext();
						return;
					} 
					else 
					{
						temp.setNext(current.getNext());
						return;
					}
				}
				temp = current;
				current = current.getNext();
			}
		}
	}

	/*************************************
	 * traversingLinkedlist
	 **************************************/
	void reverse() 
	{
		Node prev = null;
		Node temp = start;
		Node next = temp.getNext();
		while (temp != null) 
		{
			if (next == null)
				break;
			temp.setNext(prev);
			prev = temp;
			temp = next;
			next = next.getNext();
		}
		temp.setNext(prev);
		start = temp;
	}

	/*************************************
	 * traversingLinkedlist
	 **************************************/
	void sortLinkedList()
	{
		Node temp, current = start;
		int check;
		while (current != null) // apply simple sorting to sort the elements of
		// Linked list
		{
			temp = start;
			while (temp.getNext() != null) 
			{
				if (temp.getValue() > temp.getNext().getValue()) 
				{
					check = temp.getValue();
					temp.setValue(temp.getNext().getValue());
					temp.getNext().setValue(check);
				}
				temp = temp.getNext();
			}
			current = current.getNext();
		}

	}

	/*************************************
	 * MainClass
	 **************************************/
	public static void main(String args[])
	{
		LinkedList linkList = new LinkedList();
		int ch, item, loc;
		sc = new Scanner(System.in);
		while (true) 
		{
			System.out.print("\n 1. Create Linked List"
					+ "\n 2. Add Element at particular Location"
					+ "\n 3. Removal of an item based on its value "
					+ "\n 4. Removal of an item based on its index"
					+ "\n 5. Retrieval of an item of particular index"
					+ "\n 6. Reversal of linked list"
					+ "\n 7. Sorting of linked list"
					+ "\n 8. Display linked list" + "\n 9. Exit");
			System.out.print("\n Enter Your choice : ");
			ch = sc.nextInt();			//choice of user to perform particular function
			switch (ch) // Apply switch case and call corresponding method
			// according to the user's choice
			{
				case 1:
					System.out.print("\n Enter node value : ");
					item = sc.nextInt();
					linkList.createLinkedList(item);
					break;
				case 2:
					System.out.print("\n Enter node value : ");
					item = sc.nextInt();
					System.out.print("\n Enter Location : ");
					loc = sc.nextInt();
					linkList.insertAtParticularPosition(item, loc);
					break;
				case 3:
					System.out.print("\n Enter node value : ");
					item = sc.nextInt();
					linkList.deleteItemOnValue(item);
					break;
				case 4:
					System.out.print("\n Enter Location : ");
					loc = sc.nextInt();
					linkList.deleteItemOnIndex(loc);
					break;
				case 5:
					System.out.print("\n Enter Location : ");
					loc = sc.nextInt();
					linkList.retrievalAtIndex(loc);
					break;
				case 6:
					linkList.reverse();
					break;
				case 7:
					linkList.sortLinkedList();
					break;
				case 8:
					linkList.traversalLinkedList();
					break;
				case 9:
					System.exit(0);
			}
		}
	}
}
