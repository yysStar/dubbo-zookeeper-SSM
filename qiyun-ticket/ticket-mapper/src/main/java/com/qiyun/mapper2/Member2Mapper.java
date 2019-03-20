package com.qiyun.mapper2;

import com.qiyun.model.MemberAgentCommision;
import com.qiyun.model2.Member2;
import com.qiyun.model2.Member2Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Member2Mapper {
    int countByExample(Member2Query example);

    int deleteByExample(Member2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(Member2 record);

    int insertSelective(Member2 record);

    List<Member2> selectByExample(Member2Query example);

    Member2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Member2 record, @Param("example") Member2Query example);

    int updateByExample(@Param("record") Member2 record, @Param("example") Member2Query example);

    int updateByPrimaryKeySelective(Member2 record);

    int updateByPrimaryKey(Member2 record);

    Member2 selectByAccount(String account);

    Member2 selectByMobileOrAccount(String account);

    void insertMemberAgentCommision(MemberAgentCommision memberAgentCommision);
}