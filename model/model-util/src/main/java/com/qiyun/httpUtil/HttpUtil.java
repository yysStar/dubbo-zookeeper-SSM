package com.qiyun.httpUtil;

import com.qiyun.util.LogUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.net.www.protocol.https.HttpsURLConnectionImpl;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class HttpUtil {


    /**
     * 发送 get请求
     */
    public static String get(String URL,String param) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String obj=null;
        try {
            HttpUriRequest httpget = new HttpGet(URL+"?"+param);
            // 执行get请求.
            CloseableHttpResponse response = httpclient.execute(httpget);
            try {
                // 获取响应实体
                HttpEntity entity = response.getEntity();
                // 打印响应状态
//                System.out.println(response.getStatusLine());
                if (entity != null) {
                    obj=EntityUtils.toString(entity);
                }
                return obj;
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
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
     * 向指定 URL 发送POST方法的请求
     *
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        String s = HttpUtil.sendGet("http://i.sporttery.cn/rank_calculator/get_list",
//                "tid[]=104895&pcode[]=chp&i_callback=cphData");
//        s = Ascii2NativeUtil.ascii2Native(s);
//        int i = s.indexOf("(");
//        int j = s.indexOf(")");
//        s = s.substring(i + 1, j);
//        JSONObject obj = JSONObject.fromObject(s);
//        JSONArray data = obj.optJSONArray("data");
//        String d = "";
//        for(Object o : data){
//            JSONObject jo = (JSONObject) o;
//            d = jo.optString("data");
//            System.out.println(d);
//            int n = d.indexOf("|");
//            System.out.println(n);
//            String[] str = d.split("\\|");
////            String[] str = d.split("-");
//            System.out.println(str.length);
//            List<String> list = Arrays.asList(str);
//            System.out.println(list);
//        }
//        System.out.println(s);
//        System.out.println(data.toString());
//        System.out.println(d);
//    }

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
            // com.cailele.lottery.tools.LogUtil.info(connection.getContentEncoding());
            Map headers = connection.getHeaderFields();
            if (headers.size() > 0) {
                String response = headers.get(null).toString();
                if (response.indexOf("200 OK") < 0) {
                    throw new Exception("读取地址:" + url + " 错误:" + response);
                }
				/*
				 * com.cailele.lottery.tools.LogUtil.info(headers.keySet().toArray().length);
				 * for(Object o:headers.keySet().toArray()) {
				 * com.cailele.lottery.tools.LogUtil.info(o==null?"":o.toString()
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
