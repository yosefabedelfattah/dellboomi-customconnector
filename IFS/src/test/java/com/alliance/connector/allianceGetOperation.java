package com.alliance.connector;
import com.boomi.connector.api.AtomContext;
import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.ContentType;
import com.boomi.connector.api.ObjectDefinition;
import com.boomi.connector.api.ObjectDefinitions;
import com.boomi.connector.api.ObjectType;
import com.boomi.connector.api.ObjectTypes;
import com.boomi.connector.api.OperationStatus;
import com.boomi.connector.api.OperationType;
import com.boomi.connector.testutil.ConnectorTester;
import com.boomi.connector.testutil.SimpleOperationResult;
import com.boomi.connector.testutil.junit.BrowserTest;

import org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.FieldMetadataForLogicApp;
import org.datacontract.schemas._2004._07.Astea_AO_Interfaces_Contracts.ModuleMetadataForLogicApp;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class allianceGetOperation {
	 @Test
	    public void testGetOperation() throws Exception {
		 
		 String url = "http://172.28.4.249/AsteaAllianceCurrent";
		  url = url + String.format("_APP_Framework%s/LogicAppsService.svc/dotnet" , "VDEV_CURRENT");
		 
		  WriteToFile("ddddd" + "sdsds");
		 
		/* public BrowserTest(java.lang.String label,
		           java.lang.String id,
		           java.lang.String expectedElementName,
		           java.util.EnumSet<OperationType> expectedOperations)*/
		 
       //BrowserTest  test =  new BrowserTest("customer" , "customer" , "customer" ,OperationType.EXECUTE );
		 
		 

		String address = "http://172.28.4.249/AsteaAllianceCurrent_APP_FrameworkVDEV_CURRENT/LogicAppsService.svc/dotnet";
			
	    

		
		
		
		wcf.services.astea.ILogicAppsServiceContractProxy locator =  new wcf.services.astea.ILogicAppsServiceContractProxy();
		locator.setEndpoint(address);
		
		ModuleMetadataForLogicApp[] allianceMDs  = locator.getServicesMetaData("user", "pass", "VDEV_CURRENT");
		 
		boolean  ismatch = allianceMDs[0].getModuleId() == "product_435";
		
		
		String x = BuildInputPutPutSchema(allianceMDs[0]);
		String y = BuildInputPutPutSchema(allianceMDs[1]);


		
		 
		String  customerSchema = "{\n" +
		            "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\n" +
		            "  \"title\": \"AllianceCustomers\",\n" +
		            "  \"type\": \"array\",\n" +
		            "  \"items\": {\n" +
		            "    \"title\": \"Customer\",\n" +
		            "    \"type\": \"object\",\n" +
		            "    \"properties\": {\n" +
		            "      \"company_id\": {\n" +
		            "        \"type\": \"string\"\n" +
		            "      },\n" +
		            "      \"descr\": {\n" +
		            "        \"type\": \"number\"\n" +
		            "      },\n" +
		            "      \"def_node_id\": {\n" +
		            "        \"type\": \"string\"\n" +
		            "      },\n" +
		            "      \"is_site\": {\n" +
		            "        \"type\": \"string\"\n" +
		            "      },\n" +
		            "      \"is_legal\": {\n" +
		            "        \"type\": \"string\"\n" +
		            "      },\n" +
		            "      \"is_active\": {\n" +
		            "        \"type\": \"string\"\n" +
		            "      },\n"+
		            "    }\n" +
		            "  }\n" +
		            "}\n";
		
		 ObjectDefinitions definitions = new ObjectDefinitions();
		 ObjectDefinition allianceCustomerDefinition = new ObjectDefinition();
		 allianceCustomerDefinition.setElementName("Customer");
		    allianceCustomerDefinition.setInputType(ContentType.JSON);
	        allianceCustomerDefinition.setOutputType(ContentType.JSON);
	        allianceCustomerDefinition.setJsonSchema(customerSchema);
	        definitions.getDefinitions().add(allianceCustomerDefinition);
		 
		 List<String> typeNames = new ArrayList<String>();
		 typeNames.add("Followers");
		 typeNames.add("Customer");
		 typeNames.add("Product");
		 typeNames.add("InstalledItem");
	     ObjectTypes types = new ObjectTypes();
	     for (String typeName : typeNames) {
	            ObjectType type = new ObjectType();
	            type.setId(typeName);
	            types.getTypes().add(type);
	        }
	
		 
		 
		 
		
	     
	     
		/* AllianceConnectorConnector connector = new AllianceConnectorConnector();
		 
	//	 AllianceConnectorConnection conn = 	allian.getConnection();
			
			//conn.getContext().getConnectionProperties().getProperty("url");
		 
		 
		
		 		
	        ConnectorTester tester = new ConnectorTester(connector);

	        tester.setBrowseContext(newBrowseContext);(OperationType.GET, null, null, "Follower", null);

	        tester.testExecuteGetOperation("soofaloofa", Arrays.asList(
	                new SimpleOperationResult(OperationStatus.SUCCESS, "200", null, Arrays.asList("test".getBytes()))));*/
	    }
	 
	 
	
	 private  String BuildInputPutPutSchema(ModuleMetadataForLogicApp serviceMd){
			
			
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
			
			
			return schema.toString();
		}
	 
	 
	 
		
		private  void WriteToFile( String txt) throws IOException{
			String fileName = "c:/test.txt";
			FileWriter write  =  new FileWriter( fileName , true);
			PrintWriter print_line =  new  PrintWriter(write);
			
			print_line.printf("%s" + "/n" , txt);
			print_line.close();
			
			
		}
		
		
	 

}
