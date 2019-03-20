package com.qiyun.mapper2;

import com.qiyun.model.basketball.BasketballDxp;
import com.qiyun.model2.SportteryBasketballDxp2;
import com.qiyun.model2.SportteryBasketballDxp2Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportteryBasketballDxp2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketballDxp2 record);

    int insertSelective(SportteryBasketballDxp2 record);

    List<SportteryBasketballDxp2> selectByExample(SportteryBasketballDxp2Example example);

    SportteryBasketballDxp2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryBasketballDxp2 record);

    int updateByPrimaryKey(SportteryBasketballDxp2 record);

    List<BasketballDxp> selectByIntTimes(@Param("intTimes") List<String> intTimeList);
}