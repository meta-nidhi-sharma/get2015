package EmployeesCollection;
/**
* @ author Nidhi Sharma
* Date: 31 august,2015
* Description: This class is comparing ans sorting employees based on their Name
*/
import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class NameComparator implements Comparator 
{
	//Comparing objects of employees and sorting based on their names
	@Override
	public int compare(Object employee1, Object employee2)
	{
		Employee em1 = (Employee) employee1;		//Holding details of employee 1
		Employee em2 = (Employee)employee2;		//Holding details of employee 2
		return (int)(em1.getEmployeeName().compareTo(em2.getEmployeeName()));
	}
}

