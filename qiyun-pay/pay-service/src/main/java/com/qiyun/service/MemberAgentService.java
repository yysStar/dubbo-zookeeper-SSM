package com.qiyun.service;

import com.qiyun.dto.MemberAgent2DTO;

public interface MemberAgentService {
    MemberAgent2DTO getByAccount(String account);
}
