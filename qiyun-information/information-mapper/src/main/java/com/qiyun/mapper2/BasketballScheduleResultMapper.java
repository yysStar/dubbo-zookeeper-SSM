package com.qiyun.mapper2;

import com.qiyun.model2.BasketballScheduleResult;
import com.qiyun.model2.BasketballScheduleResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasketballScheduleResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasketballScheduleResult record);

    int insertSelective(BasketballScheduleResult record);

    List<BasketballScheduleResult> selectByExample(BasketballScheduleResultExample example);

    BasketballScheduleResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasketballScheduleResult record);

    int updateByPrimaryKey(BasketballScheduleResult record);

    List<BasketballScheduleResult> getScheduleResultByDate(String date);
}