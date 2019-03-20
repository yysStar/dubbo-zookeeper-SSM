package com.qiyun.service2.Impl;

import com.qiyun.mapper2.MemberGrade2Mapper;
import com.qiyun.model2.MemberGrade2;
import com.qiyun.service2.MemberGrade2Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("memberGrade2Service")
public class MemberGrade2ServiceImpl implements MemberGrade2Service{
    @Resource
    private MemberGrade2Mapper memberGrade2Mapper;

    public MemberGrade2 getByAccount(String account) {
        return memberGrade2Mapper.selectByAccount(account);
    }
}
