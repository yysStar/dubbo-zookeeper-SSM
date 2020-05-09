package com.qiyun.service.Impl;

import com.qiyun.mapper2.TicketNotifySpMapper;
import com.qiyun.model.TicketNotifySp;
import com.qiyun.service.TicketNotifySpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ticketNotifySpService")
public class TicketNotifySpServiceImpl implements TicketNotifySpService {
    @Resource
    private TicketNotifySpMapper ticketNotifySpMapper;

    public int insertSelective(TicketNotifySp ticketNotifySp) {
        return ticketNotifySpMapper.insertSelective(ticketNotifySp);
    }

    public List<TicketNotifySp> getByOrderId(String orderId) {
        return ticketNotifySpMapper.selectByOrderId(orderId);
    }
}
