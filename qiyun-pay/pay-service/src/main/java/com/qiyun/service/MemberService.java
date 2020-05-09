package com.qiyun.service;

import com.qiyun.common.GoldCard2;
import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;
import com.qiyun.model.Member;
import com.qiyun.model2.Member2;

public interface MemberService {
    Member2DTO getMemberById(int id);

    Result getPayMember(int page, int pageSize);
    Result getPayMember(String account);

    Result updateMemberPayWays(int id, String payWays);

    Member getMemberByAccount(String account);

    void updateMember(Member member);

    Member2 getMember2ByAccount(String account);

    void updateMember2(Member2 member2);

    Member2 getMember2ByUsername(String account);

    int addGoldCard(GoldCard2 g);

    String getPicture(String account);
}
