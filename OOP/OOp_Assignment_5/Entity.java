package SocialNetwork;
/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: Contains common variables in Person and Organization class
 */
public abstract class Entity 
{
	String userType = "";
	String userName = "";
	String userEmail_ID = "";
	String userContactNumber = "";
	//Constructor
	public Entity(String userType, String userName , String userEmail_ID, String userContactNumber)
	{
		this.userType = userType;
		this.userName = userName;
		this.userEmail_ID = userEmail_ID;
		this.userContactNumber = userContactNumber;
	}
}
