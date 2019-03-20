package com.qiyun.model.basketball;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.MatchItem;
import com.qiyun.model.OptionItem;
import com.qiyun.model.SportteryOption;
import com.qiyun.tools.DateTools;
import com.qiyun.utils.CommonUtils;

import java.util.List;

public class BasketBallUpMatchItem extends MatchItem {

	private static final long serialVersionUID = 1L;

	private Double RF;
	private Double DXF;

	public Double getRF() {
		return RF;
	}

	public void setRF(Double rf) {
		RF = rf;
	}

	public Double getDXF() {
		return DXF;
	}

	public void setDXF(Double dxf) {
		DXF = dxf;
	}

	public String show2String(boolean isPass, LotteryType lt) {
		String result = "";
		List<SportteryOption> optionList = this.getOptions();
		String weekStr = DateTools.getWeekStr(DateTools.StringToDate(this.getIntTime() + "", "yyyyMMdd"));
		result += weekStr + this.getLineId() + "(";
		for (int j = 0; j < optionList.size(); j++) {
			SportteryOption option = optionList.get(j);
			OptionItem optionItem = CommonUtils.getByPlayType(lt, option);

			if (!isPass) {// 单关
				result += optionItem.getText() + ",";
			} else {// 过关
				result += optionItem.getText() + option.getAward() + ",";
			}
		}
		result = result.substring(0, result.length() - 1);
		result += ")";
		return result;
	}

	public Double getMaxAward() {
		List<SportteryOption> options = getOptions();
		Double award = 0d;
		for (int i = 0; i < options.size(); i++) {
			Double tempAward = options.get(i).getAward();
			award = award > tempAward ? award : tempAward;
		}
		return award;
	}

	public Double getMinAward() {
		List<SportteryOption> options = getOptions();
		Double award = options.get(0).getAward();
		for (int i = 0; i < options.size(); i++) {
			Double tempAward = options.get(i).getAward();
			award = award < tempAward ? award : tempAward;
		}
		return award;
	}
	public void setMinAward(double minAward){
		
	}
	
	public void setMaxAward(double maxAward){
		
	}
}
