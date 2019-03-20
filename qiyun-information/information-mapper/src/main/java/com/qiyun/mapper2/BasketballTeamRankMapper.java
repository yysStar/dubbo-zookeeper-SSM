package com.qiyun.mapper2;

import com.qiyun.model2.BasketballTeamRank;
import com.qiyun.model2.BasketballTeamRankExample;
import java.util.List;

public interface BasketballTeamRankMapper {
    int deleteByPrimaryKey(String teamId);

    int insert(BasketballTeamRank record);

    int insertSelective(BasketballTeamRank record);

    List<BasketballTeamRank> selectByExample(BasketballTeamRankExample example);

    BasketballTeamRank selectByPrimaryKey(String teamId);

    int updateByPrimaryKeySelective(BasketballTeamRank record);

    int updateByPrimaryKey(BasketballTeamRank record);
}