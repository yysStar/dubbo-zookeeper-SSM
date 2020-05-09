package com.qiyun.service;

import com.github.pagehelper.PageInfo;
import com.qiyun.DTO.TicketFindDTO;
import com.qiyun.model.TicketFind;
import com.qiyun.model2.TicketFindNew2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TicketFindService {
    int insertSelective(TicketFind ticketFind);

    TicketFind getByPlanNo(int planNo);

    PageInfo<TicketFindDTO> getAll(int offset, int pageSize);

    int update(TicketFind ticket);

    TicketFindNew2 getByPlanNoNew(int planNo);

    void insertSelectiveNew(TicketFindNew2 ticketFindNew2);

    Map<String,Object> findTicketList2(int type, String account, int planNo, int page, int pageSize);

    TicketFindNew2 getByCopyPlanNo(int planNo);

    void updateTicketStatus(TicketFindNew2 findNew);

    TicketFindNew2 getTicketFindNewByPlanNo(Integer planNo);

    void updateTicketFindNew(TicketFindNew2 ticketFindNew);
}
