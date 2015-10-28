package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class FahrenheitToCelsiusConvertor 
{
	@WebMethod
    public double farenheitToCelsius(double temperatureInFarenheit)  
    {  
	 	double temperatureInCelsius = (temperatureInFarenheit -  32)*5/9;
        return temperatureInCelsius;  
    }  
}
