package com.qiyun.service.impl;

import com.qiyun.mapper2.MemberNote2Mapper;
import com.qiyun.model2.MemberNote2;
import com.qiyun.model2.MemberNote2Query;
import com.qiyun.service.MemberNoteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberNoteServiceImpl implements MemberNoteService {

    @Resource
    private MemberNote2Mapper memberNote2Mapper;

    public MemberNote2 getByKhAccount(String account) {
        MemberNote2Query memberNote2Query = new MemberNote2Query();
        MemberNote2Query.Criteria criteria = memberNote2Query.createCriteria();
        criteria.andMemberIdEqualTo(account);
        List<MemberNote2> memberNote2s = memberNote2Mapper.selectByExample(memberNote2Query);
        if (memberNote2s==null || memberNote2s.size()<=0){
            return null;
        }
        return memberNote2s.get(0);
    }

    public void add(MemberNote2 memberNote2) {
        memberNote2Mapper.insertSelective(memberNote2);
    }

    public void update(MemberNote2 memberNote2) {
        memberNote2Mapper.updateByPrimaryKeySelective(memberNote2);
    }
}
