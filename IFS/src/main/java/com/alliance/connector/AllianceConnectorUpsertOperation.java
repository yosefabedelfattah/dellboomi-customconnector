package com.alliance.connector;

import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.UpdateRequest;
import com.boomi.connector.util.BaseUpdateOperation;

public class AllianceConnectorUpsertOperation extends BaseUpdateOperation {

	protected AllianceConnectorUpsertOperation(AllianceConnectorConnection conn) {
		super(conn);
	}

	@Override
	protected void executeUpdate(UpdateRequest request, OperationResponse response) {
		// TODO Auto-generated method stub
	}

	@Override
    public AllianceConnectorConnection getConnection() {
        return (AllianceConnectorConnection) super.getConnection();
    }
}