
	package com.CarDekho.Controller;

	import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CarDekho.CarDekhoSystemException;
import com.CarDekho.Model.Car;
import com.CarDekho.Model.Vehicle;
import com.CarDekho.service.CarDekhoService;

	/**
	 * @author Nidhi Sharma
	 * Date: 17 October,2015
	 */
	@WebServlet("/CarSearchController")
public class CarSearchController extends HttpServlet  {

		 
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CarSearchController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Vehicle> vehicleList = new ArrayList<Vehicle>();
			String message;
			String price;
			String make;
			
			Car car = null;
			
			if(request.getParameter("budgetlist1") != null)
			{	
				price = request.getParameter("budgetlist1");
			
					CarDekhoService service = new CarDekhoService();
					try {
						vehicleList = (List<Vehicle>) service.getCarByBudget(price, car);
					} catch (CarDekhoSystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("vehicleList", vehicleList);
				
			} 
			
			else if(request.getParameter("brandlist1") != null)
			{
				make = request.getParameter("brandlist1");
				car = new Car();
				car.setMake(make);
				CarDekhoService service = new CarDekhoService();
			
					try {
						vehicleList = service.getCarByBrand(car);
					} catch (CarDekhoSystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("vehicleList", vehicleList);
			
			}
			else 
			{
				message = "No cars Available";
				request.setAttribute("message", message);
			}					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/car_list_page.jsp");
			dispatcher.forward(request, response);
		}
	}	




