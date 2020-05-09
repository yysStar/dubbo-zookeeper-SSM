package com.qiyun.openResult;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiyun.model.LotteryTerm;

public class OpenCaiSnatcher {
	//地址
	private String url;
	public void setUrl(String v){url=v;}
	//彩种映射
	private Map<String,String> lotteryTypeMap;
	public void setLotteryTypeMap(Map<String,String> v){lotteryTypeMap=v;}
	/**
	 * 获取高频开奖结果
	 * **/
	public String getHighFrequencyOpenCode(LotteryTerm term) {
		String lotteryType=String.valueOf(term.getLotteryType().getValue());
		if(!lotteryTypeMap.containsKey(lotteryType))return null;
		JSONObject result=get(String.format(url,lotteryTypeMap.get(lotteryType)));
		if(result==null)return null;
		String termNo=term.getTerm();
		JSONArray lists=result.getJSONArray("data");
		int len=lists.size();
		JSONObject item=null;
		for(int i=0;i<len;i++){
			item=lists.getJSONObject(i);
			if(!termEquals(termNo,item.getString("expect")))continue;
			String code=item.getString("opencode");
			return code;
		}
		return null;
	}
	
	private static boolean termEquals(String localTerm,String remoteTerm){
		return remoteTerm.endsWith(localTerm); 
	}
	
	/**
	 * HTTP GET
	 * */
	private static JSONObject get(String url) {
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null)result.append(line);
            return JSONObject.parseObject(result.toString());
        } catch (Exception e) {return null;}
        finally {
            try {
                if (in != null) in.close();
            } catch (Exception e2) {}
        }
    }
	
}
