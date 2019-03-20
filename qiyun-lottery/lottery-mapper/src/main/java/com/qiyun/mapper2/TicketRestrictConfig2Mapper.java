package com.qiyun.mapper2;

import com.qiyun.model2.TicketRestrictConfig2;
import com.qiyun.model2.TicketRestrictConfig2Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TicketRestrictConfig2Mapper {
    int countByExample(TicketRestrictConfig2Query example);

    int deleteByExample(TicketRestrictConfig2Query example);

    int deleteByPrimaryKey(Integer isSuper);

    int insert(TicketRestrictConfig2 record);

    int insertSelective(TicketRestrictConfig2 record);

    List<TicketRestrictConfig2> selectByExample(TicketRestrictConfig2Query example);

    TicketRestrictConfig2 selectByPrimaryKey(Integer isSuper);

    int updateByExampleSelective(@Param("record") TicketRestrictConfig2 record, @Param("example") TicketRestrictConfig2Query example);

    int updateByExample(@Param("record") TicketRestrictConfig2 record, @Param("example") TicketRestrictConfig2Query example);

    int updateByPrimaryKeySelective(TicketRestrictConfig2 record);

    int updateByPrimaryKey(TicketRestrictConfig2 record);
}