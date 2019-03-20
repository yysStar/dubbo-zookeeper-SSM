package com.qiyun.mapper2;

import com.qiyun.model2.TicketUser;
import com.qiyun.model2.TicketUserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TicketUserMapper {
    int countByExample(TicketUserQuery example);

    int deleteByExample(TicketUserQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketUser record);

    int insertSelective(TicketUser record);

    List<TicketUser> selectByExample(TicketUserQuery example);

    TicketUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketUser record, @Param("example") TicketUserQuery example);

    int updateByExample(@Param("record") TicketUser record, @Param("example") TicketUserQuery example);

    int updateByPrimaryKeySelective(TicketUser record);

    int updateByPrimaryKey(TicketUser record);
}