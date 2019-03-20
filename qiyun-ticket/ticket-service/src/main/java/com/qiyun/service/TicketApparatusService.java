package com.qiyun.service;

import com.qiyun.model2.TicketApparatus;

public interface TicketApparatusService {
    TicketApparatus getById(String apparatusId);

    void updateByPrimaryKeySelective(TicketApparatus ticketApparatus);
}
