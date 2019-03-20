package com.qiyun.mapper2;

import com.qiyun.model2.SportteryFootballMatch2;
import com.qiyun.model2.SportteryFootballMatch2Query;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SportteryFootballMatch2Mapper {
    int countByExample(SportteryFootballMatch2Query example);

    int deleteByExample(SportteryFootballMatch2Query example);

    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballMatch2 record);

    int insertSelective(SportteryFootballMatch2 record);

    List<SportteryFootballMatch2> selectByExample(SportteryFootballMatch2Query example);

    SportteryFootballMatch2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SportteryFootballMatch2 record, @Param("example") SportteryFootballMatch2Query example);

    int updateByExample(@Param("record") SportteryFootballMatch2 record, @Param("example") SportteryFootballMatch2Query example);

    int updateByPrimaryKeySelective(SportteryFootballMatch2 record);

    int updateByPrimaryKey(SportteryFootballMatch2 record);

    String getContent(int planNo);

//    Object getSporttery(Map<String,Object> map);

    int  getSporttery(Integer lineId,Integer intTime);
}