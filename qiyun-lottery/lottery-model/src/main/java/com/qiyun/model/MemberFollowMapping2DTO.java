package com.qiyun.model;

import java.io.Serializable;
import java.util.Date;

public class MemberFollowMapping2DTO implements Serializable {
    /**
     * 关注关系id
     */
    private Integer id;

    /**
     * 大神账户名
     */
    private String account;

    /**
     * 关注者账号
     */
    private String fansAccount;

    /**
     * 是否取消,1为取消
     */
    private Boolean isCancel;

    /**
     * 关注时间
     */
    private Date createDatetime;

    /**
     * 修改时间
     */
    private Date updateDatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getFansAccount() {
        return fansAccount;
    }

    public void setFansAccount(String fansAccount) {
        this.fansAccount = fansAccount == null ? null : fansAccount.trim();
    }

    public Boolean getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Boolean isCancel) {
        this.isCancel = isCancel;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", fansAccount=").append(fansAccount);
        sb.append(", isCancel=").append(isCancel);
        sb.append(", createDatetime=").append(createDatetime);
        sb.append(", updateDatetime=").append(updateDatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
