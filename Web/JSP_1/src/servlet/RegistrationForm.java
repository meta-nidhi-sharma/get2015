package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectionUtil.ConnectionUtil;

import java.sql.Connection;
/**
 * 
 * @author Nidhi
 * Date : 12 October,2015
 * Description : This servlet is used to post form details and get appropriate message on submission.
 *
 */

public class RegistrationForm extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		
		PrintWriter pw = res.getWriter();
		
		boolean flag=true;
		
		res.setContentType("text/html");
		
		pw.println("This is servlet page.<br>");
		
		if(req.getParameter("userName").isEmpty())
		{
			pw.println("First Name not entered<br>");
			flag=false;
		} 
	
		if(req.getParameter("email").isEmpty())
		{
			pw.println("E-mail ID not entered<br>");
		     flag=false;
		}
		if(req.getParameter("password").length() < 8 )
		{
			pw.println("Password Length should be greater than 8 <br>");
		     flag=false;
		}
		
		if(!req.getParameter("password").equalsIgnoreCase(req.getParameter("confirmPassword"))) 
		{  
			pw.println("Password doesn't match<br>");
			flag=false;
		}
		
		if(req.getParameter("states").isEmpty())
		{ 
			pw.println("State is not entered<br>");
			flag=false;
		}
		if(req.getParameter("cities").isEmpty()) 
		{ 
			pw.println("City is not entered<br>");
			flag=false;
		}
		if(req.getParameter("address").isEmpty())
		{
			pw.println("Address is not entered<br>");
			flag=false;
		}
	   if( req.getParameter("age").isEmpty())
		{
		   pw.println("Age is not entered<br>");
		   flag=false;	
		}
		if(flag==true){
				pw.println("Form submitted successfully<br>");
		
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Connection con = null;
		int rs;				//To hold resultset
		PreparedStatement ps = null;			//To hold prepared statement
		ConnectionUtil conUtil = new ConnectionUtil();			//Creating object of ConnectionUtil
		con = (Connection) conUtil.getConnection();			//To hold connection
		String query = "INSERT INTO User VALUES (?, ?, ?);";		//getting required query
		
		try 
		{
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, email);
			ps.setString(3, password);
			rs = ps.executeUpdate();	
			pw.println("No. of new users entered -> " + rs);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			// close connection 
			try 
			{
				if (con != null)
				{
					con.close();
				}
				if (ps != null) 
				{
					ps.close();
				}
			/*	if (rs != null) 
				{
					rs.close();
				}*/
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}	
		}

	}
}	
