package com.qiyun.commonModel;

import com.qiyun.hibernate.IntegerBeanLabelItem;

/**
 * 充值促销活动
 */



public class ChargePromotionType extends IntegerBeanLabelItem {


    protected ChargePromotionType(String name, int value) {
        super(ChargePromotionType.class.getName(), name, value);
    }

    public static ChargePromotionType getItem(int value) {
        return (ChargePromotionType) ChargePromotionType.getResult(ChargePromotionType.class.getName(), value);
    }

    public static final ChargePromotionType CHARGE_RETURN_MONEY = new ChargePromotionType("充值送彩金",1);

    public static final ChargePromotionType CHARGE_SCORE_EXCHANGE_MONEY = new ChargePromotionType("充值积分兑彩金",2);

    public static final ChargePromotionType CHARGE_BY_ABC_PRESENT_SSQ = new ChargePromotionType("农行赠送双色球",3);

    public static final ChargePromotionType CHARGE_AMOUNT_EXCHANGE_SCROE = new ChargePromotionType("充值彩金兑积分",4);

    public static final ChargePromotionType CHARGE_AMOUNT_GIFT_SCROE = new ChargePromotionType("充值彩金送积分",5);

}
