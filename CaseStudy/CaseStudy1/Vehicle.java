package CaseStudy1;
/**
 * @author Nidhi
 *Date: 21 september 2015
 * Description: Vehicle class
 */
public class Vehicle 
{	
	
	private int vehicleNo;
	private int make;
	private String model;
	private int engineInCC;
	private double fuelCapacity;
	private double milage;
	private double price;
	private double roadTax;
	private String createdBy;
	private String createdTime;

	public int setSelfStart() 
	{
		return vehicleNo;
	}

	public void setVehicleNo(int vehicleNo) 
	{
		this.vehicleNo = vehicleNo;
	}

	public int getVehicleNo()
	{
		// TODO Auto-generated method stub
		return vehicleNo;
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

	public String getCreatedTime() 
	{
		return createdTime;
	}

	public void setCreatedTime(String createdTime) 
	{
		this.createdTime = createdTime;
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
		return "Vehicle [vehicleNo=" + vehicleNo + ", make=" + make + ", model=" + model + ", engineInCC="
				+ engineInCC + ", fuelCapacity=" + fuelCapacity + ", milage="
				+ milage + ", price=" + price + ", roadTax=" + roadTax
				+  ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + "]";
	}
}
