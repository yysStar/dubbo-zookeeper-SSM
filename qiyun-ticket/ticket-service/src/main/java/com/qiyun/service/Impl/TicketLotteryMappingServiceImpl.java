package com.qiyun.service.Impl;

import com.qiyun.mapper2.TicketLottreyMapping2Mapper;
import com.qiyun.model2.TicketLottreyMapping2;
import com.qiyun.model2.TicketLottreyMapping2Example;
import com.qiyun.service.TicketLotteryMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TicketLotteryMappingServiceImpl implements TicketLotteryMappingService {

    @Resource
    private TicketLottreyMapping2Mapper ticketLottreyMapping2Mapper;

    public TicketLottreyMapping2 getByLotteryType(int lotteryType) {
        TicketLottreyMapping2Example ticketLottreyMapping2Example = new TicketLottreyMapping2Example();
        TicketLottreyMapping2Example.Criteria criteria = ticketLottreyMapping2Example.createCriteria();
        criteria.andLotteryTypeIdEqualTo(lotteryType);
        List<TicketLottreyMapping2> ticketLottreyMapping2s = ticketLottreyMapping2Mapper.selectByExample(ticketLottreyMapping2Example);
        if (ticketLottreyMapping2s==null || ticketLottreyMapping2s.size()<=0){
            return null;
        }
        return ticketLottreyMapping2s.get(0);
    }
}
