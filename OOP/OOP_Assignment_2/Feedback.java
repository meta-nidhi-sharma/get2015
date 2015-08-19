package SurveyApplication;

/**
 *@author Nidhi Sharma
 * Description: It is a feedback report which consists of choices whether the user wants to give feedback or to see report.
 */

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;

public class Feedback 
{
	
	/*************************************
	 * Main Function
	 *************************************/
	public static void main(String[] args)
	{
		List<String> question=new  ArrayList<String>();
		question=Questions.readQuestions();                    //returning questions from Questions Class containing readQuestions function
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		int count=0,y=0,numOfParticipants=0;
		List<String> participantAnswers=new ArrayList<String>();
		String value="";
		String result="";
		HashMap<Integer,String> outputMap=new HashMap<Integer,String>();
		Answers object=new Answers();
		int option;
		try
		{
			do
			{
				System.out.println("Enter your choice:");
				System.out.println("1. Give Feedback");
				System.out.println("2. Total Percentage Distribution");
				System.out.println("3. Final Output");
				System.out.println("4. Exit");
				option=Integer.parseInt(sc.readLine());
				switch(option)
				{
					case 1:
					{	
						//If user wants to give the Feedback and answer the questions increment Number of participants by 1
						numOfParticipants++;
						for(String s:question)
						{
							do
							{
								System.out.println(s);
								value=sc.readLine();
								result=object.checkOption(value,s);
							}
							while(result.equals(""));
								participantAnswers.add(result);
						}
						outputMap =object.storeAnswer(count,participantAnswers.get(0),participantAnswers.get(1),participantAnswers.get(2),outputMap);
						count+=3;
						participantAnswers.clear();
						break;
					}
					case 2:
					{
						//If user wants the percentage for an option opted by the participants
						object.totalPercentage(outputMap, numOfParticipants,count);
						break;
					}
					case 3:
					{
						//If user wants to see all the answers for all participants
						object.display(outputMap, question,numOfParticipants);
						break;
					}
					case 4:
					{
						//If user wants to exit from the program
						System.out.println("Thanks for visitng. Have a nice day, Bye");
						System.exit(0);
					}
					default:
					{
						//If user enters a value other than available options
						System.out.println("Enter a value from the available options");
						break;
					}
				}
				System.out.println("Press 0 to continue or 1 to exit");
				y=Integer.parseInt(sc.readLine());
			}while(y==0);
		}
		catch(Exception e)
		{
			System.out.println("ENTER A VALID INTEGER VALUE");
		}
	}
}


	
