package com.CarDekho.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CarDekho.CarAlreadyExistsException;
import com.CarDekho.CarDekhoSystemException;
import com.CarDekho.Facade.CarDekhoFacade;
import com.CarDekho.Model.Car;
import com.CarDekho.Model.Vehicle;
import com.CarDekho.db.ConnectionFactory;

public class CarDekhoService {

	public Vehicle createCar(Vehicle car)
			throws CarDekhoSystemException, CarAlreadyExistsException {
		Vehicle returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.createCar(connection, car);
		} catch (CarDekhoSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		if(returnValue != null){
		return returnValue;}
		else
			return null;
	}

	public List<Vehicle> getCarByBudget(String price, Car car)
			throws CarDekhoSystemException {
		List<Vehicle> returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.getCarByBudget(connection, price, car);
		} catch (CarDekhoSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

	public List<Vehicle> getCarByBrand(Car car)
			throws CarDekhoSystemException {
		
		List<Vehicle> returnValue = new ArrayList<Vehicle>();
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.getCarByBrand(connection, car);
		} catch (CarDekhoSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

	public Vehicle getCarById(Vehicle car) throws CarDekhoSystemException {
		Vehicle returnValue = new Car();
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.getCarById(connection, car);
		} catch (CarDekhoSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}

	public Vehicle updateCarById(Vehicle car) throws CarDekhoSystemException {
		Vehicle returnValue = null;
		Connection connection = ConnectionFactory.getConnection();
		CarDekhoFacade facade = new CarDekhoFacade();
		try {
			returnValue = facade.updateCarById(connection, car);
		} catch (CarDekhoSystemException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("Could not roleback.");
			}
			throw e;
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		return returnValue;
	}



}
