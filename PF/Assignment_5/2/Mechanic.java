package CarServiceAppointmentSystem;
/**
author: Nidhi Sharma
Description: This program contains a class Mechanic, which takes mechanicID, mechanic_name, Mechanic_type
             and service_rate by that mechanic 
*/

	public class Mechanic extends People
	{

		private String type;
		private String rate;

		public void setRate(String r)         //To set rate
			{
				try
					{
						this.rate = r;
					}
				catch (Exception e)
					{
						this.rate = "0";
					}
	
			}

		public String getRate()             //To get rate
			{
				return this.rate;
			}

		public String getType()             //To get type of mechanic
			{
				return this.type;
			}

		boolean isAvailable;                 //A variable to store availability of mechanic

		
		/**
		    Constructor which contains mechanicID, mechanic_name, Mechanic_type
            and service_rate by that mechanic 
		 */
		public Mechanic(String mechId, String mechName, String mechType, String mechRate)
			{
				mechID = mechId;
				name = mechName;
				type = mechType;
				setRate(mechRate);
				isAvailable = true;
			}
	}

