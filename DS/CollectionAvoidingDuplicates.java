package EmployeesCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CollectionAvoidingDuplicates {

	static ArrayList<Employee> employeeList =  new ArrayList<Employee>();
		
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		/*employeeList.add(new Employee(110, "Nidhi", "Karauli"));
		employeeList.add(new Employee(103, "Richa", "Jaipur"));
		employeeList.add(new Employee(109, "Neha", "Kotputhli"));
		employeeList.add(new Employee(108, "Chetna", "Jai"));
		employeeList.add(new Employee(101, "Suman", "jodhpur"));*/
		do
		{
			System.out.println("1. To add new employee");
			System.out.println("2. To Display employeeList");
			System.out.println("3. Exit");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					int flag = 0;
					Employee emp = createEmployee();
					Iterator<Employee> it = employeeList.iterator();
					while(it.hasNext())
					{
						Employee ee = it.next();
						System.out.println(emp.employee_ID +"\t"+ ee.employee_ID);
						if(emp.employee_ID == ee.employee_ID)
						{
							flag = 1;
							break;
						}
					}
					System.out.println(flag);
					if(flag != 1 )
						employeeList.add(emp);
					else
						System.out.println("Employee_ID already exists");
					break;
				case 2:
					for(Employee ee : employeeList)
						System.out.println("Emloyee ID: "+ee.employee_ID+" Name: "+ee.employee_Name+" Address: "+ee.employee_Address);
					break;
				case 3:
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option");
					break;
			}
		}
		while(true);
	}
		
	private static Employee createEmployee()
	{
		Scanner sc =new Scanner(System.in);
		Integer id = 0;
		String name = "";
		String address = "";
		System.out.println("Enter Employee Details : ID");
		id =sc.nextInt();
		System.out.println("name");
		name = sc.next();
		System.out.println("address");
		address = sc.next();
		Employee emp = new Employee(id , name, address);
		return emp;
	}
		
}
