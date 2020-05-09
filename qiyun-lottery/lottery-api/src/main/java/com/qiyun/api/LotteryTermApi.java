package com.qiyun.api;

import java.util.Map;

public interface LotteryTermApi {

    Map<String,Object> findByLotteryTypeAndTerm(Integer lotteryTypeIn, Integer buildCount);

    Map<String,Object> findTerm(Integer lotteryTypeValue, Integer page, Integer pageSize, String term);

    Map<String,Object> updateTerm(Map<String,Object> map);
}
