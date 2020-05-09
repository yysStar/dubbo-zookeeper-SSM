package com.qiyun.mapper2;

import com.qiyun.model.basketball.BasketballOp;
import com.qiyun.model2.SportteryBasketballOp2;
import com.qiyun.model2.SportteryBasketballOp2Example;
import java.util.List;

public interface SportteryBasketballOp2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketballOp2 record);

    int insertSelective(SportteryBasketballOp2 record);

    List<SportteryBasketballOp2> selectByExample(SportteryBasketballOp2Example example);

    SportteryBasketballOp2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryBasketballOp2 record);

    int updateByPrimaryKey(SportteryBasketballOp2 record);

    List<BasketballOp> selectByIntTimes(List<String> intTimeList, String company);
}