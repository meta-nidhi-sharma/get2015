package assignment_1_jdbc;
/**
* @author Nidhi Sharma
* Date: 16 September,2015
* Description :  titles class
*/
public class Titles 
{
	private int title_id;
	private String title_name;
	
	/**********************
	 * To get title_id
	 * @return title_id
	 **********************/
	public int getTitle_id() 
	{
		return title_id;
	}
	
	/**********************
	 * To set title_id
	 **********************/
	public void setTitle_id(int title_id)
	{
		this.title_id = title_id;
	}
	
	/**********************
	 * To get title_name
	 * @return title_name
	 **********************/
	public String getTitle_name() 
	{
		return title_name;
	}
	
	/**********************
	 * To set title_name
	 **********************/
	public void setTitle_name(String title_name) 
	{
		this.title_name = title_name;
	}
	
	@Override
	public String toString() {
		return "Titles [title_name=" + title_name
				+ "]";
	}
	
}
