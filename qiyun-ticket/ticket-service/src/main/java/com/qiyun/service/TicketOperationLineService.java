package com.qiyun.service;

import com.qiyun.DTO.TicketOperationLineSearch;
import com.qiyun.model2.TicketOperationLine;
import com.qiyun.type.TicketUserTransType;
import java.util.List;
import java.util.Map;

import java.math.BigDecimal;

public interface TicketOperationLineService {
    void add(String account, TicketUserTransType transType, BigDecimal amount, int ticketId, String ticketApparatusId, BigDecimal ticketApparatusAbleBalance,String remark,int ticketCount);

    List<Map> getSumTicketCountByTypeAndDateGroupByDate(String startTimeStr, String endTimeStr,  int value);

    List<Map> getSumAmountByTypeAndDateGroupByDate(String startTimeStr, String endTimeStr, int value);

    List<Map> getSumAmountByTypeAndDateAndAccountGroupByDate(String startTimeStr, String endTimeStr, String account, int value);

    List<Map> getSumTicketCountByTypeAndDateAndAccountGroupByDate(String startTimeStr, String endTimeStr, String account, int value);

    BigDecimal getSumAmountByTypeAndDate(String startTimeStr, String endTimeStr, int value,String account);

    Integer getSumTicketCountByTypeAndDate(String startTimeStr, String endTimeStr, int value,String account);

    List<TicketOperationLine> ticketOperationLineSearch(TicketOperationLineSearch ticketOperationLineSearch);

    Integer ticketOperationLineSearchCount(TicketOperationLineSearch ticketOperationLineSearch);
}
