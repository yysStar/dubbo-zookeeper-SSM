package com.qiyun.service;

import com.github.pagehelper.PageInfo;
import com.qiyun.commonModel.LotteryType;
import com.qiyun.model.football.MatchAwardOfHT;
import com.qiyun.model.PassMode;
import com.qiyun.model2.SportteryFootballMatch2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SportteryFootballMatchService {
    SportteryFootballMatch2 getByIntTimeAndLineId(Integer intTime, Integer lineId);

    List<Map<String,Object>> findFootballMixureInfo(int isFocus);

    Map<String, Object> findFootballMixureMoreInfo(String matchId);

    Map<String,MatchAwardOfHT> getAwardMapByIntTimeListAndPlayTypePassMode(Set<Integer> intTimeSet, LotteryType jcZqHt, PassMode pass);

    List<Map> getSpfAward(Integer intTime, Integer lineId);

    List<Map> getRqspfAward(Integer intTime, Integer lineId);

    List<Map> getBqcAward(Integer intTime, Integer lineId);

    List<Map> getBfAward(Integer intTime, Integer lineId);

    List<Map> getJqsAward(Integer intTime, Integer lineId);

    List<SportteryFootballMatch2> getWorldCupByIntTime(int i);

    List<SportteryFootballMatch2> getMatchListByIntTime(Set<Integer> intTimeSet);
	
    List<SportteryFootballMatch2> getByIntTime(Integer intTime);

    void update(SportteryFootballMatch2 footballMatch2);

    SportteryFootballMatch2 getById(Integer id);
}
