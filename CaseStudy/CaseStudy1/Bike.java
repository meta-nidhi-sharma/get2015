package CaseStudy1;


/**
 * @author Nidhi
 * Date: 21 september 2015
 * Description: Bike class extending vehicle
 */
public class Bike extends Vehicle 
{
	private String selfStart;
	private int helmetPrice;
	
	/**
	 * @return true/false for self start availablity
	 */
	public String isSelfStart() 
	{
		return selfStart;
	}

	@Override
	public String toString()
	{
		return "Bike [selfStart=" + selfStart
				+ ", helmetPrice=" + helmetPrice + "]" + super.toString();
	}

	/**
	 * @param selfStart
	 */
	public void setSelfStart(String selfStart)
	{
		this.selfStart = selfStart;
	}

	/**
	 * @return helmet price
	 */
	public int getHelmetPrice() 
	{
		return helmetPrice;
	}

	/**
	 * @param helmetPrice
	 */
	public void setHelmetPrice(int helmetPrice) 
	{
		this.helmetPrice = helmetPrice;
	}
	
	/* (non-Javadoc)
	 * @see com.vehiclemanagement.model.Vehicle#calculateOnRoadPrice()
	 */
	public double calculateOnRoadPrice()
	{
		//override the method to calculate on road price
		return getPrice() + getRoadTax()*2;
	}

}
