package com.qiyun.lotteryterm;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.PrizeBean;
import com.qiyun.httpUtil.HttpUtil;
import com.qiyun.model.LotteryTerm;
import com.qiyun.model.PlaceOpenResultBean;
import com.qiyun.tools.NumberTools;
import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;
import com.qiyun.util.MathUtil;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLEditorKit;


public class OpenCodeSnatcher_500w extends HTMLEditorKit {
	private static final long serialVersionUID = 1L;

	private com.qiyun.lotteryterm.Parser pss;
	

	public String snatch(String web_url, String coding) {
		return HttpUtil.getUrl(web_url);
	}



	public HTMLEditorKit.Parser getParser() {
		return super.getParser();
	}

	// 返回的新的实体，只填充抓取到的开奖信息，不改变传入的彩期实体
	public LotteryTerm mainGetResult(LotteryTerm term) {
		String termStr = term.getTerm();
		HTMLEditorKit.Parser parser = this.getParser();
		pss = new com.qiyun.lotteryterm.Parser();
		try {
			if (term.getLotteryType().getValue() == LotteryType.SSQ.getValue()) {
				termStr = termStr.substring(2, termStr.length());
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/ssq/" + termStr + ".shtml", "gbk")), pss, true);
				return ssqGetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.QLC.getValue()) {
				termStr = termStr.substring(2, termStr.length());
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/qlc/" + termStr + ".shtml", "gbk")), pss, true);
				return qlcGetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.FC3D.getValue()) {
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/sd/" + termStr + ".shtml", "gbk")), pss, true);
				return sdGetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.DLT.getValue()) {
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/dlt/" + termStr + ".shtml", "gbk")), pss, true);
				return dltGetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.QXC.getValue()) {
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/qxc/" + termStr + ".shtml", "gbk")), pss, true);
				return qxcGetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.PL3.getValue()) {
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/pls/" + termStr + ".shtml", "gbk")), pss, true);
				return plsGetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.PL5.getValue()) {
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/plw/" + termStr + ".shtml", "gbk")), pss, true);
				return plwGetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.SFC.getValue()) {
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/sfc/" + termStr + ".shtml", "gbk")), pss, true);
				return sfcGetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.JQC.getValue()) {
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/jq4/" + termStr + ".shtml", "gbk")), pss, true);
				return jq4GetResult(term);
			} else if (term.getLotteryType().getValue() == LotteryType.BQC.getValue()) {
				parser.parse(new StringReader(snatch("http://kaijiang.500.com/shtml/zc6/" + termStr + ".shtml", "gbk")), pss, true);
				return bqcGetResult(term);
			} else {
				throw new Exception("没有该彩种的开奖号码抓取器！！");
			}
		} catch (Exception e) {
			LogUtil.error("彩种:" + term.getLotteryType().getValue() + " 期号:" + termStr + "抓取失败" , e);
			return null;
		}
	}

	
	/*********************************************地方彩种捉取start*********************************************************/
	
	public PlaceOpenResultBean hdswxwGetResult(PlaceOpenResultBean por){
		LogUtil.info("福彩15选5第"+por.getTerm()+"期抓取开奖...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销售") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("特等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "特等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean df6j1GetResult(PlaceOpenResultBean por){
		LogUtil.info("东方6+1 第" + por.getTerm() + "期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[6];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 5){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}

	//上海天天彩选4开奖信息先不捉取
	public PlaceOpenResultBean ttcx4GetResult(PlaceOpenResultBean por){
		return null;
	}
	
	public PlaceOpenResultBean js7wsGetResult(PlaceOpenResultBean por){
		LogUtil.info("体彩7位数 第" + por.getTerm() + "期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean zjesxwGetResult(PlaceOpenResultBean por){
		LogUtil.info("体彩20选5 第" + por.getTerm() + "期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			} else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n";
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "派送特等奖  " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean zj6j1GetResult(PlaceOpenResultBean por){
		LogUtil.info("浙江6+1 第" + por.getTerm() + "期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[6];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 5){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean fjeexwGetResult(PlaceOpenResultBean por){
		LogUtil.info("福建体彩22选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("特等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "特等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean fjslxqGetResult(PlaceOpenResultBean por){
		LogUtil.info("福建福彩36选7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 8; i++) {
					resultStr = result.next();
					if (i == 7) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 6){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("特等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "特等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean gdslxqGetResult(PlaceOpenResultBean por){
		LogUtil.info("广东福彩36选7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[6];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 5){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}else if (resultStr.trim().indexOf(">好彩2") > -1) {
				result_detail = result_detail + "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + ">好彩2  " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + ">好彩3  " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean gdhc1GetResult(PlaceOpenResultBean por){
		LogUtil.info("广东福彩好彩1 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[1];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 4; i++) {
					resultStr = result.next();
					if (i == 0) {
						openResult = openResult + resultStr + "|";
						array[i] = resultStr;
					} else if(i <= 2){
						openResult = openResult + resultStr + ",";
					}else{
						openResult = openResult + resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("数字") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "数字  " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "生肖  " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "季节  " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "方位  " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean gdelxwGetResult(PlaceOpenResultBean por){
		LogUtil.info("福彩26选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean szfcGetResult(PlaceOpenResultBean por){
		LogUtil.info("深圳风采 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 8; i++) {
					resultStr = result.next();
					if (i == 7) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 6){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "七等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "八等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean hljslxqGetResult(PlaceOpenResultBean por){
		LogUtil.info("黑龙江福彩36选7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 8; i++) {
					resultStr = result.next();
					if (i == 7) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 6){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "七等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "八等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean hljeexwGetResult(PlaceOpenResultBean por){
		LogUtil.info("黑龙江福彩22选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean hljp62GetResult(PlaceOpenResultBean por){
		LogUtil.info("黑龙江福彩P62 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[6];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 5){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean hlj6j1GetResult(PlaceOpenResultBean por){
		LogUtil.info("黑龙江体彩6+1 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[6];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 5){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("特等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "特等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean lnswxqGetResult(PlaceOpenResultBean por){
		LogUtil.info("辽宁福彩35选7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 8; i++) {
					resultStr = result.next();
					if (i == 7) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 6){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "七等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean hbhy3GetResult(PlaceOpenResultBean por){
		return null;
	}
	
	public PlaceOpenResultBean hbplwGetResult(PlaceOpenResultBean por){
		LogUtil.info("河北燕赵风采排列5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean hbplqGetResult(PlaceOpenResultBean por){
		LogUtil.info("河北燕赵风采排列7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if(i != 7){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("特等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "特等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean hbesxwGetResult(PlaceOpenResultBean por){
		LogUtil.info("河北燕赵风采20选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean zyeexwGetResult(PlaceOpenResultBean por){
		LogUtil.info("河南中原风采22选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean cteexwGetResult(PlaceOpenResultBean por){
		LogUtil.info("湖北楚天风采22选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean sdesxwGetResult(PlaceOpenResultBean por){
		LogUtil.info("山东齐鲁风采23选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean sxeyxwGetResult(PlaceOpenResultBean por){
		LogUtil.info("山西三晋风采21选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("特别奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "特别奖  " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean ygcttlGetResult(PlaceOpenResultBean por){
		LogUtil.info("云贵川天天乐 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean xjewxqGetResult(PlaceOpenResultBean por){
		LogUtil.info("新疆风采25选7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 8; i++) {
					resultStr = result.next();
					if (i == 7) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 6){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("特等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "特等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "七等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean xjswxqGetResult(PlaceOpenResultBean por){
		LogUtil.info("新疆风采35选7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 8; i++) {
					resultStr = result.next();
					if (i == 7) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 6){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "七等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean xjsbxqGetResult(PlaceOpenResultBean por){
		LogUtil.info("新疆风采18选7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean klscGetResult(PlaceOpenResultBean por){
		return null;
	}
	
	public PlaceOpenResultBean ahewxwGetResult(PlaceOpenResultBean por){
		LogUtil.info("安徽福彩25选5 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[5];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
						array[i] = resultStr;
					} else {
						openResult = openResult + resultStr + ",";
						array[i] = resultStr;
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	public PlaceOpenResultBean fjsyxqGetResult(PlaceOpenResultBean por){
		LogUtil.info("福建体彩31选7 第"+por.getTerm()+"期捉取开始...");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String openTime = "";
		String endTime = "";
		String[] array = new String[7];
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 8; i++) {
					resultStr = result.next();
					if (i == 7) {
						openResult = openResult + "|" +resultStr;
					} else if(i != 6){
						openResult = openResult + resultStr + ",";
						array[i] = resultStr; 
					}else{
						openResult = openResult + resultStr;
						array[i] = resultStr; 
					}
				}
			}else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			}else if (resultStr.trim().indexOf("开奖日期") > -1) {
				openTime = resultStr.trim().split("日")[1].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
				endTime = resultStr.trim().split("日")[3].replaceAll("期：", "").replaceAll("年", "-").replaceAll("月", "-");
			}else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = "奖项 中奖注数 单注奖金（元） \r\n"; 
				result_detail = result_detail + "一等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "二等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "三等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "四等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "五等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
				result_detail = result_detail + "六等奖 " + result.next() + " " + result.next().replaceAll(",", "") + " \r\n";
				result.next();
			}
		}
		
		por.setHz(String.valueOf(MathUtil.getArraySum(array)));
		por.setOpenResult(openResult);
		por.setTermSale(xiaoliang);
		por.setOpenTime(openTime);
		por.setAward(gunc);
		por.setOpenDetail(result_detail);
		por.setEndTime(endTime);
		
		return por;
	}
	
	/*********************************************地方彩种捉取end*********************************************************/
	
	public LotteryTerm ssqGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("幸运号码") > -1){
				resultStr = result.next();
				openResult = openResult +","+ resultStr;
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = result_detail + "prize1^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize2^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize3^" + result.next() + "^3000";
				result.next();
				result.next();
				result_detail = result_detail + "#prize4^" + result.next() + "^200";
				result.next();
				result.next();
				result_detail = result_detail + "#prize5^" + result.next() + "^10";
				result.next();
				result.next();
				result_detail = result_detail + "#prize6^" + result.next() + "^5";
				result.next();
			} else if (resultStr.trim().indexOf("幸运二等奖") > -1) {
				result_detail = result_detail + "#prize7^" + result.next() + "^"+(result.next().split("\\(")[0].replaceAll(",",""));
				
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm sdGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String numberType = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 3; i++) {
					resultStr = result.next();
					if (i == 2) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("号码类型") > -1) {
				numberType = result.next();
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("单选") > -1) {
				result_detail = "prize1^" + result.next() + "^1040";
				result.next();
				result.next();
				if (numberType.indexOf("组三")>-1) {
					result_detail += "#prize2^" + result.next() + "^346#prize3^0^173";
					result.next();
				} else if (numberType.indexOf("组六")>-1) {
					result_detail += "#prize2^0^346#prize3^" + result.next() + "^173";
					result.next();
				}else{
					result_detail += "#prize2^0^0#prize3^0^0";
				}
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool("0");
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm qlcGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		String specialPrize = "#prize8^0^0";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 8; i++) {
					resultStr = result.next();
					if (i == 7) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = result_detail + "prize1^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize2^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize3^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize4^" + result.next() + "^200";
				result.next();
				result.next();
				result_detail = result_detail + "#prize5^" + result.next() + "^50";
				result.next();
				result.next();
				result_detail = result_detail + "#prize6^" + result.next() + "^10";
				result.next();
				result.next();
				result_detail = result_detail + "#prize7^" + result.next() + "^5";
			} else if (resultStr.trim().indexOf("特别奖") > -1) {
				specialPrize = result_detail + "#prize8^" + result.next() + "^" + result.next().replaceAll(",", "");
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail );
		return r;

	}
	
	public LotteryTerm gdhc1GetResult(LotteryTerm term) {
		Map<String, String> sx = new HashMap<String, String>();
		sx.put("鼠", "鼠");
		sx.put("牛", "牛");
		sx.put("虎", "虎");
		sx.put("兔", "兔");
		sx.put("龙", "龙");
		sx.put("蛇", "蛇");
		sx.put("马", "马");
		sx.put("羊", "羊");
		sx.put("猴", "猴");
		sx.put("鸡", "鸡");
		sx.put("狗", "狗");
		sx.put("猪", "猪");
		
		Map<String, String> sj = new HashMap<String, String>();
		sj.put("春", "春");
		sj.put("夏", "夏");
		sj.put("秋", "秋");
		sj.put("冬", "冬");
		
		Map<String, String> fw = new HashMap<String, String>();
		fw.put("东", "东");
		fw.put("南", "南");
		fw.put("西", "西");
		fw.put("北", "北");
		
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 4; i++) {
					resultStr = result.next();
					if (i == 0) {
						openResult = openResult + resultStr + ",";
					} else if( i == 1){
						openResult = openResult + sx.get(resultStr) + ",";
					} else if( i == 2){
						openResult = openResult + sj.get(resultStr) + ",";
					} else if( i == 3){
						openResult = openResult + fw.get(resultStr);
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("数字") > -1) {
				result_detail = result_detail + "prize1^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize2^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				String jjCount = result.next();
				String jjPrize = result.next().replaceAll(",", "");
				result.next();
				String fwCount = result.next();
				String fwPrize = result.next().replaceAll(",", "");
				result_detail = result_detail + "#prize3^" + fwCount + "^" + fwPrize;
				result_detail = result_detail + "#prize4^" + jjCount + "^" + jjPrize;
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}
	
	public LotteryTerm ljyGetResult(LotteryTerm term) {
		Map<String, String> sx = new HashMap<String, String>();
		sx.put("鼠", "01");
		sx.put("牛", "02");
		sx.put("虎", "03");
		sx.put("兔", "04");
		sx.put("龙", "05");
		sx.put("蛇", "06");
		sx.put("马", "07");
		sx.put("羊", "08");
		sx.put("猴", "09");
		sx.put("鸡", "10");
		sx.put("狗", "11");
		sx.put("猪", "12");
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + sx.get(resultStr);
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = result_detail + "prize1^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize2^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize3^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize4^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize5^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize6^" + result.next() + "^" + result.next().replaceAll(",", "");
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm f15x5GetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String awardPool = "";
		String result_detail = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				awardPool = result.next().replaceAll("元|,", "");
			} else if (resultStr.trim().indexOf("特等奖") > -1) {
				result_detail = result_detail + "prize1^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize2^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize3^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				/******************** 非加奖时期添加默认加奖奖级 ***********************/
				result_detail += "#prize4^0^0";
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(awardPool);
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm plwGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
//			} else if (resultStr.trim().indexOf("排列五直选") > -1) {
			} else if (resultStr.trim().indexOf("排列5直选") > -1) {
				result_detail = "prize1^" + result.next() + "^100000";
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool("0");
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm plsGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String numberType = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 3; i++) {
					resultStr = result.next();
					if (i == 2) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("号码类型") > -1) {
				numberType = result.next();
//			} else if (resultStr.trim().indexOf("排列三直选") > -1) {
			} else if (resultStr.trim().indexOf("排列3直选") > -1) {
				if(result_detail != null && !"".equals(result_detail)){
					continue;
				}
				result_detail = "#prize1^" + result.next() + "^" + 1040;
				result.next();
				result.next();
				if (numberType.indexOf("组三")>-1) {
					result_detail = result_detail + "#prize2^" + result.next() + "^" + 346 + "#prize3^0^0";
				} else if (numberType.indexOf("组六")>-1) {
					result_detail = result_detail + "#prize2^0^0#prize3^" + result.next() + "^" + 173;
				} else {
					result_detail = result_detail + "#prize2^0^0#prize3^0^0";
				}
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool("0");
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm qxcGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		boolean flag = false;
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1) {
				if(flag) {
					continue;
				}
				result_detail = result_detail + "prize1^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize2^" + result.next() + "^" + result.next().replaceAll(",", "");
				result.next();
				result_detail = result_detail + "#prize3^" + result.next() + "^1800";
				result.next();
				result.next();
				result_detail = result_detail + "#prize4^" + result.next() + "^300";
				result.next();
				result.next();
				result_detail = result_detail + "#prize5^" + result.next() + "^20";
				result.next();
				result.next();
				result_detail = result_detail + "#prize6^" + result.next() + "^5";
				flag = true;
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm dltGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String result_detail = "";
		String gunc = "";
		Integer liuLevel=0;
		boolean flag = false;
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
				if(xiaoliang.indexOf("亿") > -1) {
					xiaoliang = NumberTools.doubleToString(Double.parseDouble(xiaoliang.replaceAll("亿", "")) * 100000000,false);
				}
			} else if (resultStr.trim().indexOf("12选2销量") > -1) {
				xiaoliang = String.valueOf(Long.parseLong(xiaoliang) + Long.parseLong(result.next().replaceAll("元", "").replaceAll(",", "")));
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
				if(gunc.indexOf("亿") > -1) {
					gunc = NumberTools.doubleToString(Double.parseDouble(gunc.replaceAll("亿", "")) * 100000000,false);
				}
			} else if (resultStr.trim().indexOf("一等奖") > -1 && resultStr.trim().indexOf("一等奖派奖") == -1) {
				//if(flag) continue;
				String awardLevel="一等奖";
				String prize;
				String bonusNum;
				String singleBonus;
				List<String> awardLevels = new ArrayList<String>();
				awardLevels.add("一等奖");
				awardLevels.add("二等奖");
				awardLevels.add("三等奖");
				awardLevels.add("四等奖");
				awardLevels.add("五等奖");
				awardLevels.add("六等奖");
				while (result.hasNext() && !flag){
					resultStr=result.next();
					if(resultStr!=null)
						resultStr=resultStr.trim();
					if(awardLevels.contains(resultStr))
						awardLevel=resultStr;
					if(resultStr.equals("基本") || resultStr.equals("追加")){
						prize=awardLevel.replace("等奖","");
						if(resultStr.equals("基本")){
							prize=prize
									.replace("一", "prize1").replace("二", "#prize3").replace("三", "#prize5")
									.replace("四", "#prize7").replace("五", "#prize8").replace("六", "#prize9");
						}else{
							prize=prize
									.replace("一", "#prize2").replace("二", "#prize4").replace("三", "#prize6")
									.replace("四", "#prize13").replace("五", "#prize14");
						}
						bonusNum=result.next();
						singleBonus=result.next().replaceAll(",", "");
						result_detail += prize+ "^" + bonusNum + "^" + singleBonus;
						if(awardLevel.equals("六等奖")) {
							if(StringTools.isInteger(singleBonus)) liuLevel=Integer.parseInt(singleBonus);
							flag=true;
						}
					} 
				}
			}
		}
		
		LotteryTerm r = new LotteryTerm();
		if(liuLevel>0){
			r.setLotteryType(term.getLotteryType());
			r.setTerm(term.getTerm());
			r.setResult(openResult);
			r.setTotalAmount(xiaoliang);
			r.setAwardPool(gunc);
			r.setResultDetail(result_detail);
		}
		return r;
	}

	public LotteryTerm sfcGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String gunc = "";
		String result_detail = "";
		boolean onePrize = true;
		boolean twoPrize = true;
		boolean r9Prize = true;
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖日期") > -1) {
				for (int i = 0; i < 28; i++) {
					resultStr = result.next();
					if (i > 13) {
						if (i == 27) {
							openResult = openResult + resultStr;
						} else {
							openResult = openResult + resultStr + ",";
						}
					}
				}
			} else if (resultStr.trim().indexOf("本期足彩胜负销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("本期任九销量") > -1) {
				xiaoliang += "^" + result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("足彩胜负奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1 && onePrize) {
				result_detail = "prize1^" + result.next() + "^" + result.next().replaceAll(",", "");
				onePrize = false;
			} else if (resultStr.trim().indexOf("二等奖") > -1 && twoPrize) {
				result_detail = result_detail + "#prize2^" + result.next() + "^" + result.next().replaceAll(",", "");
				twoPrize = false;
			} else if (resultStr.trim().indexOf("任九") > -1 && resultStr.trim().indexOf("足彩胜负") == -1 && r9Prize) {
				result_detail = result_detail + "#prize3^" + result.next() + "^" + result.next().replaceAll(",", "");
				r9Prize = false;
			}
		}

		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);

		List<PrizeBean> prizeBeanList = r.getPrizeBeanList();
		for (PrizeBean bean : prizeBeanList) {
			if ("--".equals(bean.getAmount())) {
				bean.setAmount("0");
			}
		}
		r.setPrizeBeanList(prizeBeanList);

		return r;
	}

	public LotteryTerm jq4GetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String gunc = "";
		String result_detail = "";
		boolean onePrize = true;
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖日期") > -1) {
				for (int i = 0; i < 16; i++) {
					resultStr = result.next();
					if (i > 7) {
						if (i == 15) {
							openResult = openResult + resultStr;
						} else {
							openResult = openResult + resultStr + ",";
						}
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1  && onePrize) {
				result_detail = result_detail + "prize1^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				onePrize = false;
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm bqcGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String gunc = "";
		String result_detail = "";
		boolean onePrize = true;
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖日期") > -1) {
				for (int i = 0; i < 30; i++) {
					resultStr = result.next();
					if (i > 17) {
						if (i == 29) {
							openResult = openResult + resultStr;
						} else {
							openResult = openResult + resultStr + ",";
						}
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1 && onePrize) {
				result_detail = result_detail + "prize1^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				onePrize = false;
			}
		}
		
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm zc6GetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String gunc = "";
		String result_detail = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖日期") > -1) {
				for (int i = 0; i < 30; i++) {
					resultStr = result.next();
					if (i > 17) {
						if (i == 29) {
							openResult = openResult + resultStr;
						} else {
							openResult = openResult + resultStr + ",";
						}
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = result_detail + "prize1^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm slxqGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String gunc = "";
		String result_detail = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 7; i++) {
					resultStr = result.next();
					if (i == 6) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = result_detail + "prize1^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				result.next();
				result_detail = result_detail + "#prize2^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				result.next();
				result_detail = result_detail + "#prize3^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				result.next();
				result_detail = result_detail + "#prize4^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				result.next();
				result_detail = result_detail + "#prize5^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				result.next();
				result_detail = result_detail + "#prize6^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}

	public LotteryTerm eexwGetResult(LotteryTerm term) {
		Iterator<String> result = pss.getKeyList().iterator();
		String openResult = "";
		String xiaoliang = "";
		String gunc = "";
		String result_detail = "";
		while (result.hasNext()) {
			String resultStr = result.next();
			if (resultStr.trim().indexOf("开奖号码") > -1) {
				for (int i = 0; i < 5; i++) {
					resultStr = result.next();
					if (i == 4) {
						openResult = openResult + resultStr;
					} else {
						openResult = openResult + resultStr + ",";
					}
				}
			} else if (resultStr.trim().indexOf("本期全国销售金额") > -1 || resultStr.trim().indexOf("本期销量") > -1) {
				xiaoliang = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("奖池滚存") > -1) {
				gunc = result.next().replaceAll("元", "").replaceAll(",", "");
			} else if (resultStr.trim().indexOf("一等奖") > -1) {
				result_detail = result_detail + "prize1^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				result.next();
				result_detail = result_detail + "#prize2^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
				result.next();
				result_detail = result_detail + "#prize3^" + result.next().replaceAll("注", "") + "^"
						+ result.next().replaceAll("元", "").replaceAll("/注", "").replace(",", "").trim();
			}
		}
		LotteryTerm r = new LotteryTerm();
		r.setLotteryType(term.getLotteryType());
		r.setTerm(term.getTerm());
		r.setResult(openResult);
		r.setTotalAmount(xiaoliang);
		r.setAwardPool(gunc);
		r.setResultDetail(result_detail);
		return r;
	}


}