package com.qiyun.model2;

import java.io.Serializable;

public class MemberGrade2 implements Serializable {
    private Integer id;

    private Integer memberId;

    private String memberAccount;

    private Integer isReturnPoint;

    private Integer isVip;

    /**
     * 鏄惁鐩存帴绁ㄥ姟鍟嗗嚭绁�  1鏄� 0鍚�
     */
    private Integer isProviderTicket;

    private static final long serialVersionUID = 1L;

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

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount == null ? null : memberAccount.trim();
    }

    public Integer getIsReturnPoint() {
        return isReturnPoint;
    }

    public void setIsReturnPoint(Integer isReturnPoint) {
        this.isReturnPoint = isReturnPoint;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getIsProviderTicket() {
        return isProviderTicket;
    }

    public void setIsProviderTicket(Integer isProviderTicket) {
        this.isProviderTicket = isProviderTicket;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", memberAccount=").append(memberAccount);
        sb.append(", isReturnPoint=").append(isReturnPoint);
        sb.append(", isVip=").append(isVip);
        sb.append(", isProviderTicket=").append(isProviderTicket);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}