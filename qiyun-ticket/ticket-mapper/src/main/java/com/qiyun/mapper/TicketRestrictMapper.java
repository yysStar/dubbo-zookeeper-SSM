package com.qiyun.mapper;

import com.qiyun.model.TicketRestrict;
import com.qiyun.model.TicketRestrictExample;
import java.util.List;

public interface TicketRestrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketRestrict record);

    int insertSelective(TicketRestrict record);

    List<TicketRestrict> selectByExample(TicketRestrictExample example);

    TicketRestrict selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketRestrict record);

    int updateByPrimaryKey(TicketRestrict record);

    /**
     * 查询生效记录
     * @return
     */
    TicketRestrict selectByStatus();
}