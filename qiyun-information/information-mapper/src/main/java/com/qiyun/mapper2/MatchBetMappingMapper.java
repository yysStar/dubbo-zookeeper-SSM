package com.qiyun.mapper2;

import com.qiyun.model2.MatchBetMapping;
import com.qiyun.model2.MatchBetMappingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatchBetMappingMapper {
    int deleteByPrimaryKey(String id);

    int insert(MatchBetMapping record);

    int insertSelective(MatchBetMapping record);

    List<MatchBetMapping> selectByExample(MatchBetMappingExample example);

    MatchBetMapping selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MatchBetMapping record);

    int updateByPrimaryKey(MatchBetMapping record);

    List<MatchBetMapping> getNowDayMacth(@Param("offset")Integer offset,@Param("pageSize") Integer pageSize,@Param("startDate") String startDate,@Param("endDate") String endDate);

    List<MatchBetMapping> getNowDayMacth1(@Param("offset")Integer offset,@Param("pageSize") Integer pageSize,@Param("startDate") String startDate,@Param("endDate") String endDate);

    List<MatchBetMapping> getNowDayMacth2(@Param("offset")Integer offset,@Param("pageSize") Integer pageSize,@Param("startDate") String startDate,@Param("endDate") String endDate);

    List<MatchBetMapping> getNowDayMacth3(@Param("offset")Integer offset,@Param("pageSize") Integer pageSize,@Param("startDate") String startDate,@Param("endDate") String endDate);

    int getNowDayCount(@Param("startDate") String startDate,@Param("endDate") String endDate);

    String getCcById(Integer id);
}