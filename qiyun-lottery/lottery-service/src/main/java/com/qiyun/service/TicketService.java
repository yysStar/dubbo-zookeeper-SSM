package com.qiyun.service;

import com.qiyun.dto.Member2DTO;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Ticket2;
import com.qiyun.model2.Ticket2WithBLOBs;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TicketService {
    Map<String,Object> getTicketDetail(Integer planNo, Member2DTO member2DTO);

    List<Ticket2WithBLOBs> getByPlanNo(Integer planNo);

    void updateTicketByPlanBack(Integer planNo);

    void updateStatusByPlanNo(Integer planNo, int i);

    void update(Ticket2WithBLOBs ticket);

    void insert(Ticket2WithBLOBs ticket);

    void updateForSongPiaoSuccess(Integer planNo);

    void updateForSongPiaoFail(Integer planNo);
}
