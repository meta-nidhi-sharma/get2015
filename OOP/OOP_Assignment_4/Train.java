package MenuBasedTrainReservationSystem;

/**
 * @author Nidhi
 *Description: Train class is to initialize train variables so that they can be used anywhere in package.Also contains two more classes
 *				one of passenger and other is goods_train class.
 */
public abstract class Train
{
	public String train_Type;		
	public String train_Name;
	public String train_ID;
	public String train_From;
	public String train_To;
	public int travel_Duration;
	public int train_Fare;
	
	//constructor
	public Train(String trainType,String trainID, String trainName,String trainFrom,String trainTo,int travelDuration,int trainFare)
	{
		this.train_Type=trainType;
		this.train_ID=trainID;
		this.train_Name=trainName;
		this.train_From=trainFrom;
		this.train_To=trainTo;
		this.travel_Duration=travelDuration;
		this.train_Fare=trainFare;
	}
}

/**
 * @author Nidhi
 *Description: PassengerTrain class is to initialize passenger train variables and also available seats in passenger trains
 */
class PassengerTrain extends Train
{
	int available_Seat;			//To hold no. of seats available in train
	//constructor
	public PassengerTrain(String trainType,String trainID,String trainName,String trainFrom,String trainTo,int travelDuration,int trainFare,int availableSeat)
	{
		super(trainType, trainID, trainName, trainFrom, trainTo, travelDuration, trainFare);
		this.available_Seat=availableSeat;
	}
	
}

/**
 * @author Nidhi
 *Description:  GoodsTrain class is to initialize goods train variables and also available weight in goods trains
 */
class GoodsTrain extends Train
{
	int available_Weight;		//To hold amount of weight available in train
	//constructor
	public GoodsTrain(String trainType, String trainID,String trainName,String trainFrom,String trainTo,int travelDuration,int trainFare,int availableWeight)
	{
		super(trainType, trainID, trainName,  trainFrom, trainTo, travelDuration, trainFare);
		this.available_Weight= availableWeight;
	}
	
}
