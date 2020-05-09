package com.qiyun.mapper2;

import com.qiyun.model2.MemberAgentCommision2;
import com.qiyun.model2.MemberAgentCommision2Query;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberAgentCommision2Mapper {
    int countByExample(MemberAgentCommision2Query example);

    int deleteByExample(MemberAgentCommision2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberAgentCommision2 record);

    int insertSelective(MemberAgentCommision2 record);

    List<MemberAgentCommision2> selectByExampleWithBLOBs(MemberAgentCommision2Query example);

    List<MemberAgentCommision2> selectByExample(MemberAgentCommision2Query example);

    MemberAgentCommision2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberAgentCommision2 record, @Param("example") MemberAgentCommision2Query example);

    int updateByExampleWithBLOBs(@Param("record") MemberAgentCommision2 record, @Param("example") MemberAgentCommision2Query example);

    int updateByExample(@Param("record") MemberAgentCommision2 record, @Param("example") MemberAgentCommision2Query example);

    int updateByPrimaryKeySelective(MemberAgentCommision2 record);

    int updateByPrimaryKeyWithBLOBs(MemberAgentCommision2 record);

    int updateByPrimaryKey(MemberAgentCommision2 record);
}