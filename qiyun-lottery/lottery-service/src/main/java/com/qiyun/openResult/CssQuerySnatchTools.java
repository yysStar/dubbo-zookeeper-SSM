package com.qiyun.openResult;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.openResult.SnatcherConfig;
import com.qiyun.openResult.SnatcherConfig.ConfigItem;
import com.qiyun.openResult.SnatcherConfig.ConfigSource;
import com.qiyun.model.LotteryTerm;
import com.qiyun.tools.DateTools;
import com.qiyun.util.LogUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CssQuerySnatchTools {

	/**
	 * 获取高频彩开奖号码
	 */
	public static String getHighFrequencyOpenCode(LotteryTerm term) {
		String termNo = getTerm(term);
		LotteryType lotteryType=term.getLotteryType();
		Integer lType=lotteryType.getValue();
		// 特殊抓取
		String result = SpecialSnatcher.GetResultForHigh(lotteryType, termNo);
		if(result!=null)return result;
		// 普通抓取 
		List<ConfigSource> configs= SnatcherConfig.getInstance().getConfigSources(lType);
		if(configs==null)return null; 
		for(ConfigSource config:configs){
			Map<String, String> ret=snatchResultMap(config);
			if(ret!=null) result=ret.get(termNo);
			if(result!=null && ! result.isEmpty()){
				LogUtil.info(term.getLotteryType().getName()+"抓取"+term.getTerm()+"期开奖号码:" + result+"--数据来自："+config.source);
				return ret.get(termNo);
			}
		}
		return null;
	}

	/**
	 * 提取高频彩开奖号码?
	 */
	private static Map<String, String> snatchResultMap(ConfigSource configSource) {
		Map<String, String> resultMap = new HashMap<String, String>();
		try {
			// 请求地址
			String href = configSource.href;
			if(configSource.dateFormat!=null){
				String date = DateTools.dateToString(new Date(), configSource.dateFormat);
				href=configSource.href.replace("{$date}", date);
			}
			//测试
			if(configSource.source.equals("百度彩票") && configSource.name.equals("江苏快3")){
				
			}
			Connection connection = Jsoup
					.connect(href)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
					.cookie("auth", "token").timeout(5000);
			
			// 远程数据获取、处理方法
			Document doc;
			if(configSource.method!=null && configSource.method.toLowerCase().equals("method1")){
				Connection.Response res = connection.execute();
				String response = res.body();
				doc=Jsoup.parse(response);
			} else if(configSource.method!=null && configSource.method.toLowerCase().equals("post")){
				doc=connection.post();
			} else{
				doc=connection.get();
			}
			Elements trs = doc.select(configSource.listQuery);
			for (Element tr : trs) {
				for(ConfigItem configItem:configSource.configItems){
					String termQuery=configItem.termQuery;
					Elements termElement=tr.select(termQuery);
					if(termElement.size()==0)continue;
					String term=termElement.text().replaceAll("[^0-9]","");
					if(configItem.termQuery!=null&&!configItem.termQuery.equals("")){
						Pattern termReg = Pattern.compile(configItem.termReg);
						Matcher matcher=termReg.matcher(term);
						if(!matcher.find())continue;
						term=matcher.group();
					}
					if(configItem.termFormat!=null&&!configItem.termFormat.equals("")){
						term=termFormat(term,configItem.termFormat);
					}
					Elements codeElement=tr.select(configItem.codeQuery);
					if(codeElement.size()==0)continue;
					String code=codeElement.text();
					//替换
					if(configItem.codeRepalceMap!=null&&!configItem.codeRepalceMap.equals("")){
						String[] arr= code.split("♠|♥|♣|♦");
						if(arr.length!=4)continue;
						arr=new String[]{arr[1],arr[2],arr[3]};
						char[] arrl=code.replaceAll("[^♠|♥|♣|♦]","").toCharArray();
						code="";
						for(int i=0;i<arr.length;i++){
							arr[i]=arr[i].replaceAll("[^0-9|J|Q|K|A]","");
							boolean isM=arr[i].equals("A") || arr[i].equals("J") || arr[i].equals("Q") || arr[i].equals("K");
							if(arr[i].length()==1 && !isM)arr[i]="0"+arr[i];
							code+=arrl[i]+arr[i];
						}
						code=codeReplace(configItem.codeRepalceMap, code);
						Pattern codeReg = Pattern.compile(configItem.codeReg);
						Matcher matcher=codeReg.matcher(code);
						if(!matcher.find())continue;
						code=matcher.group();
					}
					code=code.replaceAll("[^0-9]","");
					//匹配
					if(configItem.codeQuery!=null&&!configItem.codeQuery.equals("")){
						Pattern codeReg = Pattern.compile(configItem.codeReg);
						Matcher matcher=codeReg.matcher(code);
						if(!matcher.find())continue;
						code=matcher.group();
					}
					code=codeFormat(code,configItem.codeFormat);
					resultMap.put(term, code);
				}
			}
		} catch (Exception e) {
			String msg=e.getMessage();
			LogUtil.info("抓取:" + configSource.href + "出现错误,请检查!"+msg);
		}
		return resultMap;
	}
	
	/**
	 * 号码格替换
	 **/
	private static String codeReplace(String mapStr,String code){
		String[] parts=mapStr.split(";");
		for(String part:parts){
			String[] subParts=part.split(":");
			code=code.replace(subParts[0], subParts[1]);
		}
		return code;		
	}
	
	/**
	 * 号码格式化
	 **/
	private static String codeFormat(String code,String format){
		// 其它
		int l=code.length();
		for(int i=0;i<l;i++){
			format=format.replaceFirst("X", code.substring(i, i+1));
		}
		return format;
	}
	
	/**
	 * 期号格式化
	 **/
	private static String termFormat(String term,String format){
		
		String _format=format.replaceAll("[^X|#]", "");
		if(_format==null || _format.isEmpty())return term;
		char[] arr=_format.toCharArray();
		int cl=arr.length;
		int l=term.length();
		if(cl!=l){
			return term;
		}
		for(int i=0;i<l;i++){
			if("X".equals(arr[i]+"")){
				format=format.replaceFirst("X", term.substring(i, i+1));
			}
		}
		format=format.replace("#", "");
		format= DateTools.dateToString(new Date(), format);
		return format;
	}
	
	private static String getTerm(LotteryTerm term) {
		String termNo = term.getTerm();
		if( term.getLotteryType() == LotteryType.ZJ11X5 ||
			term.getLotteryType() == LotteryType.LN11X5) {
			termNo = termNo.substring(0, 8) + "0" + termNo.substring(8, termNo.length()) ;
		} else if(
			term.getLotteryType() == LotteryType.JS11X5 ||
			term.getLotteryType() == LotteryType.SYYDJ) {
			termNo = "20" + termNo.substring(0, 6) + "0" + termNo.substring(6, termNo.length()) ;
		} else if (
			term.getLotteryType() == LotteryType.AH_K3 ||
			term.getLotteryType() == LotteryType.JX_K3 ||
		    term.getLotteryType() == LotteryType.JL_K3 ||
		    term.getLotteryType() == LotteryType.HB_K3 ||
    		term.getLotteryType() == LotteryType.POKER3 ||
		    LotteryType.K3_SNATCH_LIST.contains(term.getLotteryType())) {
			termNo = "20" + termNo;
		}
		return termNo;
	}
	
	public static class te{
		LotteryType lt;
		String str;
		public te(LotteryType l, String s){
			this.lt=l;
			this.str=s;
		}
	}
	
	/**
	 * 测试高频彩开奖号码
	 */
	private static String TestOpenCode(LotteryTerm term) {
		String termNo = getTerm(term);
		LotteryType lotteryType=term.getLotteryType();
		Integer lType=lotteryType.getValue();
		// 特殊抓取
		String result = SpecialSnatcher.GetResultForHigh(lotteryType, termNo);
		// 普通抓取 
		List<ConfigSource> configs= SnatcherConfig.getInstance().getConfigSources(lType);
		if(configs==null)return null;
		int index=0;
		int length=configs.size();
		while(true){
			ConfigSource config=configs.get(index);
			Map<String, String> ret=snatchResultMap(config);
			if(ret!=null){
			    result=ret.get(termNo);
			}
			if(result!=null && !result.isEmpty()){
				LogUtil.info(term.getLotteryType().getName()+"抓取"+term.getTerm()+"期开奖号码:" + result+"--数据来自："+config.source);
			}else{
				LogUtil.error(term.getLotteryType().getName()+"抓取"+term.getTerm()+"期开奖号码:" + result+"--数据来自："+config.source);
			}
			index++;
			if(index>=length) return null;
		}
	}

	public static void main(String[] args) {
		/*
		Double  ddc =NumberTools.formatDouble2(16625080.84, "#.##");
		String str = NumberTools.formatDouble(ddc, "#.##");
		
		
		System.out.println(str);
		return;
		
		Calendar startCal = Calendar.getInstance();
		//startCal.set(2013, 1, 1);
		startCal.add(Calendar.DATE, -2);
		Date startDate = startCal.getTime();
		
		Calendar endCal = Calendar.getInstance();
		endCal.add(Calendar.MINUTE, -15);
		Date endDate = endCal.getTime();
		
		System.out.println(startDate.toString());
		System.out.println(endDate.toString());
		*/
		String shortTerm="08";
		String  format1="yyyyMMdd"+shortTerm,
				format2="yyMMdd0"+shortTerm,
				format3="yyyyMMdd0"+shortTerm,
				format4="yyMMdd"+shortTerm;
		List<te> list=new ArrayList<te>();
		
//		list.add(new te(LotteryType.SYYDJ,format4));
//		list.add(new te(LotteryType.JXDLC,format1));
//		list.add(new te(LotteryType.GD11X5,format1));
//		list.add(new te(LotteryType.LN11X5,format1));
//		list.add(new te(LotteryType.SH11X5,format1));
//		list.add(new te(LotteryType.HLJ11X5,format1));
//		list.add(new te(LotteryType.JS11X5,format4));
//		list.add(new te(LotteryType.K3,format2));
//		list.add(new te(LotteryType.JL_K3,format2));
//		list.add(new te(LotteryType.HB_K3,format2));
//		list.add(new te(LotteryType.AH_K3,format2));
//		list.add(new te(LotteryType.JX_K3,format2));
//		list.add(new te(LotteryType.KLSF,format1));
		list.add(new te(LotteryType.CQ_KLSF,format1));
//		list.add(new te(LotteryType.SSC,format3));
//		list.add(new te(LotteryType.POKER3,format4));

		Date openDateTime=new Date();
		String snatchResult;
		for(te ltype:list){
			
			try{
			// 单元测试开始
			String dateStr= DateTools.dateToString(openDateTime, ltype.str);
			LotteryTerm term = new LotteryTerm();
			term.setOpenDateTime(openDateTime);
			term.setLotteryType(ltype.lt);
			term.setTerm(dateStr);

			String termNo = term.getTerm();
			String termName=term.getLotteryType().getName();
//			System.out.println(termName+"("+ltype.lt.getValue()+"): "+termNo);
			snatchResult = TestOpenCode(term);
			//System.out.println(termName+"抓取"+termNo+"期开奖号码:" + snatchResult);
			}catch(Exception e){
				String d=e.getMessage();
				System.out.println(d);
				String dd= d;
			}
		}
		
		snatchResult="";
	

	}
}
