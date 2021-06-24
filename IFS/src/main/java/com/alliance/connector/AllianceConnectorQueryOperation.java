package com.alliance.connector;

import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.QueryRequest;
import com.boomi.connector.util.BaseQueryOperation;

public class AllianceConnectorQueryOperation extends BaseQueryOperation {

	protected AllianceConnectorQueryOperation(AllianceConnectorConnection conn) {
		super(conn);
	}

	@Override
	protected void executeQuery(QueryRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public AllianceConnectorConnection getConnection() {
        return (AllianceConnectorConnection) super.getConnection();
    }
}