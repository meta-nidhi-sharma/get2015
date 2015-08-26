package SocialNetwork;
/**
 * @ Nidhi
 * Date: 24 august,2015
 * Description: Organization Info
 */
public class Organization extends Entity
{

	String courses;
	String placement;
	
	//Constructor
	public Organization(String userType, String userName , String userEmail_ID,String userContactNumber,String userCourses, String userPlacement)
	{
		super(userType, userName, userEmail_ID, userContactNumber);
		this.courses =userCourses ;
		this.placement = userPlacement;
	}
}

