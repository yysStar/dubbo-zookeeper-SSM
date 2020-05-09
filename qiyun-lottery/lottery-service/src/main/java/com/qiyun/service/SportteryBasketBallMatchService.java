package com.qiyun.service;

import com.qiyun.dto.BasketBallMatchDTO;
import com.qiyun.model.HTAward;
import com.qiyun.model.PassMode;
import com.qiyun.model.basketball.BasketBallMatch;
import com.qiyun.model2.SportteryBasketMatch2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface SportteryBasketBallMatchService {
    SportteryBasketMatch2 getByIntTimeAndLineId(Integer intTime, Integer lineId);

    List<BasketBallMatchDTO> getBasketBallMatch(int isFocus);

    List<BasketBallMatch> getNBAbyDate(int i);

    Map<String,HTAward> findForBbHTAwardMapByIntTime(Set<String> intTimeStrs, PassMode pass);

    Map getSfcAward(int i, Integer intTime, Integer lineId);

    List<Map> getbasketAward(int i, Integer intTime, Integer lineId, int i1);

    List<SportteryBasketMatch2> getByIntTime(Integer intTime);

    void update(SportteryBasketMatch2 basketMatch2);

    SportteryBasketMatch2 getById(Integer id);
}
