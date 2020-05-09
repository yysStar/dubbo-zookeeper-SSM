package com.qiyun.dto;

import java.io.Serializable;

public class CmsNews2WithBLOBsDTO extends CmsNews2DTO implements Serializable {
    private String content;

    private String commendContent;

    private static final long serialVersionUID = 1L;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCommendContent() {
        return commendContent;
    }

    public void setCommendContent(String commendContent) {
        this.commendContent = commendContent == null ? null : commendContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", content=").append(content);
        sb.append(", commendContent=").append(commendContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
