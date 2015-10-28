package com.CarDekho.db.vo;

import java.util.Date;

/**
 * @author Nidhi
 * Date: 21 september 2015
 * Description: Vehicle class
 */
public abstract class Vehicle 
{		
	private int vehicleId;
	private int make;
	private String model;
	private int engineInCC;
	private double fuelCapacity;
	private double milage;
	private double price;
	private double roadTax;
	private String createdBy;
	private Date createdTime;

	public int setSelfStart() 
	{
		return vehicleId;
	}

	public void setVehicleId(int vehicleNo) 
	{
		this.vehicleId = vehicleNo;
	}

	public int getVehicleId()
	{
		// TODO Auto-generated method stub
		return vehicleId;
	}

	/**
	 * @return year of manufacturing
	 */
	public int getMake()
	{
		return make;
	}

	/**
	 * @param year of manufacturing
	 */
	
	public void setMake(int make2)
	{
		this.make = make2;
	}

	public String getCreatedBy() 
	{
		return createdBy;
	}

	public void setCreatedBy(String i)
	{
		this.createdBy = i;
	}

	public Date getCreatedTime() 
	{
		return createdTime;
	}

	public void setCreatedTime(Date time) 
	{
		this.createdTime = time;
	}

	/**
	 * @return model name
	 */
	public String getModel()
	{
		return model;
	}

	/**
	 * @param model name
	 */
	public void setModel(String model) 
	{
		this.model = model;
	}

	/**
	 * @return engineCC
	 */
	public int getEngineInCC()
	{
		return engineInCC;
	}

	/**
	 * @param engineInCC
	 */
	public void setEngineInCC(int engineInCC)
	{
		this.engineInCC = engineInCC;
	}

	/**
	 * @return fuel capacity
	 */
	public double getFuelCapacity() 
	{
		return fuelCapacity;
	}

	/**
	 * @param fuelCapacity
	 */
	public void setFuelCapacity(double fuelCapacity)
	{
		this.fuelCapacity = fuelCapacity;
	}

	/**
	 * @return milage
	 */
	public double getMilage() 
	{
		return milage;
	}

	/**
	 * @param milage
	 */
	public void setMilage(double milage) 
	{
		this.milage = milage;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (model == null) 
		{
			if (other.model != null)
				return false;
		} 
		else if (!model.equals(other.model))
			return false;
		return true;
	}

	/**
	 * @return price of vehicle
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	/**
	 * @return road tax
	 */
	public double getRoadTax() 
	{
		return roadTax;
	}

	/**
	 * @param roadTax
	 */
	public void setRoadTax(double roadTax) 
	{
		this.roadTax = roadTax;
	}

	/**
	 * @return price
	 */
	public double calculateOnRoadPrice()
	{  
		//calculate the on road price by returning price
		return getPrice();
	}

	@Override
	public String toString() 
	{
		return "Vehicle [vehicleNo=" + vehicleId + ", make=" + make + ", model=" + model + ", engineInCC="
				+ engineInCC + ", fuelCapacity=" + fuelCapacity + ", milage="
				+ milage + ", price=" + price + ", roadTax=" + roadTax
				+  ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + "]";
	}
}
