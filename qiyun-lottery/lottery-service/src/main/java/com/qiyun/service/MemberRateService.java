package com.qiyun.service;

import com.qiyun.model2.MemberRate2;
import org.springframework.stereotype.Service;

@Service
public interface MemberRateService {
    MemberRate2 getByMemberIdAndLotteryType(Integer id, Integer lotType);
}
