package com.qiyun.service.impl;

import com.qiyun.mapper2.MemberGrade2Mapper;
import com.qiyun.model2.MemberGrade2;
import com.qiyun.model2.MemberGrade2Query;
import com.qiyun.service.MemberGradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberGradeServiceImpl implements MemberGradeService {

    @Resource
    private MemberGrade2Mapper memberGrade2Mapper;

    public MemberGrade2 getByAccount(String account) {
        MemberGrade2Query memberGrade2Query = new MemberGrade2Query();
        MemberGrade2Query.Criteria criteria = memberGrade2Query.createCriteria();
        criteria.andMemberAccountEqualTo(account);
        List<MemberGrade2> memberGrade2s = memberGrade2Mapper.selectByExample(memberGrade2Query);
        if (memberGrade2s==null){
            return null;
        }
        return memberGrade2s.get(0);
    }

    public void update(MemberGrade2 memberGrade2) {
        memberGrade2Mapper.updateByPrimaryKeySelective(memberGrade2);
    }
}
