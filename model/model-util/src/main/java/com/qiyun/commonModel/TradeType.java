package com.qiyun.commonModel;


import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class TradeType extends IntegerBeanLabelItem {

    private static final long serialVersionUID = 1L;

    public static final TradeType ALL = new TradeType("全部", -1);

    public static final TradeType TRADE_BALANCE = new TradeType("余额购买", 0);

    public static final TradeType FREE_SAVE = new TradeType("免费保存", 1);

    public static final TradeType SCORE_BET = new TradeType("积分投注", 2);

    public static List<TradeType> list = new ArrayList<TradeType>();

    protected TradeType(String name, int value) {
        super(TradeType.class.getName(), name, value);
    }

    public static TradeType getItem(int value) {
        return (TradeType) TradeType.getResult(TradeType.class.getName(), value);
    }

    static {
        list.add(ALL);
        list.add(TRADE_BALANCE);
        list.add(FREE_SAVE);
        list.add(SCORE_BET);
    }
    //投注金额 全局性
    public static int getTradeAmount(TradeType tradeType) {
        int number = 2;//2元
        if (tradeType == SCORE_BET) {
            number = 400;//400积分
        }
        return number;
    }

    public static boolean isBalanceTrade(TradeType tradeType) {
        return tradeType == TRADE_BALANCE;
    }

    public static boolean isScroeTrade(TradeType tradeType) {
        return tradeType == SCORE_BET;
    }
}

