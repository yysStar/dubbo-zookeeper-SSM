package com.qiyun.mapper2;

import com.qiyun.model2.BasketballLeague;
import com.qiyun.model2.BasketballLeagueExample;
import java.util.List;

public interface BasketballLeagueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasketballLeague record);

    int insertSelective(BasketballLeague record);

    List<BasketballLeague> selectByExample(BasketballLeagueExample example);

    BasketballLeague selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasketballLeague record);

    int updateByPrimaryKey(BasketballLeague record);

    List<Integer>getNowDayLeague(int date);
}