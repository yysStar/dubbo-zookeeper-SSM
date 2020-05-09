package com.qiyun.DTO;

import java.io.Serializable;

public class BusinessDTO implements Serializable {
    /**
     * 出票商id
     */
    private int id;
    /**
     * 出票商名称
     */
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
