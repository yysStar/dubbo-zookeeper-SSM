package com.qiyun.httpUtil;

import com.qiyun.util.LogUtil;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpConnectionParams;

public class HttpClientUtil {
	public static String getRemoteStr(String url, String encode) {
		try {
//			DefaultHttpClient httpclient = new DefaultHttpClient();
//
//			httpclient.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, 30000); // 超时设置
//			httpclient.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 30000);// 连接超时
			//重写过期方法
			CloseableHttpClient httpclient = HttpClients.createDefault();

			RequestConfig requestConfig = RequestConfig.custom()// 超时设置
					.setConnectTimeout(30000).setConnectionRequestTimeout(10000)
					.setSocketTimeout(30000).build();// 连接超时

//			HttpUriRequest httpReq = new HttpGet(url);
			HttpGet httpGet = new HttpGet(url);
			httpGet.setConfig(requestConfig);
			HttpUriRequest httpReq = httpGet;
			ResponseHandler<String> responseHandler = new MyResponseHandler(encode);
			String returnStr = httpclient.execute(httpReq, responseHandler);
			httpclient.close();
			return returnStr;
		} catch (Exception e) {
			LogUtil.error(e);
		}
		return null;
	}

}
