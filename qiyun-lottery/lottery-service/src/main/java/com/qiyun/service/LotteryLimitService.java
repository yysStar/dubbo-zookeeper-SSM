package com.qiyun.service;

import com.qiyun.model2.LotteryLimit2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface LotteryLimitService {
    void addLotteryLimit(LotteryLimit2 lotteryLimit2);

    List<LotteryLimit2> getValidLimitByType(int i);

    List<LotteryLimit2> getLotteryLimit(int page, int pageSize);

    LotteryLimit2 getById(Integer id);

    void update(LotteryLimit2 lotteryLimit2);
}
