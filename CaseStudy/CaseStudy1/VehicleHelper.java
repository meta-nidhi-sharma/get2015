package CaseStudy1;


/**
 * @author Nidhi
 *
 */
public class VehicleHelper
{
	private String vehicleType;

	/**
	 * @return
	 */
	public String getVehicleType() 
	{
		return vehicleType;
	}

	/**
	 * @param vehicleType
	 */
	public void setVehicleType(String vehicleType)
	{
		this.vehicleType = vehicleType;
	}

	/**
	 * @param vehicleType
	 * @param model
	 * @param make
	 * @return vehicle type refrence
	 */
	public static Vehicle createVehicle(VehicleType vehicleType, String model,
			int make)
	{
		String s = String.valueOf(vehicleType);
		if (s.equalsIgnoreCase("Car"))
		{
			return createCar(model, make);
		} 
		else
		{
			return createBike(model, make);
		}
	}

	/**
	 * @param model
	 * @param make
	 * @return bike type
	 */
	static Vehicle createBike(String model, int make)
	{
		Bike bike = new Bike();
		bike.setModel(model);
		bike.setMake(make);
		return bike;
	}

	/**
	 * @param model
	 * @param make
	 * @return car type 
	 */
	static Vehicle createCar(String model,int make) 
	{
		Car car = new Car();
		car.setModel(model);
		car.setMake(make);
		return car;
	}
}
