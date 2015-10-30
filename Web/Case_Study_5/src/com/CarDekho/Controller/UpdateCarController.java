package com.CarDekho.Controller;

import java.io.IOException;
import java.util.Calendar;

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
 * Servlet implementation class EmployeeRegistrationController
 */
@WebServlet("/UpdateCarController")
public class UpdateCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardUrl = "/view/car_detail_page.jsp";
		String id;
		
		Vehicle car = new Car();
		Vehicle carById = null;
		if(request.getParameter("id") != null)
		{
		car = createCar(request);
	
		CarDekhoService service = new CarDekhoService();
		try {
			
			Vehicle updatedCar = (Car) service.updateCarById(car);
			
			request.setAttribute("message", "Updated Successfully");
			request.setAttribute("carById", updatedCar);
		} catch (CarDekhoSystemException e) {
			System.out.println("Exception while updating car " + e.getMessage());
			request.setAttribute("message", e.getMessage());
			request.setAttribute("car", car);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}
	}
	private Vehicle createCar(HttpServletRequest request) {
		Vehicle car = new Car();
		
		car.setVehicleId(Integer.parseInt(request.getParameter("id")));
		car.setMake(request.getParameter("make"));
		car.setModel(request.getParameter("model"));
		car.setEngineInCC(Integer.parseInt(request.getParameter("engineInCc")));
		car.setFuelCapacity(Double.parseDouble(request.getParameter("fuelCapacity")));
		car.setMilage(Double.parseDouble(request.getParameter("mileage")));
		car.setPrice(Double.parseDouble(request.getParameter("price")));
		car.setRoadTax(Double.parseDouble(request.getParameter("roadTax")));
		car.setCreatedBy(request.getParameter("created_by"));
		car.setCreatedTime(Calendar.getInstance().getTime());
		System.out.println("created " + car);
		return car;
	}
}
