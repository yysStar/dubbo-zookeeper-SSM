package com.qiyun.model.basketball;

import com.qiyun.item.MatchItem;
import com.qiyun.sporttery.SportteryOption;

import java.util.ArrayList;
import java.util.List;

public class BasketBallMatchItem extends MatchItem {

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

	public Double initMaxAward() {
		List<SportteryOption> options = getOptions();
		Double award = 0d;
		for (int i = 0; i < options.size(); i++) {
			Double tempAward = options.get(i).getAward();
			award = award > tempAward ? award : tempAward;
		}
		return award;
	}

	public Double initMinAward() {
		List<SportteryOption> options = getOptions();
		Double award = options.get(0).getAward();
		for (int i = 0; i < options.size(); i++) {
			Double tempAward = options.get(i).getAward();
			award = award < tempAward ? award : tempAward;
		}
		return award;
	}
	@Override
	public BasketBallMatchItem cloneItem() {
		BasketBallMatchItem item = new BasketBallMatchItem();
		item.setIntTime(this.getIntTime());
		item.setLineId(this.getLineId());
		List<SportteryOption> tempOptionList = this.getOptions();
		List<SportteryOption> optionList = new ArrayList<SportteryOption>();
		for (SportteryOption option : tempOptionList) {
			optionList.add(option);
		}
		item.setOptions(optionList);
		item.setShedan(this.isShedan());
		item.setDXF(this.getDXF());
		item.setRF(this.getRF());
		return item;
	}
	private List<String> lotteryTypeList= new ArrayList<String>();
	public List<String> getLotteryTypeList() {
		return lotteryTypeList;
	}
	public void setLotteryTypeList(List<String> lotteryTypeList) {
		this.lotteryTypeList = lotteryTypeList;
	}
	
//	public void setMinAward(double minAward){
//		
//	}
//	
//	public void setMaxAward(double maxAward){
//		
//	}
}
