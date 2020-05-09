package com.qiyun.service;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.model.PassMode;
import com.qiyun.model.football.FootBallMatch;
import com.qiyun.model2.Config;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public interface FootBallService {
    List<FootBallMatch> findMatchByStatus(int status);

    <A extends AbstractAward> List<A> getAwardListByIntTimeListAndPlayType(Set<Integer> integers, LotteryType lType);

    <A extends AbstractAward> A saveAward(A award, AwardListEnum playType);

    List<FootBallMatch> getMatchListByIntTime(Set<Integer> intTimeSet);

    <A extends AbstractAward> A attachDirty(A newDbAward, AwardListEnum playType);

    void attachDirty(List<FootBallMatch> jcList);

    void attachDirty(FootBallMatch footBallMatch);

    <A extends AbstractAward> Map<String, List<A>> findAllAward(List<Integer> matchIdList, LotteryType lType,
                                                                PassMode pass);
    Map<Integer,AbstractAward> findMatchAwardMap(List<Integer> matchIds, PassMode pass, LotteryType jcZqSpf);

    List<FootBallMatch> findMatchListBetweenIntTimes(Integer bgintTime, Integer edintTime);

    List<FootBallMatch> findNewlyPrizeMatchList(int i);

    Config getConfigById(int id);
}
