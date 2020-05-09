package com.qiyun.service;

import com.qiyun.model2.TicketRestrictConfig2;

public interface TicketRestrictConfigService {

    void update(TicketRestrictConfig2 ticketRestrictConfig);

    TicketRestrictConfig2 getByIsSuper(int isSuper);
}
