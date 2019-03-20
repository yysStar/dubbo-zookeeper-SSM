package com.qiyun.httpUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiyun.util.MD5;

public class Demo {
	private static final SimpleDateFormat format0 = new SimpleDateFormat("yyyyMMddHHmmss");
	
//	public static void main(String[] args) {
//		JSONObject jo = new JSONObject();
//		String timestamp = format0.format(new Date());
//		jo.put("@version", "2.0");
//		jo.put("@wMsgID", JsonUtil.getTcymId("qsy2018", JsonUtil.wMsgID));
//		JSONObject header = new JSONObject();
//		header.put("wAgentID", "qsy2018");
//		header.put("timestamp", timestamp);
//		header.put("wActionType", "176");
//		JSONObject body = new JSONObject();
//		JSONObject matchTicketQuery = new JSONObject();
//		JSONArray tickets = new JSONArray();
//		JSONObject ticket = new JSONObject();
//		ticket.put("@OrderID", "qsy20182018061200000101");
//		tickets.add(ticket);
//		matchTicketQuery.put("ticket", tickets);
//		body.put("matchTicketQuery", matchTicketQuery);
//		JSONObject match = new JSONObject();
//		match.put("@type", "1");
//		matchQuery.put("match", match);
//		body.put("matchQuery", matchQuery);
//		JSONObject issueQuery = new JSONObject();
//		JSONObject issue = new JSONObject();
//		issue.put("@LotId", "D11");
//		issue.put("@number", "16010601");
//		issueQuery.put("issue", issue);
//		body.put("issueQuery", issueQuery);
//		String wSign = MD5.encode(jo.getString("@wMsgID") + timestamp
//				+ "qsy123456" + body.toJSONString());
//		header.put("wSign", wSign);
//		jo.put("header", header);
//		jo.put("body", body);
//		System.out.println(jo.toJSONString());
//		String message = "wAction=176&wMessage=" + jo.toJSONString();
//		String message = "wAction=176&wMessage={\"@version\":\"2.0\",\"@wMsgID\":\"qsy20182018061200410069\",\"header\":{\"wAgentID\":\"qsy2018\",\"timestamp\":\"20180612144504\",\"wActionType\":\"176\",\"wSign\":\"d88caf1e79ef83f0ee2b8778f1221014\"},\"body\":{\"matchTicketQuery\":{\"ticket\":[{\"@OrderID\":\"qsy20182018061200000099\"},{\"@OrderID\":\"qsy20182018061200000100\"}]}}}";
//		String res = ZipHttpUtil.sendZipHttp("http://115.28.166.108:8090/LotterySystem/LotJsonService", message);
//		String res = ZipHttpUtil.sendHttp("http://115.28.166.108:8090/LotterySystem/LotJsonService", jo.toJSONString());
//		System.out.println("返回结果：" + res);
//		String s = res.substring(res.indexOf("{"), res.lastIndexOf("}")+1);
//		System.out.println("返回结果s：" + s);
//		JSONObject resJo = JSONObject.parseObject(s);
//		System.out.println("返回结果resJo：" + resJo);
//	}
}
