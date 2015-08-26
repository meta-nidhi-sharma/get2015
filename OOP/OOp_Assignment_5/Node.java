package SocialNetwork;
/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: To create new node
 */
import java.util.Scanner;

public class Node 
{
	/**************************
	 * creating Node or sign up
	 ****************************/
	void createNode()
	{
		SocialNetwork sn = new SocialNetwork();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your userName");
		String name = sc.next();
		System.out.println("Enter email_ID");
		String email_ID = sc.next();
		System.out.println("Enter contactNumber");
		String contactNumber = sc.next();
		System.out.println("how you want to signup\n1. As a person\n2.As a Organization");
		int choice2 = sc.nextInt();
		if(choice2 == 1)
		{
			String type = "Person";
			System.out.println("Enter your Interest separating them using (/)");
			String interest = sc.next();
			System.out.println("Enter your Hobbies separating them using (/)");
			String hobbies = sc.next();
			Person person = new Person(type, name , email_ID , contactNumber, interest, hobbies);
			sn.detailsListOfPerson.add(person);
			
			//Display New list
			java.util.Iterator<Person> par1 = sn.detailsListOfPerson.iterator();
			while (par1.hasNext()) 
			{
				Person pass = par1.next();
				System.out.println(pass.userType + "\t\t" + pass.userName
						+ "\t" + pass.userEmail_ID + "\t" + pass.userContactNumber + "\t" + pass.interests + "\t" + pass.hobbies);		
			}
		}
		else if(choice2 == 2)
		{
			String type = "Organization";
			System.out.println("Enter your Courses separating them using (/)");
			String courses = sc.next();
			System.out.println("Enter your placements separating them using (/)");
			String placement = sc.next();
			Person person = new Person(type, name , email_ID , contactNumber, courses, placement);
			sn.detailsListOfPerson.add(person);
			
			//Display New list
			java.util.Iterator<Organization> par2 = sn.detailsListOfOrganization.iterator();
			while (par2.hasNext()) 
			{
				Organization pass = par2.next();
				System.out.println(pass.userType + "\t\t" + pass.userName
						+ "\t" + pass.userEmail_ID + "\t" + pass.userContactNumber + "\t" + pass.courses + "\t" + pass.placement);
						
			}
		}
		else
			System.out.println("Invalid Type");
		sc.close();
	}	
}
