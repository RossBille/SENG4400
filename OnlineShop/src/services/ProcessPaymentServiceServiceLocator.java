/**
 * ProcessPaymentServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public class ProcessPaymentServiceServiceLocator extends org.apache.axis.client.Service implements services.ProcessPaymentServiceService {

    public ProcessPaymentServiceServiceLocator() {
    }


    public ProcessPaymentServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProcessPaymentServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for processPaymentServicePort
    private java.lang.String processPaymentServicePort_address = "http://localhost:8081/Payment/processPaymentServiceService";

    public java.lang.String getprocessPaymentServicePortAddress() {
        return processPaymentServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String processPaymentServicePortWSDDServiceName = "processPaymentServicePort";

    public java.lang.String getprocessPaymentServicePortWSDDServiceName() {
        return processPaymentServicePortWSDDServiceName;
    }

    public void setprocessPaymentServicePortWSDDServiceName(java.lang.String name) {
        processPaymentServicePortWSDDServiceName = name;
    }

    public services.ProcessPaymentService getprocessPaymentServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(processPaymentServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getprocessPaymentServicePort(endpoint);
    }

    public services.ProcessPaymentService getprocessPaymentServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            services.ProcessPaymentServicePortBindingStub _stub = new services.ProcessPaymentServicePortBindingStub(portAddress, this);
            _stub.setPortName(getprocessPaymentServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setprocessPaymentServicePortEndpointAddress(java.lang.String address) {
        processPaymentServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (services.ProcessPaymentService.class.isAssignableFrom(serviceEndpointInterface)) {
                services.ProcessPaymentServicePortBindingStub _stub = new services.ProcessPaymentServicePortBindingStub(new java.net.URL(processPaymentServicePort_address), this);
                _stub.setPortName(getprocessPaymentServicePortWSDDServiceName());
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
        if ("processPaymentServicePort".equals(inputPortName)) {
            return getprocessPaymentServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services/", "processPaymentServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services/", "processPaymentServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("processPaymentServicePort".equals(portName)) {
            setprocessPaymentServicePortEndpointAddress(address);
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
