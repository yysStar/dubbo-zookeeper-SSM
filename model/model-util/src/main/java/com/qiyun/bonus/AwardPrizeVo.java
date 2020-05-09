package com.qiyun.bonus;

import com.qiyun.util.ArithUtil;

import java.util.List;

/**
 * 过关方式对应明细VO
 * 
 * @author wqs
 * 
 */
public class AwardPrizeVo {
	/**
	 * 过关数
	 */
	public Integer passType;
	/**
	 * 明细
	 */
	public List<AwardDetailVo> detailList;
	/**
	 * 注数
	 */
	public Integer zs;
	/**
	 * detailList金额之和
	 */
	public Double sumAward;

	public Integer getZs() {
		zs=0;
		if(detailList!=null){
			zs=detailList.size();
		}
		return zs;
	}
	public Double getSumAward() {
		if(detailList!=null){
			double sum=0;
			for (AwardDetailVo vo : detailList) {
				sum= ArithUtil.add(sum,vo.getTotalSp());
			}
			sumAward=sum;
		}
		return sumAward;
	}

	public Integer getPassType() {
		return passType;
	}

	public void setPassType(Integer passType) {
		this.passType = passType;
	}

	public List<AwardDetailVo> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<AwardDetailVo> detailList) {
		this.detailList = detailList;
	}

}
