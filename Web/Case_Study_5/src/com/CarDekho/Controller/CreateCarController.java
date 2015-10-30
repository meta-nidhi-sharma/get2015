package com.CarDekho.Controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CarDekho.CarAlreadyExistsException;
import com.CarDekho.CarDekhoSystemException;
import com.CarDekho.Model.Car;
import com.CarDekho.service.CarDekhoService;

/**
 * @author Nidhi Sharma
 * Date: 17 October,2015
 * Servlet implementation class EmployeeRegistrationController
 */
@WebServlet("/CreateCarController")
public class CreateCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCarController() {
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
		String forwardUrl = "/view/admin_car_edit_page.jsp";
		Car car = createCar(request);
		CarDekhoService service = new CarDekhoService();
		try {
			Car createdCar = (Car) service.createCar(car);
			request.setAttribute("message", "Created Successfully");
			request.setAttribute("carById", createdCar);
			forwardUrl = "/view/admin_car_edit_page.jsp";
		} catch (CarDekhoSystemException e) {
			System.out.println("Exception while creating car " + e.getMessage());
			forwardUrl = "/view/admin_car_create_page.jsp";
			request.setAttribute("message", e.getMessage());
			request.setAttribute("car", car);
		} catch (CarAlreadyExistsException e) {
			System.out.println("Exception while creating car " + e.getMessage());
			forwardUrl = "/view/admin_car_create_page.jsp";
			request.setAttribute("message", e.getMessage());
			request.setAttribute("car", car);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}

	private Car createCar(HttpServletRequest request) {
		Car car = new Car();
		
		car.setAC(request.getParameter("ac"));
		car.setAccessoryKit(request.getParameter("accessoryKit"));
		car.setPowerStearing(request.getParameter("powerSteering"));
		car.setVehicleId(Integer.parseInt(request.getParameter("id")));
		car.setMake(request.getParameter("make"));
		car.setModel(request.getParameter("model"));
		car.setEngineInCC(Integer.parseInt(request.getParameter("engineInCc")));
		car.setFuelCapacity(Double.parseDouble(request.getParameter("fuelCapacity")));
		car.setMilage(Double.parseDouble(request.getParameter("mileage")));
		car.setPrice(Double.parseDouble(request.getParameter("price")));
		car.setRoadTax(Double.parseDouble(request.getParameter("roadTax")));
		car.setCreatedBy(request.getParameter("roadTax"));
		car.setCreatedTime(Calendar.getInstance().getTime());
		return car;
	}
}
