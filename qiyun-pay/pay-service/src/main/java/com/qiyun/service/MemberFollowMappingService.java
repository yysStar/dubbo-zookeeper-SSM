package com.qiyun.service;

import com.qiyun.model2.MemberFollowMapping2;
import org.springframework.stereotype.Service;

@Service
public interface MemberFollowMappingService {
    MemberFollowMapping2 getByFansAccount(String account, String fansAccount);
}
