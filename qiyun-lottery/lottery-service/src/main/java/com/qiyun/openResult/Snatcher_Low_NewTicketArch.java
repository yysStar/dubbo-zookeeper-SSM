package com.qiyun.openResult;

import com.qiyun.lotteryterm.OpenCodeSnatcher_500w;
import com.qiyun.model.LotteryTerm;
import com.qiyun.tools.NumberTools;
import com.qiyun.util.LogUtil;

//快乐8获取开奖号码接口  zf   2012-7-15
public class Snatcher_Low_NewTicketArch extends AbstractSnatcher {
	
	//获取开奖号码
	public LotteryTerm getOpenResult(LotteryTerm term){
		LotteryTerm snatchResult = null;
		try{
			OpenCodeSnatcher_500w sn = new OpenCodeSnatcher_500w();
			snatchResult = sn.mainGetResult(term);
			
			//增加对开奖号码进行简单的验证
			if(snatchResult != null && snatchResult.getResult() != null && snatchResult.getResult().length() > 0) {
				 String resultTemp = snatchResult.getResult().replaceAll("\\,", "");
				 if(!NumberTools.isNum(resultTemp)) {
					 return null;
				 }
			}
			
			if( !checkTermResultDetail(snatchResult)){
				 return null;
			}
		}catch(Exception e){
			LogUtil.error(e);
		}
		
		//停售期间，直接抓取500万开奖结果，不进行对比
		return snatchResult;
		
		/*if(term.getLotteryType().equals(LotteryType.HC1)){//好彩1不比较 奖级信息,奖池,总投注额在出票商getAwardNumber已取到
			return providerResult;
		}
		//对比开奖号码
		if( checkResult(providerResult, snatchResult) ){
			providerResult.setResultDetail(snatchResult.getResultDetail());
			providerResult.setTotalAmount(snatchResult.getTotalAmount());
			providerResult.setAwardPool(snatchResult.getAwardPool());
			return providerResult;
		}else{
			return null;
		}*/

	}	
}
