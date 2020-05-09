package com.qiyun.mapper2;

import com.qiyun.model2.BasketballScheduleResult;
import com.qiyun.model2.FootballScheduleResult;
import com.qiyun.model2.FootballScheduleResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FootballScheduleResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FootballScheduleResult record);

    int insertSelective(FootballScheduleResult record);

    List<FootballScheduleResult> selectByExample(FootballScheduleResultExample example);

    FootballScheduleResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FootballScheduleResult record);

    int updateByPrimaryKey(FootballScheduleResult record);

    List<FootballScheduleResult> getScheduleResultByDate(@Param("date")String date);

}