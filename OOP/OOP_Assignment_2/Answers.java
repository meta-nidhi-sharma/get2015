package SurveyApplication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
* @author Nidhi Sharma
*Description: The Class Answers will store the answers given by user of feedback questions
*/
public class Answers
{
	public static int number;	//to store participant number
	public static String answer1;	//To store string of answer of question 1
	public static String answer2="";	//To store string of answer of question 2
	public static String answer3="";	//To store string of answer of question 3
	public static HashMap<Integer,String> inputMap=new HashMap<Integer,String>();	//To store answers given by participants
	public static int index=0; 	//To store participant index
	public static String token[]=new String[5];	
	public static String result="";

	/******************************************
	 *Storing answers for every question in hashmap
	*******************************************/
	public HashMap<Integer,String> storeAnswer(int number,String answer1,String answer2,String answer3,HashMap<Integer, String> inputMap)
	{
		inputMap.put(number+1, answer1);
		inputMap.put(number+2, answer2);
		inputMap.put(number+3, answer3);
		return inputMap;
	}

	/***************************************************************
	 To display finalreport of each participant
	 *@param inputMap: answer string
	 *@param question: question string
	 *@param numOfParticipants: Number of participants who gave feedback
	 ***************************************************************/
	public void display(HashMap<Integer, String> inputMap,List<String> question,int numOfParticipants)
	{
		Iterator<Integer> keySetValue=inputMap.keySet().iterator();
		Integer key=1;
		for(index=0;index<numOfParticipants;index++)
		{
			System.out.println("Participant "+(index+1)+" : ");
			System.out.println("Ques "+question.get(0)+"\n"+inputMap.get(key));
			System.out.println("Ques "+question.get(1)+"\n"+inputMap.get(key+1));
			System.out.println("Ques "+question.get(2)+"\n"+inputMap.get(key+2));
			key+=3;
		}
		if(keySetValue.hasNext()==false)
			System.out.println("Do serve first");
	}
	
	/*********************************************************
	 * Total percentage distribution of answers
	 * *******************************************************/
	public void totalPercentage(HashMap<Integer, String> output,int numOfParticipants,int count)
	{
		int[] total=new int[5];
		Iterator<Integer> keySetValue=output.keySet().iterator();
		Integer key=1;
		if(numOfParticipants==0)
			System.out.println("Do serve first");
		else
		{
			//Calculating total number of selection for an answer
			while(keySetValue.hasNext() && key<=count)
			{
				if(Integer.parseInt(output.get(key))==1)
				{
					total[0]++;
				}
				if(Integer.parseInt(output.get(key))==2)
				{
					total[1]++;
				}
				if(Integer.parseInt(output.get(key))==3)
				{
					total[2]++;
				}
				if(Integer.parseInt(output.get(key))==4)
				{
					total[3]++;
				}
				if(Integer.parseInt(output.get(key))==5)
				{
					total[4]++;
				}
				key+=3;
			}	
			// Calculating total percentage for an answer
			for (index = 0; index < total.length; index++) 
			{
				total[index] = (total[index] * 100) / numOfParticipants;
				System.out.println((index + 1) + " := " + total[index] + "%");
			}
		}
	}

	/*********************************************************
	 * To check options whether it is valid or not
	 * @param value:  option selected by participants 
	 * @param question: question string
	 *********************************************************/
	public String checkOption(String value,String question)
	{
		if(question.equals("1 Overall Rating (1/2/3/4/5)")==true)         //if question is equal to 1st question
		{
			token=value.split(" ");
			if(token.length>1)                 //Condition to check the number of values entered by the user
			{
				System.out.println("Select only one option from available options");
				return result;
			}
			if(Integer.parseInt(token[0])==1 || Integer.parseInt(token[0])==2 || Integer.parseInt(token[0])==3 || Integer.parseInt(token[0])==4 || Integer.parseInt(token[0])==5)
			{
				return token[0];
			}
			else
			{
				//Condition to iterate again to enter the answer by the user if input is wrong
				System.out.println("Enter a vaid option");
				return result;
			}
		}
		else if(question.equals("2 Area of improvement (Service Quality/ Communication/ Delivery Process)")==true)
		{
			token=value.split("/");
			
			//Condition to check the number of values entered by the user
			if(token.length>3)
			{
				System.out.println("Enter values available from options only");
				return result;
			}
			//Condition to check the value entered by the user
			for(index=0;index<token.length;index++)
			{
				if(token[index].equalsIgnoreCase("Communication") || token[index].equalsIgnoreCase("Service Quality") || token[index].equalsIgnoreCase("Delivery Process"))
					result=result.concat(token[index]);
				else
				{
					//Condition to iterate again to enter the answer by the user if input is wrong
					System.out.println("Enter valid options");
					return result;
				}
			}
		}
		return value;
	}
}
