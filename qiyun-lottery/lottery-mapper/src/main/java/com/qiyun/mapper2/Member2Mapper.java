package com.qiyun.mapper2;

import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Member2;
import com.qiyun.model2.Member2Query;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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

    List<Member2> selectByAccounts(String account);

    Map selectMaxDate(String account);

    void addSalesCount(Map paramMap);

    void updateSalesCount(Map paramMap);
}