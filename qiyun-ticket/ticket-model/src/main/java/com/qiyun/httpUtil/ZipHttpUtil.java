package com.qiyun.httpUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.qiyun.tools.StringTools;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipHttpUtil {
	private static Logger logger = LoggerFactory.getLogger(ZipHttpUtil.class);

	public static String sendZipHttp(String url, String message) {
		if (StringTools.isNullOrBlank(message)) {
			logger.info("a blank message, return.");
			return null;
		}
		PostMethod postMethod = new PostMethod(url);
		postMethod.setContentChunked(true);
		postMethod.addRequestHeader("Content-Type", "application/x-gzip");
		postMethod.addRequestHeader("Accept", "application/x-gzip,text/plain");
		postMethod.setRequestHeader("Content-Encoding", "gzip");
		postMethod.setRequestHeader("Transfer-Encoding", "chunked");

		try {
			// ByteArrayOutputStream originalContent = new ByteArrayOutputStream();
			// originalContent.write(message.getBytes(Charset.forName("UTF-8")));

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			GZIPOutputStream gzipOut = new GZIPOutputStream(baos);
			gzipOut.write(message.getBytes(Charset.forName("GBK")));
			// gzipOut.write(message.getBytes(Charset.forName("UTF-8")));
			// originalContent.writeTo(gzipOut);
			gzipOut.finish();

			postMethod.setRequestEntity(new ByteArrayRequestEntity(baos.toByteArray(),
					"text/plain; charset=GBK"));
			// postMethod.setRequestEntity(new ByteArrayRequestEntity(baos
			// .toByteArray(), "text/plain; charset=utf-8"));
			gzipOut.close();
		} catch (IOException e) {
			logger.error("write message fail.", e);
			return null;
		}

		HttpClient httpClient = new HttpClient();
		int retry = 0;
		do {
			try {
				int status = httpClient.executeMethod(postMethod);
				if (HttpStatus.SC_OK == status) {
					// if (LOGGER.isDebugEnabled()) {
					// LOGGER.debug("send http success, url=" + url
					// + ", content=" + message);
					// }
//					String rsp = postMethod.getResponseBodyAsString();
					StringBuffer respStr = new StringBuffer();

					InputStream is = postMethod.getResponseBodyAsStream();

					// 返回结果解压

					BufferedReader br = new BufferedReader(new InputStreamReader(new GZIPInputStream(is), "GBK"));
					String line = null;
					while ((line = br.readLine()) != null) {
						respStr.append(line);
					}

					return respStr.toString();
				} else {
					String rsp = postMethod.getResponseBodyAsString();
					logger.error("send http fail, status is: " + status + ", response is: " + rsp);
				}
			} catch (HttpException e) {
				logger.info("http exception when send http.", e);
			} catch (IOException e) {
				logger.info("io exception when send http.", e);
			} finally {
				postMethod.releaseConnection();
			}
			logger.info("this is " + retry + " time, try next");
		} while (retry++ < 3);
		return null;
	}

	public static String sendHttp(String url, String message) {
		BufferedReader buffer = null;
		String result = "";
		try {
			// 1.建立HttpClient对象
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 配置超时时间
//			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000)
//					.setConnectionRequestTimeout(1000).setSocketTimeout(1000).setRedirectsEnabled(true).build();
			HttpPost httpPost = new HttpPost(url);
			//装配post请求参数
	        List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>(); 
	        list.add(new BasicNameValuePair("wAction", "102"));  //请求参数
	        list.add(new BasicNameValuePair("wMessage", message)); //请求参数
//			httpPost.setConfig(requestConfig);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"GBK");
//			StringEntity se = new StringEntity(message);
			httpPost.setEntity(entity);
			CloseableHttpResponse response = httpclient.execute(httpPost);
			buffer = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "GBK"));
			result = buffer.readLine();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			buffer.close();
		}
		return result;
	}

	public static String sendGetHttp(String url, JSONObject message) {
//		BufferedReader buffer = null;
		String result = "";
		// 1.建立HttpClient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			//装配get请求参数
			List<NameValuePair> params = new ArrayList<NameValuePair>();
//	        params.add(new BasicNameValuePair("username", "admin"));
//	        params.add(new BasicNameValuePair("password", "123456"));
			@SuppressWarnings("unchecked")
			Iterator<String> sIterator = message.keySet().iterator();
			//循环并得到key列表
			while (sIterator.hasNext()) {
				// 获得key
				String key = sIterator.next();
				//获得key值对应的value
				String value = message.getString(key);
				//装配get请求参数
				params.add(new BasicNameValuePair(key, value));
			}
			//参数转换为字符串
			String paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(params, "UTF-8"));
			url = url + "?" + paramsStr;
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(httpGet);
//			buffer = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
//			result = buffer.readLine();
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity);
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
