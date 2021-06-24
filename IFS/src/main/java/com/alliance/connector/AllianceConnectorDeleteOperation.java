package com.alliance.connector;

import com.boomi.connector.api.DeleteRequest;
import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.util.BaseDeleteOperation;

public class AllianceConnectorDeleteOperation extends BaseDeleteOperation {

	protected AllianceConnectorDeleteOperation(AllianceConnectorConnection conn) {
		super(conn);
	}

	@Override
	protected void executeDelete(DeleteRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public AllianceConnectorConnection getConnection() {
        return (AllianceConnectorConnection) super.getConnection();
    }
}