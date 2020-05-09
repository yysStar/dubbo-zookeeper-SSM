package com.qiyun.httpUtil;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class JsonUtil {
	private static Logger log = LoggerFactory.getLogger(JsonUtil.class);
	private static int i = 1;
	private static final DecimalFormat df = new DecimalFormat("00000000");
	private static final DecimalFormat df1 = new DecimalFormat("000");
	private static final DecimalFormat df2 = new DecimalFormat("00");
	private static final SimpleDateFormat format0 = new SimpleDateFormat("yyyyMMdd");
	public static final String wMsgID = "wMsgId";
	public static final String OrderID = "orderID";
	
	public static String getTcymId(String str1, String key) {
		Jedis jedis = RedisUtil.getJedis();
		if(jedis.get(key) == null) {
			jedis.set(key, i+"");
			i++;
		} else {
			i = Integer.parseInt(jedis.get(key)) + 1;
			jedis.set(key, i+"");
		}
	    String str = df.format(i);
	    log.info("-----------i=" + str);
	    String date = format0.format(new Date());
		jedis.close();
		return str1 + date + str;
	}

	/**
	 * 获取赛事id
	 * @param lineId
	 * @return
	 */
	public static String getmatchId(String lineId){
		int j = Integer.parseInt(lineId);
		return df1.format(j);
	}

	/**
	 * 冠亚军玩法
	 * @param matchId
	 * @return
	 */
	public static String getAnteCode(int matchId){
		return df2.format(matchId);
	}

	public static List<String> getKey(JSONObject obj){
		Iterator<String> sIterator = obj.keySet().iterator();
		List<String> keys = new ArrayList<String>();
		//循环并得到key列表
		while (sIterator.hasNext()) {
			// 获得key
			keys.add(sIterator.next());
		}
		return keys;
	}
}
