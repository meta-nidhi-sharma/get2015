package SocialNetwork;

import java.util.List;
import java.util.Map;

/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: Graph adding edges and removing edges between users
 */
public class Graph
{
	
	/******************************
	 *To add edge or connection 
	 * @param userName
	 * @param friendName
	 *****************************/
	void addEdge(String userName, String friendName, Map<String,List<String>> connectionMap)
	{
		Connection connection = new Connection();
		connection.friendsList.add(friendName);
		connectionMap.put(userName, connection.friendsList);
		
	}
	/******************************
	 *To remove edge or connection 
	 * @param userName
	 * @param friendName
	 *****************************/
	void removeEdge(String userName,String friendName,Map<String,List<String>> connectionMap)
	{
		Connection connection = new Connection();
		int i=0;
		java.util.Iterator<String> par = connection.friendsList.iterator();
		while (par.hasNext()) 
		{
			String pass = par.next();
			if((pass).compareToIgnoreCase(friendName)==0)
			{
				connection.friendsList.remove(i);
				break;	
			}
			i++;
		}
		connectionMap.put(userName, connection.friendsList);
	}
}
