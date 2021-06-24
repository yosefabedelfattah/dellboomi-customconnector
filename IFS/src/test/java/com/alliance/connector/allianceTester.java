package com.alliance.connector;

import org.junit.Test;

import com.boomi.connector.testutil.ConnectorTester;




public class allianceTester {
	
	
	 @Test
	public void testExecuteOperation() throws Exception
	{
		 int x= 1;
		 x= 1+1;
		 AllianceConnectorConnector connector  = new  AllianceConnectorConnector();
		 ConnectorTester tester = new ConnectorTester(connector);
		

		
		 x= 1+1;



	}
	
	
	  

}
