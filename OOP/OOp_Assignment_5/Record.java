package SocialNetwork;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: Record to search other users by name or emailID
 */
import java.util.Scanner;

public class Record
{
	/*****************************************
	 * To search other users by name
	 *****************************************/
	void recordByName(ArrayList<Entity> entityList) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int repetationChoice;
		do{
			System.out.println("Enter name of user you want to search");
		
		String name = sc.next();
		java.util.Iterator<Entity> par1 = entityList.iterator();
		while (par1.hasNext()) 
		{
			Entity person = par1.next();
			if((person.userName).compareToIgnoreCase(name)==0)
			{
			System.out.println(person.userType + "\t\t" + person.userName
					+ "\t" + person.userEmail_ID + "\t" + person.userContactNumber);
			break;
			}
		}
		System.out.println("Do you want to search another friend(if yes, press 1)");
		repetationChoice = sc.nextInt();
		}while(repetationChoice==1);
		sc.close();
	}
	
	/*****************************************
	 * To search other users by emailID
	 *****************************************/
	void recordByEmail_ID(ArrayList<Entity> entityList)
	{
		Scanner sc = new Scanner(System.in);
		int repetationChoice;
		do
		{
		System.out.println("Enter Email");
		String email = sc.next();
		java.util.Iterator<Entity> par1 = entityList.iterator();
			while (par1.hasNext()) 
			{
				Entity person = par1.next();
				if((person.userEmail_ID).compareToIgnoreCase(email)==0)
				{
					System.out.println(person.userType + "\t\t" + person.userName
							+ "\t" + person.userEmail_ID + "\t" + person.userContactNumber);
					break;
				}
			}
			System.out.println("Do you want to search another friend(if yes, press 1)");
			repetationChoice = sc.nextInt();
			}while(repetationChoice==1);
		sc.close();
	}
}
