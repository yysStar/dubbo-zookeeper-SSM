package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.XxPayApply2DTO;
import com.qiyun.dto.XxPayApplyDTO;
import com.qiyun.mapper.XxPayApplyMapper;
import com.qiyun.mapper2.XxPayApply2Mapper;
import com.qiyun.model.XxPayApply;
import com.qiyun.model2.XxPayApply2;
import com.qiyun.model2.XxPayApply2Query;
import com.qiyun.service.XxPayApplyService;
import com.qiyun.utils.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class XxPayApplyServiceImpl implements XxPayApplyService {

    private static Logger logger = LoggerFactory.getLogger(XxPayApplyServiceImpl.class);

    @Resource
    private XxPayApplyMapper xxPayApplyMapper;

    @Resource
    private XxPayApply2Mapper xxPayApply2Mapper;

    public Result addXxPayApply(XxPayApplyDTO xxPayApply) {
        try {
            XxPayApply2 xxPayApply12 = new XxPayApply2();
            CopyUtils.Copy(xxPayApply12,xxPayApply,true);
            xxPayApply2Mapper.insert(xxPayApply12);

            XxPayApply xxPayApply1 = new XxPayApply();
            CopyUtils.Copy(xxPayApply1,xxPayApply,true);
            xxPayApplyMapper.insert(xxPayApply1);
            Result result = new Result();
            result.setMsg("申请成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("发起线下支付申请出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("发起线下支付申请出错");
            return result;
        }
    }

    public Result getPayApplyList(int page, int pageSize) {
        try {

            Result result = new Result();

            XxPayApply2Query xxPayApply2Query = new XxPayApply2Query();
            XxPayApply2Query.Criteria criteria2 = xxPayApply2Query.createCriteria();
            criteria2.andStatusEqualTo(0);
            xxPayApply2Query.setOrderByClause("create_date desc");
            PageHelper.startPage(page,pageSize);
            List<XxPayApply2> xxPayApplie2s = xxPayApply2Mapper.selectByExample(xxPayApply2Query);
            int totalCount = xxPayApply2Mapper.countByExample(xxPayApply2Query);
            if (xxPayApplie2s==null || xxPayApplie2s.size()<=0){
                result.setSuccess(true);
                result.setData(null);
                result.setTotalCount(0);
                return result;
            }
            List<XxPayApply2DTO> list = new ArrayList<XxPayApply2DTO>();
            for (XxPayApply2 xxPayApply2 : xxPayApplie2s) {
                XxPayApply2DTO xxPayApply2DTO = new XxPayApply2DTO();
                CopyUtils.Copy(xxPayApply2DTO,xxPayApply2,true);
                list.add(xxPayApply2DTO);
            }

            result.setData(list);
            result.setTotalCount(totalCount);
            result.setSuccess(true);

            return result;
        }catch (Exception e){
            logger.error("获取线下支付申请出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取线下支付申请出错");
            return result;
        }
    }

    public XxPayApply2DTO getById(int id) {
        try {
            XxPayApply2 xxPayApply2 = xxPayApply2Mapper.selectByPrimaryKey(id);
            XxPayApply2DTO xxPayApply2DTO = new XxPayApply2DTO();
            CopyUtils.Copy(xxPayApply2DTO,xxPayApply2,true);
            return xxPayApply2DTO;
        }catch (Exception e){
            logger.error("根据id获取线下支付申请出错",e);
            return null;
        }
    }

    public Result passPayApply(int id) {
        try {
            Result result = new Result();
            XxPayApply2 xxPayApply2 = xxPayApply2Mapper.selectByPrimaryKey(id);
            if (xxPayApply2!=null){
                xxPayApply2.setStatus(1);
                xxPayApply2Mapper.updateByPrimaryKey(xxPayApply2);
                result.setSuccess(true);
                result.setMsg("已通过");
            }

            XxPayApply xxPayApply = xxPayApplyMapper.selectByPrimaryKey(id);
            if (xxPayApply!=null){
                xxPayApply.setStatus(1);
                xxPayApplyMapper.updateByPrimaryKey(xxPayApply);
                result.setSuccess(true);
                result.setMsg("已通过");
            }
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("通过线下支付申请出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("通过线下支付申请出错");
            return result;
        }
    }

    public Result refuseApply(int id) {
        try {
            Result result = new Result();

            XxPayApply2 xxPayApply2 = xxPayApply2Mapper.selectByPrimaryKey(id);
            if (xxPayApply2!=null) {
                xxPayApply2.setStatus(2);
                xxPayApply2Mapper.updateByPrimaryKey(xxPayApply2);
                result.setSuccess(true);
                result.setMsg("已驳回");
            }

            XxPayApply xxPayApply = xxPayApplyMapper.selectByPrimaryKey(id);
            if (xxPayApply!=null) {
                xxPayApply.setStatus(2);
                xxPayApplyMapper.updateByPrimaryKey(xxPayApply);
                result.setSuccess(true);
                result.setMsg("已驳回");
            }
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("驳回线下支付申请出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("驳回线下支付申请出错");
            return result;
        }
    }
}
