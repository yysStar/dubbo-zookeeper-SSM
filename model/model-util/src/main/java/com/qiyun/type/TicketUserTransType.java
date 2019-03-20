package com.qiyun.type;

import com.qiyun.hibernate.IntegerBeanLabelItem;

public class TicketUserTransType extends IntegerBeanLabelItem {
    private String name;
    private int value;

    protected TicketUserTransType(String name, int value) {
        super(TicketUserTransType.class.getName(), name, value);
    }

    public static TicketUserTransType getItem(int value) {
        return (TicketUserTransType) TicketUserTransType.getResult(TicketUserTransType.class.getName(), value);
    }

    public static final TicketUserTransType ALL = new TicketUserTransType("全部", -1);
    public static final TicketUserTransType ONOFF = new TicketUserTransType("上下线休息", 1);
    public static final TicketUserTransType RECEIVE_ORDER = new TicketUserTransType("接收票", 2);
    public static final TicketUserTransType FINISH_ORDER = new TicketUserTransType("完成打票", 3);
    public static final TicketUserTransType REVOCATION_ORDER = new TicketUserTransType("撤销票", 4);
    public static final TicketUserTransType CHARGE = new TicketUserTransType("加款", 5);
    public static final TicketUserTransType CHARGE_BONUS = new TicketUserTransType("加奖金", 6);
}
