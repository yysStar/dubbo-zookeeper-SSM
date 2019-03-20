package com.qiyun.openResult;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.LotteryTerm;

/**
 * 高频通用抓取开奖结果
 */
public class Snatcher_High extends AbstractSnatcher {
	//获取彩期的开奖信息
	public LotteryTerm getOpenResult(LotteryTerm queryTerm) {
		LotteryTerm term = null;
		String resultCode = getOpenCode(queryTerm);
		if (resultCode != null && !"".equals(resultCode)) {
			term = new LotteryTerm();
			term.setResult(resultCode);
			term.setResultDetail(getResultDetail(queryTerm));
			term.setLotteryType(queryTerm.getLotteryType());
			term.setAwardPool("0");
			term.setTotalAmount("0");
		}
		return term;
	}

	private OpenCaiSnatcher openCaiSnatcher;
	public void setOpenCaiSnatcher(OpenCaiSnatcher v){openCaiSnatcher=v;}
	/**
	 * 获取开奖号码
	 */
	public String getOpenCode(LotteryTerm term){
		/*
		String resultCode=openCaiSnatcher.getHighFrequencyOpenCode(term);
		if(resultCode!=null)return resultCode;
		resultCode=CssQuerySnatchTools.getHighFrequencyOpenCode(term);
		return resultCode;
		*/
		return CssQuerySnatchTools.getHighFrequencyOpenCode(term);
	}
	
	/**
	 * 获取开奖详情
	 */
	private String getResultDetail(LotteryTerm term){
		LotteryType lotteryType= term.getLotteryType();
		return getResultDetail(lotteryType);
	}

	/**
	 * 获取开奖详情
	 */
	private String getResultDetail(LotteryType lotteryType){
		// 11选5
		if(lotteryType.equals(LotteryType.GD11X5)
		|| lotteryType.equals(LotteryType.JXDLC) 
		|| lotteryType.equals(LotteryType.SYYDJ) 
		|| lotteryType.equals(LotteryType.LN11X5) 
		|| lotteryType.equals(LotteryType.SH11X5) 
		|| lotteryType.equals(LotteryType.HLJ11X5)
		|| lotteryType.equals(LotteryType.JS11X5) ){
			return "prize1^1^13#prize2^2^6#prize3^3^19#prize4^4^78#prize5^5^540#prize6^6^90#prize7^7^26#prize8^8^9#prize9^9^130#prize10^10^65#prize11^11^1170#prize12^12^195";
		}
		//快3
		else if(lotteryType.equals(LotteryType.K3)
		|| lotteryType.equals(LotteryType.JL_K3) 
		|| lotteryType.equals(LotteryType.HB_K3) 
		|| lotteryType.equals(LotteryType.AH_K3) 
		|| lotteryType.equals(LotteryType.JX_K3) ){
			return "prize1^0^25#prize2^0^80#prize3^0^40#prize4^0^16#prize5^0^12#prize6^0^10#prize7^0^9#prize8^0^40#prize9^0^240#prize10^0^15#prize11^0^80#prize12^0^40#prize13^0^8#prize14^0^10";
		}
		//广东快乐十分
		else if(lotteryType.equals(LotteryType.KLSF)){
			return "prize1^1^8#prize2^2^24#prize3^3^80#prize4^4^320#prize5^5^25#prize6^6^5#prize7^7^62#prize8^8^8000#prize9^9^31#prize10^10^1300";
		}
		//重庆快乐十分
		else if(lotteryType.equals(LotteryType.CQ_KLSF)){
			return "prize1^1^8#prize2^2^24#prize3^3^80#prize4^4^320#prize5^5^25#prize6^6^5#prize7^7^62#prize8^8^31";
		}
		//重庆时时彩
		else if(lotteryType.equals(LotteryType.SSC)){
			return "prize1^0^100000#prize2^0^1000#prize3^0^100#prize4^0^10#prize5^0^4#prize6^0^50#prize7^0^20000#prize8^0^200#prize9^0^20#prize10^0^320#prize11^0^160";
		}
		//山东快乐扑克
		else if(lotteryType.equals(LotteryType.POKER3)){
			StringBuilder resultDetail =new StringBuilder("");
			resultDetail.append("prize1^1^5#prize2^2^33#prize3^3^116#prize4^4^46#prize5^5^22#prize6^6^12");
			resultDetail.append("#prize7^7^22#prize8^8^90#prize9^9^535#prize10^10^2150#prize11^11^33#prize12^12^400");
			resultDetail.append("#prize13^13^500#prize14^14^6400#prize15^15^7#prize16^16^88");
			return resultDetail.toString();
		}
		//其它 
		else{
			return null;
		}
	}
}

