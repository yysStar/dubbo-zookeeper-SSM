package com.qiyun.mapper2;

import com.qiyun.model.basketball.BasketBallTeam;
import com.qiyun.model2.BasketballTeam2;
import com.qiyun.model2.BasketballTeam2Example;
import java.util.List;

public interface BasketballTeam2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasketballTeam2 record);

    int insertSelective(BasketballTeam2 record);

    List<BasketballTeam2> selectByExample(BasketballTeam2Example example);

    BasketballTeam2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasketballTeam2 record);

    int updateByPrimaryKey(BasketballTeam2 record);

    BasketBallTeam selectByFullName(String name);
}