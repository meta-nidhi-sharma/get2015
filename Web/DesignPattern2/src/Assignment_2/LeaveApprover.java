package Assignment_2;
/**
 * 
 * @author Nidhi
 * Date : 20 august,2015
 * Description :  The abstract class of leave approver
 */
public abstract class LeaveApprover
{
	protected LeaveApprover successor;
 
    public void SetSuccessor(LeaveApprover successor)
    {
      this.successor = successor;
    }
    
    /*************************
     * Abstract Method
     * @param no_Of_Leaves
     ************************/
    public abstract void ProcessRequest(int no_Of_Leaves);
}
	 

	
	

