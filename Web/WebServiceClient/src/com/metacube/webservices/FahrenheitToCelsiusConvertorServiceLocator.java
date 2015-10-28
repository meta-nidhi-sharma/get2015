/**
 * FahrenheitToCelsiusConvertorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.webservices;

public class FahrenheitToCelsiusConvertorServiceLocator extends org.apache.axis.client.Service implements com.metacube.webservices.FahrenheitToCelsiusConvertorService {

    public FahrenheitToCelsiusConvertorServiceLocator() {
    }


    public FahrenheitToCelsiusConvertorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FahrenheitToCelsiusConvertorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FahrenheitToCelsiusConvertor
    private java.lang.String FahrenheitToCelsiusConvertor_address = "http://localhost:8080/TemperatureWebService/services/FahrenheitToCelsiusConvertor";

    public java.lang.String getFahrenheitToCelsiusConvertorAddress() {
        return FahrenheitToCelsiusConvertor_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FahrenheitToCelsiusConvertorWSDDServiceName = "FahrenheitToCelsiusConvertor";

    public java.lang.String getFahrenheitToCelsiusConvertorWSDDServiceName() {
        return FahrenheitToCelsiusConvertorWSDDServiceName;
    }

    public void setFahrenheitToCelsiusConvertorWSDDServiceName(java.lang.String name) {
        FahrenheitToCelsiusConvertorWSDDServiceName = name;
    }

    public com.metacube.webservices.FahrenheitToCelsiusConvertor getFahrenheitToCelsiusConvertor() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FahrenheitToCelsiusConvertor_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFahrenheitToCelsiusConvertor(endpoint);
    }

    public com.metacube.webservices.FahrenheitToCelsiusConvertor getFahrenheitToCelsiusConvertor(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.metacube.webservices.FahrenheitToCelsiusConvertorSoapBindingStub _stub = new com.metacube.webservices.FahrenheitToCelsiusConvertorSoapBindingStub(portAddress, this);
            _stub.setPortName(getFahrenheitToCelsiusConvertorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFahrenheitToCelsiusConvertorEndpointAddress(java.lang.String address) {
        FahrenheitToCelsiusConvertor_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.metacube.webservices.FahrenheitToCelsiusConvertor.class.isAssignableFrom(serviceEndpointInterface)) {
                com.metacube.webservices.FahrenheitToCelsiusConvertorSoapBindingStub _stub = new com.metacube.webservices.FahrenheitToCelsiusConvertorSoapBindingStub(new java.net.URL(FahrenheitToCelsiusConvertor_address), this);
                _stub.setPortName(getFahrenheitToCelsiusConvertorWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("FahrenheitToCelsiusConvertor".equals(inputPortName)) {
            return getFahrenheitToCelsiusConvertor();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservices.metacube.com", "FahrenheitToCelsiusConvertorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservices.metacube.com", "FahrenheitToCelsiusConvertor"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FahrenheitToCelsiusConvertor".equals(portName)) {
            setFahrenheitToCelsiusConvertorEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
