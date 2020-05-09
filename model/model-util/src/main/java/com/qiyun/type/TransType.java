package com.qiyun.type;

import java.util.ArrayList;
import java.util.List;

/**
 * 云朵流水种类
 */
public class TransType {
    //购买推荐
    public static final Integer BUY = 401;
    //不中退款
    public static final Integer REFUND = 402;
    //被购加款
    public static final Integer ADD = 403;
    //提现
    public static final Integer WITHDRAW_CASH = 404;
    //充值
//    public static final Integer ALIPAY = 2070;
//    public static final Integer WECHAT = 2071;
//    public static final Integer QUICK = 2067;
    public static final List<Integer> pays = new ArrayList<Integer>(){{
        add(0);add(1000);add(1017);add(2058);add(2062);add(2063);add(2064);add(2065);
        add(2066);add(2067);add(2068);add(2069);add(2070);add(2071);add(2072);
        add(2073);add(2074);add(2075);
    }};
    //打赏
    public static final Integer REWARD = 51;
    //被打赏
    public static final Integer BEREWARD = 52;
    //快速审核扣款
    public static final Integer QUICKREVIW = 61;

    //云朵提现转换率
    public static final Integer SCALE = 2;
}
