package com.qiyun.service;

import com.qiyun.common.Result;
import com.qiyun.dto.MemberDTO;
import com.qiyun.dto.MemberWallet2DTO;
import com.qiyun.model.MemberAgentCommision;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberAgent2;
import com.qiyun.model2.MemberRate2;
import com.qiyun.model2.MemberWalletLine2;

public interface MemberService {

    Result updateMemberUsername(MemberDTO memberDTO);

    Result updateMember(MemberDTO memberDTO);

    Result updatePwdByMobile(String mobile, String password);

    Result updateMobile(MemberDTO memberDTO);

    MemberDTO getByAccount(String account);

    Member2 getById(Integer memberId);

    MemberRate2 findMemberRate2ByAccount(Integer sourceId, Integer member);


    MemberAgent2 findIsAgentOrQd(Integer member);

    MemberWallet2DTO getMemberWalletByAccount(String account);

    void updateMemberWallet(MemberWallet2DTO memberWalletByAccount);

    void insertSelective(MemberWalletLine2 memberWalletLine2);

    void insert(MemberAgentCommision memberAgentCommision);

    MemberWalletLine2 getByPlanNoAndRemark(Integer planNo, String 彩金卡抵扣);
}
