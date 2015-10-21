package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connections.CreateConnection;

import com.mysql.jdbc.Statement;

public class LoginCheck extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("resource")
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		
		PrintWriter pw = res.getWriter();
		
		boolean flag=true;
		
		res.setContentType("text/html");
		
		pw.println("This is servlet page.<br>");
		
		String uName = req.getParameter("userName");

		String password = req.getParameter("password");
		
		if(req.getParameter("userName").isEmpty() )
		{
			pw.println("User name not entered");
		     flag=false;
		}
		if(req.getParameter("password").isEmpty())
		{
			pw.println("Password not entered");
		     flag=false;
		}
		if(flag==true)
		{
			Connection con = null;				//To hold connection
			PreparedStatement ps = null;				//To hold statement
			ResultSet rs = null;
			CreateConnection conUtil = new CreateConnection();
			con = (Connection) conUtil.getConnection();
			String query1 = "SELECT password FROM User WHERE userName=?;";

			try 
			{
				ps = con.prepareStatement(query1);
				ps.setString(1, uName);
				rs = ps.executeQuery();
			
				if(rs.next()){
					if(password.equals(rs.getString("password"))){
						pw.println("Successfully Logged In");
					}
					else{
						pw.println("Password doesn't matches");
					}
				}
				else
				{
					pw.println("User does not Exist");
				}
			} 
			catch (SQLException e)
			{
				String message = "Check your SQL Database and Queries";
				req.setAttribute("message", message);
				RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
				rd.forward(req,res);
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
					if (rs != null) 
					{
						rs.close();
					}

				} 
				catch (SQLException e)
				{
					String message = "Connection closing problem occured";
					req.setAttribute("message", message);
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(req,res);
				}
			}
		
		}
	}
}
