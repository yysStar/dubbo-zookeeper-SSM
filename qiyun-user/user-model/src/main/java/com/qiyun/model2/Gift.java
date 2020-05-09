package com.qiyun.model2;

public class Gift {

    private int id;         //奖品Id
    private String name;    //奖品名称
    private double prob;    //获奖概率
    private Integer money;//金额
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
    public double getProb() {
        return prob;
    }
    public void setProb(double prob) {
        this.prob = prob;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Gift(int id, String name, double prob, Integer money) {
        this.id = id;
        this.name = name;
        this.prob = prob;
        this.money = money;
    }

    public Gift() {
    }
}
