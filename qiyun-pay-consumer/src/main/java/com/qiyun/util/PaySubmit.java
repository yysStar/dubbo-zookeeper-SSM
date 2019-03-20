package com.qiyun.util;

import java.util.SortedMap;

public class PaySubmit {
	/**
	 * @Title: buildRequest
	 * @Description: 用于下订单后自动提交 交易表单到支付系统
	 */
	public static String buildRequest(String actionUrl, SortedMap<String, String> paramMap) {
		StringBuilder html = new StringBuilder();
		html.append("<script language=\"javascript\">window.onload=function(){document.pay_form.submit();}</script>\n");
		html.append("<form id=\"pay_form\" name=\"pay_form\" action=\"").append(actionUrl).append("\" method=\"post\">\n");
		for (String key : paramMap.keySet()) {
			if(paramMap.get(key)!=null)
				html.append("<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + paramMap.get(key) + "\">\n");
		}
		html.append("</form>\n");
		return html.toString();
	}
	
}
