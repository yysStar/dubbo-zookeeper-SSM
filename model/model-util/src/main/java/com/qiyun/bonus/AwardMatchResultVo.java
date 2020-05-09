package com.qiyun.bonus;

import com.qiyun.util.ArithUtil;

import java.util.List;

/**
 * 命中场次vo
 * 
 * @author wqs
 * 
 */
public class AwardMatchResultVo {
	/**
	 * 命中场次个数
	 */
	public Integer matchCount;
	/**
	 * 倍数
	 */
	public Integer multiple;
	/**
	 * 最小奖金明细
	 */
	public List<AwardPrizeVo> minList;
	/**
	 * 最大奖金明细
	 */
	public List<AwardPrizeVo> maxList;
	/**
	 * 最小奖金
	 */
	public Double minAward = 0d;
	/**
	 * 最大奖金
	 */
	public Double maxAward = 0d;
	/**
	 * 投注金额
	 */
	public Integer amount=0;
	/**
	 * 最小回报率已乘以100
	 */
	public Double minRate;
	/**
	 * 最大回报率已乘以100
	 */
	public Double maxRate;

	public Integer getMatchCount() {
		return matchCount;
	}

	public void setMatchCount(Integer matchCount) {
		this.matchCount = matchCount;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public List<AwardPrizeVo> getMinList() {
		return minList;
	}

	public void setMinList(List<AwardPrizeVo> minList) {
		this.minList = minList;
	}

	public List<AwardPrizeVo> getMaxList() {
		return maxList;
	}

	public void setMaxList(List<AwardPrizeVo> maxList) {
		this.maxList = maxList;
	}

	public Double getMinAward() {
		if(minList!=null){
			double sum=0;
			for (AwardPrizeVo vo : minList) {
				sum= ArithUtil.add(sum,vo.getSumAward());
			}
			minAward=sum;
		}
		return minAward;
	}


	public Double getMaxAward() {
		if(maxList!=null){
			double sum=0;
			for (AwardPrizeVo vo : maxList) {
				sum=ArithUtil.add(sum,vo.getSumAward());
			}
			maxAward=sum;
		}
		return maxAward;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getMinRate() {
		if(amount==0 || getMinAward()==0){
			minRate=0d;
		}else{
			minRate=ArithUtil.mul(ArithUtil.div(getMinAward(),amount, 4), 100);
		}
		return minRate;
	}

	public Double getMaxRate() {
		if(amount==0 || getMaxAward()==0){
			maxRate=0d;
		}else{
			maxRate=ArithUtil.mul(ArithUtil.div(getMaxAward(),amount, 4), 100);
		}
		return maxRate;
	}


}
