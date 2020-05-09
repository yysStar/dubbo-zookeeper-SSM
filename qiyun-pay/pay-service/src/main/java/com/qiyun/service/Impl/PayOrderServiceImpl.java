package com.qiyun.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiyun.common.Result;
import com.qiyun.dto.*;
import com.qiyun.mapper.PayOrderMapper;
import com.qiyun.mapper2.Member2Mapper;
import com.qiyun.mapper2.PayOrder2Mapper;
import com.qiyun.model.PayOrder;
import com.qiyun.model2.MemberWalletLine2;
import com.qiyun.model2.PayOrder2;
import com.qiyun.model2.PayOrder2Query;
import com.qiyun.service.PayOrderService;
import com.qiyun.utils.CopyUtils;
import com.qiyun.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PayOrderServiceImpl implements PayOrderService {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(PayOrderServiceImpl.class);

    @Resource
    private PayOrderMapper payOrderMapper;

    @Resource
    private PayOrder2Mapper payOrder2Mapper;
    @Resource
    private Member2Mapper member2Mapper;

    public Result insert(PayOrderDTO payOrderDTO) {
        Result result = new Result();
        try {
            PayOrder2 payOrder2 = new PayOrder2();
            CopyUtils.Copy(payOrder2,payOrderDTO,true);

            payOrder2Mapper.insert(payOrder2);
            log.info("添加订单"+payOrderDTO.getId()+"成功");
            result.setSuccess(true);
            return result;
        }catch (Exception e){
            e.printStackTrace();
            result.setSuccess(false);
            result.setMsg("添加支付订单出错");
            return result;
        }
    }

    public int update(PayOrderDTO payOrderDTO) {
        try {
            PayOrder2 payOrder2 = new PayOrder2();
            CopyUtils.Copy(payOrder2,payOrderDTO,true);
            return payOrder2Mapper.updateByPrimaryKeySelective(payOrder2);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return 0;
    }

    public Result getPayOrder(String id) {
        try {
            Result result = new Result();
            PayOrder2 payOrder2 = payOrder2Mapper.selectByPrimaryKey(id);
            PayOrder2DTO payOrder2DTO = new PayOrder2DTO();
            if (payOrder2==null){
                result.setSuccess(false);
                result.setMsg("订单号错误");
                return result;
            }
            CopyUtils.Copy(payOrder2DTO,payOrder2,true);
            result.setSuccess(true);
            result.setData(payOrder2DTO);
            return result;
        }catch (Exception e){
            Result result = new Result();
            result.setSuccess(false);
            result.setMsg("获取支付订单出错");
            return result;
        }
    }

    public PayOrder2DTO getPayOrderById(String id) {
        if (StringUtils.isNullOrBlank(id)){
            return null;
        }
        PayOrder2 payOrder2 = payOrder2Mapper.selectByPrimaryKey(id);
        if (payOrder2==null){
            return null;
        }
        PayOrder2DTO payOrder2DTO = new PayOrder2DTO();
        CopyUtils.Copy(payOrder2DTO,payOrder2,true);
        return payOrder2DTO;
    }

    public List<MemberDrawing> findMemberDrawingByAccount(String account) {
        return payOrder2Mapper.findMemberDrawingByAccount(account);
    }

    public int addMemberOperTrack(MemberOperTrack requestInfo) {
        payOrder2Mapper.addMemberOperTrack(requestInfo);
        return requestInfo.getOPER_LINE_NO();
    }

    public int addWithdrawalOrder(MemberDrawing drawing) {

        return  payOrder2Mapper.addWithdrawalOrder(drawing);
    }

    public int updateWalltInfo(MemberWallet2DTO memberWallet) {
        return payOrder2Mapper.updateWalltInfo(memberWallet);
    }

    public int addwalltLineInfo(MemberWalletLine2 walletLine) {
        return payOrder2Mapper.addwalltLineInfo(walletLine);
    }

    public PayOrder2 findById(Map paramsMap) {
        PayOrder2Query payOrder2Query = new PayOrder2Query();
        PayOrder2Query.Criteria criteria = payOrder2Query.createCriteria();
        criteria.andIdEqualTo(paramsMap.get("payedNo")+"");
        List<PayOrder2> payOrder2s = payOrder2Mapper.selectByExample(payOrder2Query);
        return  payOrder2s.get(0);
    }

    public List<Map> getAllFailPayOrder(Map paramsMap) {
        return payOrder2Mapper.getAllFailPayOrder(paramsMap);
    }

    public Result findMemberDrawingList(String loginAccount, String account, String start_time, String end_time, String flow_num, String is_drawing_time, Integer page, Integer pageSize,Integer status) {
        Result result = new Result();
        try {

/*
        List<String> qdList  = member2Mapper.findQDByLoginAccount(loginAccount);
        if (qdList.size()==0){
            result.setSuccess(false);
            result.setMsg("没有权限进行操作");
            return result;
        }
        //查询渠道下面的代理
        List<String> dlList = member2Mapper.findDLByQD(qdList);*/
        //条件查询
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("account",account);
            map.put("startTime",start_time);
            map.put("endTime",end_time);
            map.put("flow_num",flow_num);
            map.put("is_drawing_time",is_drawing_time);
            map.put("status",status);
           /* map.put("dlList",dlList);*/
        PageHelper.startPage(page,pageSize);
        List<Map> list  = payOrder2Mapper.findMemberDrawingList(map);
        PageInfo pageInfo = new PageInfo(list);
        if (list.size()>0){
            result.setMsg("数据获取成功");
            result.setData(pageInfo);
            result.setSuccess(true);
        }else {
            result.setMsg("没有提款申请");
            result.setSuccess(false);
        }
        }catch (Exception ex){
            ex.printStackTrace();
            result.setMsg("获取数据失败");
            result.setSuccess(false);
        }
        return result;
    }

    public MemberDrawing findDrawingById(String drawingId) {
        return payOrder2Mapper.findDrawingById(drawingId);
    }

    public void updateDrawing(MemberDrawing memberDrawing) {
        payOrder2Mapper.updateDrawingStatus(memberDrawing);
    }
}
