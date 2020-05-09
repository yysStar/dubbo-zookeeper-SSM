package com.qiyun.lottery;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.tools.StringTools;
import com.qiyun.util.LogUtil;

public class GainConditionParser {
	
	public final static int WHOLE_GAIN = 3;//盈利设置--全程盈利
	public final static int PART_GAIN = 4;//盈利设置--前几期盈利（部分盈利）
	
	public static String getGainConditionShow(LotteryType lotteryType, String gainCondition, Integer totalTerm) {
		if(StringTools.isNullOrBlank(gainCondition)){
			return "";
		}
		
		String info = gainCondition;
		
		try {
			String[] conditions = gainCondition.split("\\:");// 盈利类别:盈利内容
			int type = Integer.parseInt(conditions[0]);
			String[] contents = conditions[1].split("\\#");// 最低盈利#最低盈利率

			if(WHOLE_GAIN == type){//盈利设置--全程盈利
				if(contents[0].equals("-1")){
					info = "追号<font color='red'>"+totalTerm+"</font>期，全程最低盈利率<font color='red'>"+contents[1]+"</font>%";
				}else if(contents[1].equals("-1")){
					info = "追号<font color='red'>"+totalTerm+"</font>期，全程最低盈利<font color='red'>"+contents[0]+"</font>元";
				}else{
					info = "追号<font color='red'>"+totalTerm+"</font>期，全程最低盈利<font color='red'>"+contents[0]+"</font>元,之后盈利<font color='red'>"+contents[1]+"</font>%";
				}
			}
			
			if(PART_GAIN == type){//盈利设置--部分盈利（前几期盈利）
				if("-1".equals(contents[2]) || "0".equals(contents[2])){
					info = "追号<font color='red'>"+totalTerm+"</font>期，前<font color='red'>"+contents[0]+"</font>期计划盈利<font color='red'>"+contents[1]+"</font>%";
				}else{
					info = "追号<font color='red'>"+totalTerm+"</font>期，前<font color='red'>"+contents[0]+"</font>期计划盈利<font color='red'>"+contents[1]+"</font>%，之后盈利<font color='red'>"+contents[2]+"</font>%";
				}
			}
			
		} catch (Exception e) {
			LogUtil.info("解析盈利条件发生错误");
		}
		
		return info;
	}
}
