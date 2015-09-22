package CaseStudy1;


import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleHelperTest {
	@Test
	public void testCreateCar() {
		Vehicle vehicle = VehicleHelper.createVehicle(VehicleType.Car,"XUV", 2008);
		assertNotNull(vehicle);
		assertEquals("XUV", vehicle.getModel());
	}

	@Test
	public void testCreateBike() {
		Vehicle vehicle = VehicleHelper.createVehicle(VehicleType.Bike,
				"Pulsar", 2013);
		assertEquals("Pulsar", vehicle.getModel());
	}

}
