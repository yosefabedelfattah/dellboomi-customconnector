package com.alliance.connector;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.rmi.RemoteException;

import org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.AsteaAPIResponce;
import org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.ModuleMetadataForLogicApp;

import com.boomi.connector.api.ObjectData;

import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.OperationStatus;
import com.boomi.connector.api.UpdateRequest;
import com.boomi.connector.util.BaseUpdateOperation;

public class AllianceConnectorExecuteOperation extends BaseUpdateOperation {

    String user  = "";
    String password = "";
    String profile = "";
    String url = "";
    
	protected AllianceConnectorExecuteOperation(AllianceConnectorConnection conn) {
		super(conn);
	}

	@Override
	protected void executeUpdate(UpdateRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
		
		String objectTypeId = getContext().getObjectTypeId();
	
		// get user credentials
		getConnectionProperties();
        
    	String endPoint  = getBaseUrlOfAlliance();   
        wcf.services.astea.ILogicAppsServiceContractProxy locator =  new wcf.services.astea.ILogicAppsServiceContractProxy();
		locator.setEndpoint(endPoint);
		
		for(ObjectData requestData : request) {
		
			try
			{

			WriteToFile(requestData.getData().toString());
			
			}
			catch(Exception e)
			{
				
			}

		}
        		
        		
		
	
		
		
	    String session;
		try {
			session = locator.login(user, password, profile);
			String apicode = getApicodeOfObject(objectTypeId);
			
			try
			{
			WriteToFile(apicode);
			}
			catch(Exception e)
			{
				
			}
			
			
			try {
			AsteaAPIResponce responce =	locator.executeAPI(session, apicode);
			
			
			
			
		//	int httpStatusCode = OperationStatus.SUCCESS;
			
	
			
		//	OperationStatus status = ((httpStatusCode == HttpURLConnection.HTTP_OK) ? OperationStatus.SUCCESS : OperationStatus.FAILURE);
		//	ResponseUtil.addEmptyResults(response, requestDataBatch, status, String.valueOf(httpStatusCode), null);
			
			
			
			
			
			
			
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        
			
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		
     
		
		
	}

	@Override
    public AllianceConnectorConnection getConnection() {
        return (AllianceConnectorConnection) super.getConnection();
    }
	
	

	private String getBaseUrlOfAlliance(){
		if(url != null && !url.isEmpty())
		{
			if(url.toString().endsWith("/")){
				url = url.substring(0,url.length()-1);
			}
			url = url + String.format("_APP_Framework%s/LogicAppsService.svc/dotnet" , profile);
		}

		return url;
		
	}
	
	private  void WriteToFile( String txt) throws IOException{
		String fileName = "c:/test.txt";
		FileWriter write  =  new FileWriter( fileName , true);
		PrintWriter print_line =  new  PrintWriter(write);
		
		print_line.printf("%s" + "/n" , txt);
		print_line.close();
		
		
	}

	
	private void getConnectionProperties(){
		 user = getContext().getConnectionProperties().getProperty("user");
		  password = getContext().getConnectionProperties().getProperty("password");
		  profile = getContext().getConnectionProperties().getProperty("profile");
		  url = getContext().getConnectionProperties().getProperty("url");
	}

   private String getApicodeOfObject(String objectTypeId) {
	   
		for(ModuleMetadataForLogicApp serviceMd : 	AllianceConnectorBrowser.servicesMDs2){
			
			// Temporary need to call the WCF to bring the exact Object ID
			
			if (serviceMd.getModuleId().equalsIgnoreCase(objectTypeId)){
				return  serviceMd.getModuleApiCode();
			}
		}
		return  null;
	   
   }





}