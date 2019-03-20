package com.qiyun.service.Impl;

import com.qiyun.common.Result;
import com.qiyun.mapper2.MemberClouds2Mapper;
import com.qiyun.model2.MemberClouds2;
import com.qiyun.model2.MemberClouds2Query;
import com.qiyun.service.MemberCloudsService;
import com.qiyun.service.biz.PayOrderBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberCloudsServiceImpl implements MemberCloudsService {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MemberCloudsServiceImpl.class);

    @Resource
    private MemberClouds2Mapper memberClouds2Mapper;

    public Result addClouds(String account, double clouds) {
        Result result = new Result();
        try {
            MemberClouds2Query memberClouds2Query = new MemberClouds2Query();
            MemberClouds2Query.Criteria criteria = memberClouds2Query.createCriteria();
            criteria.andAccountEqualTo(account);
            List<MemberClouds2> memberClouds2s = memberClouds2Mapper.selectByExample(memberClouds2Query);
            MemberClouds2 memberClouds = new MemberClouds2();
            if (memberClouds2s==null || memberClouds2s.size()<=0){
                //不存在 ，新增
                log.info("新增");
                MemberClouds2 memberClouds2 = new MemberClouds2();
                memberClouds2.setAccount(account);
                memberClouds2.setCloudsAbleBalance(clouds);
                memberClouds2.setTakeCashQuota(0d);
                memberClouds2.setFreezeBalance(0d);
                memberClouds2.setHeapBalance(0d);
                memberClouds2Mapper.insertSelective(memberClouds2);
                memberClouds = memberClouds2;
            }else{
                //存在， 修改
                log.info("修改");
                MemberClouds2 memberClouds2 = memberClouds2s.get(0);
                memberClouds2.setCloudsAbleBalance(memberClouds2.getCloudsAbleBalance()+clouds);
                memberClouds2Mapper.updateByPrimaryKey(memberClouds2);
                memberClouds = memberClouds2;
            }
            result.setSuccess(true);
            result.setData(memberClouds);
            log.info("修改会员云朵成功");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setSuccess(false);
            result.setMsg("修改会员云朵出错");
            log.info("修改会员云朵出错");
            return result;
        }
    }
}
