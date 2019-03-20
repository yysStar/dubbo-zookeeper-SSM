package com.qiyun.api;

import com.qiyun.DTO.TicketOperationLineSearch;
import com.qiyun.DTO.TicketPrintSearch;

import java.util.List;
import java.util.Map;

public interface TicketSystemApi {
    Map<String,Object> addTicketUser(String account);

    Map<String,Object> updateUserType(String account, int status,double amount,double bonus,String apparatusId);

    Map<String,Object> receivingOrder(String account);

    Map<String,Object> finishOrder(String account,int residueCount);

    Map<String,Object> revocationOrder(String account, int residueCount);

    Map<String,Object> getNowOrder(String account);

    Map<String,Object> getTicketDetail(int id);

    Map<String,Object> addMoney(String account, double money, double bonus);

    Map<String,Object> getNowUserInfos(String account);

    Map<String,Object> getUserCountStatistics(String account, String startTimeStr, String endTimeStr);

    Map<String,Object> getUserAmountStatistics(String account, String startTimeStr, String endTimeStr);

    Map<String,Object> runDateForTime(String startTimeStr, String endTimeStr);

    Map<String,Object> runDateForAccount(String startTimeStr, String endTimeStr);

    Map<String,Object> ticketPrintSearch(TicketPrintSearch ticketPrintSearch);

    Map<String,Object> firstPush(String[] ids);

    Map<String,Object> updateTicketStatus(int id, int status);

    Map<String,Object> ticketPrintDetail(int id);

    Map<String,Object> ticketOperationLineSearch(TicketOperationLineSearch ticketOperationLineSearch);

    Map<String,Object> ticketUserLine(String account, int page, int pageSize);

    Map<String,Object> getUserStatus(int page, int pageSize);

    Map<String,Object> ticketManagerByDealTime();

    Map<String,Object> getChaiPiaoCount();

    Map<String,Object> updateChaiPiaoCount(int count);
}
