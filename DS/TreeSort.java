package TreeSort;

import java.util.Scanner;
/**
 * @author Nidhi Sharma
 * Date: 26 august,2015
 * Description : TreeSort class creating tree in binary form of student ids
 * also performing sorting of student IDs(using inorder traversing)
 */
public class TreeSort 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);		//Scanner Class
		BinaryTreeNode root = null;			//holding root
		do
		{
			System.out.println("Enter your choice of operation");
			System.out.println("1. To add student");
			System.out.println("2. To display students");
			System.out.println("3. To Exit");
			//holding user's choice of operation
			int choice = sc.nextInt();
			switch(choice)
			{
			//To add student
			case 1: 
				System.out.print("Enter a value : ");
				Integer dataOfTree = sc.nextInt();
				root = insert(root, dataOfTree);
				System.out.println("data placed "+root.nodeValue);
				break;
			//To display students
			case 2:
				String sortedList = treeSorting(root);
				System.out.println("Sorted IDS in String are : "+sortedList);
				break;
			//To Exit
			case 3:
				sc.close();
				System.exit(0);
				break;
			//Default
			default:
				System.out.println("Invalid choice");
				break;
			}
		}while(true);
	}
	/************************
	 * insert data in node
	 * @param node
	 * @param data
	 * @return
	 ************************/
	public static BinaryTreeNode insert(BinaryTreeNode node, Integer data) 
	{
		
		if (node == null)
			node = new BinaryTreeNode(data); 
		else 
		{
			if (data <= node.getNodeValue()) 
				node.left = insert(node.left, data);
			else 
				node.right = insert(node.right, data);
		}
		return node;
	}
	/**********************************
	 * node by node inorder traversing 
	 * @param node
	 * @return String containinng sorted 
	 * list of elements
	 *********************************/
	static String sortedString = "";			//To hold sorted ids in string
	public static String treeSorting(BinaryTreeNode node) 
	{
		if(node != null)
		{
			treeSorting(node.left);
			String s = Integer.toString(node.nodeValue);
			sortedString = sortedString.concat(" "+s);
			treeSorting(node.right);
		}
		return sortedString;
	
	}
}
