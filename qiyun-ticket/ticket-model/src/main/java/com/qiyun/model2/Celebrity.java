package com.qiyun.model2;

public class Celebrity {
    private Integer id;

    private String celebrityName;

    private String celebrityContent;

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
}