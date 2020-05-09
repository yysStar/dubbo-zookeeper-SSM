package com.qiyun.service;

import com.qiyun.model.LotteryTypeProps;
import org.springframework.stereotype.Service;

@Service
public interface LotteryTypePropsService {
    LotteryTypeProps findById(int value);

    LotteryTypeProps findAndCommendByLotType(int value);
}
