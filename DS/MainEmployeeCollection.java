package EmployeesCollection;
/**
 * @ author Nidhi Sharma
 * Date: 31 gugust,2015
 * Description: Main class
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainEmployeeCollection
{
	public static ArrayList<Employee> emList =  new ArrayList<Employee>();
	//Main function
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		//adding employees in list
		emList.add(new Employee(110, "Nidhi", "Karauli"));
		emList.add(new Employee(103, "Richa", "Jaipur"));
		emList.add(new Employee(109, "Neha", "Kotputhli"));
		emList.add(new Employee(108, "Chetna", "Jai"));
		emList.add(new Employee(101, "Suman", "jodhpur"));
		
		//Natural Sort
		Collections.sort(emList);
		System.out.println("Sorted in natural order...");
		displayEmployeelist();		//to display sorted list based on natural sorting
		
		//sorting based on name
		Collections.sort(emList, new NameComparator());
		System.out.println("Sorted on name basis...");
		displayEmployeelist();			//to display sorted list based on name
		
	}
	
	/***************************************
	 * Display function
	 ***************************************/
	private static void displayEmployeelist()
	{
		Iterator<Employee> iterator = emList.iterator();		//Iterator
		while(iterator.hasNext())
		{
			Employee e = (Employee) iterator.next();			//Holding employee details one by one
			System.out.println(e.employee_ID + "\t" + e.employee_Name + "\t" + e.employee_Address);
			
		}
	}
}
