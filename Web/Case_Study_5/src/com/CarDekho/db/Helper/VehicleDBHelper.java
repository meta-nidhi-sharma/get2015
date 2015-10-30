package com.CarDekho.db.Helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.CarDekho.CarDekhoSystemException;
import com.CarDekho.Model.Vehicle;

public class VehicleDBHelper {
	
	private static String INSERT_VEHICLE_QUERY = "insert into Vehicle "
			+ "(vehicle_id,make,model,engineIn_CC,fuel_Capacity,milage,price,road_Tax,created_by,created_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static String UPDATE_VEHICLE_QUERY = "UPDATE Vehicle "
			+ "set make=?,model=?,engineIn_CC=?,fuel_Capacity=?,milage=?,price=?,road_Tax=?,created_by=? where vehicle_id=?;";
	
	private static String SELECT_FOR_MODEL_QUERY = "select vehicle_Id from VEHICLE where model=?";
	
	protected void createVehicle(Connection connection, Vehicle vehicle) throws CarDekhoSystemException {
		PreparedStatement preparedStatement = null;
		try 
		{
			preparedStatement = connection.prepareStatement(INSERT_VEHICLE_QUERY);
			preparedStatement.setInt(1, vehicle.getVehicleId());
			preparedStatement.setString(2, vehicle.getMake());
			preparedStatement.setString(3, vehicle.getModel());
			preparedStatement.setInt(4, vehicle.getEngineInCC());
			preparedStatement.setDouble(5, vehicle.getFuelCapacity());
			preparedStatement.setDouble(6, vehicle.getMilage());
			preparedStatement.setDouble(7, vehicle.getPrice());
			preparedStatement.setDouble(8, vehicle.getRoadTax());
			preparedStatement.setString(9, vehicle.getCreatedBy());
			preparedStatement.setTimestamp(10, new Timestamp(vehicle.getCreatedTime().getTime()));
			preparedStatement.execute();
		}
		catch (SQLException e) 
		{
			throw new CarDekhoSystemException("Could not create Vehicle, [" + e.getMessage() + "]");
		}
		finally
		{
			if(preparedStatement != null) 
			{
				try 
				{
					preparedStatement.close();
				} 
				catch (SQLException e)
				{
					System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
				}
			}
		}
	}
	
	
	protected int getVehicleIdByModel(Connection connection, String model) throws CarDekhoSystemException {
		int id = -1;
		if(connection != null) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			try {
				preparedStatement = connection.prepareStatement(SELECT_FOR_MODEL_QUERY);
				preparedStatement.setString(1, model);
				resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					id = resultSet.getInt(1);
				}
			} catch(SQLException e) {
				throw new CarDekhoSystemException("Could not find Vehicle by model, [" + e.getMessage() + "]");
			}
		}
		return id;
	}


	public int updateVehicle(Connection connection, Vehicle vehicle) throws CarDekhoSystemException  {
		int flag = 0;
		PreparedStatement preparedStatement = null;
		try 
		{
			preparedStatement = connection.prepareStatement(UPDATE_VEHICLE_QUERY);
			preparedStatement.setString(1, vehicle.getMake());
			preparedStatement.setString(2, vehicle.getModel());
			preparedStatement.setInt(3, vehicle.getEngineInCC());
			preparedStatement.setDouble(4, vehicle.getFuelCapacity());
			preparedStatement.setDouble(5, vehicle.getMilage());
			preparedStatement.setDouble(6, vehicle.getPrice());
			preparedStatement.setDouble(7, vehicle.getRoadTax());
			preparedStatement.setString(8, vehicle.getCreatedBy());
			preparedStatement.setInt(9, vehicle.getVehicleId());
	
			flag = preparedStatement.executeUpdate();
			System.out.println("flag " + flag );
			
		}
		catch (SQLException e) 
		{
			throw new CarDekhoSystemException("Could not update Vehicle, [" + e.getMessage() + "]");
		}
		finally
		{
			if(preparedStatement != null) 
			{
				try 
				{
					preparedStatement.close();
				} 
				catch (SQLException e)
				{
					System.out.println("Could not close prepared statement, [" + e.getMessage() + "]");
				}
			}
		}
		return flag;
	}
}
