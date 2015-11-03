package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Model.Employee;

public class EmployeeDBHelper
{
	private static String INSERT_EMPLOYEE_QUERY = "INSERT INTO employee VALUES (?, ?, ?);";

	private static String DELETE_EMPLOYEE_QUERY = "DELETE from employee where id=?;";
	
	private static String SEARCH_EMPLOYEE_BY_ID_QUERY = "Select id, name, designation FROM Employee " 
			+ "where id=?;";
	
	private static String SEARCH_EMPLOYEE_BY_NAME_QUERY = "Select id, name, designation FROM Employee " 
			+ "where name=?;";
	
	private static String SEARCH_ALL_EMPLOYEE_QUERY = "Select * FROM employee;";
	
	/**********
	 * To create New Employee
	 * @param connection
	 * @param e
	 * @return
	 */
	public static int createEmployee(Connection connection, Employee e) 
	{
		int created = 0;
	
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
					preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_QUERY);
					preparedStatement.setInt(1, e.getId());
					preparedStatement.setString(2, e.getName());
					preparedStatement.setString(3, e.getDesignation());
					created = preparedStatement.executeUpdate();
					connection.commit();
					System.out.println("flag " + created);
			} catch (SQLException e2) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e3) {
						System.out.println("Could not close prepared statement, [" + e3.getMessage() + "]");
					}
				}
			}
		}
		
		return created;
	}
	
	/*******************************
	 * To delete employee byId
	 * @param connection
	 * @param emp
	 * @return
	 */
	public static int deleteEmployee(Connection connection, Employee emp) {
	
		int deleted = 0;
		
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
					preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_QUERY);
					preparedStatement.setInt(1, emp.getId());
					deleted = preparedStatement.executeUpdate();
					connection.commit();
					System.out.println("flag " + deleted);
			} catch (SQLException e2) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e3) {
						System.out.println("Could not close prepared statement, [" + e3.getMessage() + "]");
					}
				}
			}
		}
		
		return deleted;
	}

	/**************************
	 * To retrieve employee by id
	 * @param connection
	 * @param emp
	 * @return
	 */
	public static Employee retrieveEmployeeById(Connection connection, Employee emp) {
		Employee e = new Employee();
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {System.out.println("db");
					preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_ID_QUERY);
					preparedStatement.setInt(1, emp.getId());
					System.out.println(preparedStatement);
					ResultSet rs = preparedStatement.executeQuery();
					connection.commit();
					if(rs.next()){	
					
						e.setId(rs.getInt(1));
						e.setName(rs.getString(2));
						e.setDesignation(rs.getString(3));
						System.out.println("Employee " + e.getId() + e.getName() + e.getDesignation());
					}
	
			} catch (SQLException e2) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e3) {
						System.out.println("Could not close prepared statement, [" + e3.getMessage() + "]");
					}
				}
			}
		}
		
		return e;		
	}

	/**************************
	 * To retrieve employee by name
	 * @param connection
	 * @param emp
	 * @return
	 */
	public static Employee retrieveEmployeeByName(Connection connection, Employee emp) {
			Employee e = new Employee();
	if(connection != null) 
	{
		PreparedStatement preparedStatement = null;
		try
		{	System.out.println("db");
			preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME_QUERY);
			preparedStatement.setString(1, emp.getName());
			ResultSet rs = preparedStatement.executeQuery();
			connection.commit();
			if(rs.next())
			{	
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setDesignation(rs.getString(3));
				System.out.println("Employee " + e.getId() + e.getName() + e.getDesignation());
			}
		} 
		catch (SQLException e2) 
		{
			try 
			{
				connection.rollback();
			} 
			catch (SQLException e1) 
			{
				System.out.println("Could not roleback.");
			}
		}
		finally 
		{
			if(preparedStatement != null) 
			{
				try 
				{
					preparedStatement.close();
				}
				catch (SQLException e3) 
				{
					System.out.println("Could not close prepared statement, [" + e3.getMessage() + "]");
				}
			}
		}
	}	
	return e;		
	}

	/**************************
	 * To retrieve all employees
	 * @param connection
	 * @return
	 */
	public static List<Employee> retrieveAllEmployee(Connection connection) {
	List<Employee> empList = new ArrayList<Employee>();
	if(connection != null) 
	{
		java.sql.Statement statement = null;
		try
		{
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(SEARCH_ALL_EMPLOYEE_QUERY);
			connection.commit();
			while(rs.next())
			{	
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setDesignation(rs.getString(3));
				empList.add(emp);
			}
		} 
		catch (SQLException e2) 
		{
			try 
			{
				connection.rollback();
			} 
			catch (SQLException e1) 
			{
				System.out.println("Could not roleback.");
			}
		}
		finally 
		{
			if(statement != null) 
			{
				try 
				{
					statement.close();
				}
				catch (SQLException e3) 
				{
					System.out.println("Could not close prepared statement, [" + e3.getMessage() + "]");
				}
			}
		}
	}	
	return empList;		
	}	
}
