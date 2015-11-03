package rest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.EmployeeDBHelper;
import Model.Employee;

public class Service {

	public int addNewEmployee(Employee e) {
		int flag = 0;
		Connection connection = ConnectionFactory.getConnection();
		
			flag = EmployeeDBHelper.createEmployee(connection, e);
		
		
			ConnectionFactory.closeConnection(connection);
	
			return flag;
	}

	public int deleteEmployee(Employee emp) {
		int flag = 0;
		Connection connection = ConnectionFactory.getConnection();
		System.out.println("service");
			flag = EmployeeDBHelper.deleteEmployee(connection, emp);
		
		
			ConnectionFactory.closeConnection(connection);
	
			return flag;
	}

	public Employee retrieveEmployeeById(Employee emp) {
		
		Connection connection = ConnectionFactory.getConnection();
		
		emp = EmployeeDBHelper.retrieveEmployeeById(connection, emp);
		
		return emp;
	}

	public Employee retrieveEmployeeByName(Employee emp) {
		
	Connection connection = ConnectionFactory.getConnection();
		
		emp = EmployeeDBHelper.retrieveEmployeeByName(connection, emp);
		
		return emp;
	}

	public List<Employee> retrieveAllEmployee() {
	Connection connection = ConnectionFactory.getConnection();
	
	List<Employee> empList = EmployeeDBHelper.retrieveAllEmployee(connection);
		
		return empList;
	}


}
