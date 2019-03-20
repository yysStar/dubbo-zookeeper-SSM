package com.qiyun.service;

import com.qiyun.model2.MemberNote2;

public interface MemberNoteService {
    MemberNote2 getByKhAccount(String account);

    void add(MemberNote2 memberNote2);

    void update(MemberNote2 memberNote2);
}
