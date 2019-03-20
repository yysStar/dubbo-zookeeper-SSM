package com.qiyun.service.Impl;

import com.qiyun.mapper2.PlanTicketMappingMapper;
import com.qiyun.model.PlanTicketMapping;
import com.qiyun.service.PlanTicketMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("planTicketMappingService")
public class PlanTicketMappingServiceImpl implements PlanTicketMappingService {
    @Resource
    private PlanTicketMappingMapper planTicketMappingMapper;

    public int insertSelective(PlanTicketMapping mapping) {
        return planTicketMappingMapper.insertSelective(mapping);
    }

    public int updateByPrimaryKeySelective(PlanTicketMapping mapping){
        return planTicketMappingMapper.updateByPrimaryKeySelective(mapping);
    }

    public PlanTicketMapping getByOrderId(String orderId) {
        return planTicketMappingMapper.selectByOrderId(orderId);
    }

    public List<PlanTicketMapping> getByPlanNo(int planNo) {
        return planTicketMappingMapper.selectByPlanNo(planNo);
    }

    public PlanTicketMapping getByTicketId(int ticketId) {
        return planTicketMappingMapper.selectByTicketId(ticketId);
    }

    public void updateForStatusByOrderId(String orderID, int status) {
        planTicketMappingMapper.updateForStatusByOrderId(orderID,status);
    }
}
