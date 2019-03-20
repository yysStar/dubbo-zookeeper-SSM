package com.qiyun.service.Impl;

import com.qiyun.common.Result;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.MemberCloudsLine2Mapper;
import com.qiyun.model2.Member2;
import com.qiyun.model2.MemberClouds2;
import com.qiyun.model2.MemberCloudsLine2;
import com.qiyun.model2.MemberCloudsLine2Query;
import com.qiyun.service.MemberCloudsLineService;
import com.qiyun.service.biz.PayOrderBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class MemberCloudsLineServiceImpl implements MemberCloudsLineService {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MemberCloudsLineServiceImpl.class);

    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private MemberCloudsLine2Mapper memberCloudsLine2Mapper;

    public Result insert(MemberClouds2 memberClouds2, double clouds,String remark,int transType) {
        Result result = new Result();
        try {
            Member2 member2 = member2Mapper.selectByAccount(memberClouds2.getAccount());
            MemberCloudsLine2 memberCloudsLine2 = new MemberCloudsLine2();
            memberCloudsLine2.setAccount(member2.getAccount());
            memberCloudsLine2.setMemberId(member2.getId());
            memberCloudsLine2.setClouds((int) clouds);
            memberCloudsLine2.setCreateDateTime(new Date());
            memberCloudsLine2.setAbleBalance(memberClouds2.getCloudsAbleBalance());
            memberCloudsLine2.setFreezeBalance(memberClouds2.getFreezeBalance());
            memberCloudsLine2.setHeapBalance(memberClouds2.getHeapBalance());
            memberCloudsLine2.setRemark(remark);
            memberCloudsLine2.setTransType(transType);
            memberCloudsLine2Mapper.insertSelective(memberCloudsLine2);
            result.setSuccess(true);
            log.info("添加云朵流水成功");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result.setSuccess(false);
            result.setMsg("添加云朵流水失败");
            log.info("添加云朵流水失败");
            return result;
        }
    }
}
