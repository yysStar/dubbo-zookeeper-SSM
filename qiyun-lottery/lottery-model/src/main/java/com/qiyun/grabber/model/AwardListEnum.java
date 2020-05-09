package com.qiyun.grabber.model;

import com.qiyun.grabber.basketball.DXFAwardList;
import com.qiyun.grabber.basketball.SFAwardList;
import com.qiyun.grabber.basketball.SFCAwardList;
import com.qiyun.grabber.basketball.SFRFAwardList;
import com.qiyun.grabber.football.*;
import com.qiyun.model.basketball.HTAward;
import com.qiyun.model.basketball.SFAward;
import com.qiyun.model.basketball.SFCAward;
import com.qiyun.model.football.*;
import com.qiyun.model.inter.AwardInterface;
import com.qiyun.commonModel.LotteryType;

public enum AwardListEnum {
	
	SFAWARD(new SFAwardList(), LotteryType.JC_LQ_SF, PlatformEnum.BASKETBALL.getMatchUrl(),
			PlatformEnum.BASKETBALL.getMatchUrl(),SFAward.class),
	SFCAWARD(new SFCAwardList(), LotteryType.JC_LQ_SFC,PlatformEnum.BASKETBALL.getMatchUrl(), PlatformEnum.BASKETBALL.getMatchUrl(),SFCAward.class),
	SFRFAWARD(new SFRFAwardList(),LotteryType.JC_LQ_RFSF, PlatformEnum.BASKETBALL.getMatchUrl(), PlatformEnum.BASKETBALL.getMatchUrl(),SFAward.class),
	DXF(new DXFAwardList(), LotteryType.JC_LQ_DXF, PlatformEnum.BASKETBALL.getMatchUrl(),PlatformEnum.BASKETBALL.getMatchUrl(),SFAward.class),
	BBHTAWARD(null, LotteryType.JC_LQ_HT, "", "",HTAward.class),
	BBDGTZAWARD(null, LotteryType.JC_LQ_DGTZ, "", "",HTAward.class),// 固定单关不需要URL 去抓取数据
	
	SPFAWARD(new SPFAwardList(), LotteryType.JC_ZQ_SPF, PlatformEnum.FOOTBALL.getMatchUrl(), PlatformEnum.FOOTBALL.getMatchUrl(),MatchAwardOfSPF.class),
	RQSPFAWARD(new RQSPFAwardList(), LotteryType.JC_ZQ_RQSPF, PlatformEnum.FOOTBALL.getMatchUrl(), PlatformEnum.FOOTBALL.getMatchUrl(),MatchAwardOfRQSPF.class),
	BFAWARD(new BFAwardList(), LotteryType.JC_ZQ_BF, PlatformEnum.FOOTBALL.getMatchUrl(), PlatformEnum.FOOTBALL.getMatchUrl(),MatchAwardOfBF.class),
	JQSAWARD(new JQSAwardList(), LotteryType.JC_ZQ_JQS, PlatformEnum.FOOTBALL.getMatchUrl(), PlatformEnum.FOOTBALL.getMatchUrl(),MatchAwardOfJQS.class),
	BQCAWARD(new BQCAwardList(), LotteryType.JC_ZQ_BQC, PlatformEnum.FOOTBALL.getMatchUrl(), PlatformEnum.FOOTBALL.getMatchUrl(),MatchAwardOfBQC.class),
	HTAWARD(null,LotteryType.JC_ZQ_HT, "", "",MatchAwardOfHT.class), // 混合过关不需要URL 去抓取数据
	SPFHTAWARD(null, LotteryType.JC_ZQ_SPFHT, "", "",MatchAwardOfHT.class), // 竞彩足球胜平负/让球不需要URL 去抓取数据
	HT2C1AWARD(null, LotteryType.JC_ZQ_ALTERNATIVE, "", "",MatchAwardOfHT.class),// 竞彩足球2选1不需要URL 去抓取数据
	DGTZAWARD(null, LotteryType.JC_ZQ_DGTZ, "", "",MatchAwardOfHT.class);// 固定单关不需要URL 去抓取数据
	
	private AwardInterface awardInterface;
	private LotteryType lotteryType;
	private String passUrl;
	private String singleUrl;
	private Class awardClass;

	private AwardListEnum(AwardInterface awardinterface, LotteryType lotteryType, String passUrl, String singleUrl, Class awardClass) {
		this.awardInterface = awardinterface;
		this.lotteryType = lotteryType;
		this.passUrl = passUrl;
		this.singleUrl = singleUrl;
		this.awardClass=awardClass;
	}

	public AwardInterface getAwardInterface() {
		return awardInterface;
	}

	public void setAwardInterface(AwardInterface awardInterface) {
		this.awardInterface = awardInterface;
	}

	public String getPassUrl() {
		return passUrl;
	}

	public void setPassUrl(String passUrl) {
		this.passUrl = passUrl;
	}

	public String getSingleUrl() {
		return singleUrl;
	}

	public void setSingleUrl(String singleUrl) {
		this.singleUrl = singleUrl;
	}

	public static AwardListEnum valueOfName(String name) {
		for (AwardListEnum ae : AwardListEnum.values()) {
			if (ae.name().equals(name)) {
				return ae;
			}
		}
		return null;
	}

	public static Class classNameOfAward(int ordinal) {
		AwardListEnum[] awards = AwardListEnum.values();
		if(ordinal >=awards.length){
			throw new RuntimeException("玩法类型不正确");
		}else{
			return awards[ordinal].awardClass;
		}
	}

	/** 根据玩法类型获得玩法奖金的class* */
	public static Class classNameOfAwardByLotteryType(LotteryType type) {
		for (AwardListEnum ae : AwardListEnum.values()) {
			if (ae.lotteryType.equals(type)) {
				return classNameOfAward(ae.ordinal());
			}
		}
		throw new RuntimeException("玩法类型不正确");
	}

	/** 根据玩法类型获得玩法奖金的枚举* */
	public static AwardListEnum enumOfAwardByLotteryType(LotteryType type) {
		for (AwardListEnum ae : AwardListEnum.values()) {
			if (ae.lotteryType.equals(type)) {
				return ae;
			}
		}
		throw new RuntimeException("玩法类型不正确");
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public Class getAwardClass() {
		return awardClass;
	}

	public void setAwardClass(Class awardClass) {
		this.awardClass = awardClass;
	}

}
