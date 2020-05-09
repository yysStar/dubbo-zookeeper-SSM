package com.qiyun.service;

import com.qiyun.model.TicketBusiness;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketBusinessService {
    /**
     * 获取预存款大于0的出票商列表
     * @return
     */
    public List<TicketBusiness> getPreList();

}
