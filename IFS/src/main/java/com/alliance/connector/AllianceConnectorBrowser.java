package com.alliance.connector;

import java.util.ArrayList;
import java.util.Collection;

import com.boomi.connector.api.ConnectionTester;
import com.boomi.connector.api.ConnectorException;
import com.boomi.connector.api.ContentType;
import com.boomi.connector.api.ObjectDefinition;
import com.boomi.connector.api.ObjectDefinitionRole;
import com.boomi.connector.api.ObjectDefinitions;
import com.boomi.connector.api.ObjectType;
import com.boomi.connector.api.ObjectTypes;
import com.boomi.connector.api.OperationType;
import com.boomi.connector.util.BaseBrowser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.List;

import org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.FieldMetadataForLogicApp;
import org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.ModuleMetadataForLogicApp;

public class AllianceConnectorBrowser extends BaseBrowser implements ConnectionTester  {
	List<String> typeNames = new ArrayList<String>();
	static  ModuleMetadataForLogicApp[] servicesMDs2;
    String user  = "";
    String password = "";
    String profile = "";
    String url = "";
    
	ModuleMetadataForLogicApp[] servicesMDs;

    protected AllianceConnectorBrowser(AllianceConnectorConnection conn) {
        super(conn);
    }

	@Override
	public ObjectDefinitions getObjectDefinitions(String objectTypeId,
			Collection<ObjectDefinitionRole> roles) {

		
		try
		{
		WriteToFile("Enter getObjectDefinitions Types " + objectTypeId);
		}
		catch(Exception e)
		{
			
		}
		
		
	    ObjectDefinitions definitions = new ObjectDefinitions();
		try {
			getConnectionProperties();
			OperationType operationType = getContext().getOperationType(); 
				
			try
			{
			WriteToFile("Enter getObjectDefinitions Types " + operationType.name());
			}
			catch(Exception e)
			{
				
			}
			
			String endPoint  = getBaseUrlOfAlliance();
			
			wcf.services.astea.ILogicAppsServiceContractProxy locator =  new wcf.services.astea.ILogicAppsServiceContractProxy();
			locator.setEndpoint(endPoint);
					
			servicesMDs2  = locator.getServicesMetaData(user, password, profile);

			for(ModuleMetadataForLogicApp serviceMd : servicesMDs2){
				
				// Temporary need to call the WCF to bring the exact Object ID
				
				if (serviceMd.getModuleId().equalsIgnoreCase(objectTypeId)){
					
					 for (ObjectDefinitionRole role: roles){
						 
						 ObjectDefinition objDefinition = new ObjectDefinition();
						 objDefinition.setElementName(""); //this assumes the response object schema is at the root of the returned json schema
						 if (ObjectDefinitionRole.INPUT == role) 
							 {
								try
								{
								WriteToFile("Enter getObjectDefinitions Types  ObjectDefinitionRole.INPUT1 ");
								}
								catch(Exception e)
								{
									
								}
								
								 objDefinition.setInputType(ContentType.JSON);
								 switch (operationType)
									{
										case EXECUTE: // This means we will execute API ( SOAP Request )
											objDefinition.setJsonSchema(getServiceSchema(serviceMd)); 
											break;
										default:
											break;
									}
							 }
						 else{
							 
							 objDefinition.setOutputType(ContentType.JSON);
							 switch (operationType)
								{
									case EXECUTE: // This means we will execute API ( SOAP Request )
										objDefinition.setJsonSchema(BuildSchemaOfResponse()); 
										break;
									default:
										break;
								}
										
							 
						 }
						    definitions.getDefinitions().add(objDefinition);
						 }
					 
					 }
				else{
					
					try
					{
					WriteToFile("Enter getObjectDefinitions  : Object Id  no match ");
					}
					catch(Exception e)
					{
						
					}
					
				}
				}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		 return definitions;
	}
	
	
	
	
	private String getServiceSchema(ModuleMetadataForLogicApp serviceMd) {

		try{
		return BuildSchemaOfParams(serviceMd);
		}
		catch(Exception e){
		return null;
		}

	}
	
	

	@Override
	public ObjectTypes getObjectTypes() {
		
		try
		{
		WriteToFile("Enter get object Types");
		}
		catch(Exception e)
		{		
		}
	
	    ObjectTypes types = new ObjectTypes();    
	 	try {
	 		getConnectionProperties();
			String endPoint  = getBaseUrlOfAlliance();
			wcf.services.astea.ILogicAppsServiceContractProxy locator =  new wcf.services.astea.ILogicAppsServiceContractProxy();
			locator.setEndpoint(endPoint);

		    servicesMDs  = locator.getServicesMetaData(user, password, profile);

		    for(ModuleMetadataForLogicApp serviceMd : servicesMDs){
				String typeName  = serviceMd.getModuleId();
	            ObjectType type = new ObjectType();
	            type.setId(typeName);
	            types.getTypes().add(type);
	        }
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw  new Exception( String.format("getObjectTypes() Failed  Arguments passed to WCF Service are :User = %s , Profile = %s ,URL =  %s ", user,profile,url ));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	        return types;
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

	private  String BuildSchemaOfParams(ModuleMetadataForLogicApp serviceMd){
	
		
		StringBuilder schema = new StringBuilder( "{\n" +
	            "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
	            "  \"title\": \"AllianceServices\",\n" +
	            "  \"type\": \"array\",\n" +
	            "  \"items\": {\n" );
		
			
			schema.append( "    \"title\": \""+serviceMd.getModuleId()+"\",\n" +
						   "    \"type\": \"object\",\n" +
		                   "    \"properties\": {\n" );
			
			
			for(FieldMetadataForLogicApp field  : serviceMd.getModuleFieldsForLogicApps()){
			
					schema.append( "      \""+field.getId()+"\": {\n" +
			                       "        \"type\": \"string\"\n" +
			                       "      },\n" );
					}
					
			// if ends with ,  remove it 
			schema.setLength(schema.length() - 2);
			
			schema.append("\n    }\n" + //pro
						  "  }\n" +
						  "}\n");
		
		
			try{
				WriteToFile(schema.toString());	
			}
			catch(Exception e){
				
			}
			
		return schema.toString();
	}

	
	private  String BuildSchemaOfResponse()
	{
		String objectname = "allianceapiresponce";
		String[] responceFields =  {"ErrorCode","Result","Description" , "Succeded"};
		StringBuilder schema = new StringBuilder( "{\n" +
	            "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
	            "  \"title\": \"AllianceServices\",\n" +
	            "  \"type\": \"array\",\n" +
	            "  \"items\": {\n" );
		
			
			schema.append( "    \"title\": \""+objectname+"\",\n" +
						   "    \"type\": \"object\",\n" +
		                   "    \"properties\": {\n" );
			
			
			for(String field  : responceFields){
			
					schema.append( "      \""+field+"\": {\n" +
			                       "        \"type\": \"string\"\n" +
			                       "      },\n" );
					}
					
			// if ends with ,  remove it 
			schema.setLength(schema.length() - 2);
			
			schema.append("\n    }\n" + //pro
						  "  }\n" +
						  "}\n");
		
		
			try{
				WriteToFile(schema.toString());	
			}
			catch(Exception e){
				
			}
			
		return schema.toString();
	}
	
	
	@Override
	public void testConnection() {
		try
		{
		WriteToFile("Enter test Connection");
		}
		catch(Exception e)
		{
			
		}
		// TODO Auto-generated method stub
		getConnectionProperties();
		String endPoint  = getBaseUrlOfAlliance();
		wcf.services.astea.ILogicAppsServiceContractProxy locator =  new wcf.services.astea.ILogicAppsServiceContractProxy();
		locator.setEndpoint(endPoint);

		 
		 try {
			String session = locator.login(user, password, profile);
			if ( ! locator.isSessionValid(session) )
				 throw new ConnectorException("Could not Login using the User/Pass / Profile supplied");
			else
				locator.logout(session);
				
		} catch (Exception e) {
			  throw new ConnectorException("Could not establish a connection ", e);
		} 
		 
		
	}
	
	private void getConnectionProperties(){
		 user = getContext().getConnectionProperties().getProperty("user");
		  password = getContext().getConnectionProperties().getProperty("password");
		  profile = getContext().getConnectionProperties().getProperty("profile");
		  url = getContext().getConnectionProperties().getProperty("url");
	}
	
	// code For Debugging to be remove later 
	private  void WriteToFile( String txt) throws IOException{
		String fileName = "c:/test.txt";
		FileWriter write  =  new FileWriter( fileName , true);
		PrintWriter print_line =  new  PrintWriter(write);
		
		print_line.printf("%s" + "/n" , txt);
		print_line.close();
		
		
	}
	
	
	
	
}