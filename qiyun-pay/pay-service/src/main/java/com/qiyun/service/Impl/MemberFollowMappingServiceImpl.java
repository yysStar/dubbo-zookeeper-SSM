package com.qiyun.service.Impl;

import com.qiyun.mapper2.MemberFollowMappingMapper;
import com.qiyun.model2.MemberFollowMapping2;
import com.qiyun.service.MemberFollowMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("memberFollowMappingService")
public class MemberFollowMappingServiceImpl implements MemberFollowMappingService {
    @Resource
    private MemberFollowMappingMapper memberFollowMappingMapper;

    public MemberFollowMapping2 getByFansAccount(String account, String fansAccount) {
        return memberFollowMappingMapper.getByFansAccount(account, fansAccount);
    }
}
