package com.qiyun.model2;

import java.io.Serializable;

public class MemberNote2 implements Serializable {
    private Integer id;

    /**
     * 瀹㈡埛id
     */
    private String memberId;

    /**
     * 鏀粯瀹濆娉�
     */
    private String memeberTel;

    private String memberZxb;

    /**
     * 寰俊澶囨敞
     */
    private String memberWx;

    /**
     * 澶囨敞
     */
    private String note;

    /**
     * 鏄惁涓洪噸鐐瑰鎴�  1鏄�  0鍚�
     */
    private Integer isKey;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getMemeberTel() {
        return memeberTel;
    }

    public void setMemeberTel(String memeberTel) {
        this.memeberTel = memeberTel == null ? null : memeberTel.trim();
    }

    public String getMemberZxb() {
        return memberZxb;
    }

    public void setMemberZxb(String memberZxb) {
        this.memberZxb = memberZxb == null ? null : memberZxb.trim();
    }

    public String getMemberWx() {
        return memberWx;
    }

    public void setMemberWx(String memberWx) {
        this.memberWx = memberWx == null ? null : memberWx.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getIsKey() {
        return isKey;
    }

    public void setIsKey(Integer isKey) {
        this.isKey = isKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", memeberTel=").append(memeberTel);
        sb.append(", memberZxb=").append(memberZxb);
        sb.append(", memberWx=").append(memberWx);
        sb.append(", note=").append(note);
        sb.append(", isKey=").append(isKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}