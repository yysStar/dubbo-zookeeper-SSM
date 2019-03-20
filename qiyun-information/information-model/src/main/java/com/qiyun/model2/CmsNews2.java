package com.qiyun.model2;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CmsNews2 implements Serializable {
    private Integer id;

    //类别(传)
    private Integer typeId;

    //标题(传)
    private String title;

    //热点标题
    private String shortTitle;

    //页面描述(传)
    private String htmlDescription;

    //点击数
    private Integer click;

    //关键词
    private String keyword;

    //
    private String editor;

    private Integer isHead;

    private Date createDateTime;

    private Integer contentType;

    private String link;

    private Integer province;

    private Integer lotteryType;

    private Integer status;

    private Integer playType;

    private String account;

    private String color;

    private String tag;

    private String htmlKeyword;

    private Integer digs;

    private Integer undigs;

    private String newsSource;

    private Integer ifRemark;

    private Integer expertId;

    private String commendTitle;

    private String videoName;

    private String videoPath;

    private Integer isLotteryType;

    private Integer isFirstHead;

    private Integer isPriority;

    private Date showDateTime;

    private Integer ifDynamic;

    private String hotspotTitle;

    private Integer isShow;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle == null ? null : shortTitle.trim();
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription == null ? null : htmlDescription.trim();
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public Integer getIsHead() {
        return isHead;
    }

    public void setIsHead(Integer isHead) {
        this.isHead = isHead;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(Integer lotteryType) {
        this.lotteryType = lotteryType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    public String getHtmlKeyword() {
        return htmlKeyword;
    }

    public void setHtmlKeyword(String htmlKeyword) {
        this.htmlKeyword = htmlKeyword == null ? null : htmlKeyword.trim();
    }

    public Integer getDigs() {
        return digs;
    }

    public void setDigs(Integer digs) {
        this.digs = digs;
    }

    public Integer getUndigs() {
        return undigs;
    }

    public void setUndigs(Integer undigs) {
        this.undigs = undigs;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource == null ? null : newsSource.trim();
    }

    public Integer getIfRemark() {
        return ifRemark;
    }

    public void setIfRemark(Integer ifRemark) {
        this.ifRemark = ifRemark;
    }

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public String getCommendTitle() {
        return commendTitle;
    }

    public void setCommendTitle(String commendTitle) {
        this.commendTitle = commendTitle == null ? null : commendTitle.trim();
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath == null ? null : videoPath.trim();
    }

    public Integer getIsLotteryType() {
        return isLotteryType;
    }

    public void setIsLotteryType(Integer isLotteryType) {
        this.isLotteryType = isLotteryType;
    }

    public Integer getIsFirstHead() {
        return isFirstHead;
    }

    public void setIsFirstHead(Integer isFirstHead) {
        this.isFirstHead = isFirstHead;
    }

    public Integer getIsPriority() {
        return isPriority;
    }

    public void setIsPriority(Integer isPriority) {
        this.isPriority = isPriority;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getShowDateTime() {
        return showDateTime;
    }

    public void setShowDateTime(Date showDateTime) {
        this.showDateTime = showDateTime;
    }

    public Integer getIfDynamic() {
        return ifDynamic;
    }

    public void setIfDynamic(Integer ifDynamic) {
        this.ifDynamic = ifDynamic;
    }

    public String getHotspotTitle() {
        return hotspotTitle;
    }

    public void setHotspotTitle(String hotspotTitle) {
        this.hotspotTitle = hotspotTitle == null ? null : hotspotTitle.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typeId=").append(typeId);
        sb.append(", title=").append(title);
        sb.append(", shortTitle=").append(shortTitle);
        sb.append(", htmlDescription=").append(htmlDescription);
        sb.append(", click=").append(click);
        sb.append(", keyword=").append(keyword);
        sb.append(", editor=").append(editor);
        sb.append(", isHead=").append(isHead);
        sb.append(", createDateTime=").append(createDateTime);
        sb.append(", contentType=").append(contentType);
        sb.append(", link=").append(link);
        sb.append(", province=").append(province);
        sb.append(", lotteryType=").append(lotteryType);
        sb.append(", status=").append(status);
        sb.append(", playType=").append(playType);
        sb.append(", account=").append(account);
        sb.append(", color=").append(color);
        sb.append(", tag=").append(tag);
        sb.append(", htmlKeyword=").append(htmlKeyword);
        sb.append(", digs=").append(digs);
        sb.append(", undigs=").append(undigs);
        sb.append(", newsSource=").append(newsSource);
        sb.append(", ifRemark=").append(ifRemark);
        sb.append(", expertId=").append(expertId);
        sb.append(", commendTitle=").append(commendTitle);
        sb.append(", videoName=").append(videoName);
        sb.append(", videoPath=").append(videoPath);
        sb.append(", isLotteryType=").append(isLotteryType);
        sb.append(", isFirstHead=").append(isFirstHead);
        sb.append(", isPriority=").append(isPriority);
        sb.append(", showDateTime=").append(showDateTime);
        sb.append(", ifDynamic=").append(ifDynamic);
        sb.append(", hotspotTitle=").append(hotspotTitle);
        sb.append(", isShow=").append(isShow);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}