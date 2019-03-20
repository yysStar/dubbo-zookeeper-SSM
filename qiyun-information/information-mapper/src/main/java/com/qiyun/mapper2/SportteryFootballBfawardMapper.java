package com.qiyun.mapper2;

import com.qiyun.model2.SportteryFootballBfaward;
import com.qiyun.model2.SportteryFootballBfawardExample;
import java.util.List;

public interface SportteryFootballBfawardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballBfaward record);

    int insertSelective(SportteryFootballBfaward record);

    List<SportteryFootballBfaward> selectByExample(SportteryFootballBfawardExample example);

    SportteryFootballBfaward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballBfaward record);

    int updateByPrimaryKey(SportteryFootballBfaward record);

    List<SportteryFootballBfaward> selectByMatchId(Integer matchId);

    SportteryFootballBfaward selectByLastUpdate(Integer matchId);
}