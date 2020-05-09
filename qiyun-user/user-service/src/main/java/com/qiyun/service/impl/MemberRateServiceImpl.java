package com.qiyun.service.impl;

import com.qiyun.mapper2.MemberRate2Mapper;
import com.qiyun.model.Member;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberRate2;
import com.qiyun.model2.MemberRate2Query;
import com.qiyun.model2.MemberRate2WithBLOBs;
import com.qiyun.service.MemberRateService;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberRateServiceImpl implements MemberRateService {

    @Resource
    private MemberRate2Mapper memberRate2Mapper;

    public MemberRate2WithBLOBs getByAccountAndType(String account, Integer lotteryType) {
        MemberRate2Query memberRate2Query = new MemberRate2Query();
        MemberRate2Query.Criteria criteria = memberRate2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andLotteryTypeEqualTo(lotteryType);
        criteria.andRateEndDateGreaterThan(new Date());
        List<MemberRate2WithBLOBs> memberRate2WithBLOBs = memberRate2Mapper.selectByExampleWithBLOBs(memberRate2Query);
        if (memberRate2WithBLOBs==null || memberRate2WithBLOBs.size()<=0){
            return null;
        }
        return memberRate2WithBLOBs.get(0);
    }

    public void insert(MemberRate2WithBLOBs memberRate21) {
        memberRate2Mapper.insertSelective(memberRate21);
    }

    public void update(MemberRate2WithBLOBs memberRate21) {
        memberRate2Mapper.updateByPrimaryKeySelective(memberRate21);
    }

    public Map<String, Object> getMemberRate(String account) {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Map> list = memberRate2Mapper.getMemberRate(account);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,list);
        return map;
    }

    public List<MemberRate2> findMemberRate(Member2 sourceId) {
        MemberRate2Query memberRate2Query = new MemberRate2Query();
        MemberRate2Query.Criteria criteria = memberRate2Query.createCriteria();
        criteria.andMemberIdEqualTo(sourceId.getSourceId());
        return   memberRate2Mapper.selectByExample(memberRate2Query);
    }

    public List<MemberRate2WithBLOBs> findMemberRateById(Integer member2) {
        MemberRate2Query memberRate2Query = new MemberRate2Query();
        MemberRate2Query.Criteria criteria = memberRate2Query.createCriteria();
        criteria.andMemberIdEqualTo(member2);
        return   memberRate2Mapper.selectByExampleWithBLOBs(memberRate2Query);
    }

    public List<Map> findAllRate(String account) {
        return memberRate2Mapper.findAllRate(account);
    }

    public int updateRateByAccount(Map memberRate2) {
        return memberRate2Mapper.updateRateByAccount(memberRate2);
    }

    public int delRateByAccount(String account, Integer lottery_type) {
        return memberRate2Mapper.delRateByAccount(account,lottery_type);
    }

    public int cancelFD(String account) {
//        MemberRate2WithBLOBs memberRate2 = new MemberRate2WithBLOBs();
//        memberRate2.setFdDgRate(0D);
//        memberRate2.setFdHmRate(0D);
//        memberRate2.setRateEndDate(new Date());
//        int i = memberRate2Mapper.updateByPrimaryKeySelective(memberRate2);
        int i = memberRate2Mapper.cancelFD(account);
        return i;
    }

}
