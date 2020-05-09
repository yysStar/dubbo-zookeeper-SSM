package com.qiyun.status;

import com.qiyun.hibernate.IntegerBeanLabelItem;

import java.util.ArrayList;
import java.util.List;

public class PlanTicketStatus extends IntegerBeanLabelItem {
    protected PlanTicketStatus(String name, int value) {
        super(PlanTicketStatus.class.getName(), name, value);
    }

    public static final PlanTicketStatus NO_PROCESS = new PlanTicketStatus("未处理", 1);

    public static final PlanTicketStatus TICKETING = new PlanTicketStatus("出票中", 2);

    public static final PlanTicketStatus TICKET_SOME_FAIL = new PlanTicketStatus("部分出票失败", 3);

    public static final PlanTicketStatus TICKET_FINISH = new PlanTicketStatus("出票成功", 4);

    public static final PlanTicketStatus TICKET_FAIL = new PlanTicketStatus("出票失败", 5);

    public static PlanTicketStatus getItem(int value) {
        return (PlanTicketStatus) PlanTicketStatus.getResult(PlanTicketStatus.class.getName(), value);
    }

    public static List list = new ArrayList();

    static {
        list.add(NO_PROCESS);
        list.add(TICKETING);
        list.add(TICKET_FINISH);
        list.add(TICKET_FAIL);
    }
}
