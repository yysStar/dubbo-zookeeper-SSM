package com.qiyun.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.mapper2.MemberGrade2Mapper;
import com.qiyun.model2.MemberGrade2;
import com.qiyun.model2.MemberGrade2Query;
import com.qiyun.service.MemberGradeService;
import com.qiyun.util.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("memberGradeService")
public class MemberGradeServiceImpl implements MemberGradeService {

    @Resource
    private MemberGrade2Mapper memberGrade2Mapper;

    public MemberGrade2 getByAccount(String account) {
        MemberGrade2Query memberGrade2Query = new MemberGrade2Query();
        MemberGrade2Query.Criteria criteria = memberGrade2Query.createCriteria();
        criteria.andMemberAccountEqualTo(account);
        List<MemberGrade2> memberGrade2s = memberGrade2Mapper.selectByExample(memberGrade2Query);
        if (memberGrade2s==null || memberGrade2s.size()<=0){
            return null;
        }
        return memberGrade2s.get(0);
    }

    public void update(MemberGrade2 byAccount) {
        memberGrade2Mapper.updateByPrimaryKeySelective(byAccount);
    }

    public Map<String, Object> getMemberTicket(int page, int pageSize) {
        Map<String,Object> map = new HashMap<String,Object>();
        PageHelper.startPage(page,pageSize);
        List<Map> list = memberGrade2Mapper.getMemberTicket();
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        map.put(Constants.DATA,new PageInfo<Map>(list));
        return map;
    }
}
