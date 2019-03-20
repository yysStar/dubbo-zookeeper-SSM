package com.qiyun.mapper2;

import com.qiyun.model2.SportteryBasketMatch2;
import com.qiyun.model2.SportteryBasketMatch2Query;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SportteryBasketMatch2Mapper {
    int countByExample(SportteryBasketMatch2Query example);

    int deleteByExample(SportteryBasketMatch2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(SportteryBasketMatch2 record);

    int insertSelective(SportteryBasketMatch2 record);

    List<Object> selectByExample(SportteryBasketMatch2Query example);

    SportteryBasketMatch2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SportteryBasketMatch2 record, @Param("example") SportteryBasketMatch2Query example);

    int updateByExample(@Param("record") SportteryBasketMatch2 record, @Param("example") SportteryBasketMatch2Query example);

    int updateByPrimaryKeySelective(SportteryBasketMatch2 record);

    int updateByPrimaryKey(SportteryBasketMatch2 record);

//    Object getSporttery(Map<String,Object> map);

    int getSporttery(int lineId,int intTime);
}