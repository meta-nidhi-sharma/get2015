package com.CarDekho.db.Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.CarDekho.CarDekhoSystemException;
import com.CarDekho.Model.Admin;

public class LoginDBHelper {
	private static String CHECK_LOGIN_DETAILS_QUERY = "SELECT * FROM user where userName = ? && password = ?;";
	
	
	public boolean checkLoginDetails(Connection connection, Admin admin) throws CarDekhoSystemException {
		boolean flag = false;
		ResultSet rs = null;				//To hold resultset
		PreparedStatement ps = null;			//To hold prepared statement
		try 
		{
			ps = connection.prepareStatement(CHECK_LOGIN_DETAILS_QUERY);
	
				/* set variable in prepared statement */
				ps.setString(1, admin.getUserName());
				ps.setString(2, admin.getPassword());
				rs = ps.executeQuery();
			if(rs.next()){
				if(admin.getUserName().equalsIgnoreCase(rs.getString(1)) && admin.getPassword().equalsIgnoreCase(rs.getString(2))){
				System.out.println("username that you entered " +admin.getUserName() +" & actual userName " + rs.getString(1));
				System.out.println("password that you entered " +admin.getPassword() + " & actual password " + rs.getString(2));
				flag = true;
			}
		}}
		catch (SQLException e) 
		{
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
		}
		finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
			}		
		return flag;
	}
}
