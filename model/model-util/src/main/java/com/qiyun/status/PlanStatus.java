package com.qiyun.status;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class PlanStatus extends IntegerBeanLabelItem {
    protected PlanStatus(String name, int value) {
        super(PlanStatus.class.getName(), name, value);
    }

    public static final PlanStatus ALL = new PlanStatus("全部状态", -1);

    public static final PlanStatus NOT_PAY = new PlanStatus("未支付", 1);

    public static final PlanStatus RECRUITING = new PlanStatus("招募中", 2);

    public static final PlanStatus PAY_FINISH = new PlanStatus("出票中", 3);

    public static final PlanStatus TICKET_OUT = new PlanStatus("已出票", 4);

    public static final PlanStatus CANCEL = new PlanStatus("已撤单", 5);

    public static final PlanStatus ABORT = new PlanStatus("已流单", 6);

    public static final PlanStatus TICKETING = new PlanStatus("受理中", 7);

    public static final PlanStatus TICKET_PARTOUT = new PlanStatus("部份出票", 8);

    public static final PlanStatus TICKET_GQ = new PlanStatus("未出票作废", 9);

    public static final PlanStatus PAST_DUE = new PlanStatus("已过期", 10);

    public static PlanStatus getItem(int value) {
        return (PlanStatus) PlanStatus.getResult(PlanStatus.class.getName(), value);
    }

    public static List list = new ArrayList();

    static {
        list.add(ALL);
        list.add(NOT_PAY);
        list.add(RECRUITING);
        list.add(PAY_FINISH);
        list.add(TICKET_OUT);
        list.add(CANCEL);
        list.add(ABORT);
        list.add(TICKETING);
        list.add(TICKET_PARTOUT);
        list.add(TICKET_GQ);
        list.add(PAST_DUE);
    }

}
