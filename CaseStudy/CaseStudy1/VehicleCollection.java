package CaseStudy1;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*
 * @author Nidhi
 * Date: 21 september 2015
 * Description: Vehicle collection containing Main function
 */
public class VehicleCollection
{
	private static List<Vehicle> bikeList=(List<Vehicle>) new ArrayList<Vehicle>();
	private static List<Vehicle> carList=(List<Vehicle>) new ArrayList<Vehicle>();

	public static void main(String args[]) throws SQLException 
	{	
		xmlReader read = new xmlReader();
		bikeList = read.readConfig("configBike.xml");
		carList = read.readConfig("configCar.xml");
	  for (Vehicle item : bikeList)
	    {
	      System.out.println(item.toString());
	      System.out.println("\n");
	    }
	   for (Vehicle item :carList)
	    {
	      System.out.println(item.toString());
	      System.out.println("\n");
	    }
	/*	Vehicle developer1=VehicleHelper.createVehicle(VehicleType.Bike, "Honda", 2009 );
		employeeSet.add(developer1);
		Vehicle developer2=VehicleHelper.createVehicle(VehicleType.Bike, "RAM", 2009);
		employeeSet.add(developer2);
		Vehicle developer3=VehicleHelper.createVehicle(VehicleType.Bike, "Honda", 2005);
		employeeSet.add(developer3);
		System.out.println(employeeSet.size());*/
	}
}