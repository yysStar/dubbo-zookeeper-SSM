package com.qiyun.model2;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LotteryPlan2 implements Serializable {
    private Integer planNo;

    /**
     * 褰╃エ绉嶇被
     */
    private Integer lotteryType;

    /**
     * 褰╂湡
     */
    private String term;

    private Integer planType;

    private Integer selectType;

    private Integer memberId;

    /**
     * 鐢ㄦ埛鍚�
     */
    private String account;

    private Date createDateTime;

    /**
     * 鍙戣捣閲戦
     */
    private Integer amount;

    /**
     * 鍗曚环
     */
    private Integer perAmount;

    private Integer part;

    private Integer soldPart;

    private Integer founderPart;

    private Integer reservePart;

    private Date dealDateTime;

    /**
     * 鍊嶆暟
     */
    private Integer multiple;

    /**
     * 鐘舵�侊細1.鏈敮浠橈紱2.鎷涘嫙涓紱3.鍑虹エ涓紱4.宸插嚭绁�
     */
    private Integer planStatus;

    private Date printTicketDateTime;

    private Integer winStatus;

    private Double pretaxPrize;

    private Double posttaxPrize;

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
     * 鍑虹エ鐘舵��:1.鏈鐞�,2.鍑虹エ涓�,4.鍑虹エ鎴愬姛,5.鍑虹エ澶辫触
     */
    private Integer planTicketStatus;

    private Integer isAbleTicketing;

    private Double addPrize;

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
     * 鎬婚噾棰�
     */
    private Integer sumamount;

    /**
     * 璺熷崟鎵�浜や剑閲�
     */
    private Double gold;

    /**
     * 鍙戝崟浜鸿幏寰楁�讳剑閲�
     */
    private Double sumGold;

    /**
     * 璺熷崟浜轰氦缁欑綉绔欎剑閲�
     */
    private Double webSiteGold;

    /**
     * 杩欎竴鍗曚氦缁欑綉绔欐�讳剑閲�
     */
    private Double sumWebSiteGold;

    /**
     * 鏈�澶P
     */
    private Double maxSp;

    /**
     * 浠ｇ悊鐢ㄦ埛鍚�
     */
    private String dlAccount;

    /**
     * 娓犻亾鐢ㄦ埛鍚�
     */
    private String qdAccount;

    /**
     * 鏈�浣庡閲�
     */
    private BigDecimal minBonus;

    /**
     * 鏈�楂樺閲�
     */
    private BigDecimal maxBonus;

    private static final long serialVersionUID = 1L;

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

    public Date getReturnPrizeTime() {
        return returnPrizeTime;
    }

    public void setReturnPrizeTime(Date returnPrizeTime) {
        this.returnPrizeTime = returnPrizeTime;
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

    public Double getWebSiteGold() {
        return webSiteGold;
    }

    public void setWebSiteGold(Double webSiteGold) {
        this.webSiteGold = webSiteGold;
    }

    public Double getSumWebSiteGold() {
        return sumWebSiteGold;
    }

    public void setSumWebSiteGold(Double sumWebSiteGold) {
        this.sumWebSiteGold = sumWebSiteGold;
    }

    public Double getMaxSp() {
        return maxSp;
    }

    public void setMaxSp(Double maxSp) {
        this.maxSp = maxSp;
    }

    public String getDlAccount() {
        return dlAccount;
    }

    public void setDlAccount(String dlAccount) {
        this.dlAccount = dlAccount == null ? null : dlAccount.trim();
    }

    public String getQdAccount() {
        return qdAccount;
    }

    public void setQdAccount(String qdAccount) {
        this.qdAccount = qdAccount == null ? null : qdAccount.trim();
    }

    public BigDecimal getMinBonus() {
        return minBonus;
    }

    public void setMinBonus(BigDecimal minBonus) {
        this.minBonus = minBonus;
    }

    public BigDecimal getMaxBonus() {
        return maxBonus;
    }

    public void setMaxBonus(BigDecimal maxBonus) {
        this.maxBonus = maxBonus;
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
        sb.append(", maxSp=").append(maxSp);
        sb.append(", dlAccount=").append(dlAccount);
        sb.append(", qdAccount=").append(qdAccount);
        sb.append(", minBonus=").append(minBonus);
        sb.append(", maxBonus=").append(maxBonus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}