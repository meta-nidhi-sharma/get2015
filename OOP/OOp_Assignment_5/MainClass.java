package SocialNetwork;
/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: Main class and also contain perform operation containing list of operations
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass
{
	/*************************
	 * Main function
	 * @param args
	 * @throws IOException
	 **********************/
	public static void main(String args[]) throws IOException
	{		
		Scanner sc = new Scanner(System.in);
		SocialNetwork sn = new SocialNetwork();
		ArrayList<Entity> entityList = sn.menu();
		displayAllNodes(entityList);
		Connection connection = new Connection();
		connection.setConnectionList();
		performOperations(entityList);
		
		sc.close();
	}
	
	/*************************************************	
	To perform sign in, sign up functions
	 * @throws IOException 
	*************************************************/	
	public static void performOperations(ArrayList<Entity> entityList) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Sign_IN\n2. Sign_UP");
		int choice1 = sc.nextInt();
		int validation=0;
		if (choice1 == 1)
		{
			System.out.println("UserName:");
			String userName1 = sc.next();
			System.out.println("Password:");
			String password = sc.next();
			System.out.print("****");
				java.util.Iterator<Entity> par1 = entityList.iterator();
				while (par1.hasNext()) 
				{
					Entity pass = par1.next();
					System.out.println(pass.userName);
					if((pass.userName).compareToIgnoreCase(userName1)==0)
					{
						System.out.println(pass.userName);
						System.out.println(userName1);
						validation=1;
						break;	
					}
				}
				if(validation==1)
				{
				System.out.println("successfully logged in");
				Connection connection = new Connection();
				System.out.println("1. To perform connections operation\n2. To perform search record operations");
				int ch = sc.nextInt();
				if(ch == 1)
				{
					System.out.println("1. Add Connection\n2. Remove Connection");
					int choice = sc.nextInt();
					switch(choice)
					{
						case 1:
						{
							System.out.println("Enter name of user you want to connect to");
							String friendname = sc.next();
							connection.add(userName1,friendname);
							break;
						}
						case 2:
						{
							System.out.println("Enter name of user you want to remove");
							String friendname = sc.next();
							connection.remove(userName1,friendname);
							break;
						}
						default:
							break;
					}
				}
				else if(ch == 2)
				{
					System.out.println("1. Search by name\n2. Search by email_ID");
					int choice = sc.nextInt();
					switch(choice)
					{
						case 1:
						{
							Record record = new Record();
							record.recordByName(entityList);
						}
						case 2:
						{
							Record record = new Record();
							record.recordByEmail_ID(entityList);
						}
						default:
							break;
					}
				}
			}
			else
			{
				System.out.println("user doesn't exist\nplease sign up");
				Node node = new Node();
				node.createNode();
			}
					
		}	
		else if(choice1 == 2)
		{
			Node node = new Node();
			node.createNode();
		}
		else
			System.out.println("Invalid");
		sc.close();
	}
	
	private static void displayAllNodes(ArrayList<Entity> entityList)
	{
		java.util.Iterator<Entity> par1 = entityList.iterator();
		while (par1.hasNext()) 
		{
			Entity pass = par1.next();
			System.out.println(pass.userType+"\t"+pass.userName+"\t"+pass.userEmail_ID+"\t"+pass.userContactNumber);
		}
	}
	
}
