package com.qiyun.mapper2;

import com.qiyun.model.TicketNotifySp;
import com.qiyun.model.TicketNotifySpExample;
import java.util.List;

public interface TicketNotifySpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketNotifySp record);

    int insertSelective(TicketNotifySp record);

    List<TicketNotifySp> selectByExample(TicketNotifySpExample example);

    TicketNotifySp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketNotifySp record);

    int updateByPrimaryKey(TicketNotifySp record);

    List<TicketNotifySp> selectByOrderId(String orderId);
}