package com.qiyun.service;

import com.qiyun.model.TicketNotify;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface TicketNotifyService {
    int insertSelective(TicketNotify ticketNotify);

    TicketNotify getByOrderId(String orderId);

    /**
     * 插入通知表
     * @param resJo
     */
    void builderNotify(JSONObject resJo);
}
