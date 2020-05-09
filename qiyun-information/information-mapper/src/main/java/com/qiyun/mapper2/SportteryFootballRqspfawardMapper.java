package com.qiyun.mapper2;

import com.qiyun.model2.SportteryFootballBfaward;
import com.qiyun.model2.SportteryFootballRqspfaward;
import com.qiyun.model2.SportteryFootballRqspfawardExample;
import java.util.List;

public interface SportteryFootballRqspfawardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportteryFootballRqspfaward record);

    int insertSelective(SportteryFootballRqspfaward record);

    List<SportteryFootballRqspfaward> selectByExample(SportteryFootballRqspfawardExample example);

    SportteryFootballRqspfaward selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportteryFootballRqspfaward record);

    int updateByPrimaryKey(SportteryFootballRqspfaward record);

    List<SportteryFootballRqspfaward> selectByMatchId(Integer matchId);

    SportteryFootballRqspfaward selectByLastUpdate(Integer matchId);

}