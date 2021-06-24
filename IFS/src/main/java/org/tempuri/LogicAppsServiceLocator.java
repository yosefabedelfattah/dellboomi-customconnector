/**
 * LogicAppsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class LogicAppsServiceLocator extends org.apache.axis.client.Service implements org.tempuri.LogicAppsService {

    public LogicAppsServiceLocator() {
    }


    public LogicAppsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LogicAppsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for simple
    private java.lang.String simple_address = "http://localhost/AsteaAllianceCurrent_APP_FrameworkVDEV_CURRENT/LogicAppsService.svc/dotnet";

    public java.lang.String getsimpleAddress() {
        return simple_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String simpleWSDDServiceName = "simple";

    public java.lang.String getsimpleWSDDServiceName() {
        return simpleWSDDServiceName;
    }

    public void setsimpleWSDDServiceName(java.lang.String name) {
        simpleWSDDServiceName = name;
    }

    public wcf.services.astea.ILogicAppsServiceContract getsimple() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(simple_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsimple(endpoint);
    }

    public wcf.services.astea.ILogicAppsServiceContract getsimple(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.SimpleStub _stub = new org.tempuri.SimpleStub(portAddress, this);
            _stub.setPortName(getsimpleWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsimpleEndpointAddress(java.lang.String address) {
        simple_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (wcf.services.astea.ILogicAppsServiceContract.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.SimpleStub _stub = new org.tempuri.SimpleStub(new java.net.URL(simple_address), this);
                _stub.setPortName(getsimpleWSDDServiceName());
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
        if ("simple".equals(inputPortName)) {
            return getsimple();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "LogicAppsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "simple"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("simple".equals(portName)) {
            setsimpleEndpointAddress(address);
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
