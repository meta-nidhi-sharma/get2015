package com.CarDekho.db.Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CarDekho.CarDekhoSystemException;
import com.CarDekho.Model.Car;
import com.CarDekho.Model.Vehicle;

public class CarDBHelper extends VehicleDBHelper {
	private static double VALUE = 1000000;
	private static String INSERT_CAR_QUERY = "Insert into CAR (VEHICLE_ID, AC, POWER_STEARING, ACCESSORY_KIT) VALUES (?, ?, ?, ?)";
	
	private static String SEARCH_FOR_MODEL_QUERY = "Select v.vehicle_id, v.make, v.model, v.engineIn_CC, "
													+ " v.fuel_capacity, v.milage, v.price, v.road_tax,"
													+ "v.created_by, v.created_time "
													+ " from Car c INNER JOIN Vehicle v ON c.vehicle_id = v.vehicle_id where v.make=?";
	
	private static String SEARCH_CAR_BY_ID_QUERY = "Select v.vehicle_id, v.make, v.model, v.engineIn_CC, "
			+ " v.fuel_capacity, v.milage, v.price, v.road_tax,"
			+ "v.created_by, v.created_time "
			+ " from Car c INNER JOIN Vehicle v ON c.vehicle_id = v.vehicle_id where c.vehicle_id=?";
	
	private static String SEARCH_CAR_BY_LESS_BUDGET_QUERY = "Select v.vehicle_id, v.make, v.model, v.engineIn_CC, "
			+ " v.fuel_capacity, v.milage, v.price, v.road_tax,"
			+ "v.created_by, v.created_time "
			+ " from Car c INNER JOIN Vehicle v ON c.vehicle_id = v.vehicle_id where v.price<=?";
	
	private static String SEARCH_CAR_BY_MORE_BUDGET_QUERY = "Select v.vehicle_id, v.make, v.model, v.engineIn_CC, "
			+ " v.fuel_capacity, v.milage, v.price, v.road_tax,"
			+ "v.created_by, v.created_time "
			+ " from Car c INNER JOIN Vehicle v ON c.vehicle_id = v.vehicle_id where v.price>?";
	
	private static String UPDATE_CAR_QUERY = "UPDATE Car SET ac=?, POWER_STEARING=?, "
			+ " ACCESSORY_KIT=?,"
			+ "where vehicle_id=?";

	
	public boolean create(Connection connection, Vehicle car) throws CarDekhoSystemException {
		boolean created = false;
	
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				super.createVehicle(connection, car);
				int vehicleId = getVehicleIdByModel(connection, car.getModel());
				if(vehicleId > 0) {
					preparedStatement = connection.prepareStatement(INSERT_CAR_QUERY);
					preparedStatement.setInt(1, car.getVehicleId());
					preparedStatement.setString(2, ((Car) car).isAC());
					preparedStatement.setString(3, ((Car) car).isPowerStearing());
					preparedStatement.setString(4, ((Car) car).isAccessoryKit());
					created = preparedStatement.execute();
					connection.commit();
				}
			} catch(CarDekhoSystemException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw e;
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw new CarDekhoSystemException("Could not create Car, [" + e.getMessage() + "]");
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
			}
		}
		
		return created;
	}
	
	public List<Vehicle> getCarByBudget(Connection connection, String price, Car car)
	{
		List<Vehicle> vList = new ArrayList<Vehicle>();

		ResultSet rs = null;				//To hold resultset
		PreparedStatement ps = null;			//To hold prepared statement
		try 
		{
			if(price.equalsIgnoreCase("Below 10 lac"))
				ps = connection.prepareStatement(SEARCH_CAR_BY_LESS_BUDGET_QUERY);
			else
				ps = connection.prepareStatement(SEARCH_CAR_BY_MORE_BUDGET_QUERY);
			
				/* set variable in prepared statement */
				ps.setDouble(1, VALUE);
				rs = ps.executeQuery();
				while(rs.next())	
				{		
					Vehicle returnValue = new Car();
					
					returnValue.setVehicleId(rs.getInt(1));
					returnValue.setMake(rs.getString(2));
					returnValue.setModel(rs.getString(3));
					returnValue.setEngineInCC(rs.getInt(4));
					returnValue.setFuelCapacity(rs.getDouble(5));
					returnValue.setMilage(rs.getDouble(6));
					returnValue.setPrice(rs.getDouble(7));
					returnValue.setRoadTax(rs.getDouble(8));
					returnValue.setCreatedBy(rs.getString(9));
					returnValue.setCreatedTime(rs.getDate(10));
					
					vList.add(returnValue);
				}
				
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			/* close connection */
			try 
			{
				if (connection != null)
				{
					connection.close();
				}
				if (ps != null)
				{
					ps.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}	
		return vList;
		
	}
	public static List<Vehicle> getCarByBrand(Connection connection, Car car) 
	{
		List<Vehicle> vList = new ArrayList<Vehicle>();
		
		ResultSet rs = null;				//To hold resultset
		PreparedStatement ps = null;			//To hold prepared statement
		try 
		{
			ps = connection.prepareStatement(SEARCH_FOR_MODEL_QUERY);
	
				/* set variable in prepared statement */
				ps.setString(1, car.getMake());
				rs = ps.executeQuery();
				while(rs.next())	
				{		
					Vehicle returnValue = new Car();
					
					returnValue.setVehicleId(rs.getInt(1));
					returnValue.setMake(rs.getString(2));
					returnValue.setModel(rs.getString(3));
					returnValue.setEngineInCC(rs.getInt(4));
					returnValue.setFuelCapacity(rs.getDouble(5));
					returnValue.setMilage(rs.getDouble(6));
					returnValue.setPrice(rs.getDouble(7));
					returnValue.setRoadTax(rs.getDouble(8));
					returnValue.setCreatedBy(rs.getString(9));
					returnValue.setCreatedTime(rs.getDate(10));

					vList.add(returnValue);
				}
				
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			/* close connection */
			try 
			{
				if (connection != null)
				{
					connection.close();
				}
				if (ps != null)
				{
					ps.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}	
		return vList;
	}

	public Vehicle getCarById(Connection connection, Vehicle car) {
		Vehicle carById = null;
		ResultSet rs = null;				//To hold resultset
		PreparedStatement ps = null;			//To hold prepared statement
		try 
		{
			ps = connection.prepareStatement(SEARCH_CAR_BY_ID_QUERY);
	
				/* set variable in prepared statement */
				ps.setInt(1, car.getVehicleId());
				rs = ps.executeQuery();
				while(rs.next())	
				{	
					carById = new Car();

					carById.setVehicleId(rs.getInt(1));
					carById.setMake(rs.getString(2));
					carById.setModel(rs.getString(3));
					carById.setEngineInCC(rs.getInt(4));
					carById.setFuelCapacity(rs.getDouble(5));
					carById.setMilage(rs.getDouble(6));
					carById.setPrice(rs.getDouble(7));
					carById.setRoadTax(rs.getDouble(8));
					carById.setCreatedBy(rs.getString(9));
					carById.setCreatedTime(rs.getDate(10));					
				}				
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			/* close connection */
			try 
			{
				if (ps != null)
				{
					ps.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}	
		return carById;	
	}

	public int updateCar(Connection connection, Vehicle car) throws CarDekhoSystemException  {
		int updated = 0;
		
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			try {
				
				updated = super.updateVehicle(connection, car);
				
					/*preparedStatement = connection.prepareStatement(UPDATE_CAR_QUERY);
					
					preparedStatement.setString(1, ((Car) car).isAC());
					preparedStatement.setString(2, ((Car) car).isPowerStearing());
					preparedStatement.setString(3, ((Car) car).isAccessoryKit());
					preparedStatement.setInt(4, car.getVehicleId());
					updated = preparedStatement.executeUpdate();*/
					
					connection.commit();
				
			} catch(CarDekhoSystemException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw e;
			} catch (SQLException e) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					System.out.println("Could not roleback.");
				}
				throw new CarDekhoSystemException("Could not update Car, [" + e.getMessage() + "]");
			} finally {
				if(preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
					}
				}
			}
		}
		
		return updated;
	}
	
}
