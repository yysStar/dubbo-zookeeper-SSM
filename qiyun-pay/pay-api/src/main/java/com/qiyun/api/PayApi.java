package com.qiyun.api;

import com.qiyun.common.Result;
import com.qiyun.dto.*;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface PayApi {

    boolean callBackForPay(String orderId,String outOrderId,int amount,int transType,String remark);

    /**
     * 添加支付订单
     * @param
     * @return
     */
    Result insert(PayOrderDTO payOrderDTO);

    /**
     * 回调
     * @param map
     */
    Result callBack(Map<String, String> map);

    /**
     * 获取订单信息
     * @param id
     * @return
     */
    Result getPayOrder(String id);

    /**
     * 添加线下支付
     * @param payChannelDTO
     * @return
     */
    Result addPayChannel(PayChannelDTO payChannelDTO);

    /**
     * 获取支付渠道列表
     * @param page
     * @param pageSize
     * @return
     */
    Result getPayChannelList(int page, int pageSize);

    /**
     * 修改支付渠道状态
     * @param id
     * @param status
     * @return
     */
    Result updateStatus(int id, int status);

    /**
     * 修改支付渠道
     * @param xxPay2DTO
     * @return
     */
    Result updatePayChannel(XxPay2DTO xxPay2DTO);

    /**
     * 根据id获取支付渠道
     * @param id
     * @return
     */
    XxPay2DTO getPayChannelById(int id);

    /**
     * 删除支付渠道
     * @param id
     * @return
     */
    Result deletePayChannel(int id);

    Member2DTO getMemberById(int id);

    XxPay2DTO getPayChannelByIdAndIsOnLineAndType(int id, int isOnLine, String type);

    Result getPayMember(int page, int pageSize);
    Result getPayMember(String account);

    /**
     * 更新用户支付渠道
     * @param id
     * @param payWays
     * @return
     */
    Result updateMemberPayWays(int id, String payWays);

    /**
     * 线下支付申请
     * @param xxPayApply
     * @return
     */
    Result addXxPayApply(XxPayApplyDTO xxPayApply);

    /**
     * 获取支付申请列表
     * @param page
     * @param pageSize
     * @return
     */
    Result getPayApplyList(int page, int pageSize);

    /**
     * 通过申请
     * @param id
     * @return
     */
    Result passPayApply(int id);

    /**
     * 驳回申请
     * @param id
     * @return
     */
    Result refuseApply(int id);

    MemberWallet2DTO getMemberWalletByAccount(String account);

    Result xxCharge(String account, double amount);

    Result getMemberWalletLineByXx(String account,int page,int pageSize);

    Result credit(double creditLimit, String account, String operatoer);

    Result agentCharge(String account, double amount, String member2DTOAccount, String DLAccount, String pass_pay);

    Result creditRefundApply(String account, double amount);

    Result passCreditRefundApply(String account, int id);

    Result refuseCreditRefundApply(String account, int id);

    Result getCreditLimitLine(int page, int pageSize, String account, String loginAccount);

    Result getCreditRefund(int page, int pageSize, String account, int status, String loginAccount, String operator, String startTime, String endTime);

    Result callBack2(Map<String, String> map);

    Result callBack3(Map<String, String> map);

    Result callBack5(Map<String, String> map);

    Result callBack6(Map<String, String> map);

    Result getAgentChargeLine(String account, int page, int pageSize, String loginAccount, String memberAccount, String start_time, String end_time);

    List<MemberDrawing> findMemberDrawingByAccount(String account);

    int addMemberOperTrack(MemberOperTrack requestInfo);

    Map addWithdrawalOrder(MemberDrawing drawing, MemberWallet2DTO memberWallet, Member2DTO member2DTO, MemberOperTrack requestInfo);

    Result callBack7(Map<String, String> resMap);

    Map<String,Object> chargeFix(Map paramsMap);

    Map<String,Object> getAllFailPayOrder(Map paramsMap, Integer page, Integer pageSize);

    Result callBack8(SortedMap<String, String> map);

    Result callBack9(SortedMap<String, String> map);


    Map<String,Object> chargeRight(Map paramsMap);

    Result callBack10(SortedMap<String, String> map);

    Result findMemberDrawingList(String loginAccount, String account, String start_time, String end_time, String flow_num, String is_drawing_time,Integer page,Integer pageSize,Integer status);

    Map memberDrawingReview(Map paramMap);
}
