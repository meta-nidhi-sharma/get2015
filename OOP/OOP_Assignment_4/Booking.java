package MenuBasedTrainReservationSystem;

import java.util.Scanner;

public class Booking {
	Scanner sc = new Scanner(System.in);
	
	void passengerTrainBooking()
	{
		System.out.println("Enter your Name");
		String userName = sc.next();
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
			//Asking user to enter his source and destination and on that basis display suitable trains
			System.out.println("Enter from station");
			String from=sc.next();
			System.out.println("Enter Destination");
			String to=sc.next();
			java.util.Iterator<PassengerTrain> par2 = Menu.pTrainList.iterator();
			while(par2.hasNext())
			{
				PassengerTrain pass = par2.next();
				
				// Compare users choice of source and destination and provide if train is available
				if(from.compareTo(pass.train_From)==0 && to.compareTo(pass.train_To)==0)
				{
					System.out.println(pass.train_ID + "\t\t" + pass.train_Name+ "\t" + pass.train_From + "\t" + pass.train_To+ "\t\t" + pass.travel_Duration + "\t"
							+ pass.train_Fare + "\t" + pass.available_Seat);
					System.out.println("Enter train name, train ID and requirement(seats if passenger train or weight in tones if goods train)");
	
					//Ask user to enter which train he wants and to enter details of that, if details matches ask for payment mode
					String trainName=sc.next();
					String trainID=sc.next();
					int requirement=sc.nextInt();				//Number of seats user require
					if(requirement<=pass.available_Seat && pass.train_ID.equalsIgnoreCase(trainID) && pass.train_Name.equalsIgnoreCase(trainName))
					{
						PaymentMode pm=new PaymentMode(requirement,pass.train_Fare);
						int totalamount;		//Total paid amount by user
						System.out.println("Choose payment mode(Enter 1 for credit card mode\n\t2 for wallet\n\t3 for net banking)");
						int Mode=sc.nextInt();			//To choose mode of payment
						pass.available_Seat=pass.available_Seat-requirement;
						//Payment using Credit Card
						if(Mode==1)
						{
							/***************************************************************
							 * Calling function "creditCardPaymentMode" to make payment
							 ***************************************************************/
							totalamount=pm.creditCardPaymentMode();
							System.out.println(Constant.TICKET_DETAILS);
							System.out.println(userName+"\t\t"+trainName+"\t\t"+trainID+"\t\t"+requirement+"\t\t"+totalamount);
						}
						//Payment using Wallet
						else if(Mode==2)
						{
							/***************************************************************
							 * Calling function "walletPaymentMode" to make payment
							 ***************************************************************/
							totalamount=pm.walletPaymentMode();
							System.out.println(Constant.TICKET_DETAILS);
							System.out.println(userName+"\t\t"+trainName+"\t\t"+trainID+"\t\t"+requirement+"\t\t"+totalamount);
						}
						//Payment using Net Banking
						else if(Mode==3)
						{
							/***************************************************************
							 * Calling function "netBankingPaymentMode" to make payment
							 ***************************************************************/
							totalamount=pm.netBankingPaymentMode();
							System.out.println(Constant.TICKET_DETAILS);
							System.out.println(userName+"\t\t"+trainName+"\t\t"+trainID+"\t\t"+requirement+"\t\t"+totalamount);
						}
						else
							System.out.println("Enter valid mode");
						
						//Display updated information of trains
						System.out.println("Updated train Chart:\n");
						for (PassengerTrain Train : Menu.pTrainList)
						{
							System.out.println(Train.train_Type + "\t" + Train.train_Name
							+ "\t" + Train.train_From + "\t" + Train.train_To
							+ "\t" + Train.travel_Duration + "\t"
							+ Train.train_Fare + "\t" + Train.available_Seat);
						}
				}
				else
					System.out.println("Invalid Details or Seats not available");
				break;
			}
		}
	}
	
	void goodsTrainBooking()
	{
		System.out.println("Enter your Name");
		String userName = sc.next();
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
		System.out.println("Enter from station");
		String from=sc.next();
		System.out.println("Enter Destination");
		String to=sc.next();
		java.util.Iterator<GoodsTrain> par2 = Menu.gTrainList.iterator();
		while(par2.hasNext())
		{
			GoodsTrain good = par2.next();
				if(from.compareTo(good.train_From)==0 && to.compareTo(good.train_To)==0)
				{
					System.out.println(good.train_ID + "\t\t" + good.train_Name
							+ "\t" + good.train_From + "\t" + good.train_To
							+ "\t\t" + good.travel_Duration + "\t"
							+ good.train_Fare + "\t" + good.available_Weight);
					
					//Ask user to enter which train he wants and to enter details of that, if details matches ask for payment mode
					System.out.println("Enter train name, train ID and requirement(seats if passenger train or weight in tones if goods train)");
					String trainName=sc.next();
					String trainID=sc.next();
					int requirement=sc.nextInt();			//amount of weight user requires
					if(requirement<=good.available_Weight  && good.train_ID.equalsIgnoreCase(trainID)  && good.train_Name.equalsIgnoreCase(trainName))
					{
					
						PaymentMode pm=new PaymentMode(requirement,good.train_Fare);		
						int totalamount;		//Total paid amount bu user
						System.out.println("Choose payment mode(Enter 1 for credit card mode\n\t2 for wallet\n\t3 for net banking)");
						int mode=sc.nextInt();			//To choose mode of payment
						good.available_Weight-=requirement;
						//Payment using Credit Card
						if(mode==1)
						{
							/***************************************************************
							 * Calling function "creditCardPaymentMode" to make payment
							 ***************************************************************/
							totalamount=pm.creditCardPaymentMode();			
							System.out.println(Constant.TICKET_DETAILS);
							System.out.println(userName+"\t\t"+trainName+"\t\t"+trainID+"\t\t"+requirement+"\t\t"+totalamount);
						}
						//Payment using Wallet
						else if(mode==2)
						{
							/***************************************************************
							 * Calling function "walletPaymentMode" to make payment
							 ***************************************************************/
							totalamount=pm.walletPaymentMode();
							System.out.println(Constant.TICKET_DETAILS);
							System.out.println(userName+"\t\t"+trainName+"\t\t"+trainID+"\t\t"+requirement+"\t\t"+totalamount);
						}
						//Payment using Net Banking
						else if(mode==3)
						{
							/***************************************************************
							 * Calling function "netBankingPaymentMode" to make payment
							 ***************************************************************/
							totalamount=pm.netBankingPaymentMode();
							System.out.println(Constant.TICKET_DETAILS);
							System.out.println(userName+"\t\t"+trainName+"\t\t"+trainID+"\t\t"+requirement+"\t\t"+totalamount);
						}
						else
							System.out.println("Not a valid mode");
						
						//Display updated information of trains
						System.out.println("Updated train Chart:\n");
						for (GoodsTrain Train : Menu.gTrainList) 
						{
							System.out.println(Train.train_Type + "\t" + Train.train_Name
							+ "\t" + Train.train_From + "\t" + Train.train_To
							+ "\t" + Train.travel_Duration + "\t"
							+ Train.train_Fare + "\t" + Train.available_Weight);
						}
					}
					else
						System.out.println("Invalid Details or Weight not available");
					break;
				}
			}
	}
}
