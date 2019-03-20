package com.qiyun.util;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientNewUtil {

	public static String post(String url, Map paramMap) throws Exception {
		BasicCookieStore cookieStore = new BasicCookieStore();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
		try {
			RequestBuilder reguestBuilder = RequestBuilder.post().setUri(new URI(url));
			Iterator iter = paramMap.entrySet().iterator();// 将参数添加到POST的参数中
			List<BasicNameValuePair> formparams = new ArrayList<BasicNameValuePair>();// 创建参数队列
			while (iter.hasNext()) {
				Entry entry = (Entry) iter.next();
				String key = String.valueOf(entry.getKey());
				String val = String.valueOf(entry.getValue());
				formparams.add(new BasicNameValuePair(key, val));
			}
			reguestBuilder.setEntity(new UrlEncodedFormEntity(formparams, Consts.UTF_8));  //防止中文乱码
			HttpUriRequest httpUriRequest = reguestBuilder.build();
			CloseableHttpResponse response2 = httpclient.execute(httpUriRequest);
			try {
				HttpEntity entity = response2.getEntity();
				String retStr = EntityUtils.toString(entity, "utf-8");
				return retStr;

			} finally {
				response2.close();
			}
		} finally {
			httpclient.close();
		}
	}
	
}


