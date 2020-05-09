package com.qiyun.bonus;


import com.qiyun.aenum.SubTypeEnum;
import com.qiyun.sporttery.SportteryOption;
import com.qiyun.util.CommonUtils;

public class SportteryOption3G extends SportteryOption {
	
	public String getTypeValueStr(){
		if(getType() != null && !"".equals(getType())){
			String tmpType=getType();
			if(SubTypeEnum.YP.name().equals(getSubType())){
				tmpType=com.qiyun.commonModel.LotteryType.JC_ZQ_ALTERNATIVE.getValue()+"";
			}
			return CommonUtils.getByPlayType(com.qiyun.commonModel.LotteryType.getItem(Integer.valueOf(tmpType)), this).getText();
		}
		return "";
	}
	
	

	
}
