package SocialNetwork;
/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: Person Info
 */
public class Person extends Entity 
{
	String interests;
	String hobbies;
	//Constructor
	public Person(String userType, String userName , String userEmail_ID, String userContactNumber, String userInterest, String userHobbies )
	{
		super(userType, userName , userEmail_ID,userContactNumber );
		this.interests = userInterest;
		this.hobbies = userHobbies;
	}
	
}
