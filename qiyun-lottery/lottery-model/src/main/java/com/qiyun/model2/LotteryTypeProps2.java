package com.qiyun.model2;

public class LotteryTypeProps2 {
    private Integer lotteryType;

    private Integer countInBatch;

    private Integer maxWaitTime;

    private Integer dsAheadTime;

    private Integer fsAheadTime;

    private Long price;

    private Double discount;

    private Long total;

    private String describe;

    private Long isHotSales;

    private String presentation;

    private Long promotion;

    private Long defaultSort;

    private String onImp;

    private String stopImp;

    private String buyLink;

    private String lotteryGuideImg;

    private String stopCause;

    private String cmdLottery;

    private Integer lotMgrIsAble;

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public Integer getCountInBatch() {
        return countInBatch;
    }

    public void setCountInBatch(Integer countInBatch) {
        this.countInBatch = countInBatch;
    }

    public Integer getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(Integer maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }

    public Integer getDsAheadTime() {
        return dsAheadTime;
    }

    public void setDsAheadTime(Integer dsAheadTime) {
        this.dsAheadTime = dsAheadTime;
    }

    public Integer getFsAheadTime() {
        return fsAheadTime;
    }

    public void setFsAheadTime(Integer fsAheadTime) {
        this.fsAheadTime = fsAheadTime;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public Long getIsHotSales() {
        return isHotSales;
    }

    public void setIsHotSales(Long isHotSales) {
        this.isHotSales = isHotSales;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation == null ? null : presentation.trim();
    }

    public Long getPromotion() {
        return promotion;
    }

    public void setPromotion(Long promotion) {
        this.promotion = promotion;
    }

    public Long getDefaultSort() {
        return defaultSort;
    }

    public void setDefaultSort(Long defaultSort) {
        this.defaultSort = defaultSort;
    }

    public String getOnImp() {
        return onImp;
    }

    public void setOnImp(String onImp) {
        this.onImp = onImp == null ? null : onImp.trim();
    }

    public String getStopImp() {
        return stopImp;
    }

    public void setStopImp(String stopImp) {
        this.stopImp = stopImp == null ? null : stopImp.trim();
    }

    public String getBuyLink() {
        return buyLink;
    }

    public void setBuyLink(String buyLink) {
        this.buyLink = buyLink == null ? null : buyLink.trim();
    }

    public String getLotteryGuideImg() {
        return lotteryGuideImg;
    }

    public void setLotteryGuideImg(String lotteryGuideImg) {
        this.lotteryGuideImg = lotteryGuideImg == null ? null : lotteryGuideImg.trim();
    }

    public String getStopCause() {
        return stopCause;
    }

    public void setStopCause(String stopCause) {
        this.stopCause = stopCause == null ? null : stopCause.trim();
    }

    public String getCmdLottery() {
        return cmdLottery;
    }

    public void setCmdLottery(String cmdLottery) {
        this.cmdLottery = cmdLottery == null ? null : cmdLottery.trim();
    }

    public Integer getLotMgrIsAble() {
        return lotMgrIsAble;
    }

    public void setLotMgrIsAble(Integer lotMgrIsAble) {
        this.lotMgrIsAble = lotMgrIsAble;
    }
}