package com.qiyun.service;
import com.qiyun.common.Result;
import com.qiyun.dto.Member2DTO;

public interface MailService {
    Result getMail(Member2DTO member2DTO, int page, int pageSize);
}
