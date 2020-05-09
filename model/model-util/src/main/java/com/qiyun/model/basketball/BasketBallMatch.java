package com.qiyun.model.basketball;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstactMatch;
import com.qiyun.item.OptionItem;
import com.qiyun.item.basketball.BbLimitOptionItem;
import com.qiyun.status.MatchShowStatus;
import com.qiyun.tools.DateTools;
import com.qiyun.util.CommonUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BasketBallMatch extends AbstactMatch {

	private static final long serialVersionUID = -4602527424812632406L;
	/** 第一节比分* */
	private String fristSection;
	/** 第二节比分* */
	private String SecondSection;
	/** 第三节比分* */
	private String thirdSection;
	/** 第四节比分* */
	private String fourthSection;
	/** 加时比分* */
	private String addTime;
	/** 总比分* */
	private String total;
	/**状态 * */
	private String condition;

	/** 单关：胜负结果* */
	private Double resultOfSF;
	/** 单关：让分胜负结果* */
	private Double resultOfRFSF;
	/** 单关：胜分差结果* */
	private Double resultOfSFC;
	/** 单关：大小分结果* */
	private Double resultOfDXF;
	/** 是否是胜负玩法的对阵* */
	private Integer showNum = 0;
	/** 让分基数过关* */
	private Double handicap;
	/** 大小分基数过关* */
	private Double baseBigOrSmall;
	/** 让分基数单关* */
	private Double single_handicap;
	/** 大小分基数单关* */
	private Double single_baseBigOrSmall;
	/** *数据来源ID*** */
	private String outId;
	/** *前二两场设置字段*** */
	private Integer dxfQ2Scene;
	
	private boolean showPm; // 是否显示排名 需要主动set值
	
	private BasketBallBase basketBallBase;// 足球资料库表 需要主动set 值
	
	private Date endTime;//需要主动set
	
	private String analysisId;
	
	private String gameIcon;//联赛图标
	
	/** 针对单关投注选项停开售 * */
	private Integer sfShowNum; // 数据库存放
	private Integer rfsfShowNum; // 数据库存放
	private Integer sfcShowNum; // 数据库存放
	private Integer dxfShowNum; // 数据库存放

	private boolean[] sfSelectStatus = new boolean[2]; // 前台获取数据
	private boolean[] rfsfSelectStatus = new boolean[2];// 前台获取数据
	private boolean[] sfcSelectStatus = new boolean[12];// 前台获取数据
	private boolean[] dxfSelectStatus = new boolean[2];// 前台获取数据
	private List<String> sfShowStatus; // 前台传输数据
	private List<String> rfsfShowStatus; // 前台传输数据
	private List<String> sfcShowStatus; // 前台传输数据
	private List<String> dxfShowStatus; // 前台传输数据
	
	private String shortHomeTeam;
	
	private String shortGuestTeam; 
	
	private String shortGameName; // 赛事缩写

	@Override
	public String toString() {
		return "BasketBallMatch [total=" + total + ", shortHomeTeam=" + shortHomeTeam + ", shortGuestTeam="
				+ shortGuestTeam + ", shortGameName=" + shortGameName + "]";
	}

	/** *页面显示使用** */
	private boolean selectStatus[] = new boolean[8];

	public Double getHandicap() {
		return handicap;
	}

	public void setHandicap(Double handicap) {
		this.handicap = handicap;
	}

	public Double getBaseBigOrSmall() {
		return baseBigOrSmall;
	}

	public void setBaseBigOrSmall(Double baseBigOrSmall) {
		this.baseBigOrSmall = baseBigOrSmall;
	}

	public String getFristSection() {
		return fristSection;
	}

	public void setFristSection(String fristSection) {
		this.fristSection = fristSection;
	}

	public String getSecondSection() {
		return SecondSection;
	}

	public void setSecondSection(String secondSection) {
		SecondSection = secondSection;
	}

	public String getThirdSection() {
		return thirdSection;
	}

	public void setThirdSection(String thirdSection) {
		this.thirdSection = thirdSection;
	}

	public String getFourthSection() {
		return fourthSection;
	}

	public void setFourthSection(String fourthSection) {
		this.fourthSection = fourthSection;
	}

	public Double getResultOfSF() {
		return resultOfSF;
	}

	public void setResultOfSF(Double resultOfSF) {
		this.resultOfSF = resultOfSF;
	}

	public Double getResultOfRFSF() {
		return resultOfRFSF;
	}

	public void setResultOfRFSF(Double resultOfRFSF) {
		this.resultOfRFSF = resultOfRFSF;
	}

	public Double getResultOfSFC() {
		return resultOfSFC;
	}

	public void setResultOfSFC(Double resultOfSFC) {
		this.resultOfSFC = resultOfSFC;
	}

	public Double getResultOfDXF() {
		return resultOfDXF;
	}

	public void setResultOfDXF(Double resultOfDXF) {
		this.resultOfDXF = resultOfDXF;
	}

	public Double getSingle_baseBigOrSmall() {
		return single_baseBigOrSmall;
	}

	public void setSingle_baseBigOrSmall(Double single_baseBigOrSmall) {
		this.single_baseBigOrSmall = single_baseBigOrSmall;
	}

	public Double getSingle_handicap() {
		return single_handicap;
	}

	public void setSingle_handicap(Double single_handicap) {
		this.single_handicap = single_handicap;
	}

	public Integer getShowNum() {
		return showNum;
	}

	public void setShowNum(Integer showNum) {
		this.showNum = showNum;
	}

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public Integer getDxfQ2Scene() {
		return dxfQ2Scene;
	}

	public void setDxfQ2Scene(Integer dxfQ2Scene) {
		this.dxfQ2Scene = dxfQ2Scene;
	}

	/**
	 * 获取胜负的最终结果
	 * 说明:出赛果后会更新match的大小分/让分数据. 
	 * 	   所以出赛果后这个方法才是正确的
	 * 	   注意使用场景
	 * @return
	 */
	public OptionItem getSFResult() {
		return getResult(LotteryType.JC_LQ_SF);
	}

	/**
	 * 获取让分胜负的最终结果
	 * 说明:出赛果后会更新match的大小分/让分数据. 
	 * 	   所以出赛果后这个方法才是正确的
	 * 	   注意使用场景
	 * @return
	 */
	public OptionItem getRFSFResult() {
		return getResult(LotteryType.JC_LQ_RFSF);
	}
	/**
	 * 获取胜分差的最终结果
	 * 说明:出赛果后会更新match的大小分/让分数据. 
	 * 	   所以出赛果后这个方法才是正确的
	 * 	   注意使用场景
	 * @return
	 */
	public OptionItem getSFCResult() {
		return getResult(LotteryType.JC_LQ_SFC);
	}
	/**
	 * 获取大小分的最终结果
	 * 说明:出赛果后会更新match的大小分/让分数据. 
	 * 	   所以出赛果后这个方法才是正确的
	 * 	   注意使用场景
	 * @return
	 */
	public OptionItem getDXFResult() {
		return getResult(LotteryType.JC_LQ_DXF);
	}
	/**
	 * 获取最终结果 
	 * 说明:出赛果后会更新match的大小分/让分数据. 
	 * 	   所以出赛果后这个方法才是正确的
	 * 	   注意使用场景
	 * @param lotteryType
	 * @return
	 */
	public OptionItem getResult(LotteryType lotteryType) {
		OptionItem resultOption=null;
		try{
			 resultOption = CommonUtils.getResultOptionItem(lotteryType.getValue() + "",
					 CommonUtils.getResultInfo(this));
		}catch (Exception e) {
		}
		return resultOption;
	}

	public boolean[] getSelectStatus() {
		MatchShowStatus status[] = MatchShowStatus.values();
		for (int i = 0; i < status.length; i++) {
			int value = 1 << status[i].getValue();
			if ((this.showNum & value) > 0) {
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
	public boolean getStatusIsSale(MatchShowStatus fb){
		MatchShowStatus status[] = MatchShowStatus.values();
		boolean[] selectStatus =getSelectStatus();
		boolean flag=false;
		for(int i=0;i<status.length;i++){
			if(status[i]==fb){
				flag=selectStatus[i];
				break;
			}
		}
		return flag;
	}

	public List<MatchShowStatus> getMatchShowStatus() {
		List<MatchShowStatus> matchShowStatusList = new ArrayList<MatchShowStatus>();
		if (getShowStatus() != null) {
			for (String s : getShowStatus()) {
				if (s != null) {
					MatchShowStatus tempstatus = MatchShowStatus.valueOf(s);
					matchShowStatusList.add(tempstatus);
				}
			}
		}
		return matchShowStatusList;
	}

	public Integer getShowStatusNum() {
		int show = 0;
		if (getShowStatus() != null && !getShowStatus().isEmpty()) {
			for (MatchShowStatus status : getMatchShowStatus()) {
				if (status != null){
					show |= 1 << status.getValue();
				}
			}
		}
		return show;
	}
	/**
	 * 全部开售状态
	 * @return
	 */
	public Integer getShowStatusNumAll() {
		int show = 0;
		MatchShowStatus status[] = MatchShowStatus.values();
		for (int i = 0; i < status.length; i++) {
			if (status != null){
				show |= 1 << status[i].getValue();
			}
		}
		return show;
	}
	
	@Override
	public Double getResultAward(LotteryType lotteryType) {
		int typeValue = lotteryType.getValue();
		switch (typeValue) {
		case 30:
			return getResultOfSF();
		case 31:
			return getResultOfRFSF();
		case 32:
			return getResultOfSFC();
		case 33:
			return getResultOfDXF();
		default:
			throw new RuntimeException("根据玩法获取篮球奖金时发生类型错误");
		}

	}
	
	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	public Date getShowDate(){
		return DateTools.stringToDate(getIntTime()+"", "yyyyMMdd");
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getAnalysisId() {
		return analysisId;
	}

	public void setAnalysisId(String analysisId) {
		this.analysisId = analysisId;
	}

	public Integer getSfShowNum() {
		return null == sfShowNum  ? 0 : sfShowNum;
	}

	public void setSfShowNum(Integer sfShowNum) {
		this.sfShowNum = sfShowNum;
	}

	public Integer getRfsfShowNum() {
		return null == rfsfShowNum  ? 0 : rfsfShowNum;
	}

	public void setRfsfShowNum(Integer rfsfShowNum) {
		this.rfsfShowNum = rfsfShowNum;
	}

	public Integer getSfcShowNum() {
		return null == sfcShowNum  ? 0 : sfcShowNum;
	}

	public void setSfcShowNum(Integer sfcShowNum) {
		this.sfcShowNum = sfcShowNum;
	}

	public Integer getDxfShowNum() {
		return null == dxfShowNum  ? 0 : dxfShowNum;
	}

	public void setDxfShowNum(Integer dxfShowNum) {
		this.dxfShowNum = dxfShowNum;
	}

	public List<String> getSfShowStatus() {
		return sfShowStatus;
	}

	public void setSfShowStatus(List<String> sfShowStatus) {
		this.sfShowStatus = sfShowStatus;
	}

	public List<String> getRfsfShowStatus() {
		return rfsfShowStatus;
	}

	public void setRfsfShowStatus(List<String> rfsfShowStatus) {
		this.rfsfShowStatus = rfsfShowStatus;
	}

	public List<String> getSfcShowStatus() {
		return sfcShowStatus;
	}

	public void setSfcShowStatus(List<String> sfcShowStatus) {
		this.sfcShowStatus = sfcShowStatus;
	}

	public List<String> getDxfShowStatus() {
		return dxfShowStatus;
	}

	public void setDxfShowStatus(List<String> dxfShowStatus) {
		this.dxfShowStatus = dxfShowStatus;
	}

	public boolean[] getSfSelectStatus() {
		Set<BbLimitOptionItem> status = BbLimitOptionItem.getSFItems();
		if (status != null) {
			for (BbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getSfShowNum() & value) > 0) {
					sfSelectStatus[item.getBit()] = true;
				} else {
					sfSelectStatus[item.getBit()] = false;
				}
			}
		}
		return sfSelectStatus;
	}

	public boolean[] getRfsfSelectStatus() {
		Set<BbLimitOptionItem> status = BbLimitOptionItem.getRFSFItems();
		if (status != null) {
			for (BbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getRfsfShowNum() & value) > 0) {
					rfsfSelectStatus[item.getBit()] = true;
				} else {
					rfsfSelectStatus[item.getBit()] = false;
				}
			}
		}
		return rfsfSelectStatus;
	}

	public boolean[] getSfcSelectStatus() {
		Set<BbLimitOptionItem> status = BbLimitOptionItem.getSFCItems();
		if (status != null) {
			for (BbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getSfcShowNum() & value) > 0) {
					sfcSelectStatus[item.getBit()] = true;
				} else {
					sfcSelectStatus[item.getBit()] = false;
				}
			}
		}
		return sfcSelectStatus;
	}

	public boolean[] getDxfSelectStatus() {
		Set<BbLimitOptionItem> status = BbLimitOptionItem.getDXFItems();
		if (status != null) {
			for (BbLimitOptionItem item : status) {
				int value = 1 << item.getBit();
				// 按位与运算(运算结果要么是0要么是1,1代表已存在)
				if ((getDxfShowNum() & value) > 0) {
					dxfSelectStatus[item.getBit()] = true;
				} else {
					dxfSelectStatus[item.getBit()] = false;
				}
			}
		}
		return dxfSelectStatus;
	}
	
	/**
	 * sf的停售状态位移成数字
	 * @return
	 */
	public Integer sfStatusToNum() {
		int show = 0;
		Set<BbLimitOptionItem> items = BbLimitOptionItem.getSFItems();
		List<String> showStatus=getSfShowStatus();
		if (showStatus != null && !showStatus.isEmpty()) {
			for (String s : showStatus) {
				if (s != null) {
					BbLimitOptionItem item = BbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;
	}
	public Integer rfsfStatusToNum() {
		int show = 0;
		Set<BbLimitOptionItem> items = BbLimitOptionItem.getRFSFItems();
		List<String> showStatus=getRfsfShowStatus();
		if (showStatus != null && !showStatus.isEmpty()) {
			for (String s : showStatus) {
				if (s != null) {
					BbLimitOptionItem item = BbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;
	}
	public Integer sfcStatusToNum() {
		int show = 0;
		Set<BbLimitOptionItem> items = BbLimitOptionItem.getSFCItems();
		List<String> showStatus=getSfcShowStatus();
		if (showStatus != null && !showStatus.isEmpty()) {
			for (String s : showStatus) {
				if (s != null) {
					BbLimitOptionItem item = BbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;
	}
	public Integer dxfStatusToNum() {
		int show = 0;
		Set<BbLimitOptionItem> items = BbLimitOptionItem.getDXFItems();
		List<String> showStatus=getDxfShowStatus();
		if (showStatus != null && !showStatus.isEmpty()) {
			for (String s : showStatus) {
				if (s != null) {
					BbLimitOptionItem item = BbLimitOptionItem.valueOf(s);
					if (item != null && items.contains(item)) {
						show |= 1 << item.getBit();
					}
				}
			}
		}
		return show;
	}

	public String getGameIcon() {
		/*
		if(StringTools.isNullOrBlank(gameIcon)){
			gameIcon=DEFAULT_ICON;
		}
		*/
		return gameIcon;
	}

	public void setShowPm(Boolean showPm) {
		this.showPm = showPm;
	}

	public void setBasketBallBase(BasketBallBase basketBallBase) {
		this.basketBallBase = basketBallBase;
	}

	public Boolean getShowPm() {
		return showPm;
	}

	public BasketBallBase getBasketBallBase() {
		return basketBallBase;
	}

	public String getShortHomeTeam() {
		shortHomeTeam=getHomeShortName();
		return shortHomeTeam;
	}

	public String getShortGuestTeam() {
		shortGuestTeam=getGuestShortName();
		return shortGuestTeam;
	}

	public String getShortGameName() {
		shortGameName=getGameShortName();
		return shortGameName;
	}

	public void setShortHomeTeam(String shortHomeTeam) {
		this.shortHomeTeam = shortHomeTeam;
		setHomeShortName(shortHomeTeam);
	}

	public void setShortGuestTeam(String shortGuestTeam) {
		this.shortGuestTeam = shortGuestTeam;
		setGuestShortName(shortGuestTeam);
	}

	public void setShortGameName(String shortGameName) {
		this.shortGameName = shortGameName;
		setGameShortName(shortGameName);
	}

	public void setGameIcon(String gameIcon) {
		this.gameIcon = gameIcon;
	}
}
