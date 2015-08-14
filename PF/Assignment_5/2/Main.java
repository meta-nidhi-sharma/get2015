package CarServiceAppointmentSystem;

	import java.util.HashMap;
	
	/**
	author: Nidhi Sharma
	Description: This program contains a main class, which which reads service station,cars and there allotment     

	*/

	
	public class Main {
	
		public static void main(String[] args)
		{
			ServiceStation serviceStation = new ServiceStation();
			serviceStation.readMechanics();
			serviceStation.readCars();
			serviceStation.doAllotment();
			HashMap<String, Integer> carProcessingList = serviceStation.getCarProcessingStatus();

			System.out.println("CarType \t Number");

			for (String carType : carProcessingList.keySet())
			{
				System.out.println(carType + "\t\t " + carProcessingList.get(carType));
			}

			System.out.println("Total Earning \t " + serviceStation.getEarning());

		}

}

