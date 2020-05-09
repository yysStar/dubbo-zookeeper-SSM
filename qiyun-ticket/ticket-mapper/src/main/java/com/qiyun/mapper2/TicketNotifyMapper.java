package com.qiyun.mapper2;

import com.qiyun.model.TicketNotify;
import com.qiyun.model.TicketNotifyExample;
import java.util.List;

public interface TicketNotifyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketNotify record);

    int insertSelective(TicketNotify record);

    List<TicketNotify> selectByExample(TicketNotifyExample example);

    TicketNotify selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketNotify record);

    int updateByPrimaryKey(TicketNotify record);

    TicketNotify selectByOrderId(String orderId);
}