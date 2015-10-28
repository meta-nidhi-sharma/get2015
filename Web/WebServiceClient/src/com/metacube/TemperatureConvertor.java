package com.metacube;

import java.util.Scanner;

import com.metacube.webservices.FahrenheitToCelsiusConvertor;
import com.metacube.webservices.FahrenheitToCelsiusConvertorServiceLocator;

public class TemperatureConvertor 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		FahrenheitToCelsiusConvertorServiceLocator ftc = new FahrenheitToCelsiusConvertorServiceLocator();
		ftc.setFahrenheitToCelsiusConvertorEndpointAddress("http://localhost:8080/TemperatureWebService/services/FahrenheitToCelsiusConvertor");	
		try 
		{
			FahrenheitToCelsiusConvertor calcCTCWebService = ftc.getFahrenheitToCelsiusConvertor();
			System.out.println("Enter temperature in farenheit");
			double temp = sc.nextDouble();	
			System.out.println("Temperature in Celsius " +calcCTCWebService.farenheitToCelsius(temp));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
