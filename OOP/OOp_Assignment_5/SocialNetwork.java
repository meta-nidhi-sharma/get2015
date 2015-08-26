package SocialNetwork;
/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: SocialNetwork containing menu where reading all available data
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SocialNetwork 
{
	ArrayList<Person> detailsListOfPerson = new ArrayList<Person>();
	ArrayList<Organization> detailsListOfOrganization = new ArrayList<Organization>();
	ArrayList<Entity> entityList = new ArrayList<Entity>();
	
	/**************************************************
	 * Reading data from file
	 **************************************************/
	public ArrayList<Entity> menu()
	{	
		BufferedReader br = null;				// input BY file
		try
		{
			StringTokenizer stringTokenizer;		//To separate content of one train in list
			FileInputStream fin = new FileInputStream(
					new File("D:/Entity_Data.txt"));	// File reader
			DataInputStream in = new DataInputStream(fin);			//data reader
			br = new BufferedReader(new InputStreamReader(in));		//buffer reader to read information
			
				String userData = "";		//containing information of individual train
				int i = 1;					//for counting tokens
				
				String userType = "", userName = "", userEmail_ID= "", userContactNumber = "", userInterest = "", userHobbies = "",userCourses="", userPlacement ="";
				while ((userData = br.readLine()) != null)
				{
					stringTokenizer = new StringTokenizer(userData, ",");
					i = 1;
					
					//organizing token by assigning them to different strings
					while (stringTokenizer.hasMoreTokens())
					{
						if(i==1)
						{
							userType = stringTokenizer.nextToken();	
						}
						else if(i==2)
						{
							userName = stringTokenizer.nextToken();
						} 
						else if(i==3)
						{
							userEmail_ID = stringTokenizer.nextToken();
						}
						else if(i==4)
						{
							userContactNumber = stringTokenizer.nextToken();
						}
						else if(i==5)
						{
							if (userType.compareTo("Person") == 0)
								userInterest = stringTokenizer.nextToken();
							else
								userCourses = stringTokenizer.nextToken();
						}
						else if(i==6)
						{
							if (userType.compareTo("Person") == 0)
								userHobbies = stringTokenizer.nextToken();
							else
								userPlacement = stringTokenizer.nextToken();
						}						
						i++;
					}					
					if (userType.equalsIgnoreCase("Person"))
					{
						detailsListOfPerson.add(new Person(userType, userName,userEmail_ID,userContactNumber, userInterest, userHobbies));
					}
					else if (userType.equalsIgnoreCase("Organization"))
						
					{
						detailsListOfOrganization.add(new Organization(userType, userName,userEmail_ID, userContactNumber,userCourses,userPlacement));	
					}
					else
					{
						System.out.print("Plz Enter a valid input");
					}
				} 
				entityList.addAll(detailsListOfPerson);
				entityList.addAll(detailsListOfOrganization);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally 
			{
				try
				{
					if (br != null)
						br.close();
				} 
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		return entityList;
		}
	
	}
