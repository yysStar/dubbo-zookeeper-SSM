package com.qiyun.serviceImpl;

import com.qiyun.mapper2.MemberAgent2Mapper;
import com.qiyun.model2.MemberAgent2;
import com.qiyun.model2.MemberAgent2Query;
import com.qiyun.service.MemberAgentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("memberAgentService")
public class MemberAgentServiceImpl implements MemberAgentService {

    @Resource
    private MemberAgent2Mapper memberAgent2Mapper;

    public MemberAgent2 getAgentByMemberId(Integer sourceId) {
        MemberAgent2Query memberAgent2Query = new MemberAgent2Query();
        MemberAgent2Query.Criteria criteria = memberAgent2Query.createCriteria();
        criteria.andMemberIdEqualTo(sourceId);
        criteria.andStatusEqualTo(1);
        List<MemberAgent2> memberAgent2s = memberAgent2Mapper.selectByExample(memberAgent2Query);
        if (memberAgent2s==null || memberAgent2s.size()<=0){
            return null;
        }
        return memberAgent2s.get(0);
    }
}
