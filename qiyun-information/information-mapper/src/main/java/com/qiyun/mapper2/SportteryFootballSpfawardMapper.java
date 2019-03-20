package com.qiyun.mapper2;

import com.qiyun.model2.SportteryFootballBqcaward;
import com.qiyun.model2.SportteryFootballSpfaward;
import com.qiyun.model2.SportteryFootballSpfawardExample;
import java.util.List;

public interface SportteryFootballSpfawardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballSpfaward record);

    int insertSelective(SportteryFootballSpfaward record);

    List<SportteryFootballSpfaward> selectByExample(SportteryFootballSpfawardExample example);

    SportteryFootballSpfaward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballSpfaward record);

    int updateByPrimaryKey(SportteryFootballSpfaward record);

    List<SportteryFootballSpfaward> selectByMatchId(Integer matchId);

    SportteryFootballSpfaward selectByLastUpdate(Integer matchId);
}