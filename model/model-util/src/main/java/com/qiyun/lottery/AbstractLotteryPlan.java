package com.qiyun.lottery;

import com.qiyun.commonModel.*;
import com.qiyun.status.PlanStatus;
import com.qiyun.status.PlanTicketStatus;
import com.qiyun.status.PublicStatus;
import com.qiyun.status.WinStatus;
import com.qiyun.type.GenType;
import com.qiyun.type.PlanType;
import com.qiyun.type.SelectType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractLotteryPlan generated by MyEclipse Persistence Tools
 */

public abstract class AbstractLotteryPlan implements java.io.Serializable {

	// Fields
	// 方案编号
	private Integer planNo;
	// 彩种
	private LotteryType lotteryType;
	// 彩期
	private String term;
	// 方案类型
	private PlanType planType;
	// 选择类型
	private SelectType selectType;
	// 会员id
	private Integer memberId;
	// 会员帐号
	private String account;
	// 发起时间
	private Date createDateTime;
	// 金额
	private Integer amount;
	// 每份金额
	private Integer perAmount;
	// 份数
	private Integer part;
	// 已售份数
	private Integer soldPart;
	// 发起人认购份数
	private Integer founderPart;
	// 保底份数
	private Integer reservePart;
	// 截止处理时间
	private Date dealDateTime;
	// 倍数
	private Integer multiple;
	// 状态
	private PlanStatus planStatus;
	// 打票时间
	private Date printTicketDateTime;
	// 中奖状态
	private WinStatus winStatus;
	// 税前奖金
	private Double pretaxPrize;
	// 税后奖金
	private Double posttaxPrize;
	// 中奖描述内容 奖级^中奖注数^中奖金额 prize1^1^1000#prize2^0^0#prize3^0^0
	private String prizeContent;
	// 查看次数
	private Integer clicks;
	// 方案描述
	private String planDesc;
	// 内容
	private String content;
	// 是否已经上传方案
	private Integer isUploadContent;
	// 中奖后获得的经验值
	private Integer experience;
	// 是否超级发单人
	private Integer isSuperMan;
	// 玩法
	private PlayType playType;
	// 辅助字段 大乐透的是否追加
	private String addAttribute;
	// 是否置顶
	private Integer isTop;
	// 模型 来源方 其中套餐标记此单来源于哪个套餐，存放套餐的planNo
	private Integer model;
	// md5验证
	private String verifyMd5;
	// 公开类型
	private PublicStatus publicStatus;

	private int commision;
	// 被跟单次数
	private Integer bookCount;
	// 购买类型
	private GenType genType;
	// 是否可处理(出票)
	private Integer isAbleTicketing;
	// 出票状态
	private PlanTicketStatus planTicketStatus;
	//活动加奖金额
	private Double addPrize;
	//开奖时间
	private Date openResultTime;
	//合买促销图标
	private Integer planHmOg;
	private String outPlanNo;
	private Platform platform;
	private Date returnPrizeTime;
	/**
	 * 合买入伙人数
	 */
	private Integer joinCount;
	// Constructors
	
	private String  automaticType; //自动合买标识//AUTOMATIC_TYPE; 产品已经下线,此字段无用

	private Integer openFinish;//是否全部开奖完成
	//支付完成时间
	private Date payFinishTime;	
	//方案受理时间
	private Date acceptTime;
	//退款开始时间
	private Date refundStartTime;
	//退款or派奖到帐时间
	private Date arrivalTime;
	//交易类型
	private TradeType tradeType;
	//被复制跟单人
	private String accountDocumentary;
	//被复制跟单方案编号
	private Integer planNoCopyDocumentary;
	
	//haploid_amount 单倍金额
	private Integer haploidAmount;
	
	//方案总金额
	private Integer sumAmount;
	
	//佣金
	private Double gold;
	
	//发单人佣金总和
	private Double sumGold;
	
	
	//网站所得拥金佣金总和
	private Double sumwebsiteGold;
	
	//网站所得佣金
	private Double websiteGold;
	
	private Set copyLotteryPlan = new HashSet();    //多的一方放在集合中	
	
	

	public AbstractLotteryPlan(Double sumwebsiteGold) {
		super();
		this.sumwebsiteGold = sumwebsiteGold;
	}

	public Double getSumwebsiteGold() {
		return sumwebsiteGold;
	}

	public void setSumwebsiteGold(Double sumwebsiteGold) {
		this.sumwebsiteGold = sumwebsiteGold;
	}

	public AbstractLotteryPlan(Double gold, Double sumGold,
			Double websiteGold) {
		super();
		this.gold = gold;
		this.sumGold = sumGold;
		this.websiteGold = websiteGold;
	}

	public Double getGold() {
		return gold;
	}

	public void setGold(Double gold) {
		this.gold = gold;
	}

	public Double getSumGold() {
		return sumGold;
	}

	public void setSumGold(Double sumGold) {
		this.sumGold = sumGold;
	}

	public Double getWebsiteGold() {
		return websiteGold;
	}

	public void setWebsiteGold(Double websiteGold) {
		this.websiteGold = websiteGold;
	}

	public AbstractLotteryPlan(Integer sumAmount) {
		super();
		this.sumAmount = sumAmount;
	}

	public Integer getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(Integer sumAmount) {
		this.sumAmount = sumAmount;
	}

	public Set getCopyLotteryPlan() {
		return copyLotteryPlan;
	}

	public void setCopyLotteryPlan(Set copyLotteryPlan) {
		this.copyLotteryPlan = copyLotteryPlan;
	}

	public Integer getHaploidAmount() {
		return haploidAmount;
	}

	public void setHaploidAmount(Integer haploidAmount) {
		this.haploidAmount = haploidAmount;
	}

	/** default constructor */
	public AbstractLotteryPlan() {
	}

	/** minimal constructor */
	public AbstractLotteryPlan(Integer planNo, LotteryType lotteryType, String term, PlanType planType, SelectType selectType, Integer memberId,
			String account, Integer amount, Integer perAmount, Integer part, Integer soldPart, Integer founderPart, Integer reservePart,
			Date dealDateTime, Integer multiple, PlanStatus planStatus, WinStatus winStatus, Integer clicks, String content, Integer isUploadContent,
			PlayType playType, String verifyMd5, Integer isAbleTicketing, PlanTicketStatus planTicketStatus,Integer joinCount) {
		this.planNo = planNo;
		this.lotteryType = lotteryType;
		this.term = term;
		this.planType = planType;
		this.selectType = selectType;
		this.memberId = memberId;
		this.account = account;
		this.amount = amount;
		this.perAmount = perAmount;
		this.part = part;
		this.soldPart = soldPart;
		this.founderPart = founderPart;
		this.reservePart = reservePart;
		this.dealDateTime = dealDateTime;
		this.multiple = multiple;
		this.planStatus = planStatus;
		this.winStatus = winStatus;
		this.clicks = clicks;
		this.content = content;
		this.isUploadContent = isUploadContent;
		this.playType = playType;
		this.verifyMd5 = verifyMd5;
		this.isAbleTicketing = isAbleTicketing;
		this.planTicketStatus = planTicketStatus;
		this.joinCount=joinCount;
	}

	/**
	 * @return the planNoCopyDocumentary
	 */
	public Integer getPlanNoCopyDocumentary() {
		return planNoCopyDocumentary;
	}

	/**
	 * @param planNoCopyDocumentary the planNoCopyDocumentary to set
	 */
	public void setPlanNoCopyDocumentary(Integer planNoCopyDocumentary) {
		this.planNoCopyDocumentary = planNoCopyDocumentary;
	}

	/** full constructor */
	public AbstractLotteryPlan(Integer planNo, LotteryType lotteryType, String term, PlanType planType, SelectType selectType, Integer memberId,
			String account, Date createDateTime, Integer amount, Integer perAmount, Integer part, Integer soldPart, Integer founderPart,
			Integer reservePart, Date dealDateTime, Integer multiple, PlanStatus planStatus, Date printTicketDateTime, WinStatus winStatus,
			Double pretaxPrize, Double posttaxPrize, String prizeContent, Integer clicks, String planDesc, String content, Integer isUploadContent,
			Integer experience, Integer isSuperMan, PlayType playType, String addAttribute, Integer isTop, Integer model, String verifyMd5,
			Integer bookCount, GenType genType, Integer isAbleTicketing, PlanTicketStatus planTicketStatus,Integer joinCount,Date returnPrizeTime,Integer openFinish) {
		this.planNo = planNo;
		this.lotteryType = lotteryType;
		this.term = term;
		this.planType = planType;
		this.selectType = selectType;
		this.memberId = memberId;
		this.account = account;
		this.createDateTime = createDateTime;
		this.amount = amount;
		this.perAmount = perAmount;
		this.part = part;
		this.soldPart = soldPart;
		this.founderPart = founderPart;
		this.reservePart = reservePart;
		this.dealDateTime = dealDateTime;
		this.multiple = multiple;
		this.planStatus = planStatus;
		this.printTicketDateTime = printTicketDateTime;
		this.winStatus = winStatus;
		this.pretaxPrize = pretaxPrize;
		this.posttaxPrize = posttaxPrize;
		this.prizeContent = prizeContent;
		this.clicks = clicks;
		this.planDesc = planDesc;
		this.content = content;
		this.isUploadContent = isUploadContent;
		this.experience = experience;
		this.isSuperMan = isSuperMan;
		this.playType = playType;
		this.addAttribute = addAttribute;
		this.isTop = isTop;
		this.model = model;
		this.verifyMd5 = verifyMd5;
		this.bookCount = bookCount;
		this.genType = genType;
		this.isAbleTicketing = isAbleTicketing;
		this.planTicketStatus = planTicketStatus;
		this.joinCount=joinCount;
		this.returnPrizeTime=returnPrizeTime;
		this.openFinish=openFinish;
	}

	// Property accessors

	public Integer getPlanNo() {
		return this.planNo;
	}

	public void setPlanNo(Integer planNo) {
		this.planNo = planNo;
	}

	public LotteryType getLotteryType() {
		return this.lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public PlanType getPlanType() {
		return this.planType;
	}

	public void setPlanType(PlanType planType) {
		this.planType = planType;
	}

	public SelectType getSelectType() {
		return this.selectType;
	}

	public void setSelectType(SelectType selectType) {
		this.selectType = selectType;
	}

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPerAmount() {
		return this.perAmount;
	}

	public void setPerAmount(Integer perAmount) {
		this.perAmount = perAmount;
	}

	public Integer getPart() {
		return this.part;
	}

	public void setPart(Integer part) {
		this.part = part;
	}

	public Integer getSoldPart() {
		return this.soldPart;
	}

	public void setSoldPart(Integer soldPart) {
		this.soldPart = soldPart;
	}

	public Integer getFounderPart() {
		return this.founderPart;
	}

	public void setFounderPart(Integer founderPart) {
		this.founderPart = founderPart;
	}

	public Integer getReservePart() {
		return this.reservePart;
	}

	public void setReservePart(Integer reservePart) {
		this.reservePart = reservePart;
	}

	public Date getDealDateTime() {
		return this.dealDateTime;
	}

	public void setDealDateTime(Date dealDateTime) {
		this.dealDateTime = dealDateTime;
	}

	public Integer getMultiple() {
		return this.multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public PlanStatus getPlanStatus() {
		return this.planStatus;
	}

	public void setPlanStatus(PlanStatus planStatus) {
		this.planStatus = planStatus;
	}

	public Date getPrintTicketDateTime() {
		return this.printTicketDateTime;
	}

	public void setPrintTicketDateTime(Date printTicketDateTime) {
		this.printTicketDateTime = printTicketDateTime;
	}

	public WinStatus getWinStatus() {
		return this.winStatus;
	}

	public void setWinStatus(WinStatus winStatus) {
		this.winStatus = winStatus;
	}

	public Double getPretaxPrize() {
		return this.pretaxPrize;
	}

	public void setPretaxPrize(Double pretaxPrize) {
		this.pretaxPrize = pretaxPrize;
	}

	public Double getPosttaxPrize() {
		return this.posttaxPrize;
	}

	public void setPosttaxPrize(Double posttaxPrize) {
		this.posttaxPrize = posttaxPrize;
	}

	public String getPrizeContent() {
		return this.prizeContent;
	}

	public void setPrizeContent(String prizeContent) {
		this.prizeContent = prizeContent;
	}

	public Integer getClicks() {
		return this.clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public String getPlanDesc() {
		return this.planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsUploadContent() {
		return this.isUploadContent;
	}

	public void setIsUploadContent(Integer isUploadContent) {
		this.isUploadContent = isUploadContent;
	}

	public Integer getExperience() {
		return this.experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getIsSuperMan() {
		return this.isSuperMan;
	}

	public void setIsSuperMan(Integer isSuperMan) {
		this.isSuperMan = isSuperMan;
	}

	public PlayType getPlayType() {
		return this.playType;
	}

	public void setPlayType(PlayType playType) {
		this.playType = playType;
	}

	public String getAddAttribute() {
		return this.addAttribute;
	}

	public void setAddAttribute(String addAttribute) {
		this.addAttribute = addAttribute;
	}

	public Integer getIsTop() {
		return this.isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getModel() {
		return this.model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public String getVerifyMd5() {
		return this.verifyMd5;
	}

	public void setVerifyMd5(String verifyMd5) {
		this.verifyMd5 = verifyMd5;
	}

	public PublicStatus getPublicStatus() {
		return publicStatus;
	}

	public void setPublicStatus(PublicStatus publicStatus) {
		this.publicStatus = publicStatus;
	}

	public int getCommision() {
		return commision;
	}

	public void setCommision(int commision) {
		this.commision = commision;
	}

	public Integer getBookCount() {
		return bookCount;
	}

	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}

	public GenType getGenType() {
		return genType;
	}

	public void setGenType(GenType genType) {
		this.genType = genType;
	}

	public Integer getIsAbleTicketing() {
		return isAbleTicketing;
	}

	public void setIsAbleTicketing(Integer isAbleTicketing) {
		this.isAbleTicketing = isAbleTicketing;
	}

	public PlanTicketStatus getPlanTicketStatus() {
		return planTicketStatus;
	}

	public void setPlanTicketStatus(PlanTicketStatus planTicketStatus) {
		this.planTicketStatus = planTicketStatus;
	}

	public Double getAddPrize() {
		return addPrize;
	}

	public void setAddPrize(Double addPrize) {
		this.addPrize = addPrize;
	}

	public Date getOpenResultTime() {
		return openResultTime;
	}

	public void setOpenResultTime(Date openResultTime) {
		this.openResultTime = openResultTime;
	}

	public String getAutomaticType() {
		return automaticType;
	}

	public void setAutomaticType(String automaticType) {
		this.automaticType = automaticType;
	}

	public Integer getPlanHmOg() {
		return planHmOg;
	}

	public void setPlanHmOg(Integer planHmOg) {
		this.planHmOg = planHmOg;
	}

	public String getOutPlanNo() {
		return outPlanNo;
	}

	public void setOutPlanNo(String outPlanNo) {
		this.outPlanNo = outPlanNo;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Integer getJoinCount() {
		joinCount=joinCount==null?0:joinCount;
		return joinCount;
	}

	public void setJoinCount(Integer joinCount) {
		this.joinCount = joinCount;
	}

	public Date getReturnPrizeTime() {
		return returnPrizeTime;
	}

	public void setReturnPrizeTime(Date returnPrizeTime) {
		this.returnPrizeTime = returnPrizeTime;
	}

	public Integer getOpenFinish() {
		openFinish=openFinish==null?0:openFinish;
		return openFinish;
	}

	public void setOpenFinish(Integer openFinish) {
		this.openFinish = openFinish;
	}

	public Date getPayFinishTime() {
		return payFinishTime;
	}

	public void setPayFinishTime(Date payFinishTime) {
		this.payFinishTime = payFinishTime;
	}

	public Date getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	public Date getRefundStartTime() {
		return refundStartTime;
	}

	public void setRefundStartTime(Date refundStartTime) {
		this.refundStartTime = refundStartTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
	

	public String getAccountDocumentary() {
		return accountDocumentary;
	}

	public void setAccountDocumentary(String accountDocumentary) {
		this.accountDocumentary = accountDocumentary;
	}
	
}