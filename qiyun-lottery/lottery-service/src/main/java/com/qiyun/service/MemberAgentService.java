package com.qiyun.service;

import com.qiyun.model2.MemberAgent2;
import org.springframework.stereotype.Service;

@Service
public interface MemberAgentService {
    MemberAgent2 getAgentByMemberId(Integer sourceId);
}
