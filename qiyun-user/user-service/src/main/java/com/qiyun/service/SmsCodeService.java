package com.qiyun.service;

import java.util.Map;

public interface SmsCodeService {
    Map<String,Object> saveSmsCode(String mobile, String sRand);

    Map<String,Object> getSmsCode(String mobile);
}
