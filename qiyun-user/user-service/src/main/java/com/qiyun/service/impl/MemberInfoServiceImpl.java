package com.qiyun.service.impl;

import com.qiyun.common.Result;
import com.qiyun.dto.MemberInfoDTO;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.MemberInfo2Mapper;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberInfo2;
import com.qiyun.model2.MemberInfo2Query;
import com.qiyun.service.MemberInfoService;
import com.qiyun.util.Constants;
import com.qiyun.util.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    private static Logger logger = LoggerFactory.getLogger(MemberInfoServiceImpl.class);

    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private MemberInfo2Mapper memberInfo2Mapper;

    public MemberInfoDTO getMemberInfoByAccount(String account) {
        try {
            MemberInfo2Query memberInfo2Query = new MemberInfo2Query();
            MemberInfo2Query.Criteria criteria = memberInfo2Query.createCriteria();
            criteria.andAccountEqualTo(account);
            List<MemberInfo2> memberInfo2s = memberInfo2Mapper.selectByExample(memberInfo2Query);
            if (memberInfo2s==null || memberInfo2s.size()==0){
                return null;
            }
            MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
            CopyUtils.Copy(memberInfoDTO,memberInfo2s.get(0),true);
            return memberInfoDTO;
        }catch (Exception e){
            logger.error("根据account获取memberInfo出错");
            return null;
        }
    }

    public Result updateMemberInfo(MemberInfoDTO memberInfoDTO) {
        try {
            MemberInfo2 memberInfo2 = new MemberInfo2();
            CopyUtils.Copy(memberInfo2,memberInfoDTO,true);
            MemberInfo2Query memberInfo2Query = new MemberInfo2Query();
            MemberInfo2Query.Criteria criteria1 = memberInfo2Query.createCriteria();
            criteria1.andAccountEqualTo(memberInfoDTO.getAccount());
            memberInfo2Mapper.updateByExampleSelective(memberInfo2,memberInfo2Query);

            Result result = new Result();
            result.setSuccess(true);
            result.setMsg("您已经成功绑定提款账号!");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("更新memberInfo出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("更新memberInfo出错");
            return result;
        }
    }

    public Map<String, Object> relieveBind(String account) {
        Map<String,Object> map = new HashMap<String,Object>();
        if (!"sj".equals(account.substring(0,2))){
            Member2 byUsername = member2Mapper.getByUsername(account);
            if (byUsername==null){
                map.put(Constants.CODE,Constants.ERROR_CODE_400);
                map.put(Constants.MSG,Constants.ERROR_MSG_400);
                return map;
            }
            account=byUsername.getAccount();
        }
        MemberInfo2Query memberInfo2Query = new MemberInfo2Query();
        MemberInfo2Query.Criteria criteria = memberInfo2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        List<MemberInfo2> memberInfo2s = memberInfo2Mapper.selectByExample(memberInfo2Query);
        if (memberInfo2s==null || memberInfo2s.size()<=0){
            map.put(Constants.CODE,Constants.ERROR_CODE_400);
            map.put(Constants.MSG,Constants.ERROR_MSG_400);
            return map;
        }
        MemberInfo2 memberInfo2 = memberInfo2s.get(0);
        memberInfo2.setBank(null);
        memberInfo2.setBankCard(null);
        memberInfo2.setBankPart(null);
        memberInfo2Mapper.updateByPrimaryKey(memberInfo2);
        map.put(Constants.CODE,Constants.SUCCESS_CODE);
        map.put(Constants.MSG,Constants.SUCCESS_MSG);
        return map;
    }


}
