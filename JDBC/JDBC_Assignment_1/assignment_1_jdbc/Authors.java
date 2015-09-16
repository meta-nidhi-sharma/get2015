package assignment_1_jdbc;
/**
* @author Nidhi Sharma
* Date: 16 September,2015
* Description :  Authors class
*/
public class Authors 
{
	private int author_id;		//Holds author id
	private String author_name;		//Holds author name
	
	/**********************
	 * To get author_id
	 * @return author_id
	 **********************/
	public int getAuthor_id() 
	{
		return author_id;
	}
	
	/**********************
	 * To set author_id
	 **********************/
	public void setAuthor_id(int author_id)
	{
		this.author_id = author_id;
	}
	
	/**********************
	 * To get author_name
	 * @return author_name
	 **********************/
	public String getAuthor_name() 
	{
		return author_name;
	}
	
	/**********************
	 * To set author_name
	 **********************/
	public void setAuthor_name(String author_name) 
	{
		this.author_name = author_name;
	}	
}
