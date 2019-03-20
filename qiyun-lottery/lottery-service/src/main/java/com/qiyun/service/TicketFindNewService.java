package com.qiyun.service;

import com.qiyun.model2.TicketFindNew2;
import org.springframework.stereotype.Service;

@Service
public interface TicketFindNewService {
    TicketFindNew2 getByPlanNo(Integer planNo);

    void update(TicketFindNew2 ticketFindNew);
}
