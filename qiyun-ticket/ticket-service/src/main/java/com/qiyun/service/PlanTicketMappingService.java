package com.qiyun.service;

import com.qiyun.model.PlanTicketMapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanTicketMappingService {
    int insertSelective(PlanTicketMapping mapping);

    PlanTicketMapping getByOrderId(String orderId);

    int updateByPrimaryKeySelective(PlanTicketMapping mapping);

    List<PlanTicketMapping> getByPlanNo(int planNo);

    PlanTicketMapping getByTicketId(int ticketId);

    void updateForStatusByOrderId(String orderID, int i);
}
