package com.qiyun.service2;

import com.qiyun.commonModel.LotteryTerm;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.model2.LotteryPlan;
import com.qiyun.model2.Ticket2;
import com.qiyun.model2.Ticket2WithBLOBs;
import com.qiyun.model2.TicketFindNew2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface Ticket2Service {
    Map<String, Object>searchTicket(Integer type,Integer provider,String term,String startTerm,String endTerm,Integer id,Integer planNo,Integer playType,Integer isBingo,Integer status,String createDateTimeStart,String createDateTimeEnd,String printDateTimeStart,String printDateTimeEnd,String sendTicketDateTimeStart,String sendTicketDateTimeEnd,Integer offset,Integer pageSize);

    int insertSelective(Ticket2WithBLOBs record);

    Ticket2WithBLOBs getById(int ticketId);

    List<Ticket2WithBLOBs> getByPlanNo(Integer planNo);

    int update(Ticket2WithBLOBs ticket2);

    LotteryTerm findPrintingTermByLotteryType(Integer lotType);


    List<Ticket2> findTicketByPlanNo(Integer planNo);

    int countTicketNotSuccess(Integer planNo);

    TicketFindNew2 getByCopyPlanNo(Integer planNo);


    List<Ticket2> findByOutId(String orderId);

    void updateSuccess(Ticket2 ticket2);

    int getFailCount(LotteryPlan lotteryPlan);

    void updateTicketByPlanBack(Integer planNo);


    int getTicketCount(LotteryPlan lotteryPlan);

    void updateForSongPiaoSuccess(Integer planNo);

    void updateForSongPiaoFail(Integer planNo);

    void updateTicketStatusForSongPiao(String ordersID,int status);
}
