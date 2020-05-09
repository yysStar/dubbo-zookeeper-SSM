package com.qiyun.service;
import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;

public interface MemberWalletLineService {
    Result getWalletLine(Member2DTO member2DTO, int page , int pageSize, String type);
}
