package session1;

/**
 * @author Nidhi
 * Date: 24 august,2015
 *  Helper class to create objects of vehicle type and
 *         returning them
 * 
 */
public class VehicleHelper {
	public static Vehicle createVehicle(String vehicleType, String make,
			String model) {
		if (vehicleType.equalsIgnoreCase("Car")) {
			// checking for car type
			Car car = new Car(make, model);
			// calling constructor
			return car;
		} else if (vehicleType.equalsIgnoreCase("Bike")) {
			// checking for bike type

			Bike bike = new Bike(make, model);
			// calling constructor
			return bike;
		} else {
			Vehicle vehicle = new Vehicle(null, null);
			return vehicle;

		}
	}

}
