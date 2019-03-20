package com.qiyun.model2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket2WithBLOBs extends Ticket2 {
    private String content;

    private String bingoContent;

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
}