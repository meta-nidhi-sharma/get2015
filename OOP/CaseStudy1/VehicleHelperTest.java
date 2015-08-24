package session1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class VehicleHelperTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	// checking for car type object
	public void test() {

		assertNotNull(VehicleHelper.createVehicle("Car", "Verna", "verna23"));

	}

	@Test
	// checking for bike type object
	public void test1() {

		assertNotNull(VehicleHelper.createVehicle("Bike", "Honda", "honda23"));

	}

}
