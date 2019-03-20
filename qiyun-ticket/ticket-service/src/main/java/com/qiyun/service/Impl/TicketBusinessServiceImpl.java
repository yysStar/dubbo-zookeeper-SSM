package com.qiyun.service.Impl;

import com.qiyun.mapper2.TicketBusinessMapper;
import com.qiyun.model.TicketBusiness;
import com.qiyun.service.TicketBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ticketbusinessService")
public class TicketBusinessServiceImpl implements TicketBusinessService {
    @Resource
    private TicketBusinessMapper ticketBusinessMapper;

    public List<TicketBusiness> getPreList() {
//        TicketBusinessExample example = new TicketBusinessExample();
//        TicketBusinessExample.Criteria criteria = example.createCriteria();
//        criteria.andPreDepositGreaterThan(new BigDecimal(0));
//        example.setOrderByClause("pre_deposit desc");
        return ticketBusinessMapper.getPreList();
    }

}
