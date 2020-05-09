package com.qiyun.mapper2;

import com.qiyun.model2.TicketApparatus;
import com.qiyun.model2.TicketApparatusQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketApparatusMapper {
    int countByExample(TicketApparatusQuery example);

    int deleteByExample(TicketApparatusQuery example);

    int deleteByPrimaryKey(String id);

    int insert(TicketApparatus record);

    int insertSelective(TicketApparatus record);

    List<TicketApparatus> selectByExample(TicketApparatusQuery example);

    TicketApparatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TicketApparatus record, @Param("example") TicketApparatusQuery example);

    int updateByExample(@Param("record") TicketApparatus record, @Param("example") TicketApparatusQuery example);

    int updateByPrimaryKeySelective(TicketApparatus record);

    int updateByPrimaryKey(TicketApparatus record);
}