package com.qiyun.model.football;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstactMatch;
import com.qiyun.item.OptionItem;
import com.qiyun.item.football.FbLimitOptionItem;
import com.qiyun.model.FootballMatch;
import com.qiyun.status.MatchShowStatusFb;
import com.qiyun.tools.DateTools;
import com.qiyun.tools.NumberTools;
import com.qiyun.type.FootBallAddPrizeType;
import com.qiyun.util.CommonUtils;

import java.util.*;

public class FootBallMatch extends AbstactMatch {
	
	private static final long serialVersionUID = 1L;
	private Integer concede;// 让球
	private Integer halfHomeScore; // 半场主队进球数
	private Integer halfGuestScore; // 半场客队进球数
	/** 胜负过关最终奖金值 */
	private Double resultAwardOfTotoPass;
	/** 让球胜负过关最终奖金值 */
	private Double resultRQAwardOfTotoPass;
	/** 进球数过关最终奖金值 */
	private Double resultAwardOfScorePass;
	/** 比分过关最终奖金值 */
	private Double resultAwardOfSingleScore;
	/** 半全场过关最终奖金值 */
	private Double resultAwardOfHfTotoPass;
	/** 足球资料库id */
	private Integer outId;
	/** 根据竞彩玩法的赛事胜平负结果 */
	private Integer resultOfRule;
	/** 加奖类型 * */
	private FootBallAddPrizeType addPrizeType;
	/** 是否针对彩种开售 * */
	private Integer showNum = 0;
	/** *页面显示使用** */
	private boolean selectStatus[] = new boolean[10]; //玩法停售, 下标对应 MatchShowStatusFb.java

	private String shortGameName; // 赛事缩写

	private String shortGuestTeam; // 客队缩写

	private String shortHomeTeam; // 主队缩写

	private Boolean showPm; // 是否显示排名 需要主动set值

	private Date endTime; // 复式截止时间 需要主动set 值

	private FootballMatch footballInfo;// 足球资料库表 需要主动set 值
	
	private String gameIcon;//联赛图标 需要主动set 值

	private Integer worldScene;// 世界杯单关1:竞彩赛事2:匹配赛事

	/** 针对单关投注选项停开售 * */
	private Integer spfShowNum; // 数据库存放
	private Integer rqspfShowNum; // 数据库存放
	private Integer bfShowNum; // 数据库存放
	private Integer jqsShowNum; // 数据库存放
	private Integer bqcShowNum; // 数据库存放

	private boolean[] spfSelectStatus = new boolean[3]; //  胜平负选项停售 下标对应FbLimitOptionItem.java spfItem
	private boolean[] rqspfSelectStatus = new boolean[3];// 让球胜平负选项停售 下标对应FbLimitOptionItem.java rqSpfItem
	private boolean[] bfSelectStatus = new boolean[31];// 比分选项停售 下标对应FbLimitOptionItem.java bfItem
	private boolean[] jqsSelectStatus = new boolean[8];// 进球数选项停售 下标对应FbLimitOptionItem.java jqsfItem
	private boolean[] bqcSelectStatus = new boolean[9];// 半全场选项停售 下标对应FbLimitOptionItem.java bqcItem
	private List<String> spfShowStatus; // 前台传输数据
	private List<String> rqspfShowStatus; // 前台传输数据
	private List<String> jqsShowStatus; // 前台传输数据
	private List<String> bqcShowStatus; // 前台传输数据
	private List<String> bfShowStatus; // 前台传输数据

	private static Map<String, String> shortNameMap;
	private static Map<String, String> getShortNameMap(){
		if(shortNameMap==null){
			shortNameMap = new HashMap<String, String>();
			shortNameMap.put("曼彻斯特城", "曼城");
			shortNameMap.put("曼彻斯特联", "曼联");
			shortNameMap.put("埃因霍温FC", "埃因");
			shortNameMap.put("埃因霍温青年队", "埃因青年");
			shortNameMap.put("阿布扎比贾兹拉", "贾兹拉");
			shortNameMap.put("阿布扎比艾因", "艾因");
			shortNameMap.put("巴黎圣日尔曼", "圣日尔曼");
		}
		return shortNameMap;
	}

	
	public Integer getWorldScene() {
		if (worldScene != null && worldScene == -1) {
			worldScene = null;
		}
		return worldScene;
	}

	public void setWorldScene(Integer worldScene) {
		this.worldScene = worldScene;
	}

	/**
	 * @return the concede
	 */
	public Integer getConcede() {
		return concede;
	}

	/**
	 * @param concede
	 *            the concede to set
	 */
	public void setConcede(Integer concede) {
		this.concede = concede;
	}

	/**
	 * @return the halfHomeScore
	 */
	public Integer getHalfHomeScore() {
		return halfHomeScore;
	}

	/**
	 * @param halfHomeScore
	 *            the halfHomeScore to set
	 */
	public void setHalfHomeScore(Integer halfHomeScore) {
		this.halfHomeScore = halfHomeScore;
	}

	/**
	 * @return the halfGuestScore
	 */
	public Integer getHalfGuestScore() {
		return halfGuestScore;
	}

	/**
	 * @param halfGuestScore
	 *            the halfGuestScore to set
	 */
	public void setHalfGuestScore(Integer halfGuestScore) {
		this.halfGuestScore = halfGuestScore;
	}

	public Double getResultAwardOfTotoPass() {
		return resultAwardOfTotoPass;
	}

	public void setResultAwardOfTotoPass(Double resultAwardOfTotoPass) {
		this.resultAwardOfTotoPass = resultAwardOfTotoPass;
	}

	/**
	 * @return the resultRQAwardOfTotoPass
	 */
	public Double getResultRQAwardOfTotoPass() {
		return resultRQAwardOfTotoPass;
	}

	/**
	 * @param resultRQAwardOfTotoPass
	 *            the resultAwardOfTotoPass to set
	 */

	public void setResultRQAwardOfTotoPass(Double resultRQAwardOfTotoPass) {
		this.resultRQAwardOfTotoPass = resultRQAwardOfTotoPass;
	}

	/**
	 * @return the resultAwardOfScorePass
	 */
	public Double getResultAwardOfScorePass() {
		return resultAwardOfScorePass;
	}

	/**
	 * @param resultAwardOfScorePass
	 *            the resultAwardOfScorePass to set
	 */
	public void setResultAwardOfScorePass(Double resultAwardOfScorePass) {
		this.resultAwardOfScorePass = resultAwardOfScorePass;
	}

	/**
	 * @return the resultAwardOfSingleScore
	 */
	public Double getResultAwardOfSingleScore() {
		return resultAwardOfSingleScore;
	}

	/**
	 * @param resultAwardOfSingleScore
	 *            the resultAwardOfSingleScore to set
	 */
	public void setResultAwardOfSingleScore(Double resultAwardOfSingleScore) {
		this.resultAwardOfSingleScore = resultAwardOfSingleScore;
	}

	/**
	 * @return the resultAwardOfHfTotoPass
	 */
	public Double getResultAwardOfHfTotoPass() {
		return resultAwardOfHfTotoPass;
	}

	public Integer getOutId() {
		return outId;
	}

	public void setOutId(Integer outId) {
		this.outId = outId;
	}

	/**
	 * @param resultAwardOfHfTotoPass
	 *            the resultAwardOfHfTotoPass to set
	 */
	public void setResultAwardOfHfTotoPass(Double resultAwardOfHfTotoPass) {
		this.resultAwardOfHfTotoPass = resultAwardOfHfTotoPass;
	}

	public String getHalfScore() {
		return halfHomeScore + ":" + halfGuestScore;
	}

	public OptionItem getResultItem(LotteryType lt) {
		OptionItem resultItem = null;
		try {
			resultItem = CommonUtils.getZQResultOptionItem(lt.getValue() + "", CommonUtils.getZQResultInfo(this));
		} catch (Exception e) {
		}
		return resultItem;
	}

	public OptionItem getResult(LotteryType lotteryType) {
		return getResultItem(lotteryType);
	}

	public OptionItem getSPFResultItem() {
		return getResultItem(LotteryType.JC_ZQ_SPF);
	}

	public OptionItem getRQSPFResultItem() {
		return getResultItem(LotteryType.JC_ZQ_RQSPF);
	}

	public OptionItem getBFResultItem() {
		return getResultItem(LotteryType.JC_ZQ_BF);
	}

	public OptionItem getJQSResultItem() {
		return getResultItem(LotteryType.JC_ZQ_JQS);
	}

	public OptionItem getBQCResultItem() {
		return getResultItem(LotteryType.JC_ZQ_BQC);
	}

	@Override
	public Double getResultAward(LotteryType lotteryType) {
		int typeValue = lotteryType.getValue();
		switch (typeValue) {
		case 34:// 胜平负
			return getResultRQAwardOfTotoPass();
		case 35:// 比分
			return getResultAwardOfSingleScore();
		case 36:// 进球数
			return getResultAwardOfScorePass();
		case 37:// 半全场
			return getResultAwardOfHfTotoPass();
		case 41:
			return getResultAwardOfTotoPass();
		default:
			throw new RuntimeException("根据玩法获取篮球奖金时发生类型错误");
		}

	}

	public Integer getResultOfRule() {
		return resultOfRule;
	}

	public FootBallAddPrizeType getAddPrizeType() {
		return addPrizeType;
	}

	public void setAddPrizeType(FootBallAddPrizeType addPrizeType) {
		this.addPrizeType = addPrizeType;
	}

	public void setResultOfRule(Integer resultOfRule) {
		this.resultOfRule = resultOfRule;
	}

	public void setHomeScore(Integer homeScore) {
		super.setHomeScore(homeScore);

		Integer parentHomeScore = super.getHomeScore();
		Integer parentguestScore = super.getGuestScore();
		Integer concede = this.concede;
		if (parentHomeScore != null && parentguestScore != null && concede != null) {
			if (NumberTools.isNum(parentHomeScore.toString()) && NumberTools.isNum(parentguestScore.toString())
					&& NumberTools.isNum(concede.toString())) {
				Integer yingpanShu = (parentHomeScore - parentguestScore) + concede;
				if (yingpanShu > 0) {
					this.setResultOfRule(3);
				} else if (yingpanShu == 0) {
					this.setResultOfRule(1);
				} else if (yingpanShu < 0) {
					this.setResultOfRule(0);
				}
			}
		}
	}

	public boolean[] getSelectStatus() {
		MatchShowStatusFb status[] = MatchShowStatusFb.values();
		for (int i = 0; i < status.length; i++) {
			// 把1向左移动N位
			int value = 1 << status[i].getValue();
			// 按位与运算(运算结果要么是0要么是1,1代表已存在)
			if ((getShowNum() & value) > 0) {
				selectStatus[i] = true;
			} else {
				selectStatus[i] = false;
			}
		}
		return selectStatus;
	}

	/**
	 * 玩法是否在售
	 * 
	 * @param fb
	 * @return true 开售/false停售
	 */
	public boolean getStatusIsSale(MatchShowStatusFb fb) {
		MatchShowStatusFb status[] = MatchShowStatusFb.values();
		boolean[] selectStatus = getSelectStatus();
		boolean flag = false;
		for (int i = 0; i < status.length; i++) {
			if (status[i] == fb) {
				flag = selectStatus[i];
				break;
			}
		}
		return flag;
	}

	public List<MatchShowStatusFb> getMatchShowStatusFb() {
		List<MatchShowStatusFb> matchShowStatusList = new ArrayList<MatchShowStatusFb>();
		if (getShowStatus() != null) {
			for (String s : getShowStatus()) {
				if (s != null) {
					MatchShowStatusFb tempstatus = MatchShowStatusFb.valueOf(s);
					matchShowStatusList.add(tempstatus);
				}
			}
		}
		return matchShowStatusList;
	}

	public Integer getShowStatusNum() {
		int show = 0;
		if (getShowStatus() != null && !getShowStatus().isEmpty()) {
			for (MatchShowStatusFb status : getMatchShowStatusFb()) {
				if (status != null) {
					show |= 1 << status.getValue();
				}
			}
		}
		return show;
	}

	public Integer getShowStatusNumAll() {
		int show = 0;
		MatchShowStatusFb status[] = MatchShowStatusFb.values();
		for (int i = 0; i < status.length; i++) {
			if (status != null) {
				show |= 1 << status[i].getValue();
			}
		}
		return show;
	}

	public Date getShowDate() {
		return DateTools.stringToDate(getIntTime() + "", "yyyyMMdd");
	}

	public Integer getShowNum() {
		return null == showNum || showNum.equals("null") ? 0 : showNum;
	}

	public void setShowNum(Integer showNum) {
		this.showNum = showNum;
	}

	public String getShortGameName() {
		shortGameName=getGameShortName();
		return shortGameName;
	}

	public String getShortGuestTeam() {
		if (getShortNameMap().containsKey(getGuestTeam())) {
			shortGuestTeam = getShortNameMap().get(getGuestTeam());
		} else {
			shortGuestTeam = getGuestTeam().length() > 4 ? getGuestTeam().substring(0, 4) : getGuestTeam();
		}
		return shortGuestTeam;
	}

	public String getShortHomeTeam() {
		if (getShortNameMap().containsKey(getHomeTeam())) {
			shortHomeTeam = getShortNameMap().get(getHomeTeam());
		} else {
			shortHomeTeam = getHomeTeam().length() > 4 ? getHomeTeam().substring(0, 4) : getHomeTeam();
		}
		return shortHomeTeam;
	}

	public Boolean getShowPm() {
		return showPm;
	}

	public void setShowPm(Boolean showPm) {
		this.showPm = showPm;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public FootballMatch getFootballInfo() {
		return footballInfo;
	}

	public void setFootballInfo(FootballMatch footballInfo) {
		this.footballInfo = footballInfo;
	}

	public boolean[] getSpfSelectStatus() {
		Set<FbLimitOptionItem> status = FbLimitOptionItem.getSpfItems();
		if (status != null) {
			for (FbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getSpfShowNum() & value) > 0) {
					spfSelectStatus[item.getBit()] = true;
				} else {
					spfSelectStatus[item.getBit()] = false;
				}
			}
		}
		return spfSelectStatus;
	}

	public boolean[] getRqspfSelectStatus() {
		Set<FbLimitOptionItem> status = FbLimitOptionItem.getRqspfItems();
		if (status != null) {
			for (FbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getRqspfShowNum() & value) > 0) {
					rqspfSelectStatus[item.getBit()] = true;
				} else {
					rqspfSelectStatus[item.getBit()] = false;
				}
			}
		}
		return rqspfSelectStatus;
	}

	public boolean[] getBfSelectStatus() {
		Set<FbLimitOptionItem> status = FbLimitOptionItem.getBfItems();
		if (status != null) {
			for (FbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getBfShowNum() & value) > 0) {
					bfSelectStatus[item.getBit()] = true;
				} else {
					bfSelectStatus[item.getBit()] = false;
				}
			}
		}
		return bfSelectStatus;
	}

	public boolean[] getJqsSelectStatus() {
		Set<FbLimitOptionItem> status = FbLimitOptionItem.getJqsItems();
		if (status != null) {
			for (FbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getJqsShowNum() & value) > 0) {
					jqsSelectStatus[item.getBit()] = true;
				} else {
					jqsSelectStatus[item.getBit()] = false;
				}
			}
		}
		return jqsSelectStatus;
	}

	public boolean[] getBqcSelectStatus() {
		Set<FbLimitOptionItem> status = FbLimitOptionItem.getBqcItems();
		if (status != null) {
			for (FbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getBqcShowNum() & value) > 0) {
					bqcSelectStatus[item.getBit()] = true;
				} else {
					bqcSelectStatus[item.getBit()] = false;
				}
			}
		}
		return bqcSelectStatus;
	}

	public Integer spfStatusToNum() {
		int show = 0;
		Set<FbLimitOptionItem> items = FbLimitOptionItem.getSpfItems();
		if (getSpfShowStatus() != null && !getSpfShowStatus().isEmpty()) {
			for (String s : getSpfShowStatus()) {
				if (s != null) {
					FbLimitOptionItem item = FbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;

	}

	public Integer jqsStatusToNum() {
		int show = 0;
		Set<FbLimitOptionItem> items = FbLimitOptionItem.getJqsItems();
		if (getJqsShowStatus() != null && !getJqsShowStatus().isEmpty()) {
			for (String s : getJqsShowStatus()) {
				if (s != null) {
					FbLimitOptionItem item = FbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;

	}

	public Integer rqspfStatusToNum() {
		int show = 0;
		Set<FbLimitOptionItem> items = FbLimitOptionItem.getRqspfItems();
		if (getRqspfShowStatus() != null && !getRqspfShowStatus().isEmpty()) {
			for (String s : getRqspfShowStatus()) {
				if (s != null) {
					FbLimitOptionItem item = FbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;

	}

	public Integer bfStatusToNum() {
		int show = 0;
		Set<FbLimitOptionItem> items = FbLimitOptionItem.getBfItems();
		if (getBfShowStatus() != null && !getBfShowStatus().isEmpty()) {
			for (String s : getBfShowStatus()) {
				if (s != null) {
					FbLimitOptionItem item = FbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;

	}

	public Integer bqcStatusToNum() {
		int show = 0;
		Set<FbLimitOptionItem> items = FbLimitOptionItem.getBqcItems();
		if (getBqcShowStatus() != null && !getBqcShowStatus().isEmpty()) {
			for (String s : getBqcShowStatus()) {
				if (s != null) {
					FbLimitOptionItem item = FbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;
	}

	public Integer getSpfShowNum() {
		return null == spfShowNum || spfShowNum.equals("null") ? 0 : spfShowNum;
	}

	public void setSpfShowNum(Integer spfShowNum) {
		this.spfShowNum = spfShowNum;
	}

	public Integer getRqspfShowNum() {
		return null == rqspfShowNum || rqspfShowNum.equals("null") ? 0 : rqspfShowNum;
	}

	public void setRqspfShowNum(Integer rqspfShowNum) {
		this.rqspfShowNum = rqspfShowNum;
	}

	public Integer getBfShowNum() {
		return null == bfShowNum || bfShowNum.equals("null") ? 0 : bfShowNum;
	}

	public void setBfShowNum(Integer bfShowNum) {
		this.bfShowNum = bfShowNum;
	}

	public Integer getJqsShowNum() {
		return null == jqsShowNum || jqsShowNum.equals("null") ? 0 : jqsShowNum;
	}

	public void setJqsShowNum(Integer jqsShowNum) {
		this.jqsShowNum = jqsShowNum;
	}

	public Integer getBqcShowNum() {
		return null == bqcShowNum || bqcShowNum.equals("null") ? 0 : bqcShowNum;
	}

	public void setBqcShowNum(Integer bqcShowNum) {
		this.bqcShowNum = bqcShowNum;
	}

	public List<String> getSpfShowStatus() {
		return spfShowStatus;
	}

	public void setSpfShowStatus(List<String> spfShowStatus) {
		this.spfShowStatus = spfShowStatus;
	}

	public List<String> getRqspfShowStatus() {
		return rqspfShowStatus;
	}

	public void setRqspfShowStatus(List<String> rqspfShowStatus) {
		this.rqspfShowStatus = rqspfShowStatus;
	}

	public List<String> getJqsShowStatus() {
		return jqsShowStatus;
	}

	public void setJqsShowStatus(List<String> jqsShowStatus) {
		this.jqsShowStatus = jqsShowStatus;
	}

	public List<String> getBqcShowStatus() {
		return bqcShowStatus;
	}

	public void setBqcShowStatus(List<String> bqcShowStatus) {
		this.bqcShowStatus = bqcShowStatus;
	}

	public List<String> getBfShowStatus() {
		return bfShowStatus;
	}

	public void setBfShowStatus(List<String> bfShowStatus) {
		this.bfShowStatus = bfShowStatus;
	}

	public String getGameIcon() {
		/*
		if(StringTools.isNullOrBlank(gameIcon)){
			gameIcon=DEFAULT_ICON;
		}
		*/
		return gameIcon;
	}

	public void setGameIcon(String gameIcon) {
		this.gameIcon = gameIcon;
	}

	public void setShortGameName(String shortGameName) {
		this.shortGameName = shortGameName;
		setGameShortName(shortGameName);
	}

	public void setShortGuestTeam(String shortGuestTeam) {
		this.shortGuestTeam = shortGuestTeam;
		setGuestShortName(shortGuestTeam);
	}

	public void setShortHomeTeam(String shortHomeTeam) {
		this.shortHomeTeam = shortHomeTeam;
		setHomeShortName(shortHomeTeam);
	}
	
	public String[] getResults() {
		//胜平负	让分胜平负	半全场
		String _spfText="";
		String _rspfText="";
		String _bqcText="";
		Integer _bc=halfHomeScore-halfGuestScore;
		Integer _spf=getHomeScore()-getGuestScore();
		Integer _rspf=getHomeScore()-getGuestScore()-concede;
	
		if(_bc>0)_bqcText="胜";
		else if(_bc<0)_bqcText="负";
		else _bqcText="平";
		if(_spf>0){
			_spfText="胜";
			_bqcText+="胜";
		}
		else if(_spf<0){
			_spfText="负";
			_bqcText+="负";
		}
		else {
			_spfText="平";
			_bqcText+="平";
		}
		if(_rspf>0)_rspfText="胜";
		else if(_rspf<0)_rspfText="负";
		else _rspfText="平";
		
		String[] _results= {_spfText,_rspfText,_bqcText};
		return _results;
	}
}
