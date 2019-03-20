package com.qiyun.mapper2;

import com.qiyun.model2.SportteryBasketballAward;
import com.qiyun.model2.SportteryBasketballAwardExample;
import java.util.List;

public interface SportteryBasketballAwardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketballAward record);

    int insertSelective(SportteryBasketballAward record);

    List<SportteryBasketballAward> selectByExample(SportteryBasketballAwardExample example);

    SportteryBasketballAward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryBasketballAward record);

    int updateByPrimaryKey(SportteryBasketballAward record);
}