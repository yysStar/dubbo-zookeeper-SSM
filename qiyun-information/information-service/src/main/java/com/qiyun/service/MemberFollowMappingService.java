package com.qiyun.service;

import com.qiyun.dto.MemberFansDTO;
import com.qiyun.model.MemberFollowMapping;
import com.qiyun.model2.MemberFollowMapping2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberFollowMappingService {
    int insertSelective(MemberFollowMapping record);

    List<MemberFansDTO> getFollowList(String account, int offset, int pageSize);

    List<MemberFansDTO> getFansList(String fansAccount, int offset, int pageSize);

    MemberFollowMapping2 getByFansAccount(String account, String fansAccount);

    int update(MemberFollowMapping2 mapping);
}
