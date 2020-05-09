package com.qiyun.mapper2;

import com.qiyun.model2.ScoreliveFootballNowday;
import com.qiyun.model2.ScoreliveFootballNowdayExample;
import java.util.List;

public interface ScoreliveFootballNowdayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScoreliveFootballNowday record);

    int insertSelective(ScoreliveFootballNowday record);

    List<ScoreliveFootballNowday> selectByExample(ScoreliveFootballNowdayExample example);

    ScoreliveFootballNowday selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ScoreliveFootballNowday record);

    int updateByPrimaryKey(ScoreliveFootballNowday record);
}