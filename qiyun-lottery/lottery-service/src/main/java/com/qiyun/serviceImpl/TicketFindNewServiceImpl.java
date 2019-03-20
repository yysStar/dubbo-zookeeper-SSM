package com.qiyun.serviceImpl;

import com.qiyun.mapper2.TicketFindNew2Mapper;
import com.qiyun.model2.TicketFindNew2;
import com.qiyun.model2.TicketFindNew2Query;
import com.qiyun.service.TicketFindNewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ticketFindNewService")
public class TicketFindNewServiceImpl implements TicketFindNewService {

    @Resource
    private TicketFindNew2Mapper ticketFindNew2Mapper;

    public TicketFindNew2 getByPlanNo(Integer planNo) {
        TicketFindNew2Query ticketFindNew2Query = new TicketFindNew2Query();
        TicketFindNew2Query.Criteria criteria = ticketFindNew2Query.createCriteria();
        criteria.andPlanNoEqualTo(planNo);
        List<TicketFindNew2> ticketFindNew2s = ticketFindNew2Mapper.selectByExample(ticketFindNew2Query);
        if (ticketFindNew2s==null || ticketFindNew2s.size()<=0){
            return null;
        }
        return ticketFindNew2s.get(0);
    }

    public void update(TicketFindNew2 ticketFindNew) {
        ticketFindNew2Mapper.updateByPrimaryKeySelective(ticketFindNew);
    }
}
