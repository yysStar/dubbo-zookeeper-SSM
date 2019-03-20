package com.qiyun.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.apache.struts2.ServletActionContext;
import org.htmlparser.Parser;
import org.htmlparser.util.ParserException;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

public class HttpUtil {
	static public InputStream getHtmlStreamByGetMethod(String url) {
		InputStream response = null;
		HttpClient httpClient = new HttpClient();
		// 设置 Http 连接超时为5秒
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		/* 2 生成 GetMethod 对象并设置参数 */
		GetMethod getMethod = new GetMethod(url);
		// 设置 get 请求超时为 5 秒
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

		/* 3 执行 HTTP GET 请求 */
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			/* 4 判断访问的状态码 */
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + getMethod.getStatusLine());
			}
			/* 5 处理 HTTP 响应内容 */
			// HTTP响应头部信息，这里简单打印
			Header[] headers = getMethod.getResponseHeaders();
			// 读取 HTTP 响应内容，这里简单打印网页内容
			byte[] responseBody = getMethod.getResponseBody();// 读取为字节数组
			// 读取为 InputStream，在网页内容数据量大时候推荐使用
			response = getMethod.getResponseBodyAsStream();//
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			LogUtil.error("Please check your provided http address!",e);
		} catch (IOException e) {
			// 发生网络异常
			LogUtil.error(e);
		} finally {
			/* 6 .释放连接 */
			getMethod.releaseConnection();
		}
		return response;
	}

	static public byte[] getHtmlByGetMethod(String url) {
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
		System.setProperty("org.apache.commons.logging" + ".simplelog.log.org.apache.commons.httpclient", "error");
		byte[] responseBody = new byte[] {};
		HttpClient httpClient = new HttpClient();
		// 设置 Http 连接超时为5秒
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		/* 2 生成 GetMethod 对象并设置参数 */
		GetMethod getMethod = new GetMethod(url);
		// 设置 get 请求超时为 5 秒
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());

		/* 3 执行 HTTP GET 请求 */
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			/* 4 判断访问的状态码 */
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + getMethod.getStatusLine());
			}
			/* 5 处理 HTTP 响应内容 */
			// HTTP响应头部信息，这里简单打印
			Header[] headers = getMethod.getResponseHeaders();
			// 读取 HTTP 响应内容，这里简单打印网页内容
			responseBody = getMethod.getResponseBody();// 读取为字节数组
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			LogUtil.error(e);
		} catch (IOException e) {
			// 发生网络异常
			LogUtil.error(e);
		} finally {
			/* 6 .释放连接 */
			getMethod.releaseConnection();
		}
		return responseBody;
	}

	static public String getHttpUrl(String urlString) {

		URL url = null;
		URLConnection connection = null;
		BufferedReader in = null;
		if (urlString != null && !urlString.trim().startsWith("http:")) {
			LogUtil.info("http tools: 非法请求(" + urlString + ")");
			return "";
		}

		try {
			url = new URL(urlString);
			connection = url.openConnection();
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(60000);
			if (connection instanceof HttpsURLConnectionImpl) {

				HttpsURLConnection https = (HttpsURLConnection) connection;
				https.setHostnameVerifier(new MyVerified());

				X509TrustManager xtm = new MyTrustManager();
				TrustManager mytm[] = { xtm };
				SSLContext ctx = SSLContext.getInstance("SSL");
				ctx.init(null, mytm, null);
				SSLSocketFactory sf = ctx.getSocketFactory();
				https.setSSLSocketFactory(sf);

			}

			Map headers = connection.getHeaderFields();
			if (headers.size() > 0) {
				String response = headers.get(null).toString();
				if (response.indexOf("200 OK") < 0) {
					throw new Exception("读取地址:" + url + " 错误:" + response);
				}
			}
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String temp = in.readLine();
			return temp;
		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {

			}
		}
		return null;

	}

	static public Document getHttpUrlDocument(String urlString) {
		try {
			SAXBuilder sb = new SAXBuilder();
			Reader reader = new StringReader(getHttpUrlContent(urlString));
			return sb.build(reader);
		} catch (Exception e) {
			LogUtil.error(e);
			return null;
		}
	}

	static public String getHttpUrlContent(String urlString) {
		return getHttpUrlContent(urlString, "UTF-8");
	}

	static public String getHttpUrlJson(String urlString) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(urlString);
			httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity, "UTF-8");
		} catch(Exception ex) {

		}
		return null;
//		URL url = null;
//		URLConnection connection = null;
//		BufferedReader in = null;
//
//		if (urlString != null && !urlString.trim().startsWith("http:")) {
//			 LogUtil.info("http tools: 非法请求(" + urlString + ")");
//			return "";
//		}
//
//		try {
//
//			HttpClient h = new HttpClient()
//
//			url = new URL(urlString);
//			connection = url.openConnection();
//			connection.setConnectTimeout(30000);
//			connection.setReadTimeout(60000);
//			connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
//			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
//			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0");
//			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
//
//			if (connection instanceof HttpsURLConnectionImpl) {
//
//				HttpsURLConnection https = (HttpsURLConnection) connection;
//				https.setHostnameVerifier(new MyVerified());
//
//				X509TrustManager xtm = new MyTrustManager();
//				TrustManager mytm[] = { xtm };
//				SSLContext ctx = SSLContext.getInstance("SSL");
//				ctx.init(null, mytm, null);
//				SSLSocketFactory sf = ctx.getSocketFactory();
//				https.setSSLSocketFactory(sf);
//
//			}
//			//  LogUtil.info(connection.getContentEncoding());
//			Map headers = connection.getHeaderFields();
//			if (headers.size() > 0) {
//				String response = headers.get(null).toString();
//				if (response.indexOf("200 OK") < 0) {
//					throw new Exception("读取地址:" + url + " 错误:" + response);
//				}
//				/*
//				 *  LogUtil.info(headers.keySet().toArray().length);
//				 * for(Object o:headers.keySet().toArray()) {
//				 *  LogUtil.info(o==null?"":o.toString()
//				 * +"="+headers.get(o)); } //
//				 */
//				try {
//					String contentType = headers.get("Content-Type").toString().replaceAll("\\[|\\]", "");
//					String ct[] = contentType.split(";");
//					if (ct.length > 1) {
//						String[] cs = ct[1].split("=");
//						if (cs.length > 1) {
//							charset = cs[1];
//						}
//					}
//				} catch (Exception e) {
//					 LogUtil.info(e.getMessage() + "");
//				}
//			}
//			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
//			StringBuffer sb = new StringBuffer();
//			String temp = "";
//			while ((temp = in.readLine()) != null) {
//				sb.append(temp);
//			}
//			return sb.toString();
//		} catch (Exception e) {
//			LogUtil.error(e);
//		} finally {
//			try {
//				if (in != null)
//					in.close();
//			} catch (Exception e) {
//
//			}
//		}
//		return null;

	}

	static public String getHttpUrlContent(String urlString, String charset) {

		URL url = null;
		URLConnection connection = null;
		BufferedReader in = null;

		if (urlString != null && !urlString.trim().startsWith("http:")) {
			LogUtil.info("http tools: 非法请求(" + urlString + ")");
			return "";
		}

		try {
			url = new URL(urlString);
			connection = url.openConnection();
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(60000);
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			connection.setRequestProperty("Referer", urlString);

			if (connection instanceof HttpsURLConnectionImpl) {

				HttpsURLConnection https = (HttpsURLConnection) connection;
				https.setHostnameVerifier(new MyVerified());

				X509TrustManager xtm = new MyTrustManager();
				TrustManager mytm[] = { xtm };
				SSLContext ctx = SSLContext.getInstance("SSL");
				ctx.init(null, mytm, null);
				SSLSocketFactory sf = ctx.getSocketFactory();
				https.setSSLSocketFactory(sf);

			}
			//  LogUtil.info(connection.getContentEncoding());
			Map headers = connection.getHeaderFields();
			if (headers.size() > 0) {
				String response = headers.get(null).toString();
				if (response.indexOf("200 OK") < 0) {
					throw new Exception("读取地址:" + url + " 错误:" + response);
				}
				/*
				 *  LogUtil.info(headers.keySet().toArray().length);
				 * for(Object o:headers.keySet().toArray()) {
				 *  LogUtil.info(o==null?"":o.toString()
				 * +"="+headers.get(o)); } //
				 */
				try {
					String contentType = headers.get("Content-Type").toString().replaceAll("\\[|\\]", "");
					String ct[] = contentType.split(";");
					if (ct.length > 1) {
						String[] cs = ct[1].split("=");
						if (cs.length > 1) {
							charset = cs[1];
						}
					}
				} catch (Exception e) {
					LogUtil.info(e.getMessage() + "");
				}
			}
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
			StringBuffer sb = new StringBuffer();
			String temp = "";
			while ((temp = in.readLine()) != null) {
				sb.append(temp);
			}
			return sb.toString();
		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {

			}
		}
		return null;

	}

	static public String getUrlTextContent(String urlString) {

		URL url = null;
		URLConnection connection = null;
		BufferedReader in = null;

		if (urlString != null && !urlString.trim().startsWith("http:")) {
			LogUtil.info("http tools: 非法请求(" + urlString + ")");
			return "";
		}

		try {
			url = new URL(urlString);
			connection = url.openConnection();
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(60000);
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");

			if (connection instanceof HttpsURLConnectionImpl) {

				HttpsURLConnection https = (HttpsURLConnection) connection;
				https.setHostnameVerifier(new MyVerified());

				X509TrustManager xtm = new MyTrustManager();
				TrustManager mytm[] = { xtm };
				SSLContext ctx = SSLContext.getInstance("SSL");
				ctx.init(null, mytm, null);
				SSLSocketFactory sf = ctx.getSocketFactory();
				https.setSSLSocketFactory(sf);

			}
			//  LogUtil.info(connection.getContentEncoding());
			Map headers = connection.getHeaderFields();
			String charset = "UTF-8"; // default IE charset
			if (headers.size() > 0) {
				String response = headers.get(null).toString();
				if (response.indexOf("200 OK") < 0) {
					throw new Exception("读取地址:" + url + " 错误:" + response);
				}
				/*
				 *  LogUtil.info(headers.keySet().toArray().length);
				 * for(Object o:headers.keySet().toArray()) {
				 *  LogUtil.info(o==null?"":o.toString()
				 * +"="+headers.get(o)); } //
				 */
				try {
					String contentType = headers.get("Content-Type").toString().replaceAll("\\[|\\]", "");
					String ct[] = contentType.split(";");
					if (ct.length > 1) {
						String[] cs = ct[1].split("=");
						if (cs.length > 1) {
							charset = cs[1];
						}
					}
				} catch (Exception e) {
					LogUtil.info(e.getMessage() + "");
				}
			}
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), charset));
			StringBuffer sb = new StringBuffer();
			String temp = "";
			while ((temp = in.readLine()) != null) {
				sb.append(temp + "\r\n");
			}
			return sb.toString();
		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {

			}
		}
		return null;

	}

	static public String getUrl(String urlString){
		return getUrl(urlString,"GBK");
	}

	static public String getUrl(String urlString,String charsetCode) {

		URL url = null;
		URLConnection connection = null;
		InputStream in = null;

		if (urlString != null && !urlString.trim().startsWith("http:")) {
			LogUtil.info("http tools: 非法请求(" + urlString + ")");
			return "";
		}

		try {
			url = new URL(urlString);
//			关掉代理
//			//匹配url为500的 就用代理
//			Pattern pattern500 = Pattern.compile("\\.(500|500wan)\\.");
//			Matcher matcher500 = pattern500.matcher(urlString);
//
//			//匹配url为ydniu的 就用代理
//			Pattern patternYdniu = Pattern.compile("\\.(ydniu)\\.");
//			Matcher matcherYdniu = patternYdniu.matcher(urlString);
//
//			if(false && matcher500.find()){
//				SocketAddress addr = new InetSocketAddress("117.177.250.152",80);//代理地址
//				Proxy typeProxy = new Proxy(Proxy.Type.HTTP, addr);
//				connection = url.openConnection(typeProxy);
//			} else if(matcherYdniu.find()){
//				SocketAddress addr = new InetSocketAddress("111.23.4.138",8000);//代理地址
//				Proxy typeProxy = new Proxy(Proxy.Type.HTTP, addr);
//				connection = url.openConnection(typeProxy);
//			}else{
				connection=url.openConnection();
//			}

			connection.setConnectTimeout(60000);
			connection.setReadTimeout(60000);
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
			connection.setRequestProperty("Referer", urlString);
			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");

			String charset = charsetCode; // default IE charset
			String encoding = "";
			if (connection instanceof HttpsURLConnectionImpl) {

				HttpsURLConnection https = (HttpsURLConnection) connection;
				https.setHostnameVerifier(new MyVerified());

				X509TrustManager xtm = new MyTrustManager();
				TrustManager mytm[] = { xtm };
				SSLContext ctx = SSLContext.getInstance("SSL");
				ctx.init(null, mytm, null);
				SSLSocketFactory sf = ctx.getSocketFactory();
				https.setSSLSocketFactory(sf);

			}
			if (connection instanceof HttpURLConnection) {

				HttpURLConnection http = (HttpURLConnection) connection;
				encoding = http.getContentEncoding();

			}
			//  LogUtil.info(connection.getContentEncoding());
			Map headers = connection.getHeaderFields();
			if (headers.size() > 0) {
				String response = headers.get(null).toString();
				if (response.indexOf("200 OK") < 0) {
					throw new Exception("读取地址:" + url + " 错误:" + response);
				}
				/*
				 *  LogUtil.info(headers.keySet().toArray().length);
				 * for(Object o:headers.keySet().toArray()) {
				 *  LogUtil.info(o==null?"":o.toString()
				 * +"="+headers.get(o)); } //
				 */
				// *
				try {
					String contentType = headers.get("Content-Type").toString().replaceAll("\\[|\\]|\\\"", "");
					String ct[] = contentType.split(";");
					if (ct.length > 1) {
						String[] cs = ct[1].split("=");
						if (cs.length > 1) {
							charset = cs[1];
						}
					}
				} catch (Exception e) {
					 LogUtil.info(e.getMessage() + "");
				}
				// */
			}

			if (("gzip").equals(encoding)) {
				in = new GZIPInputStream(connection.getInputStream());
			} else {
				in = connection.getInputStream();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
			StringBuffer sb = new StringBuffer();
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				sb.append(temp + "\r\n");
			}
			return sb.toString();

		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {

			}
		}
		return null;

	}

	static public String getUrlHttps(String urlString) {

		URL url = null;
		URLConnection connection = null;
		InputStream in = null;

		if (urlString != null && !urlString.trim().startsWith("https:")) {
			 LogUtil.info("http tools: 非法请求(" + urlString + ")");
			return "";
		}

		try {
			url = new URL(urlString);
			connection = url.openConnection();
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(60000);
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			connection.setRequestProperty("Referer", urlString);
			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");

			String charset = "GBK"; // default IE charset
			String encoding = "";
			if (connection instanceof HttpsURLConnectionImpl) {

				HttpsURLConnection https = (HttpsURLConnection) connection;
				https.setHostnameVerifier(new MyVerified());

				X509TrustManager xtm = new MyTrustManager();
				TrustManager mytm[] = { xtm };
				SSLContext ctx = SSLContext.getInstance("SSL");
				ctx.init(null, mytm, null);
				SSLSocketFactory sf = ctx.getSocketFactory();
				https.setSSLSocketFactory(sf);

			}
			if (connection instanceof HttpURLConnection) {

				HttpURLConnection http = (HttpURLConnection) connection;
				encoding = http.getContentEncoding();

			}
			//  LogUtil.info(connection.getContentEncoding());
			Map headers = connection.getHeaderFields();
			if (headers.size() > 0) {
				String response = headers.get(null).toString();
				if (response.indexOf("200 OK") < 0) {
					throw new Exception("读取地址:" + url + " 错误:" + response);
				}
				/*
				 *  LogUtil.info(headers.keySet().toArray().length);
				 * for(Object o:headers.keySet().toArray()) {
				 *  LogUtil.info(o==null?"":o.toString()
				 * +"="+headers.get(o)); } //
				 */
				// *
				try {
					String contentType = headers.get("Content-Type").toString().replaceAll("\\[|\\]", "");
					String ct[] = contentType.split(";");
					if (ct.length > 1) {
						String[] cs = ct[1].split("=");
						if (cs.length > 1) {
							charset = cs[1];
						}
					}
				} catch (Exception e) {
					 LogUtil.info(e.getMessage() + "");
				}
				// */
			}

			if (("gzip").equals(encoding)) {
				in = new GZIPInputStream(connection.getInputStream());
			} else {
				in = connection.getInputStream();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
			StringBuffer sb = new StringBuffer();
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				sb.append(temp + "\r\n");
			}
			return sb.toString();

		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {

			}
		}
		return null;

	}

	static public String getUrlUtf8(String urlString) {

		URL url = null;
		URLConnection connection = null;
		InputStream in = null;

		if (urlString != null && !urlString.trim().startsWith("http:")) {
			 LogUtil.info("http tools: 非法请求(" + urlString + ")");
			return "";
		}

		try {
			url = new URL(urlString);
			connection = url.openConnection();
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(60000);
			connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
			connection.setRequestProperty("Referer", urlString);
			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");

			String charset = "utf-8"; // default IE charset
			String encoding = "";
			if (connection instanceof HttpsURLConnectionImpl) {

				HttpsURLConnection https = (HttpsURLConnection) connection;
				https.setHostnameVerifier(new MyVerified());

				X509TrustManager xtm = new MyTrustManager();
				TrustManager mytm[] = { xtm };
				SSLContext ctx = SSLContext.getInstance("SSL");
				ctx.init(null, mytm, null);
				SSLSocketFactory sf = ctx.getSocketFactory();
				https.setSSLSocketFactory(sf);

			}
			if (connection instanceof HttpURLConnection) {

				HttpURLConnection http = (HttpURLConnection) connection;
				encoding = http.getContentEncoding();

			}
			//  LogUtil.info(connection.getContentEncoding());
			Map headers = connection.getHeaderFields();
			if (headers.size() > 0) {
				String response = headers.get(null).toString();
				if (response.indexOf("200 OK") < 0) {
					throw new Exception("读取地址:" + url + " 错误:" + response);
				}
				/*
				 *  LogUtil.info(headers.keySet().toArray().length);
				 * for(Object o:headers.keySet().toArray()) {
				 *  LogUtil.info(o==null?"":o.toString()
				 * +"="+headers.get(o)); } //
				 */
				// *
				try {
					String contentType = headers.get("Content-Type").toString().replaceAll("\\[|\\]", "");
					String ct[] = contentType.split(";");
					if (ct.length > 1) {
						String[] cs = ct[1].split("=");
						if (cs.length > 1) {
							charset = cs[1];
						}
					}
				} catch (Exception e) {
					 LogUtil.info(e.getMessage() + "");
				}
				// */
			}

			if (("gzip").equals(encoding)) {
				in = new GZIPInputStream(connection.getInputStream());
			} else {
				in = connection.getInputStream();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
			StringBuffer sb = new StringBuffer();
			String temp = "";
			while ((temp = reader.readLine()) != null) {
				sb.append(temp + "\r\n");
			}
			return sb.toString();

		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e) {

			}
		}
		return null;

	}

	@SuppressWarnings( { "static-access", "unchecked" })
	public static Parser getWebParser(String pkUrl) throws ParserException {

		String content = getUrl(pkUrl);
		// Parser parser = new Parser();
		// parser.getConnectionManager().getDefaultRequestProperties().put("User-Agent",
		// "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_1; zh-cn)
		// AppleWebKit/531.22.7 (KHTML, like Gecko) Version/4.0.5
		// Safari/531.22.7");
		// parser.setURL(pkUrl);
		return Parser.createParser(content, "gbk");
	}

	public static Parser getWebParserUtf8(String pkUrl) throws ParserException {

		String content = getUrlUtf8(pkUrl);
		return Parser.createParser(content, "utf-8");
	}

	// 以无参数post的方式发送数据
	public static String sendMessage(String xml, String urlpath) // ///////发送数据的方法，需要2个参数，一个地址，一个参数，返回对方页面返回的数据
	{

		String msg = "";
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(urlpath);
			conn= (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(10000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/html");
			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(xml);
			wr.flush();
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				msg = msg + line;
			}
		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (wr != null)
					wr.close();
				if (rd != null)
					rd.close();
				if (conn != null)
					conn.disconnect();
			} catch (Exception e) {

			}
		}
		return msg;

	}
	/**
	 * 模拟form的POST请求,带参数
	 * @param params	要传送的参数,格式 "name=xxx&address=xxx"
	 * @param urlpath	请求地址
	 * @return
	 * @throws Exception
	 */
	public static String sendPostRequestByForm(String params ,String urlpath) throws Exception{
		String msg = "";
		BufferedReader rd = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(urlpath);
			conn= (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(10000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			byte[] bytes = params.toString().getBytes();
	        conn.getOutputStream().write(bytes);// 输入参数
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			String line;
			while ((line = rd.readLine()) != null) {
				msg = msg + line;
			}
		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (rd != null)
					rd.close();
				if (conn != null)
					conn.disconnect();
			} catch (Exception e) {

			}
		}
		return msg;
    }

	public static String sendABMessage(String xml, String urlpath) // ///////发送数据的方法，需要2个参数，一个地址，一个参数，返回对方页面返回的数据
	{

		String msg = "";
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL(urlpath);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Accept-Charset", "utf-8");
			conn.setRequestProperty("contentType", "utf-8");

			wr = new OutputStreamWriter(conn.getOutputStream(),"utf-8");
			wr.write(xml);
			wr.flush();
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line;
			while ((line = rd.readLine()) != null) {
				msg = msg + line;
			}
		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (wr != null)
					wr.close();
				if (rd != null)
					rd.close();
				if (conn != null)
					conn.disconnect();
			} catch (Exception e) {

			}
		}
		return msg;
	}

	// 以无参数post的方式发送数据保存sessionID
	public static String sendMessageSessionID(String xml, String urlpath) // ///////发送数据的方法，需要2个参数，一个地址，一个参数，返回对方页面返回的数据
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String msg = "";
		String[] sessionIds = null;
		OutputStreamWriter wr = null;
		BufferedReader rd = null;
		String session_value = "";
		try {
			URL url = new URL(urlpath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(30000);
			conn.setReadTimeout(60000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			String sessionId = (String) request.getSession().getAttribute("sessionId");
			if (sessionId != null && !"".equals(sessionId)) {
				conn.setRequestProperty("Cookie", sessionId);
			}

			wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(xml);
			wr.flush();
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			if (sessionId == null) {
				session_value = conn.getHeaderField("Set-Cookie") == null ? "" : conn.getHeaderField("Set-Cookie");
				// session_value = conn.getHeaderField("Set-Cookie");
				if (session_value != "") {
					sessionIds = session_value.split(";");
					if (sessionIds[0] != null && !"".equals(sessionIds[0])) {
						request.getSession().setAttribute("sessionId", sessionIds[0]);
					}
				}

			}
			String line;
			while ((line = rd.readLine()) != null) {
				msg = msg + line;
			}
		} catch (Exception e) {
			LogUtil.error(e);
		} finally {
			try {
				if (wr != null)
					wr.close();
				if (rd != null)
					rd.close();
			} catch (Exception e) {

			}
		}
		return msg;
	}

	static public String connectBySSL(String content, String urlStr) {
		return connectBySSL(content, urlStr, "utf-8");
	}

	/**
	 * 使用SSL方式发送请求
	 *
	 * @param content
	 *            请求内容
	 * @return 回应信息
	 */
	@SuppressWarnings("unchecked")
	static public String connectBySSL(String content, String urlStr, String encode) {
		URL url = null;
		URLConnection connection = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			url = new URL(urlStr);

			connection = url.openConnection();
			connection.setConnectTimeout(30000);
			connection.setReadTimeout(10000);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			if (connection instanceof HttpsURLConnectionImpl) {

				HttpsURLConnection https = (HttpsURLConnection) connection;
				https.setHostnameVerifier(new MyVerified());

				X509TrustManager xtm = new MyTrustManager();
				TrustManager mytm[] = { xtm };
				SSLContext ctx = SSLContext.getInstance("SSL");
				ctx.init(null, mytm, null);
				SSLSocketFactory sf = ctx.getSocketFactory();
				https.setSSLSocketFactory(sf);
			}
			connection.connect();
			writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), encode));
			//  LogUtil.info("发送请求:\n" + content);
			writer.write(content);
			writer.flush();
			writer.close();
			Map headers = connection.getHeaderFields();
			if (headers.size() > 0) {
				String response = headers.get(null).toString();
				if (response.indexOf("200 OK") < 0) {
					throw new Exception("读取地址:" + url + " 错误:" + response);
				}
			}
			StringBuffer sb = new StringBuffer();

			InputStream is = connection.getInputStream();
			byte[] b = new byte[200];
			int index = is.read(b);
			while (index != -1) {
				sb.append(new String(b, 0, index, encode));
				index = is.read(b);
			}
			// reader = new BufferedReader(new InputStreamReader(connection
			// .getInputStream(), encode));
			//
			// String temp = null;
			// while ((temp = reader.readLine()) != null) {
			// sb.append(temp+"\n");
			// }
			//  LogUtil.info("收到响应:\n" + sb.toString());
			return sb.toString();
		} catch (Exception e) {
			LogUtil.error(e);
			return null;
		} finally {
			try {
				if (reader != null)
					reader.close();
				if (writer != null)
					writer.close();
			} catch (Exception e) {
			}
		}
	}

	public static String getWebInfo(String url) throws Exception {
		HttpClientParams clientParams = new HttpClientParams();
		clientParams.setParameter(HttpClientParams.HTTP_CONTENT_CHARSET, "GBK");
		clientParams.setSoTimeout(25000);
		HttpClient client = new HttpClient(clientParams);
		GetMethod getMethod = new GetMethod(url);
		try {
			client.executeMethod(getMethod);
			InputStream inputStream = getMethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			StringBuffer sb = new StringBuffer();
			String str= "";
			while((str = br.readLine()) != null){
				sb.append(str);
			}

			return sb.toString();
		} finally {
			getMethod.releaseConnection();
		}
	}


	/**
	 *获取post请求过来的输入流
	 *return string
	 */
	public static String getPostData(HttpServletRequest request){
		InputStream inputStream = null;
		try {
			inputStream = request.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			StringBuffer sb = new StringBuffer();
			String str= "";
			while((str = br.readLine()) != null){
				sb.append(str);
			}
			return sb.toString();
		}catch(Exception e ){
			LogUtil.error(e);
		} finally {
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					LogUtil.error(e);
				}
			}
		}
		return "";
	}
}

class MyVerified implements HostnameVerifier {
	public boolean verify(String hostname, SSLSession session) {
		return true;
	}
}

class MyTrustManager implements X509TrustManager {
	MyTrustManager() { // constructor
		// create/load keystore
	}

	public void checkClientTrusted(X509Certificate chain[], String authType) throws CertificateException {
	}

	public void checkServerTrusted(X509Certificate chain[], String authType) throws CertificateException {
		// special handling such as poping dialog boxes
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}
