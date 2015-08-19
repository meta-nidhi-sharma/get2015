package SurveyApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
* @author Nidhi Sharma
*Description: This class contains the list of questions to be asked from user in feedback form
*/

public class Questions
{
	public static String location="D:/questions.csv";	//String Variable to store location of file containing questions
	public static List<String> question=new ArrayList<String>();	//List string containing question
	public static String line="";                                   //To read line from questions file
	
	/*****************************************************
	  Function to return questions of survey form
	 *****************************************************/
	
	public static List<String> readQuestions()
	{
		try
		{
			//Reading the questions stored in the csv file
			BufferedReader br=new BufferedReader(new FileReader(location));
			while((line=br.readLine())!=null)
			{
				String[] token=line.split(",");
				//Questions are added in the list of string type
				question.add(token[0]+" "+token[1]);
			}
			br.close();		
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return question;             // Returning list of strings containg questions of feedback form
	}                                          
}

