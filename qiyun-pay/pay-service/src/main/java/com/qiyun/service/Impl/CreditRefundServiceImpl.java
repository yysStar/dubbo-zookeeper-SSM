package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.CreditRefund2DTO;
import com.qiyun.mapper2.CreditRefund2Mapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.model2.CreditRefund2;
import com.qiyun.model2.Member2;
import com.qiyun.service.CreditRefundService;
import com.qiyun.util.CopyUtils;
import org.apache.poi.hssf.record.formula.MemAreaPtg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CreditRefundServiceImpl implements CreditRefundService {

    private static Logger logger = LoggerFactory.getLogger(CreditRefundServiceImpl.class);

    @Resource
    private Member2Mapper member2Mapper;

    @Resource
    private CreditRefund2Mapper creditRefund2Mapper;

    public Result creditRefundApply(String account, double amount) {
        Result result = new Result();
        try {
            Member2 member2 = member2Mapper.selectByAccount(account);
            if (member2==null){
                result.setSuccess(false);
                result.setMsg("找不到会员");
                return result;
            }

            CreditRefund2 creditRefund2 = new CreditRefund2();
            creditRefund2.setAccount(account);
            creditRefund2.setUsername(member2.getUsername());
            creditRefund2.setMobile(member2.getMobile());
            creditRefund2.setName(member2.getName());
            creditRefund2.setAmount(amount);
            creditRefund2.setCreateTime(new Date());
            creditRefund2.setStatus(0);
            creditRefund2Mapper.insertSelective(creditRefund2);

            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("添加代理还款申请出错",e);
            result.setSuccess(false);
            result.setMsg("添加代理还款申请出错");
            return result;
        }
    }

    public Result passCreditRefundApply(String account, int id) {
        Result result = new Result();
        try {
            CreditRefund2 creditRefund2 = creditRefund2Mapper.selectByPrimaryKey(id);
            if (creditRefund2==null){
                result.setSuccess(false);
                result.setMsg("找不到申请");
                return result;
            }
            creditRefund2.setStatus(1);
            creditRefund2.setOperator(account);
            creditRefund2Mapper.updateByPrimaryKeySelective(creditRefund2);

            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("通过代理还款申请出错",e);
            result.setSuccess(false);
            result.setMsg("通过代理还款申请出错");
            return result;
        }
    }

    public CreditRefund2DTO getById(int id) {
        try {
            CreditRefund2 creditRefund2 = creditRefund2Mapper.selectByPrimaryKey(id);
            if (creditRefund2==null){
                return null;
            }
            CreditRefund2DTO creditRefund2DTO = new CreditRefund2DTO();
            CopyUtils.Copy(creditRefund2DTO,creditRefund2,true);
            return creditRefund2DTO;
        }catch (Exception e){
            logger.error("根据id获取代理还款申请失败",e);
            return null;
        }
    }

    public Result refuseCreditRefundApply(String account, int id) {
        Result result = new Result();
        try {
            CreditRefund2 creditRefund2 = creditRefund2Mapper.selectByPrimaryKey(id);
            if (creditRefund2==null){
                result.setSuccess(true);
                result.setMsg("找不到申请");
                return result;
            }
            creditRefund2.setOperator(account);
            creditRefund2.setStatus(2);
            creditRefund2Mapper.updateByPrimaryKeySelective(creditRefund2);

            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("拒绝还款申请失败",e);
            result.setSuccess(false);
            result.setMsg("拒绝还款申请失败");
            return result;
        }
    }

    public Result getCreditRefund(int page, int pageSize, String account, int status, String loginAccount, String operator, String startTime, String endTime) {
        Result result = new Result();
        try {
            //通过登录账号查找手下渠道
           List<String> qdList  = member2Mapper.findQDByLoginAccount(loginAccount);
            if (qdList.size()==0){
                result.setSuccess(false);
                result.setMsg("没有权限进行操作");
                return result;
            }
           //查询渠道下面的代理
            List<String> dlList = member2Mapper.findDLByQD(qdList);
            dlList.addAll(qdList);
            //条件查询
            if(account!=null&&!"".equals(account)){
                if (!dlList.contains(account)){
                    result.setSuccess(false);
                    result.setMsg("没有权限对这个代理进行操作");
                    return result;
                }
                dlList = new ArrayList<String>();
                dlList.add(account);
            }
            Map<String,Object> paramMap = new HashMap<String, Object>();
            paramMap.put("status",status);
            paramMap.put("operator",operator);
            paramMap.put("startTime",startTime);
            paramMap.put("endTime",endTime);
                PageHelper.startPage(page,pageSize);
                List<CreditRefund2> creditRefund2s = creditRefund2Mapper.getCreditRefund(paramMap,dlList);

                List<CreditRefund2DTO> list = new ArrayList<CreditRefund2DTO>();
                for (CreditRefund2 creditRefund2 : creditRefund2s) {
                    CreditRefund2DTO creditRefund2DTO = new CreditRefund2DTO();
                    CopyUtils.Copy(creditRefund2DTO,creditRefund2,true);
                    list.add(creditRefund2DTO);
                }



            result.setSuccess(true);
            result.setData(list);

            return result;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("获取还款记录失败",e);
            result.setSuccess(false);
            result.setMsg("获取还款记录失败");
            return result;
        }
    }
}
