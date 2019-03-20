package com.qiyun.service;

import com.qiyun.dto.MasterInfoDTO;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberCloudsLine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    Member2 getByAccount(String account);

    MasterInfoDTO getMasterInfo(String account);

    List<MemberCloudsLine> getCloudList(String account, int num, int offset, int pageSize);

}
