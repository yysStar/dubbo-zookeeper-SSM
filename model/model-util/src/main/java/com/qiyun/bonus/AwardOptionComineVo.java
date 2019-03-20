package com.qiyun.bonus;

import java.util.ArrayList;
import java.util.List;


/**
 * 对场次里的选项进行分组VO
 * 
 * @author wqs
 * 
 */
public class AwardOptionComineVo {
	/**
	 * 选项sp和
	 */
	public Double sumSp = 0d;

	/**
	 * 选项内容
	 */
	public List<SportteryOption3G> optionList=new ArrayList<SportteryOption3G>();
	
	/**
	 * 只有半全场玩法
	 */
	public Boolean onlyBqc=false;
	
	/**
	 * 半全场玩法个数
	 */
	public int bqcLen;
	

	public List<SportteryOption3G> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<SportteryOption3G> optionList) {
		this.optionList = optionList;
	}

	public Double getSumSp() {
		return sumSp;
	}

	public void setSumSp(Double sumSp) {
		this.sumSp = sumSp;
	}

	/**
	 * 半全场玩法个数
	 */
	public int getBqcLen() {
		return bqcLen;
	}

	public void setBqcLen(int bqcLen) {
		this.bqcLen = bqcLen;
	}
	/**
	 * 只有半全场玩法
	 */
	public Boolean getOnlyBqc() {
		return onlyBqc;
	}

	public void setOnlyBqc(Boolean onlyBqc) {
		this.onlyBqc = onlyBqc;
	}


}
