package com.qiyun.serviceImpl;

import com.qiyun.common.Result;
import com.qiyun.dto.CopyLotteryPlan2DTO;
import com.qiyun.mapper.CopyLotteryPlanMapper;
import com.qiyun.mapper2.CopyLotteryPlan2Mapper;
import com.qiyun.model.CopyLotteryPlan;
import com.qiyun.model2.CopyLotteryPlan2;
import com.qiyun.service.CopyLotteryPlanService;
import com.qiyun.utils.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class CopyLotteryPlanServiceImpl implements CopyLotteryPlanService {

    private static Logger logger = LoggerFactory.getLogger(CopyLotteryPlanServiceImpl.class);

    @Resource
    private CopyLotteryPlanMapper copyLotteryPlanMapper;

    @Resource
    private CopyLotteryPlan2Mapper copyLotteryPlan2Mapper;

    public Result insert(CopyLotteryPlan2DTO copyLotteryPlan2DTO) {
        Result result = new Result();
        try {
            if (copyLotteryPlan2DTO==null){
                result.setSuccess(false);
                return result;
            }
            CopyLotteryPlan2 copyLottery2Plan = new CopyLotteryPlan2();
            CopyUtils.Copy(copyLottery2Plan,copyLotteryPlan2DTO,true);
            copyLotteryPlan2Mapper.insert(copyLottery2Plan);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            logger.error("添加复制跟单表出错",e);
            result.setSuccess(false);
            result.setMsg("添加复制跟单表出错");
            return result;
        }
    }

    private CopyLotteryPlan toCopyLotteryPlan(CopyLotteryPlan2 copyLottery2Plan) {
        CopyLotteryPlan copyLotteryPlan = new CopyLotteryPlan();
        copyLotteryPlan.setCopyLotteryplanName(copyLottery2Plan.getCopyLotteryplanName());
        copyLotteryPlan.setCopyLotteryplanNo(copyLottery2Plan.getCopyLotteryplanNo());
        copyLotteryPlan.setCopyLotteryplanPlanname(copyLottery2Plan.getCopyLotteryplanPlanname());
        copyLotteryPlan.setCopyLotteryplanAmount(copyLottery2Plan.getCopyLotteryplanAmount());
        copyLotteryPlan.setCopyLotteryplanContent(copyLottery2Plan.getCopyLotteryplanContent());
        copyLotteryPlan.setCopyLotteryplanMultiple(copyLottery2Plan.getCopyLotteryplanMultiple());
        copyLotteryPlan.setCopyLotteryplanPosttaxprize(copyLottery2Plan.getCopyLotteryplanPosttaxprize());
        copyLotteryPlan.setCopyLotteryplanPlantype(copyLottery2Plan.getCopyLotteryplanPlantype());
        copyLotteryPlan.setCopyLotteryplanCreateDateTime(copyLottery2Plan.getCopyLotteryplanCreateDateTime());
        copyLotteryPlan.setCopyLotteryplanLotterytype(copyLottery2Plan.getCopyLotteryplanLotterytype());
        copyLotteryPlan.setCopyLotteryplanTerm(copyLottery2Plan.getCopyLotteryplanTerm());
        copyLotteryPlan.setCopyLotteryplanAddprize(new BigDecimal(copyLottery2Plan.getCopyLotteryplanAddprize()));
        copyLotteryPlan.setCopyLotteryplanSelecttype(copyLottery2Plan.getCopyLotteryplanSelecttype());
        copyLotteryPlan.setCopyLotteryplanPublicstatus(copyLottery2Plan.getCopyLotteryplanPublicstatus());
        copyLotteryPlan.setCopyLotteryplandesc(copyLottery2Plan.getCopyLotteryplandesc());
        return copyLotteryPlan;
    }
}
