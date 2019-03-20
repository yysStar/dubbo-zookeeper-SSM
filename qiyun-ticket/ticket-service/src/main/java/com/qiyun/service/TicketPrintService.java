package com.qiyun.service;

import com.qiyun.DTO.TicketPrintSearch;
import com.qiyun.model2.TicketPrint;

import java.util.List;
import java.util.Map;

public interface TicketPrintService {
    TicketPrint orderReceiving();

    void updateByPrimaryKeySelective(TicketPrint ticket);

    TicketPrint getById(Integer ticketId);

    void insert(TicketPrint newTicket);

    List<TicketPrint> ticketPrintSearch(TicketPrintSearch ticketPrintSearch);

    int countTicketPrintSearch(TicketPrintSearch ticketPrintSearch);

    List<TicketPrint> getByPlanNo(Integer planNo);

    List<TicketPrint> getByPrintAccount(String account, int page, int pageSize);

    Integer countByPrintAccount(String account);

    List<Map> getTotalCountGroupByDealTime();

    List<Map> getCountByStatusGroupByDealTime(int i);
}
