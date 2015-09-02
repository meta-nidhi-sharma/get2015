package EmployeesCollection;

	@SuppressWarnings("rawtypes")
public class Employee implements Comparable {

	Integer employee_ID;
	String employee_Name;
	String employee_Address;
	
	public Integer getEmployee_ID() {
		return employee_ID;
	}
	public void setEmployee_ID(Integer employeeID) {
		this.employee_ID = employeeID;
	}
	public String getEmployeeName() {
		return employee_Name;
	}
	public void setEmployeeName(String employeeName) {
		this.employee_Name = employeeName;
	}
	public String getEmployeeAddress() {
		return employee_Address;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employee_Address = employeeAddress;
	}
	public Employee(int employeeID , String employeeName, String employeeAddress)
	{
		this.employee_ID = employeeID;
		this.employee_Name = employeeName;
		this.employee_Address = employeeAddress;
	}
	
	public int compareTo(Object obj) {
		Employee emp = (Employee) obj;
		return getEmployee_ID().compareTo(emp.getEmployee_ID());
		}

}
