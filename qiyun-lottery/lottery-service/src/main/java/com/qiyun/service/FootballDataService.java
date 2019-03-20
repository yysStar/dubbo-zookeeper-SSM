package com.qiyun.service;

import com.qiyun.model.FootballGame;
import com.qiyun.model.FootballMatch;
import com.qiyun.model.FootballTeam;
import com.qiyun.model.football.SportteryFootBallBetInfo;
import com.qiyun.model2.FootballMatch2;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface FootballDataService {
    FootballGame findGameByStandardName(String matchName);

    FootballTeam findByStandardName(String name);

    void attachDirty(FootballGame game);

    void attachDirty(FootballTeam instance);

    void attachDirty(SportteryFootBallBetInfo betInfo);

    void attachDirty(Collection<FootballMatch> match);

    FootballMatch storeMatchByOddsId(FootballMatch fm);

    List<SportteryFootBallBetInfo> findTzbByMatchId(Integer id);

    Map<Integer,SportteryFootBallBetInfo> findFootballBetInfoByMatchIds(List<Integer> matchIds);

    Map<Integer,FootballMatch> findFootballMatchIdByIntTimes(Set<Integer> intTimeSet);
}
