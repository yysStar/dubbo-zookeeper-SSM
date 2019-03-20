package com.qiyun.item.football;

import com.qiyun.item.MatchItem;
import com.qiyun.sporttery.SportteryOption;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class FootBallMatchItem extends MatchItem {
	private static final long serialVersionUID = 1L;
	@Override
	public FootBallMatchItem cloneItem() {
		FootBallMatchItem item = new FootBallMatchItem();
		item.setIntTime(this.getIntTime());
		item.setLineId(this.getLineId());
		List<SportteryOption> tempOptionList = this.getOptions();
		List<SportteryOption> optionList = new ArrayList<SportteryOption>();
		for (SportteryOption option : tempOptionList) {
			optionList.add(option);
		}
		item.setOptions(optionList);
		item.setShedan(this.isShedan());
		return item;
	}
	private String gyjTeam;//冠亚军玩法专用.
	public String getGyjTeam(){
		return this.gyjTeam;
	}
	public void setGyjTeam(String gyjTeam) {
		try {
			String encode = "UTF-8";
			this.gyjTeam = java.net.URLDecoder.decode(gyjTeam, encode);
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	private List<String> lotteryTypeList= new ArrayList<String>();
	public List<String> getLotteryTypeList() {
		return lotteryTypeList;
	}
	public void setLotteryTypeList(List<String> lotteryTypeList) {
		this.lotteryTypeList = lotteryTypeList;
	}

}
