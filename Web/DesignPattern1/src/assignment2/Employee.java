package assignment2;

/**
 * @author Nidhi Sharma
 * Date : 20 october,2015
 * Description: defines an employee and contains its abstract getters and setters
 */
public abstract class Employee 
{
	protected String name;
	
	protected String role;
	
	public abstract String getName();
	public abstract void setName(String name);

	public abstract String getRole();
	public abstract void setRole(String role);
}