package com.qiyun.model2;

import java.io.Serializable;

public class Celebrity2 implements Serializable {
    private Integer id;

    private String celebrityName;

    private String celebrityContent;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrityName) {
        this.celebrityName = celebrityName == null ? null : celebrityName.trim();
    }

    public String getCelebrityContent() {
        return celebrityContent;
    }

    public void setCelebrityContent(String celebrityContent) {
        this.celebrityContent = celebrityContent == null ? null : celebrityContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", celebrityName=").append(celebrityName);
        sb.append(", celebrityContent=").append(celebrityContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}