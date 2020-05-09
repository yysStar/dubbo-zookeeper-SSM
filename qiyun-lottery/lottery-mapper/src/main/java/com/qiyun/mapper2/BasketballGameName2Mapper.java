package com.qiyun.mapper2;

import com.qiyun.model.basketball.BasketBallGame;
import com.qiyun.model2.BasketballGameName2;
import com.qiyun.model2.BasketballGameName2Example;
import java.util.List;

public interface BasketballGameName2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasketballGameName2 record);

    int insertSelective(BasketballGameName2 record);

    List<BasketballGameName2> selectByExampleWithBLOBs(BasketballGameName2Example example);

    List<BasketballGameName2> selectByExample(BasketballGameName2Example example);

    BasketballGameName2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasketballGameName2 record);

    int updateByPrimaryKeyWithBLOBs(BasketballGameName2 record);

    int updateByPrimaryKey(BasketballGameName2 record);

    BasketBallGame selectByStandardName(String matchName);
}