package TrainReservationSystem;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * @author Nidhi
 *Description: This class contains main function where the reservation will take place.
 */

public class TrainReservation 
{
	public static void main(String[] args)
	{
		ArrayList<PassengerTrain> pTrainList = new ArrayList<PassengerTrain>();  	//Passenger trains list
		ArrayList<GoodsTrain> gTrainList = new ArrayList<GoodsTrain>();				//Goods trains list
		int choice;			// For further choice of booking
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = null; 					// input BY file
		try
		{
			StringTokenizer stringTokenizer;		//To separete content of one train in list
			FileInputStream fin = new FileInputStream(
					new File("C:\\Users\\Nidhi\\workspace\\OOP_Assignment_3\\src\\TrainReservationSystem\\Train_Chart.txt"));
			// File reader
			DataInputStream in = new DataInputStream(fin);
			//data reader
			br = new BufferedReader(new InputStreamReader(in));
			//buffer reader to read information
			String traindata = "";		//containing information of individual train
			int i = 1;					//for counting tokens
			String trainType = "", trainID = "", trainName = "", from = "", to = "", duration = "", amount = "", available = "";
			while ((traindata = br.readLine()) != null)
			{
				stringTokenizer = new StringTokenizer(traindata, ",");
				i = 1;
				//organizing token by assiging them to different strings
				while (stringTokenizer.hasMoreTokens())
				{
					if (i == 1)
					{
						trainType = stringTokenizer.nextToken();
					}
					else if (i == 2) 
					{
						trainID = stringTokenizer.nextToken();
					} 
					else if (i == 3) 
					{
						trainName = stringTokenizer.nextToken();
					}
					else if (i == 4) 
					{
						from = stringTokenizer.nextToken();
					}
					else if (i == 5)
					{
						to = stringTokenizer.nextToken();
					}
					else if (i == 6)
					{
						duration = stringTokenizer.nextToken();
					}
					else if (i == 7)
					{
						amount = stringTokenizer.nextToken();
					}
					else if (i == 8)
					{
						available = stringTokenizer.nextToken();
					}
					i++;
				}
				int time = Integer.parseInt(duration);
				int amount1 = Integer.parseInt(amount);
				int available1 = Integer.parseInt(available);
				//assigning passenger trains information to PTrainlist
				if (trainType.compareTo("P") == 0)
				{
					pTrainList.add(new PassengerTrain(trainType, trainID, trainName,
							from, to, time, amount1, available1));
				}
				//assigning goods trains information to gTrainlist
				else if (trainType.compareTo("G") == 0)
				{
					gTrainList.add(new GoodsTrain(trainType, trainID, trainName, from, to, time, amount1, available1));
				}
			}

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try
			{
				if (br != null)
					br.close();
			} 
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		do
		{
			System.out.println("Enter your Name");
			String userName = sc.next();
			System.out.println("Enter type of train you want(Enter P for Passenger train and G for Goods train)");
			String trainType_User = sc.next();
			
			//For passenger type train: if user enters P it will show Passenger trains list
			
			if (trainType_User.compareTo("P") == 0) 
			{
				System.out.println(Constant.TRAIN_CHART);
				java.util.Iterator<PassengerTrain> par1 = pTrainList.iterator();
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
				java.util.Iterator<PassengerTrain> par2 = pTrainList.iterator();
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
							for (PassengerTrain Train : pTrainList)
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
		
		// For goods train
		else if (trainType_User.compareTo("G") == 0)
		{
			System.out.println(Constant.TRAIN_CHART);
			java.util.Iterator<GoodsTrain> par1 = gTrainList.iterator();
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
			java.util.Iterator<GoodsTrain> par2 = gTrainList.iterator();
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
						for (GoodsTrain Train : gTrainList) 
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
		else
			System.out.println("Enter valid train type");
		System.out.println("Enter '1' to continue more booking or '0' to exit");		
		choice=sc.nextInt();
		}while(choice==1);
	}
	
}

