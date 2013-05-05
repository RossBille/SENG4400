package services;

public class ProcessPaymentServiceProxy implements services.ProcessPaymentService {
  private String _endpoint = null;
  private services.ProcessPaymentService processPaymentService = null;
  
  public ProcessPaymentServiceProxy() {
    _initProcessPaymentServiceProxy();
  }
  
  public ProcessPaymentServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initProcessPaymentServiceProxy();
  }
  
  private void _initProcessPaymentServiceProxy() {
    try {
      processPaymentService = (new services.ProcessPaymentServiceServiceLocator()).getprocessPaymentServicePort();
      if (processPaymentService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)processPaymentService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)processPaymentService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (processPaymentService != null)
      ((javax.xml.rpc.Stub)processPaymentService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public services.ProcessPaymentService getProcessPaymentService() {
    if (processPaymentService == null)
      _initProcessPaymentServiceProxy();
    return processPaymentService;
  }
  
  public java.lang.String processCard(java.lang.String arg0) throws java.rmi.RemoteException{
    if (processPaymentService == null)
      _initProcessPaymentServiceProxy();
    return processPaymentService.processCard(arg0);
  }
  
  public java.lang.String processPaypal(java.lang.String arg0) throws java.rmi.RemoteException{
    if (processPaymentService == null)
      _initProcessPaymentServiceProxy();
    return processPaymentService.processPaypal(arg0);
  }
  
  
}