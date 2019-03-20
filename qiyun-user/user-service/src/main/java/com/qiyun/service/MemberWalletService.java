package com.qiyun.service;
import com.qiyun.common.Result;
import org.springframework.stereotype.Service;

@Service
public interface MemberWalletService {
    Result getMemberWallet(Integer id);

    Result getCreditMember(String account, int page, int pageSize, String loginAccount);
}
