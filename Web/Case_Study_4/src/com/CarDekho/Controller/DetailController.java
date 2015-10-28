
	package com.CarDekho.Controller;

	import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CarDekho.CarDekhoSystemException;
import com.CarDekho.Model.Car;
import com.CarDekho.service.CarDekhoService;

	/**
	 * @author Nidhi Sharma
	 * Date: 17 October,2015
	 */
	@WebServlet("/DetailController")
public class DetailController extends HttpServlet  {

		 
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public DetailController() {
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
			
			String id;
		
			Car car = null;
			Car carById = null;
			if(request.getParameter("id") != null)
			{	
				
				id = request.getParameter("id");
				
				car = new Car();
				car.setVehicleId(Integer.parseInt(id));
				CarDekhoService service = new CarDekhoService();
				
					try {
						carById = (Car) service.getCarById(car);
					} catch (CarDekhoSystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("carById", carById);
			
			} 
					
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/car_detail_page.jsp");
			dispatcher.forward(request, response);
		}
	}	




