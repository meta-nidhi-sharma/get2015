package com.CarDekho.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

/**
 * @author Nidhi Sharma
 * Date: 17 October,2015
 */
@WebServlet("/LoginPageController")
public class LoginPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag=true;
		
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		if(userName == "")
		{
			flag=false;
		} 
		else if(!request.getParameter("userName").equalsIgnoreCase("ADMIN"))
		{	
		    flag=false;
		}
		if(request.getParameter("password") == "") 
		{	
		    flag=false;
		}
		else if(!request.getParameter("password").equalsIgnoreCase("ADMIN"))
		{	
		    flag=false;
		}
	
		if(flag==true)
		{		
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);	
		}
		else 
		{	
			String message = "Invalid Username or Password";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("/view/login_page.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin_page.jsp");
		rd.forward(request, response);
	}
}
	

