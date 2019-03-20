package com.qiyun.service;

import com.qiyun.model.TicketNotifySp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketNotifySpService {
    int insertSelective(TicketNotifySp ticketNotifySp);

    List<TicketNotifySp> getByOrderId(String orderId);
}
