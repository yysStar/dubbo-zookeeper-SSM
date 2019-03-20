package com.qiyun.mapper2;

import com.qiyun.DTO.BusinessDTO;
import com.qiyun.model.TicketBusiness;
import com.qiyun.model.TicketBusinessExample;
import java.util.List;

public interface TicketBusinessMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TicketBusiness record);

    int insertSelective(TicketBusiness record);

    List<TicketBusiness> selectByExample(TicketBusinessExample example);

    TicketBusiness selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TicketBusiness record);

    int updateByPrimaryKey(TicketBusiness record);

    List<TicketBusiness> getPreList();

    List<BusinessDTO> selectByLotteryId();
}