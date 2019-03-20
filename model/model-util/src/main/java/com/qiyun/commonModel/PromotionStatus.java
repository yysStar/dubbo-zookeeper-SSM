package com.qiyun.commonModel;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class PromotionStatus extends IntegerBeanLabelItem {

    protected PromotionStatus(String name, int value) {
        super(PromotionStatus.class.getName(), name, value);
    }

    public static PromotionStatus getItem(int value) {
        return (PromotionStatus) PromotionStatus.getResult(PromotionStatus.class.getName(), value);
    }

    public static final PromotionStatus OFF = new PromotionStatus("不参与活动", 0);
    public static final PromotionStatus NO = new PromotionStatus("待参与活动", 1);
    public static final PromotionStatus SUCCEED = new PromotionStatus("已参与活动", 2);
    public static final PromotionStatus LOSE = new PromotionStatus("参与活动失败", 3);
    public static final List list = new ArrayList();

    static {
        list.add(OFF);
        list.add(NO);
        list.add(SUCCEED);
        list.add(LOSE);
    }
}
