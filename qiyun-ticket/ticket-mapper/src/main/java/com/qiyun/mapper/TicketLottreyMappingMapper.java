package com.qiyun.mapper;

import com.qiyun.model.TicketLottreyMapping;
import com.qiyun.model.TicketLottreyMappingExample;
import java.util.List;

public interface TicketLottreyMappingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketLottreyMapping record);

    int insertSelective(TicketLottreyMapping record);

    List<TicketLottreyMapping> selectByExample(TicketLottreyMappingExample example);

    TicketLottreyMapping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketLottreyMapping record);

    int updateByPrimaryKey(TicketLottreyMapping record);
}