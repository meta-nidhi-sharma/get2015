package com.CarDekho.db.vo;



/**
 * @author Nidhi
 *Date: 21 september 2015
 * Description: Car class extending vehicle
 */
public class Car extends Vehicle 
{
	private String AC;
	private String powerStearing;
	private String accessoryKit;

	/**
	 * @return true/false for AC availabilty
	 */
	public String isAC()
	{
		return AC;
	}

	/**
	 * @param AC
	 */
	public void setAC(String aC)
	{
		this.AC = aC;
	}

	/**
	 * @return true/false for power stearing
	 */
	public String isPowerStearing()
	{
		return powerStearing;
	}

	/**
	 * @param powerStearing
	 */
	public void setPowerStearing(String powerStearing) 
	{
		this.powerStearing = powerStearing;
	}

	/**
	 * @return true/false for accsessory kit
	 */
	public String isAccessoryKit()
	{
		return accessoryKit;
	}

	@Override
	public String toString()
	{
		return "Car [ AC=" + AC + ", powerStearing=" + powerStearing
				+ ", accessoryKit=" + accessoryKit
				+ "]" + super.toString();
	}

	/**
	 * @param accessoryKit
	 */
	public void setAccessoryKit(String accessoryKit)
	{
		this.accessoryKit = accessoryKit;
	}
	
	/* (non-Javadoc)
	 * @see com.vehiclemanagement.model.Vehicle#calculateOnRoadPrice()
	 */
	public double calculateOnRoadPrice()
	{
		//override the method to calculate the on road price
		return getPrice() + getRoadTax()*3;
	}

}
