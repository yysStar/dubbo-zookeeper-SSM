package com.qiyun.mapper2;

import com.qiyun.model2.SportteryFootballBqcaward;
import com.qiyun.model2.SportteryFootlballJqsaward;
import com.qiyun.model2.SportteryFootlballJqsawardExample;
import java.util.List;

public interface SportteryFootlballJqsawardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootlballJqsaward record);

    int insertSelective(SportteryFootlballJqsaward record);

    List<SportteryFootlballJqsaward> selectByExample(SportteryFootlballJqsawardExample example);

    SportteryFootlballJqsaward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootlballJqsaward record);

    int updateByPrimaryKey(SportteryFootlballJqsaward record);

    List<SportteryFootlballJqsaward> selectByMatchId(Integer matchId);

    SportteryFootlballJqsaward selectByLastUpdate(Integer matchId);
}