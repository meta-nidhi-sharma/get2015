package SocialNetwork;
/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: to add and remove connections and also setting connections in hashmap
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Connection 
{

	ArrayList<String> friendsList = new ArrayList<String>();		//friendlist containing friends
	Map<String,List<String>> connectionMap = new HashMap<String,List<String>>();		//hashmap to map connections

	/***************************************
	 * To add connection
	 * @param userName
	 * @param friendName
	**************************************/
	void add(String userName, String friendName)			
	{
		Graph graph = new Graph();
		graph.addEdge(userName,friendName,connectionMap);
	}
	/***************************************
	 * To remove connection
	 * @param userName
	 * @param friendName
	**************************************/
	void remove(String userName, String friendName)
	{
		Graph graph = new Graph();
		graph.removeEdge(userName,friendName,connectionMap);
	}
	
	/******************************************
	 * To set connections in list from file
	 *******************************************/
	void setConnectionList() 
	{
		BufferedReader br = null; // input BY file
		try 
		{
			StringTokenizer stringTokenizer; // To separate content of one train
												// in list
			FileInputStream fin = new FileInputStream(new File(
					"D:/Connection_List.txt")); // File reader
			DataInputStream in = new DataInputStream(fin); // data reader
			br = new BufferedReader(new InputStreamReader(in)); // buffer reader
																// to read
																// information

			String userConnection = ""; // containing information of individual train
			int countToken=1;				//count token
			String userName = "";			//username
			String friend="";				//friendname
			while ((userConnection = br.readLine()) != null)
			{
				stringTokenizer = new StringTokenizer(userConnection, ",");
				
				// organizing token by assigning them to different strings
				while (stringTokenizer.hasMoreTokens())
				{
					switch(countToken)
					{
					case 1:
					{
						userName = stringTokenizer.nextToken();
						break;
					}
					default:
					{
						friend = stringTokenizer.nextToken();
						friendsList.add(friend);
					}}
					countToken++;
				}
				countToken=1;
				connectionMap.put(userName, friendsList);
			}
		}
		catch (IOException e) {
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

	}
}
