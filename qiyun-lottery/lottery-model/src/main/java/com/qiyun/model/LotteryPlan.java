package com.qiyun.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LotteryPlan implements Serializable {
    private Integer planNo;

    /**
     * 彩票种类
     */
    private Integer lotteryType;

    /**
     * 彩期
     */
    private String term;

    private Integer planType;

    private Integer selectType;

    private Integer memberId;

    /**
     * 用户名
     */
    private String account;

    private Date createDateTime;

    /**
     * 发起金额
     */
    private Integer amount;

    /**
     * 单价
     */
    private Integer perAmount;

    private Integer part;

    private Integer soldPart;

    private Integer founderPart;

    private Integer reservePart;

    private Date dealDateTime;

    /**
     * 倍数
     */
    private Integer multiple;

    /**
     * 状态：1.未支付；2.招募中；3.出票中；4.已出票
     */
    private Integer planStatus;

    private Date printTicketDateTime;

    private Integer winStatus;

    private BigDecimal pretaxPrize;

    private BigDecimal posttaxPrize;

    private Integer clicks;

    private String planDesc;

    private Integer isUploadContent;

    private Integer experience;

    private Integer isSuperMan;

    private Integer playType;

    private String addAttribute;

    private Integer isTop;

    private Integer model;

    private String verifyMd5;

    private Integer publicStatus;

    private Integer commision;

    private Integer genType;

    private Integer bookCount;

    /**
     * 出票状态:1.未处理,2.出票中,4.出票成功,5.出票失败
     */
    private Integer planTicketStatus;

    private Integer isAbleTicketing;

    private BigDecimal addPrize;

    private Date openResultTime;

    private Integer planHmOg;

    private Integer openFinish;

    private String automaticType;

    private String outPlanNo;

    private Integer platform;

    private Integer joinCount;

    private Date returnPrizeTime;

    private Date payFinishTime;

    private Date acceptTime;

    private Date refundStartTime;

    private Date arrivalTime;

    private Integer tradeType;

    private String accountDocumentary;

    private Integer plannoCopydocumentary;

    private Integer haploidAmount;

    /**
     * 总金额
     */
    private Integer sumamount;

    /**
     * 跟单所交佣金
     */
    private BigDecimal gold;

    /**
     * 发单人获得总佣金
     */
    private BigDecimal sumGold;

    /**
     * 跟单人交给网站佣金
     */
    private BigDecimal webSiteGold;

    /**
     * 这一单交给网站总佣金
     */
    private BigDecimal sumWebSiteGold;

    private double maxSp;

    private static final long serialVersionUID = 1L;

    public double getMaxSp() {
        return maxSp;
    }

    public void setMaxSp(double maxSp) {
        this.maxSp = maxSp;
    }

    public Integer getPlanNo() {
        return planNo;
    }

    public void setPlanNo(Integer planNo) {
        this.planNo = planNo;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public Integer getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
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
        this.account = account == null ? null : account.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    public Date getDealDateTime() {
        return dealDateTime;
    }

    public void setDealDateTime(Date dealDateTime) {
        this.dealDateTime = dealDateTime;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getPrintTicketDateTime() {
        return printTicketDateTime;
    }

    public void setPrintTicketDateTime(Date printTicketDateTime) {
        this.printTicketDateTime = printTicketDateTime;
    }

    public Integer getWinStatus() {
        return winStatus;
    }

    public void setWinStatus(Integer winStatus) {
        this.winStatus = winStatus;
    }

    public BigDecimal getPretaxPrize() {
        return pretaxPrize;
    }

    public void setPretaxPrize(BigDecimal pretaxPrize) {
        this.pretaxPrize = pretaxPrize;
    }

    public BigDecimal getPosttaxPrize() {
        return posttaxPrize;
    }

    public void setPosttaxPrize(BigDecimal posttaxPrize) {
        this.posttaxPrize = posttaxPrize;
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
        this.planDesc = planDesc == null ? null : planDesc.trim();
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

    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    public String getAddAttribute() {
        return addAttribute;
    }

    public void setAddAttribute(String addAttribute) {
        this.addAttribute = addAttribute == null ? null : addAttribute.trim();
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
        this.verifyMd5 = verifyMd5 == null ? null : verifyMd5.trim();
    }

    public Integer getPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(Integer publicStatus) {
        this.publicStatus = publicStatus;
    }

    public Integer getCommision() {
        return commision;
    }

    public void setCommision(Integer commision) {
        this.commision = commision;
    }

    public Integer getGenType() {
        return genType;
    }

    public void setGenType(Integer genType) {
        this.genType = genType;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

    public Integer getPlanTicketStatus() {
        return planTicketStatus;
    }

    public void setPlanTicketStatus(Integer planTicketStatus) {
        this.planTicketStatus = planTicketStatus;
    }

    public Integer getIsAbleTicketing() {
        return isAbleTicketing;
    }

    public void setIsAbleTicketing(Integer isAbleTicketing) {
        this.isAbleTicketing = isAbleTicketing;
    }

    public BigDecimal getAddPrize() {
        return addPrize;
    }

    public void setAddPrize(BigDecimal addPrize) {
        this.addPrize = addPrize;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getOpenResultTime() {
        return openResultTime;
    }

    public void setOpenResultTime(Date openResultTime) {
        this.openResultTime = openResultTime;
    }

    public Integer getPlanHmOg() {
        return planHmOg;
    }

    public void setPlanHmOg(Integer planHmOg) {
        this.planHmOg = planHmOg;
    }

    public Integer getOpenFinish() {
        return openFinish;
    }

    public void setOpenFinish(Integer openFinish) {
        this.openFinish = openFinish;
    }

    public String getAutomaticType() {
        return automaticType;
    }

    public void setAutomaticType(String automaticType) {
        this.automaticType = automaticType == null ? null : automaticType.trim();
    }

    public String getOutPlanNo() {
        return outPlanNo;
    }

    public void setOutPlanNo(String outPlanNo) {
        this.outPlanNo = outPlanNo == null ? null : outPlanNo.trim();
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public Integer getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Integer joinCount) {
        this.joinCount = joinCount;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getReturnPrizeTime() {
        return returnPrizeTime;
    }

    public void setReturnPrizeTime(Date returnPrizeTime) {
        this.returnPrizeTime = returnPrizeTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getRefundStartTime() {
        return refundStartTime;
    }

    public void setRefundStartTime(Date refundStartTime) {
        this.refundStartTime = refundStartTime;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public String getAccountDocumentary() {
        return accountDocumentary;
    }

    public void setAccountDocumentary(String accountDocumentary) {
        this.accountDocumentary = accountDocumentary == null ? null : accountDocumentary.trim();
    }

    public Integer getPlannoCopydocumentary() {
        return plannoCopydocumentary;
    }

    public void setPlannoCopydocumentary(Integer plannoCopydocumentary) {
        this.plannoCopydocumentary = plannoCopydocumentary;
    }

    public Integer getHaploidAmount() {
        return haploidAmount;
    }

    public void setHaploidAmount(Integer haploidAmount) {
        this.haploidAmount = haploidAmount;
    }

    public Integer getSumamount() {
        return sumamount;
    }

    public void setSumamount(Integer sumamount) {
        this.sumamount = sumamount;
    }

    public BigDecimal getGold() {
        return gold;
    }

    public void setGold(BigDecimal gold) {
        this.gold = gold;
    }

    public BigDecimal getSumGold() {
        return sumGold;
    }

    public void setSumGold(BigDecimal sumGold) {
        this.sumGold = sumGold;
    }

    public BigDecimal getWebSiteGold() {
        return webSiteGold;
    }

    public void setWebSiteGold(BigDecimal webSiteGold) {
        this.webSiteGold = webSiteGold;
    }

    public BigDecimal getSumWebSiteGold() {
        return sumWebSiteGold;
    }

    public void setSumWebSiteGold(BigDecimal sumWebSiteGold) {
        this.sumWebSiteGold = sumWebSiteGold;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", planNo=").append(planNo);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", term=").append(term);
        sb.append(", planType=").append(planType);
        sb.append(", selectType=").append(selectType);
        sb.append(", memberId=").append(memberId);
        sb.append(", account=").append(account);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", amount=").append(amount);
        sb.append(", perAmount=").append(perAmount);
        sb.append(", part=").append(part);
        sb.append(", soldPart=").append(soldPart);
        sb.append(", founderPart=").append(founderPart);
        sb.append(", reservePart=").append(reservePart);
        sb.append(", dealDateTime=").append(dealDateTime);
        sb.append(", multiple=").append(multiple);
        sb.append(", planStatus=").append(planStatus);
        sb.append(", printTicketDateTime=").append(printTicketDateTime);
        sb.append(", winStatus=").append(winStatus);
        sb.append(", pretaxPrize=").append(pretaxPrize);
        sb.append(", posttaxPrize=").append(posttaxPrize);
        sb.append(", clicks=").append(clicks);
        sb.append(", planDesc=").append(planDesc);
        sb.append(", isUploadContent=").append(isUploadContent);
        sb.append(", experience=").append(experience);
        sb.append(", isSuperMan=").append(isSuperMan);
        sb.append(", playType=").append(playType);
        sb.append(", addAttribute=").append(addAttribute);
        sb.append(", isTop=").append(isTop);
        sb.append(", model=").append(model);
        sb.append(", verifyMd5=").append(verifyMd5);
        sb.append(", publicStatus=").append(publicStatus);
        sb.append(", commision=").append(commision);
        sb.append(", genType=").append(genType);
        sb.append(", bookCount=").append(bookCount);
        sb.append(", planTicketStatus=").append(planTicketStatus);
        sb.append(", isAbleTicketing=").append(isAbleTicketing);
        sb.append(", addPrize=").append(addPrize);
        sb.append(", openResultTime=").append(openResultTime);
        sb.append(", planHmOg=").append(planHmOg);
        sb.append(", openFinish=").append(openFinish);
        sb.append(", automaticType=").append(automaticType);
        sb.append(", outPlanNo=").append(outPlanNo);
        sb.append(", platform=").append(platform);
        sb.append(", joinCount=").append(joinCount);
        sb.append(", returnPrizeTime=").append(returnPrizeTime);
        sb.append(", payFinishTime=").append(payFinishTime);
        sb.append(", acceptTime=").append(acceptTime);
        sb.append(", refundStartTime=").append(refundStartTime);
        sb.append(", arrivalTime=").append(arrivalTime);
        sb.append(", tradeType=").append(tradeType);
        sb.append(", accountDocumentary=").append(accountDocumentary);
        sb.append(", plannoCopydocumentary=").append(plannoCopydocumentary);
        sb.append(", haploidAmount=").append(haploidAmount);
        sb.append(", sumamount=").append(sumamount);
        sb.append(", gold=").append(gold);
        sb.append(", sumGold=").append(sumGold);
        sb.append(", webSiteGold=").append(webSiteGold);
        sb.append(", sumWebSiteGold=").append(sumWebSiteGold);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}