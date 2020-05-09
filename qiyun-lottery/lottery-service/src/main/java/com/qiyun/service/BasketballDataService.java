package com.qiyun.service;

import com.qiyun.model.BasketBallBase;
import com.qiyun.model.basketball.BasketBallGame;
import com.qiyun.model.basketball.BasketballDxp;
import com.qiyun.model.basketball.BasketballOp;
import com.qiyun.model.basketball.BasketballYp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketballDataService {
    List<BasketBallBase> findByIds(List<Integer> oddIdList);

    List<BasketballYp> getYpListByintTimes(String s);

    List<BasketballOp> getOpListByintTimes(List<String> intTimeList, String avgCompany);

    List<BasketballDxp> getDxpListByintTimes(String s);

    BasketBallGame findGameByStandardName(String matchName);

    void attachDirty(BasketBallGame game);

    void saveIfChange(BasketBallBase base);
}
