package com.qiyun.service2;

import com.qiyun.model2.MemberGrade2;
import org.springframework.stereotype.Service;

@Service
public interface MemberGrade2Service {
    MemberGrade2 getByAccount(String account);
}
