package EmployeesCollection;
/**
 * @ author Nidhi Sharma
 * Date: 31 gugust,2015
 * Description: This class contains employee which sets and gets employee details
 */
	@SuppressWarnings("rawtypes")
public class Employee implements Comparable {

	public Integer employee_ID;		//holds employee ID
	public String employee_Name;		//holds employee name
	public String employee_Address;		//holds employee address
	
	/*******************
	 * To get employee ID
	 * @return employee ID
	 *****************/
	public Integer getEmployee_ID() {
		return employee_ID;
	}
	/*******************
	 * To set employee ID
	 * *****************/
	public void setEmployee_ID(Integer employeeID) {
		this.employee_ID = employeeID;
	}
	/***********************
	 * To get employee Name
	 * @return employee Name
	 * *********************/
	public String getEmployeeName() {
		return employee_Name;
	}
	/*******************
	 * To set employee ID
	 *******************/
	public void setEmployeeName(String employeeName) {
		this.employee_Name = employeeName;
	}
	/******************************
	 * To get employee Adress
	 * @return employee Adress
	 ******************************/
	public String getEmployeeAddress() {
		return employee_Address;
	}
	/*****************************
	 * To set employee Adress
	 * @return employee Adress
	 * ****************************/
	public void setEmployeeAddress(String employeeAddress) {
		this.employee_Address = employeeAddress;
	}
	/***************************
	 * To set employee details
	 **************************/
	public Employee(int employeeID , String employeeName, String employeeAddress)
	{
		this.employee_ID = employeeID;
		this.employee_Name = employeeName;
		this.employee_Address = employeeAddress;
	}
	/**********************************
	 * To get sorted list of employees 
	 * comparing in natural order
	 * @return
	 * *******************************/
	public int compareTo(Object obj) {
		Employee emp = (Employee) obj;			//holding employees details
		return getEmployee_ID().compareTo(emp.getEmployee_ID());
		}

}
