package com.alliance.connector;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.boomi.connector.api.GetRequest;
import com.boomi.connector.api.ObjectIdData;
import com.boomi.connector.api.OperationResponse;
import com.boomi.connector.api.ResponseUtil;
import com.boomi.connector.util.BaseGetOperation;

public class AllianceConnectorGetOperation extends BaseGetOperation {

    protected AllianceConnectorGetOperation(AllianceConnectorConnection conn) {
        super(conn);
    }


	 @Override
	    protected void executeGet(GetRequest request, OperationResponse response) {
	        ObjectIdData requestData = request.getObjectId();
	        String objectId = requestData.getObjectId();

	        String requestUrl = "https://api.github.com/users/" + objectId + "/followers";
	        try {
	            HttpURLConnection httpConnection = (HttpURLConnection) new URL(requestUrl).openConnection();
	            InputStream httpResponse = httpConnection.getInputStream();
	            int httpStatusCode = httpConnection.getResponseCode();

	            if (httpStatusCode == HttpURLConnection.HTTP_OK) {
	                ResponseUtil.addSuccess(response, requestData, String.valueOf(httpStatusCode),
	                        ResponseUtil.toPayload(httpResponse));
	            } else {
	                ResponseUtil.addFailure(response, requestData, String.valueOf(httpStatusCode));
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	@Override
    public AllianceConnectorConnection getConnection() {
        return (AllianceConnectorConnection) super.getConnection();
    }
}