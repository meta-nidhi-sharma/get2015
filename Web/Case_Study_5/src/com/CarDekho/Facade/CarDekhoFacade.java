package com.CarDekho.Facade;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.CarDekho.CarAlreadyExistsException;
import com.CarDekho.CarDekhoSystemException;
import com.CarDekho.Model.Admin;
import com.CarDekho.Model.Car;
import com.CarDekho.Model.Vehicle;
import com.CarDekho.db.Helper.CarDBHelper;
import com.CarDekho.db.Helper.LoginDBHelper;

public class CarDekhoFacade 
{	
	public Vehicle createCar(Connection connection, Vehicle car) throws CarDekhoSystemException, CarAlreadyExistsException 
	{
		Vehicle carFromDB = null;
		
		CarDBHelper carDBHelper = new CarDBHelper();
		try
		{
			carFromDB = carDBHelper.getCarById(connection, car);
			if(carFromDB == null) 
			{
				carDBHelper.create(connection, car);				
				carFromDB = carDBHelper.getCarById(connection, car);		
			} 
			else 
			{
				throw new CarAlreadyExistsException("Car with Id " + car.getVehicleId() + " already exists.");
			}
		} 
		catch (CarDekhoSystemException e) 
		{
			System.out.println("Exception while creating car " + e.getMessage());
			throw e;
		}
		return carFromDB;
	}

	public List<Vehicle> getCarByBudget(Connection connection, String price, Car car) throws CarDekhoSystemException 
	{
		List<Vehicle> response = new ArrayList<Vehicle>();
		CarDBHelper carDBHelper = new CarDBHelper();		
			response = carDBHelper.getCarByBudget(connection, price, car);
		return response;	
	}
	
	public List<Vehicle> getCarByBrand(Connection connection, Car car) throws CarDekhoSystemException 
	{
		List<Vehicle> response = new ArrayList<Vehicle>();
		CarDBHelper carDBHelper = new CarDBHelper();
		response = carDBHelper.getCarByBrand(connection, car);	
		return response;	
	}

	public Vehicle getCarById(Connection connection, Vehicle car) throws CarDekhoSystemException 
	{
		Vehicle response = new Car();
		CarDBHelper carDBHelper = new CarDBHelper();
		response = carDBHelper.getCarById(connection, car);	
		return response;	
	}

	public Vehicle updateCarById(Connection connection, Vehicle car)  throws CarDekhoSystemException
	{
		Vehicle carFromDB = null;	
		CarDBHelper carDBHelper = new CarDBHelper();
		try 
		{
			carFromDB = carDBHelper.getCarById(connection, car);
			if(carFromDB != null) 
			{			
				System.out.println("car " + carFromDB);
				carDBHelper.updateCar(connection, car);	
				carFromDB = carDBHelper.getCarById(connection, car);	
				System.out.println("car " + carFromDB);
			} 
		} 
		catch (CarDekhoSystemException e) 
		{
			System.out.println("Exception while updating car " + e.getMessage());
			throw e;
		}
		return carFromDB;
	}

	public boolean checkLoginDetails(Connection connection, Admin admin) throws CarDekhoSystemException
	{
		boolean flag = false;
		LoginDBHelper loginDBHelper = new LoginDBHelper();
		try{
			flag = loginDBHelper.checkLoginDetails(connection, admin);	
		}catch(CarDekhoSystemException e){
			e.printStackTrace();
		}
		
		return flag;
	}


}
