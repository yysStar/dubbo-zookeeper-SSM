/**
 * IprotocolLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.qiyun.jimi;

public class IprotocolLocator extends org.apache.axis.client.Service implements Iprotocol {

    public IprotocolLocator() {
    }


    public IprotocolLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IprotocolLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IprotocolPort
    private String IprotocolPort_address = "http://123.57.147.232:8088/service";

    public String getIprotocolPortAddress() {
        return IprotocolPort_address;
    }

    // The WSDD service name defaults to the port name.
    private String IprotocolPortWSDDServiceName = "IprotocolPort";

    public String getIprotocolPortWSDDServiceName() {
        return IprotocolPortWSDDServiceName;
    }

    public void setIprotocolPortWSDDServiceName(String name) {
        IprotocolPortWSDDServiceName = name;
    }

    public IprotocolPortType getIprotocolPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IprotocolPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIprotocolPort(endpoint);
    }

    public IprotocolPortType getIprotocolPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            IprotocolSoapBindingStub _stub = new IprotocolSoapBindingStub(portAddress, this);
            _stub.setPortName(getIprotocolPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIprotocolPortEndpointAddress(String address) {
        IprotocolPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (IprotocolPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                IprotocolSoapBindingStub _stub = new IprotocolSoapBindingStub(new java.net.URL(IprotocolPort_address), this);
                _stub.setPortName(getIprotocolPortWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
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
        String inputPortName = portName.getLocalPart();
        if ("IprotocolPort".equals(inputPortName)) {
            return getIprotocolPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.xixi.com/", "Iprotocol");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.xixi.com/", "IprotocolPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("IprotocolPort".equals(portName)) {
            setIprotocolPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
