package wcf.services.astea;

public class ILogicAppsServiceContractProxy implements wcf.services.astea.ILogicAppsServiceContract {
  private String _endpoint = null;
  private wcf.services.astea.ILogicAppsServiceContract iLogicAppsServiceContract = null;
  
  public ILogicAppsServiceContractProxy() {
    _initILogicAppsServiceContractProxy();
  }
  
  public ILogicAppsServiceContractProxy(String endpoint) {
    _endpoint = endpoint;
    _initILogicAppsServiceContractProxy();
  }
  
  private void _initILogicAppsServiceContractProxy() {
    try {
      iLogicAppsServiceContract = (new org.tempuri.LogicAppsServiceLocator()).getsimple();
      if (iLogicAppsServiceContract != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iLogicAppsServiceContract)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iLogicAppsServiceContract)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iLogicAppsServiceContract != null)
      ((javax.xml.rpc.Stub)iLogicAppsServiceContract)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public wcf.services.astea.ILogicAppsServiceContract getILogicAppsServiceContract() {
    if (iLogicAppsServiceContract == null)
      _initILogicAppsServiceContractProxy();
    return iLogicAppsServiceContract;
  }
  
  public java.lang.String login(java.lang.String user, java.lang.String password, java.lang.String profile) throws java.rmi.RemoteException{
    if (iLogicAppsServiceContract == null)
      _initILogicAppsServiceContractProxy();
    return iLogicAppsServiceContract.login(user, password, profile);
  }
  
  public void logout(java.lang.String session) throws java.rmi.RemoteException{
    if (iLogicAppsServiceContract == null)
      _initILogicAppsServiceContractProxy();
    iLogicAppsServiceContract.logout(session);
  }
  
  public java.lang.Boolean isSessionValid(java.lang.String session) throws java.rmi.RemoteException{
    if (iLogicAppsServiceContract == null)
      _initILogicAppsServiceContractProxy();
    return iLogicAppsServiceContract.isSessionValid(session);
  }
  
  public org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.ModuleMetadataForLogicApp[] getIntegratedModulesMetadata(java.lang.String session) throws java.rmi.RemoteException{
    if (iLogicAppsServiceContract == null)
      _initILogicAppsServiceContractProxy();
    return iLogicAppsServiceContract.getIntegratedModulesMetadata(session);
  }
  
  public org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.AsteaAPIResponce executeAPI(java.lang.String session, java.lang.String apiCode) throws java.rmi.RemoteException{
    if (iLogicAppsServiceContract == null)
      _initILogicAppsServiceContractProxy();
    return iLogicAppsServiceContract.executeAPI(session, apiCode);
  }
  
  public org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.ModuleMetadataForLogicApp[] getServicesMetaData(java.lang.String user, java.lang.String pass, java.lang.String profile) throws java.rmi.RemoteException{
    if (iLogicAppsServiceContract == null)
      _initILogicAppsServiceContractProxy();
    return iLogicAppsServiceContract.getServicesMetaData(user, pass, profile);
  }
  
  
}