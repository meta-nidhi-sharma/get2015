package EmployeesCollection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class MainEmployeeCollection {
	static ArrayList<Employee> emList =  new ArrayList<Employee>();
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		emList.add(new Employee(110, "Nidhi", "Karauli"));
		emList.add(new Employee(103, "Richa", "Jaipur"));
		emList.add(new Employee(109, "Neha", "Kotputhli"));
		emList.add(new Employee(108, "Chetna", "Jai"));
		emList.add(new Employee(101, "Suman", "jodhpur"));
		
		//Natural Sort
		Collections.sort(emList);
		System.out.println("Sorted in natural order...");
		displayEmployeelist();
		
		//sorting basd on name
		Collections.sort(emList, new NameComparator());
		System.out.println("Sorted on name basis...");
		displayEmployeelist();
		
	}
	
	private static void displayEmployeelist()
	{
		Iterator<Employee> iterator = emList.iterator();
		while(iterator.hasNext())
		{
			Employee e = (Employee) iterator.next();
			System.out.println(e.employee_ID + "\t" + e.employee_Name + "\t" + e.employee_Address);
			
		}
	}
}
