package com.qiyun.status;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.type.BasketBallPlayType;
import com.qiyun.type.PassMode;

import java.util.ArrayList;
import java.util.List;

public enum MatchShowStatus {
	// value,text,玩法过关组装字符
	SFSINGLE(0, "胜负单场", "00"), 
	SFPASS(1, "胜负过关", "01"), 
	RFSFSINGLE(2, "让分胜负单场", "10"), 
	RFSFPASS(3, "让分胜负过关", "11"), 
	SFCSINGLE(4, "胜分差单场", "20"), 
	SFCPASS(5, "胜分差过关", "21"), 
	DXFSINGLE(6, "大小分单场", "30"), 
	DXFPASS(7, "大小分过关", "31");

	private int value;
	private String text;
	private String pptext;

	private MatchShowStatus(int value, String text, String pptext) {
		this.value = value;
		this.text = text;
		this.pptext = pptext;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPptext() {
		return pptext;
	}

	public void setPptext(String pptext) {
		this.pptext = pptext;
	}
	/**
	 * 对应后台停/开售排列顺序
	 * @return
	 */
	public static List<MatchShowStatus> getShowStatsuOrderList(){
		List<MatchShowStatus> bbList=new ArrayList<MatchShowStatus>();
		bbList.add(SFSINGLE);
		bbList.add(SFPASS);
		bbList.add(RFSFSINGLE);
		bbList.add(RFSFPASS);
		bbList.add(SFCSINGLE);
		bbList.add(SFCPASS);
		bbList.add(DXFSINGLE);
		bbList.add(DXFPASS);
		return bbList;
	}
	public static MatchShowStatus getMatchShowByLotteryTypeAndPassModel(LotteryType lotteryType, PassMode passModel) {
		BasketBallPlayType playType = BasketBallPlayType.getByLotteryType(lotteryType);
		return getMatchShowStatusByppText(playType.ordinal() + "" + passModel.ordinal());
	}

	public static MatchShowStatus getMatchShowStatusByppText(String pptext) {
		MatchShowStatus status[] = MatchShowStatus.values();
		for (MatchShowStatus s : status) {
			if (s.getPptext().equals(pptext))
				return s;
		}
		throw new RuntimeException("没有找到相应的状态");
	}

	public static List<MatchShowStatus> fuzzySearchStatus(String pptext, Boolean reverse) {
		MatchShowStatus status[] = MatchShowStatus.values();
		List<MatchShowStatus> resultStatus = new ArrayList<MatchShowStatus>();
		for (MatchShowStatus s : status) {
			if (pptext.indexOf(s.getText()) != -1 ^ reverse)
				resultStatus.add(s);
		}
		return resultStatus;
	}

	public static List<MatchShowStatus> fuzzySearchStatus(String pptext) {
		return fuzzySearchStatus(pptext, false);
	}

}
