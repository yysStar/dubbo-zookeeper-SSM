package com.qiyun.serviceImpl;

import com.qiyun.mapper2.MemberRate2Mapper;
import com.qiyun.model2.MemberRate2;
import com.qiyun.model2.MemberRate2Query;
import com.qiyun.service.MemberRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("memberRateService")
public class MemberRateServiceImpl implements MemberRateService {

    @Resource
    private MemberRate2Mapper memberRate2Mapper;

    public MemberRate2 getByMemberIdAndLotteryType(Integer id, Integer lotType) {
        MemberRate2Query memberRate2Query = new MemberRate2Query();
        MemberRate2Query.Criteria criteria = memberRate2Query.createCriteria();
        criteria.andMemberIdEqualTo(id);
        criteria.andLotteryTypeEqualTo(lotType);
        criteria.andRateEndDateGreaterThan(new Date());
        List<MemberRate2> memberRate2s = memberRate2Mapper.selectByExample(memberRate2Query);
        if (memberRate2s==null || memberRate2s.size()<=0){
            return null;
        }
        return memberRate2s.get(0);
    }
}
