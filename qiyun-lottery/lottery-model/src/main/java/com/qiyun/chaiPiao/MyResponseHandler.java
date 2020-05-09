package com.qiyun.chaiPiao;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

public class MyResponseHandler implements ResponseHandler<String> {

	private String encode;

	public MyResponseHandler() {
		this.encode = "UTF-8";
	}

	public MyResponseHandler(String encode) {
		this.encode = encode;
	}

	public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		StatusLine statusLine = response.getStatusLine();
		if (statusLine.getStatusCode() >= 300) {
			throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
		}

		HttpEntity entity = response.getEntity();
		return entity == null ? null : EntityUtils.toString(entity, this.encode);
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}
}
