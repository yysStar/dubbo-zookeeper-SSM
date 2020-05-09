package com.qiyun.service.Impl;

import com.qiyun.mapper2.TicketRestrictConfig2Mapper;
import com.qiyun.model2.TicketRestrictConfig2;
import com.qiyun.model2.TicketRestrictConfig2Query;
import com.qiyun.service.TicketRestrictConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TicketRestrictConfigServiceImpl implements TicketRestrictConfigService {

    @Resource
    private TicketRestrictConfig2Mapper ticketRestrictConfig2Mapper;



    public void update(TicketRestrictConfig2 ticketRestrictConfig) {
        ticketRestrictConfig2Mapper.updateByPrimaryKey(ticketRestrictConfig);
    }

    public TicketRestrictConfig2 getByIsSuper(int isSuper) {
        TicketRestrictConfig2Query ticketRestrictConfig2Query = new TicketRestrictConfig2Query();
        TicketRestrictConfig2Query.Criteria criteria = ticketRestrictConfig2Query.createCriteria();
        criteria.andIsSuperEqualTo(isSuper);
        List<TicketRestrictConfig2> ticketRestrictConfig2s = ticketRestrictConfig2Mapper.selectByExample(ticketRestrictConfig2Query);
        return ticketRestrictConfig2s.get(0);
    }


}
