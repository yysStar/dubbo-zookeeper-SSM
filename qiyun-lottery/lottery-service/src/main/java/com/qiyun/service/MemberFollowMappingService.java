package com.qiyun.service;

import com.qiyun.model2.MemberFollowMapping2;

import java.util.List;
import java.util.Map;

public interface MemberFollowMappingService {
    Map<String,Object> getMostPopular(int page, int pageSize);

    List<MemberFollowMapping2> getByaccountAndFansAccount(String account, String account1);
}
