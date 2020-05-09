package com.qiyun.openResult;

import com.qiyun.commonModel.PrizeBean;
import com.qiyun.commonModel.PrizeCommon;
import com.qiyun.model.LotteryTerm;
import com.qiyun.tools.NumberTools;
import com.qiyun.util.LogUtil;

import java.util.List;

//获取开奖号码抽象类  zf   2012-7-15
public abstract class AbstractSnatcher implements Snatcher {

	//工具方法,检查开奖结果奖级是否符合要求
	public boolean checkTermResultDetail(LotteryTerm queryTerm) {
		boolean checkResult = false;
		try {
			if (queryTerm!=null && queryTerm.getResult() != null && queryTerm.getResult().length() > 1) {
				// 判断奖级是否有效
				if (queryTerm.getResultDetail() != null) {
					List<PrizeBean> beanList = PrizeCommon.buildToList(queryTerm.getLotteryType().getValue(), queryTerm.getResultDetail());
					if (beanList != null) {
						int prizeCount = 0;
						for (PrizeBean bean : beanList) {
							if (NumberTools.isNum(bean.getCount())) {
								prizeCount += Integer.valueOf(bean.getCount());
							}
						}
						// 如果中奖注数全为0,认为奖级无效
						if (prizeCount != 0) {
							checkResult = true;
						}
					}
				}
			}
		} catch (Exception e) {
			LogUtil.error(e);
		}
		return checkResult;
	}
	
}
