package MenuBasedTrainReservationSystem;


public class MenuItem
{
	void menuChosen(int choice)
	{
		switch(choice)
		{
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
			case 3:
			{
				Booking book = new Booking();
				book.passengerTrainBooking();
				break;
			}
			case 4:
			{
				Booking book = new Booking();
				book.goodsTrainBooking();
				break;
			}
			case 5:
				return;
			default:
				System.out.println("Invalid Choice");
		}
	
	}
}
	
	
