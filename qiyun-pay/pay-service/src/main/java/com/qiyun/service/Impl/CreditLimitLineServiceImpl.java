package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.CreditLimitLine2DTO;
import com.qiyun.dto.CreditRefund2DTO;
import com.qiyun.mapper.CreditLimitLineMapper;
import com.qiyun.mapper2.CreditLimitLine2Mapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.model2.CreditLimitLine2;
import com.qiyun.model2.CreditLimitLine2Query;
import com.qiyun.service.CreditLimitLineService;
import com.qiyun.util.CopyUtils;
import com.qiyun.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditLimitLineServiceImpl implements CreditLimitLineService {

    private static Logger logger = LoggerFactory.getLogger(CreditLimitLineServiceImpl.class);

    @Resource
    private CreditLimitLineMapper creditLimitLineMapper;

    @Resource
    private CreditLimitLine2Mapper creditLimitLine2Mapper;
    @Resource
    private Member2Mapper member2Mapper;
    public Result insert(CreditLimitLine2DTO creditLimitLine2DTO) {
        Result result = new Result();
        try {
            CreditLimitLine2 creditLimitLine2 = new CreditLimitLine2();
            CopyUtils.Copy(creditLimitLine2,creditLimitLine2DTO,true);
            creditLimitLine2Mapper.insert(creditLimitLine2);
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("添加授信流水出错",e);
            result.setSuccess(false);
            result.setMsg("添加授信流水出错");
            return result;
        }
    }

    public Result getCreditLimitLine(int page, int pageSize, String account, String loginAccount) {
        Result result = new Result();
        try {
            List<String> qdList  = member2Mapper.findQDByLoginAccount(loginAccount);
            if (qdList.size()==0){
                result.setSuccess(false);
                result.setMsg("没有权限进行操作");
                return result;
            }
            //查询渠道下面的代理
            List<String> dlList = member2Mapper.findDLByQD(qdList);
            //条件查询
            if(account!=null&&!"".equals(account)){
                //判断传入这个代理有没有权限
                if (!dlList.contains(account)){
                    result.setSuccess(false);
                    result.setMsg("没有权限对这个代理进行操作");
                    return result;
                }
                dlList = new ArrayList<String>();
                dlList.add(account);
            }
            List<CreditLimitLine2DTO> resList = new ArrayList<CreditLimitLine2DTO>();

                PageHelper.startPage(page,pageSize);
                List<CreditLimitLine2> creditLimitLine2s = creditLimitLine2Mapper.selectLimtLine(dlList);

                List<CreditLimitLine2DTO> list = new ArrayList<CreditLimitLine2DTO>();
                for (CreditLimitLine2 creditLimitLine2 : creditLimitLine2s) {
                    CreditLimitLine2DTO creditLimitLine2DTO = new CreditLimitLine2DTO();
                    CopyUtils.Copy(creditLimitLine2DTO,creditLimitLine2,true);
                    list.add(creditLimitLine2DTO);
                }
            result.setSuccess(true);
            result.setData(list);
            result.setTotalCount(resList.size());
            return result;
        }catch (Exception e){
          /*  TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();*/
            logger.error("查询授信流水出错",e);
            result.setSuccess(false);
            result.setMsg("查询授信流水出错");
            return result;
        }
    }
}
