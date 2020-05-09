package com.qiyun.service;

import com.qiyun.model2.TicketPrint;
import com.qiyun.model2.TicketUser;

import java.util.List;

public interface TicketUserService {
    TicketUser getByAccount(String account);

    void add(TicketUser user);

    void updateByPrimaryKeySelective(TicketUser ticketUser);

    List<TicketUser> getByStatus(int i);

    List<TicketUser> getByStatusAndPage(int i, int page, int pageSize);

    Integer getCountByStatus(int i);
}
