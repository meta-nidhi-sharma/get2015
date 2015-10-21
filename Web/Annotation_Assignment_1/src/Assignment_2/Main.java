package Assignment_2;
/**
 * 
 * @author Nidhi
 * Date : 20 august,2015
 * Description : Main Class
 */
public class Main 
{
	/*****************
	 * Main method
	 * @param args
	 ****************/
	public static void main(String args[])
	{
		System.out.println("Creating Employee.......");
		
		Employee e = JsonRunner.createEmployee();
		System.out.println("New Employee data ");
		System.out.println(e.toString());
		
		JsonRunner.toJson(e);
		
		Employee emp = JsonRunner.fromJson();
		
		System.out.println("Employee data Fetched from json file");
		System.out.println(emp.toString());
	}
}
