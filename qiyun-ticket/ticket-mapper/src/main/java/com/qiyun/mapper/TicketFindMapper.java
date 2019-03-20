package com.qiyun.mapper;

import com.github.pagehelper.PageInfo;
import com.qiyun.DTO.TicketFindDTO;
import com.qiyun.model.TicketFind;
import com.qiyun.model.TicketFindExample;
import java.util.List;

public interface TicketFindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketFind record);

    int insertSelective(TicketFind record);

    List<TicketFind> selectByExample(TicketFindExample example);

    TicketFind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketFind record);

    int updateByPrimaryKey(TicketFind record);

    TicketFind selectByPlanNo(Integer planNo);

    List<TicketFindDTO> selectAll();
}