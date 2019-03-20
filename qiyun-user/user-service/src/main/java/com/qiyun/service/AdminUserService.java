package com.qiyun.service;
import com.qiyun.common.Result;

public interface AdminUserService {
    Result adminLogin(String username, String password);
}
