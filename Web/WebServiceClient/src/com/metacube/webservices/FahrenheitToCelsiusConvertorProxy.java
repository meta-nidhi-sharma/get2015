package com.metacube.webservices;

public class FahrenheitToCelsiusConvertorProxy implements com.metacube.webservices.FahrenheitToCelsiusConvertor {
  private String _endpoint = null;
  private com.metacube.webservices.FahrenheitToCelsiusConvertor fahrenheitToCelsiusConvertor = null;
  
  public FahrenheitToCelsiusConvertorProxy() {
    _initFahrenheitToCelsiusConvertorProxy();
  }
  
  public FahrenheitToCelsiusConvertorProxy(String endpoint) {
    _endpoint = endpoint;
    _initFahrenheitToCelsiusConvertorProxy();
  }
  
  private void _initFahrenheitToCelsiusConvertorProxy() {
    try {
      fahrenheitToCelsiusConvertor = (new com.metacube.webservices.FahrenheitToCelsiusConvertorServiceLocator()).getFahrenheitToCelsiusConvertor();
      if (fahrenheitToCelsiusConvertor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fahrenheitToCelsiusConvertor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fahrenheitToCelsiusConvertor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fahrenheitToCelsiusConvertor != null)
      ((javax.xml.rpc.Stub)fahrenheitToCelsiusConvertor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.metacube.webservices.FahrenheitToCelsiusConvertor getFahrenheitToCelsiusConvertor() {
    if (fahrenheitToCelsiusConvertor == null)
      _initFahrenheitToCelsiusConvertorProxy();
    return fahrenheitToCelsiusConvertor;
  }
  
  public double farenheitToCelsius(double temperatureInFarenheit) throws java.rmi.RemoteException{
    if (fahrenheitToCelsiusConvertor == null)
      _initFahrenheitToCelsiusConvertorProxy();
    return fahrenheitToCelsiusConvertor.farenheitToCelsius(temperatureInFarenheit);
  }
  
  
}