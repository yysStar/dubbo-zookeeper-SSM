package com.qiyun.mapper2;

import com.qiyun.model2.BasketballLineup;
import com.qiyun.model2.BasketballLineupExample;
import java.util.List;

public interface BasketballLineupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasketballLineup record);

    int insertSelective(BasketballLineup record);

    List<BasketballLineup> selectByExample(BasketballLineupExample example);

    BasketballLineup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasketballLineup record);

    int updateByPrimaryKey(BasketballLineup record);
}