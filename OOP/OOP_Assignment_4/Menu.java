package MenuBasedTrainReservationSystem;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Menu {
	
	Scanner sc = new Scanner(System.in);
	public static ArrayList<PassengerTrain> pTrainList = new ArrayList<PassengerTrain>();  	//Passenger trains list
	public static ArrayList<GoodsTrain> gTrainList = new ArrayList<GoodsTrain>();				//Goods trains list
	
	public void setMenu()
	{		
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
	}

	void displayMenu()
	{
		System.out.println("1. Passenger Trains List\n2. Goods Trains List\n3. Booking Passenger Train\n4. Booking Goods Train\n5. Exit");
	}
	
	int chooseOption()
	{
		int optionChoose = sc.nextInt();
		return optionChoose;
	}
	
}
