package com.qiyun.service;

import com.qiyun.commonModel.LotteryType;
import com.qiyun.grabber.model.AbstractAward;
import com.qiyun.grabber.model.AwardListEnum;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.BasketBallMatch;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface BasketBallService {
    List<BasketBallMatch> findMatchByStatus(int ordinal);

    <A extends AbstractAward> List<A> getAwardListByIntTimeListAndPlayType(Set<Integer> integers, LotteryType lType);

    /** *保存修改奖金* */
    <A extends AbstractAward> A saveAward(A award, AwardListEnum playType);

    <A extends AbstractAward> A attachDirty(A award, AwardListEnum playType);

    void save(BasketBallMatch match);

    List<BasketBallMatch> getMatchListByIntTime(Set<Integer> intTimeSet);

    void attachDirty(List<BasketBallMatch> arrangeList);

    void attachDirty(BasketBallMatch basketBallMatch);

    <A extends AbstractAward> A getAwardSpecial(Integer intTime, Integer lineId, PassMode pm, AwardListEnum en);
}
