package com.qiyun.grabber.model;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.OptionItem;
import com.qiyun.tools.DateTools;
import com.qiyun.tools.StringTools;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstactMatch implements Serializable {

	private static final long serialVersionUID = 123191885145667242L;
	private Integer id;
	/** 主队名称 * */
	private String homeTeam;
	private String homeShortName;
	private String gameColor;
	/** 客队名称 * */
	private String guestTeam;
	private String guestShortName;
	/** 比赛时间 * */
	private Date matchTime;
	/** 比赛时间整型格式 * */
	private Integer intTime;
	/** 当日赛事编号--与官方对应 * */
	private Integer lineId;
	/** 联赛名称 * */
	private String gameName;
	/** 联赛名称缩写 * */
	private String gameShortName;
	/** 联赛关联ID * */
	private Integer gameId;
	/** 比赛时间 如周三* */
	private String weekStr;

	/** 对阵状态 0：进行中 1：已结束 2：取消* */
	private Integer status=0;
	/** *是否显示*** */
	private List<String> showStatus;
	/** 自定义属性 **/
	private Map<String, Object> attrMap = new HashMap<String, Object>();
	
	private Integer homeScore;
	private Integer guestScore;
	private Integer hasDelay=0;//是否推迟比赛 1是 0否

	private Integer version;
	

	public Map<String, Object> getAttrMap(){
		return this.attrMap;
	}
	
	public void setAttrMap(Map<String, Object> attrMap){
		this.attrMap=attrMap;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getGuestTeam() {
		return guestTeam;
	}

	public void setGuestTeam(String guestTeam) {
		this.guestTeam = guestTeam;
	}

	protected String getHomeShortName() {
		if(StringTools.isNullOrBlank(homeShortName)){
			homeShortName=getHomeTeam();
		}
		homeShortName = homeShortName.length() > 4 ? homeShortName.substring(0, 4) : homeShortName;
		return homeShortName;
	}

	protected void setHomeShortName(String homeShortName) {
		this.homeShortName = homeShortName;
	}

	protected String getGuestShortName() {
		if(StringTools.isNullOrBlank(guestShortName)){
			guestShortName=getGuestTeam();
		}
		guestShortName = guestShortName.length() > 4 ? guestShortName.substring(0, 4) : guestShortName;
		return guestShortName;
	}

	protected void setGuestShortName(String guestShortName) {
		this.guestShortName = guestShortName;
	}

	public Date getMatchTime() {
		return matchTime;
	}
	
	public String getMatchTime_MM_DD_HH_MM() {
		return DateTools.StringToDate_MM_DD_HH_MM(matchTime);
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public Integer getIntTime() {
		return intTime;
	}

	public void setIntTime(Integer intTime) {
		this.intTime = intTime;
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public String getGameName() {
		return gameName;
	}

	public String getWeekStr() {
		if (weekStr == null) {
			Date time = DateTools.StringToDate(getIntTime() + "", "yyyyMMdd");
			weekStr = DateTools.getWeekStr(time);
		}
		return weekStr;
	}

	public void setWeekStr(String weekStr) {
		this.weekStr = weekStr;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * 获得比赛场次的key值,备用
	 */
	public String genMatchKey() {
		if (this.intTime == null || this.lineId == null)
			throw new RuntimeException("赛事lineId或者比赛时间为空");
		return genMatchKey(intTime, lineId);
	}

	public static String genMatchKey(Integer intTime, Integer lineId) {
		return intTime + "_" + lineId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(Integer homeScore) {
		this.homeScore = homeScore;
	}

	public Integer getGuestScore() {
		return guestScore;
	}

	public void setGuestScore(Integer guestScore) {
		this.guestScore = guestScore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGameColor() {
		return gameColor;
	}

	public void setGameColor(String gameColor) {
		this.gameColor = gameColor;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	protected String getGameShortName() {
		if(StringTools.isNullOrBlank(gameShortName)){
			gameShortName=getGameName();
		}
		return gameShortName;
	}
	
	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	protected void setGameShortName(String gameShortName) {
		this.gameShortName = gameShortName;
	}
	public List<String> getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(List<String> showStatus) {
		this.showStatus = showStatus;
	}

	public String getScore() {
		if (getHomeScore() != null && getGuestScore() != null) {
			return getHomeScore() + ":" + getGuestScore();
		}
		return null;
	}

	public Integer getScorePoor() {
		if (getHomeScore() != null && getGuestScore() != null) {
			return Integer.valueOf(getHomeScore()) - Integer.valueOf(getGuestScore());
		}
		return null;
	}

	public Integer getAllScore() {
		if (getHomeScore() != null && getGuestScore() != null) {
			return Integer.valueOf(getHomeScore()) + Integer.valueOf(getGuestScore());
		}
		return null;
	}

	public String getShowLineID() {
		Date time = DateTools.StringToDate(getIntTime() + "", "yyyyMMdd");
		String lineId = getLineId().toString();
		for (int i = lineId.length(); i < 3; i++) {
			lineId = "0" + lineId;
		}
		return DateTools.getWeekStr(time) + lineId;
	}
	public String getShowMatchKey() {
		String lineId = getLineId().toString();
		for (int i = lineId.length(); i < 3; i++) {
			lineId = "0" + lineId;
		}
		String showLineId=lineId;
		String showMatchKey=intTime.toString().substring(2)+showLineId;
		return showMatchKey;
	}

	public String getLineIDText() {
		String lineId = getLineId().toString();
		for (int i = lineId.length(); i < 3; i++) {
			lineId = "0" + lineId;
		}
		return lineId;
	}

	public String getMapKey() {
		return this.getIntTime() + "_" + this.getLineId();	
	}

	public abstract OptionItem getResult(LotteryType lotteryType);

	public abstract Double getResultAward(LotteryType lotteryType);

	public Integer getHasDelay() {
		return hasDelay==null?0:hasDelay;
	}

	public void setHasDelay(Integer hasDelay) {
		this.hasDelay = hasDelay;
	}

}
