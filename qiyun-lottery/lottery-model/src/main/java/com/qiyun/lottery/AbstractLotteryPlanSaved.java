package com.qiyun.lottery;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.Platform;
import com.qiyun.commonModel.PlayType;
import com.qiyun.commonModel.TradeType;
import com.qiyun.model.GenType;
import com.qiyun.model.WinStatus;
import com.qiyun.type.SelectType;

import java.util.Date;

/**
 * <p>保存方案</p>
 * @author tangfeng
 */
public abstract class AbstractLotteryPlanSaved implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;
	
	/**
	 * 方案编号
	 */
	private Integer id;
	
	/**
	 * 会员id
	 */
	private Integer memberId;
	
	/**
	 * 彩期
	 */
	private String term;
	
	/**
	 * 彩种
	 */
	private LotteryType lotteryType;
	
	/**
	 * 玩法
	 */
	private PlayType playType;
	
	/**
	 * 选择类型
	 */
	private SelectType selectType;
	
	/**
	 * 购买类型
	 */
	private GenType genType;
	
	/**
	 * 交易类型
	 */
	private TradeType tradeType;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 金额
	 */
	private Integer amount;
	
	/**
	 * 倍数
	 */
	private Integer multiple;
	
	/**
	 * 注数
	 */
	private Integer betCount;
	
	/**
	 * 辅助字段 大乐透的是否追加
	 */
	private String addAttribute;
	
	/**
	 * 发起时间
	 */
	private Date createDateTime;
	
	/**
	 * 截止处理时间
	 */
	private Date dealDateTime;
	
	/**
	 * 方案状态
	 */
	private SavedPlanStatus planStatus;
	
	/**
	 * 中奖状态
	 */
	private WinStatus winStatus;
	
	/**
	 * 税前奖金
	 */
	private Double pretaxPrize;
	
	/**
	 * 税后奖金
	 */
	private Double posttaxPrize;
	
	/**
	 * 中奖描述内容 奖级^中奖注数^中奖金额 prize1^1^1000#prize2^0^0#prize3^0^0
	 */
	private String prizeContent;
    
	/**
	 * 开奖时间
	 */
	private Date openResultTime;
	
	/**
	 * 平台
	 */
	private Platform platform;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public PlayType getPlayType() {
		return playType;
	}

	public void setPlayType(PlayType playType) {
		this.playType = playType;
	}

	public SelectType getSelectType() {
		return selectType;
	}

	public void setSelectType(SelectType selectType) {
		this.selectType = selectType;
	}

	public GenType getGenType() {
		return genType;
	}

	public void setGenType(GenType genType) {
		this.genType = genType;
	}
	
	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public Integer getBetCount() {
		return betCount;
	}

	public void setBetCount(Integer betCount) {
		this.betCount = betCount;
	}

	public String getAddAttribute() {
		return addAttribute;
	}

	public void setAddAttribute(String addAttribute) {
		this.addAttribute = addAttribute;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getDealDateTime() {
		return dealDateTime;
	}

	public void setDealDateTime(Date dealDateTime) {
		this.dealDateTime = dealDateTime;
	}

	public SavedPlanStatus getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(SavedPlanStatus planStatus) {
		this.planStatus = planStatus;
	}

	public WinStatus getWinStatus() {
		return winStatus;
	}

	public void setWinStatus(WinStatus winStatus) {
		this.winStatus = winStatus;
	}

	public Double getPretaxPrize() {
		return pretaxPrize;
	}

	public void setPretaxPrize(Double pretaxPrize) {
		this.pretaxPrize = pretaxPrize;
	}

	public Double getPosttaxPrize() {
		return posttaxPrize;
	}

	public void setPosttaxPrize(Double posttaxPrize) {
		this.posttaxPrize = posttaxPrize;
	}

	public String getPrizeContent() {
		return prizeContent;
	}

	public void setPrizeContent(String prizeContent) {
		this.prizeContent = prizeContent;
	}

	public Date getOpenResultTime() {
		return openResultTime;
	}

	public void setOpenResultTime(Date openResultTime) {
		this.openResultTime = openResultTime;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
}
