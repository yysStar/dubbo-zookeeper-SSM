package com.qiyun.service;

import com.qiyun.model.TicketRestrict;
import org.springframework.stereotype.Service;

@Service
public interface TicketRestrictService {
    TicketRestrict getByEffective();

    TicketRestrict getById(int id);

    int updateByPrimaryKeySelective(TicketRestrict ticketRestrict);

    int insertSelective(TicketRestrict restrict);
}
