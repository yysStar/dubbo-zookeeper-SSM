package com.qiyun.mapper2;

import com.qiyun.model2.TicketLottreyMapping2;
import com.qiyun.model2.TicketLottreyMapping2Example;
import java.util.List;

public interface TicketLottreyMapping2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketLottreyMapping2 record);

    int insertSelective(TicketLottreyMapping2 record);

    List<TicketLottreyMapping2> selectByExample(TicketLottreyMapping2Example example);

    TicketLottreyMapping2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketLottreyMapping2 record);

    int updateByPrimaryKey(TicketLottreyMapping2 record);
}