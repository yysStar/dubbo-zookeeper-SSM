package com.qiyun.mapper2;

import com.qiyun.model2.SportteryFootballBqcaward;
import com.qiyun.model2.SportteryFootballBqcawardExample;
import com.qiyun.model2.SportteryFootballRqspfaward;

import java.util.List;

public interface SportteryFootballBqcawardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballBqcaward record);

    int insertSelective(SportteryFootballBqcaward record);

    List<SportteryFootballBqcaward> selectByExample(SportteryFootballBqcawardExample example);

    SportteryFootballBqcaward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballBqcaward record);

    int updateByPrimaryKey(SportteryFootballBqcaward record);

    List<SportteryFootballBqcaward> selectByMatchId(Integer matchId);

    SportteryFootballBqcaward selectByLastUpdate(Integer matchId);
}