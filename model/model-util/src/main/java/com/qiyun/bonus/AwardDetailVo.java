package com.qiyun.bonus;

import com.qiyun.util.ArithUtil;

import java.util.List;

/**
 * 具体明细VO
 * @author wqs
 *
 */
public class AwardDetailVo {
	/**
	 * 中奖奖金
	 */
	public Double totalSp; 
	/**
	 * 倍数
	 */
	public Integer multiple;
	/**
	 * 明细具体投注选项
	 */
	public List<AwardDetailItemVo> items;

	public Double getTotalSp() {
		if(items!=null ){
			double total=2*getMultiple();//2元一注
			for (AwardDetailItemVo item : items) {
				total= ArithUtil.mul(total, item.getOption().getAward());
			}
			total=ArithUtil.sixRound(total);
			this.totalSp=total;
		}
		return totalSp;
	}


	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}


	public List<AwardDetailItemVo> getItems() {
		return items;
	}


	public void setItems(List<AwardDetailItemVo> items) {
		this.items = items;
	}



}
