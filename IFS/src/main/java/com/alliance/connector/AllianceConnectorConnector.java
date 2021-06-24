package com.alliance.connector;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Browser;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.util.BaseConnector;

public class AllianceConnectorConnector extends BaseConnector {

    @Override
    public Browser createBrowser(BrowseContext context) {
        return new AllianceConnectorBrowser(createConnection(context));
    }    

    @Override
    protected Operation createGetOperation(OperationContext context) {
        return new AllianceConnectorGetOperation(createConnection(context));
    }

    @Override
    protected Operation createQueryOperation(OperationContext context) {
        return new AllianceConnectorQueryOperation(createConnection(context));
    }

    @Override
    protected Operation createCreateOperation(OperationContext context) {
        return new AllianceConnectorCreateOperation(createConnection(context));
    }

    @Override
    protected Operation createUpdateOperation(OperationContext context) {
        return new AllianceConnectorUpdateOperation(createConnection(context));
    }

    @Override
    protected Operation createUpsertOperation(OperationContext context) {
        return new AllianceConnectorUpsertOperation(createConnection(context));
    }

    @Override
    protected Operation createDeleteOperation(OperationContext context) {
        return new AllianceConnectorDeleteOperation(createConnection(context));
    }

    @Override
    protected Operation createExecuteOperation(OperationContext context) {
        return new AllianceConnectorExecuteOperation(createConnection(context));
    }
   
    private AllianceConnectorConnection createConnection(BrowseContext context) {
        return new AllianceConnectorConnection(context);
    }
}