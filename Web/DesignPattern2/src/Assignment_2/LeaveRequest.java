package Assignment_2;
/**
 * 
 * @author Nidhi
 * Date : 20 august,2015
 * Description : Creating AnnotationRunner Class and applying created annotation on some of the methods
 */
public class LeaveRequest 
{
	public static void main(String args[])
	{
		LeaveApprover gaurav = new Mentor();
		LeaveApprover shashikant = new SeniorMentor();
		LeaveApprover deepika = new HRManager();
		 
		gaurav.SetSuccessor(shashikant);
		shashikant.SetSuccessor(deepika);
	
		gaurav.ProcessRequest(30);
	}
}
