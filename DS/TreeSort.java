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
	private static BinaryTreeNode root;			//holding root
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);		//Scanner Class
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
				int dataOfTree = sc.nextInt();
				root = insert(root, dataOfTree);
				break;
			//To display students
			case 2:
				String sortedList = treeSorting(root);
				System.out.print(sortedList);
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
	private static BinaryTreeNode insert(BinaryTreeNode node, int data) 
	{
		
		if (node == null)
		{
			node = new BinaryTreeNode(data);
			System.out.println("root "+node.getNodeValue());
			System.out.println("data placed");
		} 
		else 
		{
			System.out.println("root "+node.getNodeValue());
			if (data <= node.getNodeValue()) 
			{
				System.out.println("left");
				node.left = insert(node.left, data);
			} 
			else 
			{
				System.out.println("right");
				node.right = insert(node.right, data);
			}
		}
		return node;
	}
	/**********************************
	 * node by node inorder traversing 
	 * @param node
	 * @return String containinng sorted 
	 * list of elements
	 *********************************/
	private static String treeSorting(BinaryTreeNode node) 
	{
		String sortedString = "";
		if (node != null) 
		{
			treeSorting(node.left);
			System.out.println(node.nodeValue);
			sortedString+=node.nodeValue;
			treeSorting(node.right);
		}
		return sortedString;
	}
}
