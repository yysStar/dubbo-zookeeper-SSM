package com.qiyun.serviceImpl;

import com.qiyun.mapper2.TicketPrintMapper;
import com.qiyun.model2.TicketPrint;
import com.qiyun.service.TicketPrintService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TicketPrintServiceImpl implements TicketPrintService {

    @Resource
    private TicketPrintMapper ticketPrintMapper;

    @Override
    public void insert(TicketPrint ticketPrint) {
        ticketPrintMapper.insertSelective(ticketPrint);
    }
}
