package com.qiyun.service.Impl;

import com.qiyun.mapper2.TicketApparatusMapper;
import com.qiyun.model2.TicketApparatus;
import com.qiyun.service.TicketApparatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketApparatusServiceImpl implements TicketApparatusService {

    @Autowired
    private TicketApparatusMapper ticketApparatusMapper;

    public TicketApparatus getById(String apparatusId) {
        return ticketApparatusMapper.selectByPrimaryKey(apparatusId);
    }

    public void updateByPrimaryKeySelective(TicketApparatus ticketApparatus) {
        ticketApparatusMapper.updateByPrimaryKeySelective(ticketApparatus);
    }
}
