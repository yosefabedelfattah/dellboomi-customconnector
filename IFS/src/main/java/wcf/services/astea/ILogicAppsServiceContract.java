/**
 * ILogicAppsServiceContract.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package wcf.services.astea;

public interface ILogicAppsServiceContract extends java.rmi.Remote {
    public java.lang.String login(java.lang.String user, java.lang.String password, java.lang.String profile) throws java.rmi.RemoteException;
    public void logout(java.lang.String session) throws java.rmi.RemoteException;
    public java.lang.Boolean isSessionValid(java.lang.String session) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.ModuleMetadataForLogicApp[] getIntegratedModulesMetadata(java.lang.String session) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.AsteaAPIResponce executeAPI(java.lang.String session, java.lang.String apiCode) throws java.rmi.RemoteException;
    public org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.ModuleMetadataForLogicApp[] getServicesMetaData(java.lang.String user, java.lang.String pass, java.lang.String profile) throws java.rmi.RemoteException;
}
