package com.qiyun.serviceImpl;

import com.qiyun.common.Result;
import com.qiyun.mapper.MemberWalletLineMapper;
import com.qiyun.mapper2.MemberWalletLine2Mapper;
import com.qiyun.model.MemberWalletLine;
import com.qiyun.model2.MemberWalletLine2;
import com.qiyun.model2.MemberWalletLine2Query;
import com.qiyun.service.MemberWalletLineService;
import com.qiyun.utils.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class MemberWalletLineServiceImpl implements MemberWalletLineService {

    private static Logger logger = LoggerFactory.getLogger(MemberWalletLineServiceImpl.class);

    @Resource
    private MemberWalletLineMapper memberWalletLineMapper;

    @Resource
    private MemberWalletLine2Mapper memberWalletLine2Mapper;



    public Result insert(MemberWalletLine2 memberWalletLine2) {
        Result result = new Result();
        try {
            memberWalletLine2Mapper.insertSelective(memberWalletLine2);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("添加钱包流水出错",e);
            result.setSuccess(false);
            result.setMsg("添加钱包流水出错");
            return result;
        }
    }

    public int updateCard(Integer cardId, Date date) {
        return memberWalletLine2Mapper.updateCard(cardId,date);
    }

    public BigDecimal findCardFullMoneyById(Integer cardId) {
        return memberWalletLine2Mapper.findCardFullMoneyById(cardId);
    }

    public MemberWalletLine2 getByPlanNoAndRemark(Integer planNo, String remark) {
        return memberWalletLine2Mapper.getByPlanNoAndRemark(planNo,remark);
    }

    public MemberWalletLine2 getByAccountAndPlanNoAndTransType(String account, Integer planNo, int transType) {
        MemberWalletLine2Query memberWalletLine2Query = new MemberWalletLine2Query();
        MemberWalletLine2Query.Criteria criteria = memberWalletLine2Query.createCriteria();
        criteria.andAccountEqualTo(account);
        criteria.andPlanNoEqualTo(planNo);
        criteria.andTransTypeEqualTo(transType);
        List<MemberWalletLine2> memberWalletLine2s = memberWalletLine2Mapper.selectByExampleWithBLOBs(memberWalletLine2Query);
        if (memberWalletLine2s==null || memberWalletLine2s.size()<=0){
            return null;
        }
        return memberWalletLine2s.get(0);
    }
}
