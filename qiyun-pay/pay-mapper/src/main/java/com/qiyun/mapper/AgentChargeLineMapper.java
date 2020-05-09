package com.qiyun.mapper;

import com.qiyun.model.AgentChargeLine;
import com.qiyun.model.AgentChargeLineQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgentChargeLineMapper {
    int countByExample(AgentChargeLineQuery example);

    int deleteByExample(AgentChargeLineQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(AgentChargeLine record);

    int insertSelective(AgentChargeLine record);

    List<AgentChargeLine> selectByExample(AgentChargeLineQuery example);

    AgentChargeLine selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AgentChargeLine record, @Param("example") AgentChargeLineQuery example);

    int updateByExample(@Param("record") AgentChargeLine record, @Param("example") AgentChargeLineQuery example);

    int updateByPrimaryKeySelective(AgentChargeLine record);

    int updateByPrimaryKey(AgentChargeLine record);
}