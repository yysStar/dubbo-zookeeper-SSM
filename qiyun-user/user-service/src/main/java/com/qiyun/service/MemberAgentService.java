package com.qiyun.service;
import com.qiyun.common.Result;
import com.qiyun.model2.MemberAgent2;

import java.util.List;
import java.util.Map;

public interface MemberAgentService {
    Result getMemberAgent(Integer memberId);

    Map<String,Object> getAgentList(int page, int pageSize);

    List<MemberAgent2> getMemberAgentInfo(String account);

    void updateMemberAgent(MemberAgent2 memberAgent2);
}
