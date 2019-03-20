package com.qiyun.type;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.item.*;

public enum BasketBallPlayType {

	SF("胜负", OptionItemSF.values(), 8, LotteryType.JC_LQ_SF), RFSF("让分胜负", OptionItemRFSF.values(), 8, LotteryType.JC_LQ_RFSF), SFC("胜分差",
			OptionItemSFC.values(), 3, LotteryType.JC_LQ_SFC), DXF("大小分", OptionItemDXF.values(), 8, LotteryType.JC_LQ_DXF),
	HT("混合过关",OptionItemHT.values(),8, LotteryType.JC_LQ_HT),
	DGTZ("单关投注",OptionItemHT.values(),8, LotteryType.JC_LQ_DGTZ);

	private final String text;

	private final OptionItem[] allOptionItem;

	private final int maxMatchs;

	private LotteryType lotteryType;

	private BasketBallPlayType(String text, OptionItem[] allOptionItem, int maxMatchs, LotteryType type) {
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

	public static BasketBallPlayType getByLotteryType(LotteryType type) {
		for (BasketBallPlayType t : BasketBallPlayType.values()) {
			if (t.lotteryType.equals(type))
				return t;
		}
		throw new RuntimeException("玩法类型传递出错");
	}
}
