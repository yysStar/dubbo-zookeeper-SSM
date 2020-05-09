package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.qiyun.common.Result;
import com.qiyun.dto.PayChannelDTO;
import com.qiyun.dto.XxPay2DTO;
import com.qiyun.mapper.PayChannelMapper;
import com.qiyun.mapper2.XxPay2Mapper;
import com.qiyun.model.PayChannel;
import com.qiyun.model2.XxPay2;
import com.qiyun.model2.XxPay2Query;
import com.qiyun.service.PayChannelService;
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
public class PayChannelServiceImpl implements PayChannelService {

    private static Logger logger = LoggerFactory.getLogger(PayChannelServiceImpl.class);


    @Resource
    private XxPay2Mapper xxPay2Mapper;

    public Result addPayChannel(PayChannelDTO payChannelDTO) {
        try {
            Result result = new Result();

            XxPay2 xxPay2 = new XxPay2();
            CopyUtils.Copy(xxPay2,payChannelDTO,true);
            xxPay2Mapper.insert(xxPay2);

            result.setMsg("添加线下支付成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("添加线下支付出错",e);
            Result result = new Result();
            result.setMsg("添加线下支付出错");
            result.setSuccess(true);
            return result;
        }
    }

    public Result getPayChannelList(int page, int pageSize) {
        try {
            Result result = new Result();
            XxPay2Query xxPay2Query = new XxPay2Query();
            XxPay2Query.Criteria criteria = xxPay2Query.createCriteria();
            criteria.andStatusEqualTo(1);
            PageHelper.startPage(page,pageSize);
            List<XxPay2> xxPay2s = xxPay2Mapper.selectByExample(xxPay2Query);
            final int totalCount = xxPay2Mapper.countByExample(xxPay2Query);
            List<XxPay2DTO> list = new ArrayList<XxPay2DTO>();
            if (xxPay2s!=null && xxPay2s.size()>0){
                for (XxPay2 xxPay2 : xxPay2s) {
                    XxPay2DTO xxPay2DTO = new XxPay2DTO();
                    CopyUtils.Copy(xxPay2DTO,xxPay2,true);
                    list.add(xxPay2DTO);
                }
            }
            result.setSuccess(true);
            result.setData(list);
            result.setTotalCount(totalCount);
            return result;
        }catch (Exception e){
            logger.error("获取支付列表出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取支付列表出错");
            return result;
        }
    }

    public Result updateStatus(int id, int status) {
        try {
            Result result = new Result();

            XxPay2 xxPay2 = new XxPay2();
            xxPay2.setId(id);
            xxPay2.setStatus(status);
            xxPay2Mapper.updateByPrimaryKeySelective(xxPay2);
            result.setSuccess(true);
            result.setMsg("修改状态成功");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改线下支付状态出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("修改线下支付状态出错");
            return result;
        }
    }

    public Result updatePayChannel(XxPay2DTO xxPay2DTO) {
        try {
            Result result = new Result();

            XxPay2 xxPay2 = new XxPay2();
            CopyUtils.Copy(xxPay2,xxPay2DTO,true);
            xxPay2Mapper.updateByPrimaryKeySelective(xxPay2);

            result.setSuccess(true);
            result.setMsg("修改成功");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("修改线下支付出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("修改线下支付出错");
            return result;
        }
    }

    public XxPay2DTO getPayChannelById(int id) {
        try {
            XxPay2 xxPay2 = xxPay2Mapper.selectByPrimaryKey(id);
            XxPay2DTO xxPay2DTO = new XxPay2DTO();
            CopyUtils.Copy(xxPay2DTO,xxPay2,true);
            return xxPay2DTO;
        }catch (Exception e){
            logger.error("根据id获取线下支付出错",e);
            return null;
        }
    }

    public Result deletePayChannel(int id) {
        try {
            Result result = new Result();

            xxPay2Mapper.deleteByPrimaryKey(id);

            result.setSuccess(true);
            result.setMsg("删除成功");
            return result;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("删除线下支付出错",e);
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("删除线下支付出错");
            return result;
        }
    }

    public XxPay2DTO getPayChannelByIdAndIsOnLineAndType(int id, int isOnLine, String type) {
        try {
            XxPay2Query xxPay2Query = new XxPay2Query();
            XxPay2Query.Criteria criteria = xxPay2Query.createCriteria();
            criteria.andIdEqualTo(id);
            criteria.andIsOnlineEqualTo(isOnLine);
            criteria.andTypeEqualTo(type);
            List<XxPay2> xxPay2s = xxPay2Mapper.selectByExample(xxPay2Query);
            if (xxPay2s==null || xxPay2s.size()<=0){
                return null;
            }
            XxPay2DTO xxPay2DTO = new XxPay2DTO();
            CopyUtils.Copy(xxPay2DTO,xxPay2s.get(0),true);
            return xxPay2DTO;
        }catch (Exception e){
            logger.error("根据id，isOnLine，type获取线下支付出错",e);
            return null;
        }
    }

}
