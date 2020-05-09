package com.qiyun.model;

import java.util.ArrayList;
import java.util.List;

import com.qiyun.commonModel.LotteryType;

public enum MatchShowStatusFb {
	// value,text,玩法过关组装字符
	SPF(0, "竞彩足球胜平负", "01",LotteryType.JC_ZQ_SPF,PassMode.PASS), RQSPF(1, "竞彩足球让球胜平负", "11",LotteryType.JC_ZQ_RQSPF,PassMode.PASS), BF(2, "竞彩足球比分", "21",LotteryType.JC_ZQ_BF,PassMode.PASS), JQS(3, "竞彩足球进球数", "31",LotteryType.JC_ZQ_JQS,PassMode.PASS), BQC(4, "竞彩足球半全场", "41",LotteryType.JC_ZQ_BQC,PassMode.PASS),
	SPFSINGLE(5,"胜平负单关","00",LotteryType.JC_ZQ_SPF,PassMode.SINGLE),RQSPFSINGLE(6,"让球胜平负单关","10",LotteryType.JC_ZQ_RQSPF,PassMode.SINGLE),BFSINGLE(7,"比分单关","20",LotteryType.JC_ZQ_BF,PassMode.SINGLE),JQSSINGLE(8,"进球数单关","30",LotteryType.JC_ZQ_JQS,PassMode.SINGLE),BQCSINGLE(9,"半全场单关","40",LotteryType.JC_ZQ_BQC,PassMode.SINGLE);

	private int value;
	private String text;
	private String pptext;
	private LotteryType lotteryType;
	private PassMode passMode;
	private MatchShowStatusFb(int value, String text, String pptext,LotteryType lotteryType,PassMode passMode) {
		this.value = value;
		this.text = text;
		this.pptext = pptext;
		this.lotteryType=lotteryType;
		this.passMode=passMode;
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

	public static MatchShowStatusFb getMatchShowByLotteryTypeAndPassModel(LotteryType lotteryType,PassMode passMode) {
		FootBallPlayType playType = FootBallPlayType.getByLotteryType(lotteryType);
		return getMatchShowStatusByppText(playType.ordinal()+""+passMode.ordinal());
	}

	public static MatchShowStatusFb getMatchShowStatusByppText(String pptext) {
		MatchShowStatusFb status[] = MatchShowStatusFb.values();
		for (MatchShowStatusFb s : status) {
			if (s.getPptext().equals(pptext))
				return s;
		}
		throw new RuntimeException("没有找到相应的状态");
	}

	public static List<MatchShowStatusFb> fuzzySearchStatus(String pptext, Boolean reverse) {
		MatchShowStatusFb status[] = MatchShowStatusFb.values();
		List<MatchShowStatusFb> resultStatus = new ArrayList<MatchShowStatusFb>();
		for (MatchShowStatusFb s : status) {
			if (pptext.indexOf(s.getText()) != -1 ^ reverse)
				resultStatus.add(s);
		}
		return resultStatus;
	}

	public static List<MatchShowStatusFb> fuzzySearchStatus(String pptext) {
		return fuzzySearchStatus(pptext, false);
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public PassMode getPassMode() {
		return passMode;
	}

	public void setPassMode(PassMode passMode) {
		this.passMode = passMode;
	}

}
