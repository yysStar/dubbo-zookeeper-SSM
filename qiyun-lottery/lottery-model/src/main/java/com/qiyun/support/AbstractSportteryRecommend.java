package com.qiyun.support;

import com.qiyun.commonModel.LotteryType;

import java.util.Date;

/**
 * AbstractSportteryRecommend entity provides the base persistence definition of
 * the SportteryRecommend entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractSportteryRecommend implements java.io.Serializable {

	// Fields

	private Integer id;
	private AdminExpert adminExpert; // 专家
	private String matchKey; // 对阵key 20150316_1
	private LotteryType lotteryType;// 彩种
	private Integer passMode;// 过关方式 单固or 过关
	private String optionItem; // 选项
	private String description; // 秒速
	private String danType; // 胆类型
	private Date endTime; // 截止时间
	private Integer seq; // 排序
	private SportteryRecommendStatus recommendStatus; // 状态
	private Date createDate;
	private String createAccount;
	private Integer starLevel; // 星级
	private String term;// 彩期
	private Integer delay; // 正常/延期/取消=0/1/2
	private String matchName; // 联赛名称
	private Integer buyType;// 购买类型 1彩金 2积分
	private Integer buyConsume; // 消耗额度
	private Integer buyFree;// 是否需要付费 1是0否
	private Integer buyNum;//购买人数
	private String title; //

	// Constructors

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	/** default constructor */
	public AbstractSportteryRecommend() {
	}

	/** minimal constructor */
	public AbstractSportteryRecommend(AdminExpert adminExpert, String matchKey, LotteryType lotteryType, String optionItem, String term) {
		this.adminExpert = adminExpert;
		this.matchKey = matchKey;
		this.lotteryType = lotteryType;
		this.optionItem = optionItem;
		this.term = term;
	}

	/** full constructor */
	public AbstractSportteryRecommend(AdminExpert adminExpert, String matchKey, LotteryType lotteryType, Integer passMode, String optionItem,
			String description, String danType, Date endTime, Integer seq, SportteryRecommendStatus recommendStatus, Date createDate,
			String createAccount, Integer starLevel, String term, Integer delay, String matchName, Integer buyType, Integer buyConsume,
			Integer buyFree,Integer buyNum,String title) {
		this.adminExpert = adminExpert;
		this.matchKey = matchKey;
		this.lotteryType = lotteryType;
		this.passMode = passMode;
		this.optionItem = optionItem;
		this.description = description;
		this.danType = danType;
		this.endTime = endTime;
		this.seq = seq;
		this.recommendStatus = recommendStatus;
		this.createDate = createDate;
		this.createAccount = createAccount;
		this.starLevel = starLevel;
		this.term = term;
		this.delay = delay;
		this.matchName = matchName;
		this.buyType = buyType;
		this.buyConsume = buyConsume;
		this.buyFree = buyFree;
		this.buyNum=buyNum;
		this.title=title;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AdminExpert getAdminExpert() {
		return this.adminExpert;
	}

	public void setAdminExpert(AdminExpert adminExpert) {
		this.adminExpert = adminExpert;
	}

	public String getMatchKey() {
		return this.matchKey;
	}

	public void setMatchKey(String matchKey) {
		this.matchKey = matchKey;
	}

	public LotteryType getLotteryType() {
		return this.lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getOptionItem() {
		return this.optionItem;
	}

	public void setOptionItem(String optionItem) {
		this.optionItem = optionItem;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDanType() {
		return this.danType;
	}

	public void setDanType(String danType) {
		this.danType = danType;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getCreateAccount() {
		return this.createAccount;
	}

	public void setCreateAccount(String createAccount) {
		this.createAccount = createAccount;
	}

	public Integer getStarLevel() {
		return this.starLevel;
	}

	public void setStarLevel(Integer starLevel) {
		this.starLevel = starLevel;
	}

	public Integer getPassMode() {
		return passMode;
	}

	public void setPassMode(Integer passMode) {
		this.passMode = passMode;
	}

	public SportteryRecommendStatus getRecommendStatus() {
		return recommendStatus;
	}

	public void setRecommendStatus(SportteryRecommendStatus recommendStatus) {
		this.recommendStatus = recommendStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 正常/延期/取消=0/1/2
	 * 
	 * @param delay
	 */
	public Integer getDelay() {
		delay = delay == null ? 0 : delay;
		return delay;
	}

	/**
	 * 正常/延期/取消=0/1/2
	 * 
	 * @param delay
	 */
	public void setDelay(Integer delay) {
		this.delay = delay;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public Integer getBuyType() {
		buyType = buyType == null ? 1 : buyType;
		return buyType;
	}

	public void setBuyType(Integer buyType) {
		this.buyType = buyType;
	}

	public Integer getBuyConsume() {
		return buyConsume;
	}

	public void setBuyConsume(Integer buyConsume) {
		this.buyConsume = buyConsume;
	}

	/**
	 * 是否付费 1是0否
	 * @return
	 */
	public Integer getBuyFree() {
		buyFree = buyFree == null ? 0 : buyFree;
		return buyFree;
	}

	public void setBuyFree(Integer buyFree) {
		this.buyFree = buyFree;
	}

	public Integer getBuyNum() {
		buyNum=buyNum==null?0:buyNum;
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}