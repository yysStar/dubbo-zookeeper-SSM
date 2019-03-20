package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.model2.MemberWallet2;

public interface MemberWalletService {
    MemberWallet2DTO getByMemberId(Integer id);

    Result update(MemberWallet2DTO memberWallet);

    MemberWallet2 getByAccount(String account);

    void update2(MemberWallet2 memberWallet2);
}
