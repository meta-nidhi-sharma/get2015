package TrainReservationSystem;

import java.util.Scanner;

/**
 * @author Nidhi Description: This class is to process the payment of
 *         train_fare. Having three different payment modes.
 */

public class PaymentMode 
{

	private int requirement = 0;
	private int fare = 0;
	int totalAmount = 0;

	public PaymentMode(int requirement, int train_fare) 
	{
		this.requirement = requirement;
		this.fare = train_fare;
	}

	Scanner sc = new Scanner(System.in);

	/***********************************************************************
	 * On the basis of user's choice pay train_fare using credit card mode
	 * 
	 * @return toatal amount paid by user
	 *********************************************************************/
	public int creditCardPaymentMode()
	{
		System.out.println("Enter Credit Card(CC) Number");
		int CC = sc.nextInt(); // CC number
		System.out.println("Enter CVV Number");
		int CVV = sc.nextInt(); // CVV Number
		System.out.println("\nCC: " + CC + "\tCVV: " + CVV);
		totalAmount = requirement * fare;
		return totalAmount;
	}

	/**************************************************************
	 * On the basis of user's choice pay train_fare using Wallet
	 * 
	 * @return toatal amount paid by user
	 *************************************************************/
	public int walletPaymentMode()
	{
		totalAmount = requirement * fare;
		return totalAmount;
	}

	/*********************************************************************
	 * On the basis of user's choice pay train_fare using Net Banking
	 * 
	 * @return toatal amount paid by user
	 *******************************************************************/
	public int netBankingPaymentMode()
	{
		System.out.println("Enter your Bank Name");
		String bankName = sc.next(); // Bank Name
		System.out.println("User Name:");
		String userName = sc.next(); // User name
		System.out.println("Password:");
		String password = sc.next(); // enter password
		System.out.println("\nBank Name: " + bankName + "\t\tUser Name: "
				+ userName + "\tPassword: **********");
		totalAmount = requirement * fare;
		return totalAmount;
	}
}
