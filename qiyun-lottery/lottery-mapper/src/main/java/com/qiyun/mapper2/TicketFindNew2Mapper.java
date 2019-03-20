package com.qiyun.mapper2;

import com.qiyun.model2.TicketFindNew2;
import com.qiyun.model2.TicketFindNew2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketFindNew2Mapper {
    int countByExample(TicketFindNew2Query example);

    int deleteByExample(TicketFindNew2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketFindNew2 record);

    int insertSelective(TicketFindNew2 record);

    List<TicketFindNew2> selectByExample(TicketFindNew2Query example);

    TicketFindNew2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketFindNew2 record, @Param("example") TicketFindNew2Query example);

    int updateByExample(@Param("record") TicketFindNew2 record, @Param("example") TicketFindNew2Query example);

    int updateByPrimaryKeySelective(TicketFindNew2 record);

    int updateByPrimaryKey(TicketFindNew2 record);

    TicketFindNew2 getByPlanNo(int planNo);
}