package com.qiyun.service;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.BasketBallMatch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BasketBetService {
    List<BasketBallMatch> findMatchListByToday(LotteryType lotteryType, Object byLotteryType, PassMode passMode);

    Map<Integer,AbstractAward> findMatchAwardMap(List<Integer> matchIdList, PassMode pass, LotteryType lotteryType);

    List<AbstractAward> findForBbHTAwardByIntTime(List<String> intTimeList, int ordinal);

    List<AbstractAward> findForBbAwardByIntTime(String s, Integer pType, int ordinal);

    List<BasketBallMatch> findMatchListBetweenIntTimes(Integer bgintTime, Integer edintTime);
}
