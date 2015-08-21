package MenuBasedTrainReservationSystem;

/**
 * @author Nidhi
 * Description: This class is contains all menu items and will perform only one action as per user's choice 
 */
public class MenuItem
{
	/***********************************************************
	 * This function perform action based on user's choice
	 * @param choice : User's choice from menu
	 **********************************************************/
	void menuChosen(int choice)
	{
		switch(choice)
		{
			//To display passenger trains details
			case 1:
			{
				System.out.println(Constant.TRAIN_CHART);
				java.util.Iterator<PassengerTrain> par1 = Menu.pTrainList.iterator();
				while (par1.hasNext()) 
				{
					PassengerTrain pass = par1.next();
					System.out.println(pass.train_ID + "\t\t" + pass.train_Name
							+ "\t" + pass.train_From + "\t" + pass.train_To
							+ "\t\t" + pass.travel_Duration + "\t"
							+ pass.train_Fare + "\t" + pass.available_Seat);
				}
				break;
			}
			//To display goods trains details
			case 2:
			{
				System.out.println(Constant.TRAIN_CHART);
				java.util.Iterator<GoodsTrain> par1 = Menu.gTrainList.iterator();
				while (par1.hasNext()) //Loop to check whether there is more data if yes then display
				{
					GoodsTrain good = par1.next();
					System.out.println(good.train_ID + "\t\t" + good.train_Name
							+ "\t" + good.train_From + "\t" + good.train_To
							+ "\t\t" + good.travel_Duration + "\t"
							+ good.train_Fare + "\t" + good.available_Weight);
				}
				break;
			}
			//To book passenger train
			case 3:
			{
				Booking book = new Booking();
				book.passengerTrainBooking();
				break;
			}
			//To book goods train
			case 4:
			{
				Booking book = new Booking();
				book.goodsTrainBooking();
				break;
			}
			//To exit
			case 5:
				return;
			//for invalid option choosen by user
			default:
				System.out.println("Invalid Choice");
		}
	}
}
	
	
