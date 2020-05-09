package com.qiyun.support;

import com.qiyun.model.*;

import com.qiyun.commonModel.LotteryType;

public enum SportteryFootBallPlayType {
	RQSPF("让球胜平负", OptionItemRQSPF.values(), 8, LotteryType.JC_ZQ_RQSPF),SPF("胜平负", OptionItemSPF.values(), 8, LotteryType.JC_ZQ_SPF), BF("比分", OptionItemBF.values(), 4, LotteryType.JC_ZQ_BF), JQS("进球数", OptionItemJQS
			.values(), 6, LotteryType.JC_ZQ_JQS), BQC("半全场", OptionItemBQC.values(), 4, LotteryType.JC_ZQ_BQC),HT("混合过关", OptionItemHT.values(), 4, LotteryType.JC_ZQ_HT),HT2C1("混投2选1", OptionItemHT2C1.values(), 8, LotteryType.JC_ZQ_ALTERNATIVE)
			,SPFHT("胜平负", OptionItemHT.values(), 8, LotteryType.JC_ZQ_SPFHT)
	,DGTZ("单关投注", OptionItemHT.values(), 8, LotteryType.JC_ZQ_DGTZ);

	private final String text;

	private final OptionItem[] allOptionItem;

	private final int maxMatchs;

	private LotteryType lotteryType;

	private SportteryFootBallPlayType(String text, OptionItem[] allOptionItem, int maxMatchs, LotteryType type) {
		this.text = text;
		this.allOptionItem = allOptionItem;
		this.maxMatchs = maxMatchs;
		this.lotteryType = type;
	}

	public String getText() {
		return text;
	}

	public OptionItem[] getAllOptionItem() {
		return allOptionItem;
	}

	public int getMaxMatchs() {
		return maxMatchs;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public static SportteryFootBallPlayType getByLotteryType(LotteryType type) {
		for (SportteryFootBallPlayType t : SportteryFootBallPlayType.values()) {
			if (t.lotteryType.equals(type))
				return t;
		}
		throw new RuntimeException("玩法类型传递出错");
	}

}
