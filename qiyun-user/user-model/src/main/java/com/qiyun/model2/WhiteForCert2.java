package com.qiyun.model2;

import java.io.Serializable;

public class WhiteForCert2 implements Serializable {
    private String certNo;

    /**
     * 鏄惁鏈夋晥 1鏄� 0鍚�
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", certNo=").append(certNo);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}