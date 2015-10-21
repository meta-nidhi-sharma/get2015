package Assignment_2;
/// <summary>
/// The 'ConcreteHandler' class
/// </summary>
public class Mentor extends LeaveApprover{

	@Override
	public void ProcessRequest(int no_Of_Leaves) {
		// TODO Auto-generated method stub
		 if (no_Of_Leaves <= 1)
	      {
	        System.out.println("Leave approved by Mentor");
	      }
	      else if (successor != null)
	      {
	        successor.ProcessRequest(no_Of_Leaves);
	      }
	}

	  
}
