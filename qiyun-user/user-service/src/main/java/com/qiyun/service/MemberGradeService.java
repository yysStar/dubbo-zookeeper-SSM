package com.qiyun.service;

import com.qiyun.model2.MemberGrade2;

public interface MemberGradeService {
    MemberGrade2 getByAccount(String account);

    void update(MemberGrade2 memberGrade2);
}
