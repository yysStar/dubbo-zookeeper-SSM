package com.qiyun.bonus;

import java.util.List;

/**
 * 最终结果VO
 * @author Administrator
 *
 */
public class AwardResultVo {
	public static final String MAX_PRIZE="max";
	public static final String MIN_PRIZE="min";
	
	/**
	 * 投注赛事信息
	 */
	private List<AwardMatchInfoVo> matchs;
	/**
	 * 过关方式
	 */
	private List<Integer> passType;
	/**
	 * 倍数
	 */
	private int multiple;
	/**
	 * 方案总金额
	 */
	private int amount;
	/**
	 * 奖金范围
	 */
	private Double[] awardScope;
	/**
	 * 命中场次明细
	 */
	private List<AwardMatchResultVo> details;
	/**
	 * 所有组合中最大命中率的VO
	 */
	private AwardMatchResultVo maxRateVo;
	
	
	public List<AwardMatchInfoVo> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<AwardMatchInfoVo> matchs) {
		this.matchs = matchs;
	}


	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}


	public List<Integer> getPassType() {
		return passType;
	}

	public void setPassType(List<Integer> passType) {
		this.passType = passType;
	}


	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<AwardMatchResultVo> getDetails() {
		return details;
	}

	public void setDetails(List<AwardMatchResultVo> details) {
		this.details = details;
	}

	public Double[] getAwardScope() {
		if(awardScope==null){
			Double min=0d;
			Double max=0d;
			if(details!=null){
				for (AwardMatchResultVo vo : details) {
					Double tmpMin=vo.getMinAward();
					min=min==0?tmpMin:min;
					min=min>tmpMin?tmpMin:min;
					Double tmpMax=vo.getMaxAward();
					max=max>tmpMax?max:tmpMax;
				}
			}
			awardScope=new Double[]{min,max};
		}
		return awardScope;
	}

	public void setAwardScope(Double[] awardScope) {
		this.awardScope = awardScope;
	}
	
	public AwardMatchResultVo getMaxRateVo() {
		AwardMatchResultVo maxVo=null;
		if(details!=null){
			Double rate=0d;
			for (AwardMatchResultVo vo : details) {
				Double tmpRate=vo.getMaxRate();
				if(maxVo==null){
					maxVo=vo;
					rate=tmpRate;
				}else{
					if(rate<tmpRate){
						maxVo=vo;
						rate=tmpRate;
					}
				}
			}
		}
		maxRateVo=maxVo;
		return maxRateVo;
	}
}
