package com.qiyun.commonModel;

import com.qiyun.hibernate.IntegerBeanLabelItem;

public class ChargeUseType extends IntegerBeanLabelItem {
    private static final long serialVersionUID = 1L;

    public static final ChargeUseType ALL = new ChargeUseType("全部", -1);

    public static final ChargeUseType CHARGE = new ChargeUseType("充值", 0);

    public static final ChargeUseType CONSUME = new ChargeUseType("消费", 1);

    protected ChargeUseType(String name, int value) {
        super(ChargeUseType.class.getName(), name, value);
    }

    public static ChargeUseType getItem(int value) {
        return (ChargeUseType)ChargeUseType.getResult(ChargeUseType.class.getName(), value);
    }
}
