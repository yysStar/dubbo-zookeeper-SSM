package com.qiyun.type;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.item.*;

public enum FootBallPlayType {

	SF("胜负", OptionItemSPF.values(), 8, LotteryType.JC_ZQ_SPF), RFSF("让分胜负", OptionItemRFSF.values(), 8, LotteryType.JC_ZQ_RQSPF), BF("比分",
			OptionItemBF.values(), 4, LotteryType.JC_ZQ_BF), JQS("进球数", OptionItemJQS.values(), 6, LotteryType.JC_ZQ_JQS)
			, BQC("半全场", OptionItemBQC.values(), 4, LotteryType.JC_ZQ_BQC), HT("足球混投", OptionItemHT.values(), 8, LotteryType.JC_ZQ_HT)
			,HT2C1("混投2选1", OptionItemHT2C1.values(), 8, LotteryType.JC_ZQ_ALTERNATIVE),SPFHT("胜平负混投", OptionItemHT.values(), 8, LotteryType.JC_ZQ_SPFHT)
			,DGTZ("单关投注", OptionItemHT.values(), 8, LotteryType.JC_ZQ_DGTZ);

	private final String text;

	private final OptionItem[] allOptionItem;

	private final int maxMatchs;

	private LotteryType lotteryType;

	private FootBallPlayType(String text, OptionItem[] allOptionItem, int maxMatchs, LotteryType type) {
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

	public static FootBallPlayType getByLotteryType(LotteryType type) {
		for (FootBallPlayType t : FootBallPlayType.values()) {
			if (t.lotteryType.equals(type))
				return t;
		}
		throw new RuntimeException("玩法类型传递出错");
	}
}
