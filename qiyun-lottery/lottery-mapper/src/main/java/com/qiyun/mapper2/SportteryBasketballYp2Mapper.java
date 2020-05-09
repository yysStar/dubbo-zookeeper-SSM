package com.qiyun.mapper2;

import com.qiyun.model.basketball.BasketballYp;
import com.qiyun.model2.SportteryBasketballYp2;
import com.qiyun.model2.SportteryBasketballYp2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportteryBasketballYp2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketballYp2 record);

    int insertSelective(SportteryBasketballYp2 record);

    List<SportteryBasketballYp2> selectByExample(SportteryBasketballYp2Example example);

    SportteryBasketballYp2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryBasketballYp2 record);

    int updateByPrimaryKey(SportteryBasketballYp2 record);

    List<BasketballYp> selectByIntTimes(@Param("intTimes") List<String> intTimes);
}