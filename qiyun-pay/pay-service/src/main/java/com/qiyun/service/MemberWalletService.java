package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.dto.RedPacketDTO;
import com.qiyun.dto.RedPacketListDTO;

import java.util.List;

public interface MemberWalletService {
    Result update(String prdOrdNo, String orderAmount);

    Result addMoney(String account, Double amount);

    MemberWallet2DTO getMemberWalletByAccount(String account);

    Result updateMemberWallet(MemberWallet2DTO memberWalletByAccount);

    Result updateCreditBalance(String dlAccount, double amount);

    int updateByPrimaryKeySelective(MemberWallet2DTO memberWallet2);

    List<RedPacketListDTO> grabRedRacketList(int offset, int pageSize, String account, String startTime, String endTime);

    List<RedPacketListDTO> putRedRacketList(int offset, int pageSize, String account, String startTime, String endTime);

}
