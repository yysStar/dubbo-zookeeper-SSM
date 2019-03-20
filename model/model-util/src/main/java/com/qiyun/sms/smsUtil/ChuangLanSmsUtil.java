package com.qiyun.sms.smsUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author tianyh 
 * @Description:HTTP 请求
 */
public class ChuangLanSmsUtil {
	
	/**
	 * 
	 * @author tianyh 
	 * @Description 
	 * @param path
	 * @param postContent
	 * @return String 
	 * @throws
	 */
	public static String sendSmsByPost(String path, String postContent, String charset) {
		URL url = null;
		try {
			url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");// 提交模式
			httpURLConnection.setConnectTimeout(10000);//连接超时 单位毫秒
			httpURLConnection.setReadTimeout(10000);//读取超时 单位毫秒
			// 发送POST请求必须设置如下两行
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setRequestProperty("Charset", charset);
			httpURLConnection.setRequestProperty("Content-Type", "application/json");

			
			httpURLConnection.connect();
			OutputStream os=httpURLConnection.getOutputStream();
			
			os.write(postContent.getBytes(charset));
			os.flush();
			
			StringBuilder sb = new StringBuilder();
			int httpRspCode = httpURLConnection.getResponseCode();
			if (httpRspCode == HttpURLConnection.HTTP_OK) {
				// 开始获取数据
				BufferedReader br = new BufferedReader(
						new InputStreamReader(httpURLConnection.getInputStream(), charset));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
