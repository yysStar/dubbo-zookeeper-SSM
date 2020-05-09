package com.qiyun.vo;

import static com.qiyun.commonModel.LotteryType.LOTTERY_PATH;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.commonModel.PlayType;
import com.qiyun.lottery.MedalLevelUtil;
import com.qiyun.lottery.RecordLevel;
import com.qiyun.model.*;
import com.qiyun.tools.BallCodeConverter;
import com.qiyun.type.SelectType;

import java.util.Date;

public class HmNewListBean {

	// Fields
	// 方案编号
	private Integer planNo;
	// 彩种
	private LotteryType lotteryType;
	// 彩期
	private String term;
	// 方案类型
	private String planType;
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
	private String winStatus;
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
	// 参加人数
	private int joinCount;
	// 税前奖金INT
	private int pretaxPrizeInt;

	private int levenIndex;

	private String isNewLogo;
	
	private int goldBrick;
	private int goldDiamond;
	private int goldCrown;
	private int crown;

	private double protect;

	// 总中奖次数
	private int countSum;

	// 发单成功率
	private double succeedSum;

	// 合买发单次数
	private int already;

	// 流单中奖次数
	private int loseCountSum;

	// 流单发单成功率
	private double loseSucceedSum;

	// 流单发单次数
	private int loseAlready;

	// 流单种奖奖金
	private int losePretaxPrizeInt;

	// 方案状态
	private String planStatusString;

	// 注册时间
	private Date registerDateTime;

	// 用户角色
	private String status;

	private String picture;

	private String card;

	private String role;

	private Date lastLoginDateTime;

	private String id;

	private Integer planHmOg;

	public double getSucceedSum() {
		return succeedSum;
	}

	public void setSucceedSum(double succeedSum) {
		this.succeedSum = succeedSum;
	}

	public int getCountSum() {
		return countSum;
	}

	public void setCountSum(int countSum) {
		this.countSum = countSum;
	}

	public double getProtect() {
		return protect;
	}

	public void setProtect(double protect) {
		this.protect = protect;
	}

	public int getJoinCount() {
		return joinCount;
	}

	public void setJoinCount(int joinCount) {
		this.joinCount = joinCount;
	}

	public Integer getPlanNo() {
		return planNo;
	}

	public void setPlanNo(Integer planNo) {
		this.planNo = planNo;
	}

	public LotteryType getLotteryType() {
		return lotteryType;
	}

	public void setLotteryType(LotteryType lotteryType) {
		this.lotteryType = lotteryType;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public SelectType getSelectType() {
		return selectType;
	}

	public void setSelectType(SelectType selectType) {
		this.selectType = selectType;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPerAmount() {
		return perAmount;
	}

	public void setPerAmount(Integer perAmount) {
		this.perAmount = perAmount;
	}

	public Integer getPart() {
		return part;
	}

	public void setPart(Integer part) {
		this.part = part;
	}

	public Integer getSoldPart() {
		return soldPart;
	}

	public void setSoldPart(Integer soldPart) {
		this.soldPart = soldPart;
	}

	public Integer getFounderPart() {
		return founderPart;
	}

	public void setFounderPart(Integer founderPart) {
		this.founderPart = founderPart;
	}

	public Integer getReservePart() {
		return reservePart;
	}

	public void setReservePart(Integer reservePart) {
		this.reservePart = reservePart;
	}

	public Date getDealDateTime() {
		return dealDateTime;
	}

	public void setDealDateTime(Date teTimedealDateTime) {
		this.dealDateTime = teTimedealDateTime;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public PlanStatus getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(PlanStatus planStatus) {
		this.planStatus = planStatus;
	}

	public Date getPrintTicketDateTime() {
		return printTicketDateTime;
	}

	public void setPrintTicketDateTime(Date printTicketDateTime) {
		this.printTicketDateTime = printTicketDateTime;
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

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsUploadContent() {
		return isUploadContent;
	}

	public void setIsUploadContent(Integer isUploadContent) {
		this.isUploadContent = isUploadContent;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getIsSuperMan() {
		return isSuperMan;
	}

	public void setIsSuperMan(Integer isSuperMan) {
		this.isSuperMan = isSuperMan;
	}

	public PlayType getPlayType() {
		return playType;
	}

	public void setPlayType(PlayType playType) {
		this.playType = playType;
	}

	public String getAddAttribute() {
		return addAttribute;
	}

	public void setAddAttribute(String addAttribute) {
		this.addAttribute = addAttribute;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getModel() {
		return model;
	}

	public void setModel(Integer model) {
		this.model = model;
	}

	public String getVerifyMd5() {
		return verifyMd5;
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


	public String toString() {
		//return String.valueOf(cup * 1000 + seat * 100 + brand * 10);
		return "测试";
	}

	public static void setLevel(HmNewListBean bean,MedalLevelBean mb){
		bean.setGoldBrick(mb.getGoldBrick());
		bean.setGoldDiamond(mb.getGoldDiamond());
		bean.setGoldCrown(mb.getGoldCrown());
		bean.setCrown(mb.getCrown());
	}
	
	public String getWinStatus() {
		return winStatus;
	}

	public void setWinStatus(String winStatus) {
		this.winStatus = winStatus;
	}

	public int getPretaxPrizeInt() {
		return pretaxPrizeInt;
	}

	public void setPretaxPrizeInt(int pretaxPrizeInt) {
		this.pretaxPrizeInt = pretaxPrizeInt;
	}

	public int getLevenIndex() {
		return levenIndex;
	}

	public void setLevenIndex(int levenIndex) {
		this.levenIndex = levenIndex;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getIsNewLogo() {
		return isNewLogo;
	}

	public void setIsNewLogo(String isNewLogo) {
		this.isNewLogo = isNewLogo;
	}

	public String getPlanStatusString() {
		return planStatusString;
	}

	public void setPlanStatusString(String planStatusString) {
		this.planStatusString = planStatusString;
	}

	public int getLoseCountSum() {
		return loseCountSum;
	}

	public void setLoseCountSum(int loseCountSum) {
		this.loseCountSum = loseCountSum;
	}

	public double getLoseSucceedSum() {
		return loseSucceedSum;
	}

	public void setLoseSucceedSum(double loseSucceedSum) {
		this.loseSucceedSum = loseSucceedSum;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(Date registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public int getLosePretaxPrizeInt() {
		return losePretaxPrizeInt;
	}

	public void setLosePretaxPrizeInt(int losePretaxPrizeInt) {
		this.losePretaxPrizeInt = losePretaxPrizeInt;
	}

	public int getAlready() {
		return already;
	}

	public void setAlready(int already) {
		this.already = already;
	}

	public int getLoseAlready() {
		return loseAlready;
	}

	public void setLoseAlready(int loseAlready) {
		this.loseAlready = loseAlready;
	}

	public Integer getPlanHmOg() {
		return planHmOg;
	}

	public void setPlanHmOg(Integer planHmOg) {
		this.planHmOg = planHmOg;
	}

	public String getContextShow() {
		StringBuffer sb = new StringBuffer();
		if (getSelectType() != null) {
			if (!this.getSelectType().equals(SelectType.UPLOAD)) {

				String[] lines = this.getContent().split("\\%")[0].split("\\~");
				for (int i = 0; i < lines.length; i++) {
					String[] peace = lines[i].split("\\:");
					if (i == 0 || i % 4 == 0) {
						// sb.append("<tr>");
					}
					sb.append("").append(PlayType.getItem(Integer.valueOf(peace[0])).getName()).append("：");
					sb.append(BallCodeConverter.convert(this.getLotteryType().getValue(), Integer.valueOf(peace[0]), peace[1])).append("");
					if (i % 4 == 3 || i == lines.length - 1) {
						// sb.append("</tr>");
					}

				}
			}
		}
		return sb.toString();
	}

	/**
	 * <p>
	 * 获取购彩页面链接
	 * </p>
	 * 
	 * @return String
	 */
	public String getLotteryHref() {
		return "/lottery/" + LOTTERY_PATH.get(lotteryType);
	}

	public int getGoldBrick() {
		return goldBrick;
	}

	public void setGoldBrick(int goldBrick) {
		this.goldBrick = goldBrick;
	}

	public int getGoldDiamond() {
		return goldDiamond;
	}

	public void setGoldDiamond(int goldDiamond) {
		this.goldDiamond = goldDiamond;
	}

	public int getGoldCrown() {
		return goldCrown;
	}

	public void setGoldCrown(int goldCrown) {
		this.goldCrown = goldCrown;
	}

	public int getCrown() {
		return crown;
	}

	public void setCrown(int crown) {
		this.crown = crown;
	}

	/**
	 * 重算战绩跟据中奖金额
	 */
	public void rebulidLevel() {
		this.crown = 0;
		this.goldCrown = 0;
		this.goldDiamond = 0;
		this.goldBrick = 0;
		if(this.posttaxPrize == null){
			this.posttaxPrize = 0.0;
		}
		int val = this.posttaxPrize.intValue() - this.amount;
		RecordLevel level = MedalLevelUtil.getOutLevel(val);
		if(level == RecordLevel.CROWN){
			this.crown = 1;
		}else if(level == RecordLevel.GOLD_CROWN){
			this.goldCrown = 1;
		}else if(level == RecordLevel.GOLD_DIAMOND){
			this.goldDiamond = 1;
		}else if(level == RecordLevel.GOLD_BRICK){
			this.goldBrick = 1;
		}
	}
}
