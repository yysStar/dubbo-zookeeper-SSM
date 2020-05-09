package com.qiyun.mapper;

import com.qiyun.model.MemberAgent;
import com.qiyun.model.MemberAgentQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberAgentMapper {
    int countByExample(MemberAgentQuery example);

    int deleteByExample(MemberAgentQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberAgent record);

    int insertSelective(MemberAgent record);

    List<MemberAgent> selectByExampleWithBLOBs(MemberAgentQuery example);

    List<MemberAgent> selectByExample(MemberAgentQuery example);

    MemberAgent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberAgent record, @Param("example") MemberAgentQuery example);

    int updateByExampleWithBLOBs(@Param("record") MemberAgent record, @Param("example") MemberAgentQuery example);

    int updateByExample(@Param("record") MemberAgent record, @Param("example") MemberAgentQuery example);

    int updateByPrimaryKeySelective(MemberAgent record);

    int updateByPrimaryKeyWithBLOBs(MemberAgent record);

    int updateByPrimaryKey(MemberAgent record);
}