package com.qiyun.mapper2;

import com.qiyun.model2.MemberAgent2;
import com.qiyun.model2.MemberAgent2Query;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MemberAgent2Mapper {
    int countByExample(MemberAgent2Query example);

    int deleteByExample(MemberAgent2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberAgent2 record);

    int insertSelective(MemberAgent2 record);

    List<MemberAgent2> selectByExampleWithBLOBs(MemberAgent2Query example);

    List<MemberAgent2> selectByExample(MemberAgent2Query example);

    MemberAgent2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberAgent2 record, @Param("example") MemberAgent2Query example);

    int updateByExampleWithBLOBs(@Param("record") MemberAgent2 record, @Param("example") MemberAgent2Query example);

    int updateByExample(@Param("record") MemberAgent2 record, @Param("example") MemberAgent2Query example);

    int updateByPrimaryKeySelective(MemberAgent2 record);

    int updateByPrimaryKeyWithBLOBs(MemberAgent2 record);

    int updateByPrimaryKey(MemberAgent2 record);

    List<Map> getAgentList();
}