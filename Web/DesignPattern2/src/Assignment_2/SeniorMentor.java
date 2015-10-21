package Assignment_2;
/**
 * 
 * @author Nidhi
 * Date : 20 august,2015
 * Description :  The 'ConcreteHandler' class
 */
public class SeniorMentor extends LeaveApprover{

	@Override
	public void ProcessRequest(int no_Of_Leaves) {
		// TODO Auto-generated method stub
		 if (no_Of_Leaves == 2)
	      {
	        System.out.println("Leave approved by SeniorMentor");
	      }
	      else if (successor != null)
	      {
	        successor.ProcessRequest(no_Of_Leaves);
	      }
	}

}


