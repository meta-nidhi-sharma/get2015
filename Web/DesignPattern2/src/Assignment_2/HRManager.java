package Assignment_2;
/**
 * 
 * @author Nidhi
 * Date : 20 august,2015
 * Description :  The 'ConcreteHandler' class
 */
public class HRManager extends LeaveApprover{

	@Override
	public void ProcessRequest(int no_Of_Leaves) 
	{
		// TODO Auto-generated method stub
		if (no_Of_Leaves <= 5)
	    {
			 System.out.println("Leave approved by HR Manager");
	    }
	    else if (successor == null)
	    {
	    	System.out.println( "Request requires an executive meeting!");
	    }
	}
}
