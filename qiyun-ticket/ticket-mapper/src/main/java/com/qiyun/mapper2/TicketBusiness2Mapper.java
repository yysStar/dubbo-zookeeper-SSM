package com.qiyun.mapper2;

import com.qiyun.model2.TicketBusiness2;
import com.qiyun.model2.TicketBusiness2Example;
import java.util.List;

public interface TicketBusiness2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketBusiness2 record);

    int insertSelective(TicketBusiness2 record);

    List<TicketBusiness2> selectByExample(TicketBusiness2Example example);

    TicketBusiness2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketBusiness2 record);

    int updateByPrimaryKey(TicketBusiness2 record);
}