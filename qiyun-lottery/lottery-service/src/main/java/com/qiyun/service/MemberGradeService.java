package com.qiyun.service;

import com.qiyun.model2.MemberGrade2;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface MemberGradeService {
    MemberGrade2 getByAccount(String account);

    void update(MemberGrade2 byAccount);

    Map<String,Object> getMemberTicket(int page, int pageSize);
}
