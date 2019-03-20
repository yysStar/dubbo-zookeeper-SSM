package com.qiyun.service;

import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberRate2;
import com.qiyun.model2.MemberRate2WithBLOBs;

import java.util.List;
import java.util.Map;

public interface MemberRateService {
    MemberRate2WithBLOBs getByAccountAndType(String account, Integer lotteryType);

    void insert(MemberRate2WithBLOBs memberRate21);

    void update(MemberRate2WithBLOBs memberRate21);

    Map<String,Object> getMemberRate(String account);

    List<MemberRate2> findMemberRate(Member2 sourceId);

    List<MemberRate2WithBLOBs> findMemberRateById(Integer member2);

    List<Map> findAllRate(String account);

    int updateRateByAccount(Map memberRate2);

    int delRateByAccount(String account, Integer lottery_type);

    int cancelFD(String account);

 
}
