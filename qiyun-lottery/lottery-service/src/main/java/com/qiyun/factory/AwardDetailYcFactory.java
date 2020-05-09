package com.qiyun.factory;

import com.qiyun.bonus.AwardDetailYc;
import com.qiyun.bonus.AwardResultVo;
import com.qiyun.bonus.Sporttery3GMatchItem;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.PlayType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class AwardDetailYcFactory {

	private Map<String,AwardDetailYc> awardYcMap;

	/**
	 * 
	 * @param lotteryType 彩种
	 * @param matchItems 投注内容
	 * @param multiple 倍数
	 * @param playTypeList 过关方式
	 * @param amount 方案总金额
	 * @param isOnlyPlay 是否去除单一玩法
	 * @param onlyAwardScope 是否只取最小最大奖金范围
	 * @return
	 */
	public AwardResultVo execute(LotteryType lotteryType, List<Sporttery3GMatchItem> matchItems, int multiple, List<PlayType> playTypeList, int amount, boolean isOnlyPlay, boolean onlyAwardScope ) {
		LotteryType lotType=lotteryType;
		if(LotteryType.JCZQList.contains(lotteryType)){
			lotType=LotteryType.JC_ZQ;
		}else if(LotteryType.JCLQList.contains(lotteryType)){
			lotType=LotteryType.JC_LQ;
		}
		
		AwardDetailYc yc=awardYcMap.get(lotType.getValue()+"");
		AwardResultVo vo=null;
		if(yc!=null){
			if(onlyAwardScope){
				vo=yc.minAndMaxPrize(matchItems, playTypeList);
			}else{
				vo=yc.ycAwardDetail(matchItems, playTypeList,amount,multiple,isOnlyPlay);
			}
		}
		return vo;
	}


	public void setAwardYcMap(Map<String, AwardDetailYc> awardYcMap) {
		this.awardYcMap = awardYcMap;
	}
}
