package session1;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class VehiclePrinterTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		// checking for object of car
		String object2 = "make:Verna,model:verna23";
		String object1 = VehiclePrinter.printVehicleSpecification(VehicleHelper
				.createVehicle("Car", "Verna", "verna23"));
		assertEquals(object1, object2);
	}


}
