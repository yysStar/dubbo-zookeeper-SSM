package com.qiyun.model2;

import java.io.Serializable;

public class Ticket2WithBLOBs extends Ticket2 implements Serializable,Cloneable  {
    private String content;

    private String bingoContent;

    private static final long serialVersionUID = 1L;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBingoContent() {
        return bingoContent;
    }

    public void setBingoContent(String bingoContent) {
        this.bingoContent = bingoContent == null ? null : bingoContent.trim();
    }

    public Ticket2WithBLOBs clone() throws CloneNotSupportedException {
        return (Ticket2WithBLOBs) super.clone();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", content=").append(content);
        sb.append(", bingoContent=").append(bingoContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}