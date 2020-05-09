package com.qiyun.openResult;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.util.LogUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/** 山东体彩网 **/
public class SpecialSnatcherSDTiCai {

	static final String sorce_name="山东体彩网";
	static final int timeout = 5000; // 毫秒
	static final String domain="http://www.sdticai.com";
	static final String user_agent="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36";
	
	static final String poker3_path="/find/find_klpk.asp";
	static  String poker3_xpath="body>table:eq(2)>tr>td:eq(1)>table>tr:eq(1)>td>table:eq(1)>tr>td>table>tr:eq(1)>td>table>tr";
	

	
	public static String GetPoker3(String term){
		for(int p=1;p<4;p++){
			String url = domain+poker3_path+"?page="+p;
			Connection connection = Jsoup.connect(url).userAgent(user_agent).cookie("auth", "token").timeout(timeout);
			try {
				Document doc=connection.get();
				poker3_xpath="body>table:eq(3)>tbody>tr>td:eq(1)>table>tbody>tr:eq(1)>td>table:eq(1)>tbody>tr>td>table>tbody>tr:eq(1)>td>table>tbody>tr";
				Elements trs = doc.select(poker3_xpath);
				String _term;
				String _result;
				for (Element tr : trs) {
					_result = "";
					Elements termEl=tr.select("td:eq(0)");
					if(termEl.size()==0)continue;
					_term="20"+termEl.text().replaceAll("[^0-9]","");
					if(!_term.equals(term))continue;
					String pcode;
					pcode = getCode(tr.select("td:eq(1)"),tr.select("td:eq(2)"));
					if(pcode==null)continue;
					_result += pcode;
					pcode = getCode(tr.select("td:eq(3)"),tr.select("td:eq(4)"));
					if(pcode==null)continue;
					_result += ","+pcode;
					pcode = getCode(tr.select("td:eq(5)"),tr.select("td:eq(6)"));
					if(pcode==null)continue;
					_result += ","+pcode;
					LogUtil.info(LotteryType.POKER3.getName()+"抓取"+term+"期开奖号码:" + _result+"--数据来自："+sorce_name);
					return _result;
				}
			
			} catch (Exception e) {
				
			}
		}
		
		return null;
	}
	
	private static String getCode(Elements huaseEl ,Elements codeEl){
		String code;
		if(huaseEl.size()==0) return null;
		if(codeEl.size()==0) return null;
		huaseEl=huaseEl.select("img:eq(0)");
		if(huaseEl.size()==0) return null;
	    String src = huaseEl.get(0).attr("src");
	    if(src==null){
	    	return null;
	    }else if(src.indexOf("pk-1.jpg")>-1){
	    	code="1";
	    }else if(src.indexOf("pk-3.jpg")>-1){
	    	code="2";
	    }else if(src.indexOf("pk-4.jpg")>-1){
	    	code="3";
	    }else if(src.indexOf("pk-2.jpg")>-1){
	    	code="4";
	    }else{
	    	return null;
	    }
	    String sCode=codeEl.text().toUpperCase();
	    if(sCode.length()!=1 && !sCode.equals("10")) return null;
	    sCode=sCode.replace("A","1");
	    sCode=sCode.replace("J","11");
	    sCode=sCode.replace("Q","12");
	    sCode=sCode.replace("K","13");
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    Matcher isNum = pattern.matcher(sCode);
	    if(!isNum.matches()) return null;
	    if(sCode.length()==1)sCode="0"+sCode;
	    code+=sCode;
	    return code;
	}

}
