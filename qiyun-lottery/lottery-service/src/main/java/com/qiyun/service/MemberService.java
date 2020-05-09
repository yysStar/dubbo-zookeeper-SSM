package com.qiyun.service;

import com.qiyun.dto.Member2DTO;
import com.qiyun.model2.LotteryPlan2WithBLOBs;
import com.qiyun.model2.Member2;

import java.util.List;

public interface MemberService {
    List<Member2DTO> getByAccounts(String gdAccount,int page, int pageSize);

    Member2DTO getByAccount(String gdAccount);

    Member2 getByUsername(String account);

    List<Member2> getVirtualMember();

    Member2 getById(Integer sourceId);

    void addSalesCount(LotteryPlan2WithBLOBs lotteryPlan);
}
