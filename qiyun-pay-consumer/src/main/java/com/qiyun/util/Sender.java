package com.qiyun.util;

import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


public class Sender {

	private final static Logger log = Logger.getLogger(Sender.class);

	private String cookies;//

	public static HttpURLConnection createUrl(String url)  {
		URL httpurl = null;
		HttpURLConnection http = null;
		try {
			httpurl = new URL(url);
			http = (HttpURLConnection) httpurl.openConnection();
		} catch (Exception e) {
			log.error("open connection error!");
		}
		http.setConnectTimeout(20000);
		http.setReadTimeout(20000);
		return http;
	}

	public static String sendHttpReq(String url, JSONObject obj, String charset) {

		StringBuffer buffer = new StringBuffer();
		HttpURLConnection httpurl = null;
		String charEncoding = "UTF-8";
		if (!charset.equals("")) {
			charEncoding = charset;
		}
		try {
			httpurl = createUrl(url);
			httpurl.setDoOutput(true);
			httpurl.setRequestMethod("POST");
			httpurl.setRequestProperty("Content-Type", "application/json");
			httpurl.setRequestProperty("Accept-Charset", "utf-8");
			DataOutputStream out = new DataOutputStream(
					httpurl.getOutputStream());
			out.write(obj.toString().getBytes("utf-8"));
			out.flush();
			out.close();

			InputStream in = httpurl.getInputStream();
			int code = httpurl.getResponseCode();
			if (code == 200) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in, charEncoding));
				String line;
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			} else {
				log.error("no response");
			}
		} catch (Exception e) {
//			log.error("operate failed! url is {}", url, e);
			return null;
		} finally {
			closeHttpRequest(httpurl);
		}
		return buffer.toString();
	}

	

	public static void closeHttpRequest(HttpURLConnection httpReq) {
		if (httpReq != null) {
			httpReq.disconnect();
		}
	}

	public String getCookies() {
		return cookies;
	}

	public void setCookies(String cookies) {
		this.cookies = cookies;
	}


	   public static String sendHttpForm(String url, String param) {  
	        URL u = null;  
	        HttpURLConnection con = null;  
	        
	        // 灏濊瘯鍙戦�佽姹�  
	        try {  
	            u = new URL(url);  
	            con = (HttpURLConnection) u.openConnection();  
	            //// POST 鍙兘涓哄ぇ鍐欙紝涓ユ牸闄愬埗锛宲ost浼氫笉璇嗗埆  
	            con.setRequestMethod("POST");  
	            con.setDoOutput(true);  
	            con.setDoInput(true);  
	            con.setUseCaches(false);  
	            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
	            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");  
	            osw.write(param);  
	            osw.flush();  
	            osw.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	            if (con != null) {  
	                con.disconnect();  
	            }  
	        }  
	  
	        // 璇诲彇杩斿洖鍐呭  
	        StringBuffer buffer = new StringBuffer();  
	        try {  
	            //涓�瀹氳鏈夎繑鍥炲�硷紝鍚﹀垯鏃犳硶鎶婅姹傚彂閫佺粰server绔��  
	            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));  
	            String temp;  
	            while ((temp = br.readLine()) != null) {  
	                buffer.append(temp);  
	                buffer.append("\n");  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  
	        return buffer.toString();  
	    }  
	   
	   /**
	     * 鍚戞寚瀹歎RL鍙戦�丟ET鏂规硶鐨勮姹�
	     * 
	     * @param url
	     *            鍙戦�佽姹傜殑URL
	     * @param param
	     *            璇锋眰鍙傛暟锛岃姹傚弬鏁板簲璇ユ槸 name1=value1&name2=value2 鐨勫舰寮忋��
	     * @return URL 鎵�浠ｈ〃杩滅▼璧勬簮鐨勫搷搴旂粨鏋�
	     */
	    public static String sendGet(String url, String param) {
	        String result = "";
	        BufferedReader in = null;
	        try {
	            String urlNameString = url + "?" + param;
	            URL realUrl = new URL(urlNameString);
	            // 鎵撳紑鍜孶RL涔嬮棿鐨勮繛鎺�
	            URLConnection connection = realUrl.openConnection();
	            // 璁剧疆閫氱敤鐨勮姹傚睘鎬�
	            connection.setRequestProperty("accept", "*/*");
	            connection.setRequestProperty("connection", "Keep-Alive");
	            connection.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // 寤虹珛瀹為檯鐨勮繛鎺�
	            connection.connect();
	            // 鑾峰彇鎵�鏈夊搷搴斿ご瀛楁
	            Map<String, List<String>> map = connection.getHeaderFields();
	            // 閬嶅巻鎵�鏈夌殑鍝嶅簲澶村瓧娈�
//	            for (String key : map.keySet()) {
//	                System.out.println(key + "--->" + map.get(key));
//	            }
	            // 瀹氫箟 BufferedReader杈撳叆娴佹潵璇诲彇URL鐨勫搷搴�
	            in = new BufferedReader(new InputStreamReader(
	                    connection.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("鍙戦�丟ET璇锋眰鍑虹幇寮傚父锛�" + e);
	            e.printStackTrace();
	        }
	        // 浣跨敤finally鍧楁潵鍏抽棴杈撳叆娴�
	        finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }
	        return result;
	    }
	    /**
	     * 
	     * @param url  璇锋眰鐨勮矾寰�
	     * @param content 鍙戦�佺殑鍐呭
	     * @param isPost  鏄惁涓簆ost璇锋眰
	     * @param saveCookie 鏄惁淇濆瓨Cookie
	     * @param charset    瀛楃闆�
	     * @return
	     * @throws Exception
	     */
	    	public String sendHttpReq(String url,String content,boolean isPost,boolean saveCookie,String charset) throws Exception {
	    		StringBuffer buffer = new StringBuffer();
	    		HttpURLConnection httpurl=null;
	    		String charEncoding="utf-8";
	    		if(!charset.equals("")){
	    			charEncoding=charset;
	    		}
	    		
	    	try{
	    		if(isPost){
	    				httpurl = createUrl(url);
	    				httpurl.setDoOutput(true);
	    				httpurl.setRequestMethod("POST");
	    				httpurl.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	    				OutputStream os = httpurl.getOutputStream();
	    				os.write(content.getBytes("utf-8"));
	    				os.flush();
	    				os.close();
	    		}else{
	    			httpurl = createUrl(url+content);
	    		}
	    		InputStream in = httpurl.getInputStream(); 
	    		if(saveCookie){
	    			List<String> list = ((Map<String, List<String>>)httpurl.getHeaderFields()).get("Set-Cookie");
	    			   for(String temp : list) {
	    			    cookies += temp + "; ";
	    			   }
	    		}
	    		int code = httpurl.getResponseCode();
	    			if (code == 200) {
	    				 BufferedReader reader = new BufferedReader(new InputStreamReader(in, charEncoding));
	    				 String line;
	    				 while((line = reader.readLine()) != null) {
	    	                 buffer.append(line);
	    	             }
	    			} else {
	    				log.error("no response");
	    	        }
	    		}catch (Exception e) {
	    			e.printStackTrace();
	    			log.error("operate failed! url is "+url);
	    			return null;
	    		}finally{
	    			closeHttpRequest(httpurl);
	    		}
	    		return buffer.toString();
	    	}

	    public static void main(String[] args) {
//	    	Sender send = new Sender();
	    	JSONObject obj = new JSONObject();
			obj.element("notifyTimes", "0");
			obj.element("url", "www.baidu.com");
			obj.element("merchantNo", "121154974465003520");
			obj.element("merchantOrderNo","121154974465003520");
			obj.element("notifyType", "0");
			obj.element("param", "merchant_id=121154974465003520&order_amt=1&order_id=130612480320872448&state=0&up_order_id=100001693358&extra=test&sign=02DBC486DF150DF9F9D597E018A78212");
			String result=sendHttpReq("http://127.0.0.1:8080/notify/addElementToList", obj, "utf-8");
			System.out.println(result);
	    }
}
