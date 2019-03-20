package com.qiyun.service;
import com.qiyun.common.Result;
import com.qiyun.dto.MemberInfoDTO;

import java.util.Map;

public interface MemberInfoService {
    MemberInfoDTO getMemberInfoByAccount(String account);

    Result updateMemberInfo(MemberInfoDTO memberInfoDTO);

    Map<String,Object> relieveBind(String account);
}
